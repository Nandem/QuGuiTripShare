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

    public Message register(User user)
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

    public boolean login(String account, String password)
    {
        String temPassword = userDao.retrievePasswordByAccount(account);

        return temPassword != null && temPassword.equals(password);
    }

    public int getRegisterOrder()
    {
        return userDao.getUserAmount();
    }
}
