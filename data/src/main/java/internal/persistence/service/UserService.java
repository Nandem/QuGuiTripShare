package internal.persistence.service;

import internal.persistence.dao.UserDao;
import internal.persistence.model.User;
import message.Message;
import message.MessageEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Nandem on 2017-05-09.
 */
@Service
@Transactional
public class UserService
{
    @Resource
    private UserDao userDao;

    public Message registerWithMessage(User user)
    {
        try
        {
            userDao.add(user);
            return new Message(MessageEnum.REGISTER_SUCCESS);
        }
        catch(Exception e)
        {
            return new Message(MessageEnum.REGISTER_FAIL);
        }
    }
    public boolean register(User user)
    {
        try
        {
            userDao.add(user);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public boolean login(String account, String password)
    {
        String temPassword = userDao.retrievePasswordByAccount(account);

        return temPassword != null && temPassword.equals(password);
    }

    public User getUserByUseIDAndPassword(String userID, String password)
    {
        return userDao.getUserByUserIDAndPassword(userID, password);
    }

    public User getUserByAccountAndPassword(String account, String password)
    {
        return userDao.getUserByAccountAndPassword(account, password);
    }

    public int getRegisterOrder()
    {
        return userDao.getUserAmount();
    }

    /**
     * 用户重复注册验证，同一个昵称、身份证号、手机号 、邮箱只能注册一次
     * @param account 账号
     * @return true：已注册，false：未注册。
     */
    public boolean duplicationValidation(String account)
    {
        User user = userDao.duplicationValidation(account);
        return user != null;
    }

    public boolean updateUser(User user)
    {
        try
        {
            userDao.modify(user);
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
