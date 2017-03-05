package internal.persistence.service.impl;

import internal.persistence.dao.UserDao;
import internal.persistence.model.User;
import internal.persistence.service.IUserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Nandem on 2017-02-23.
 */
@Service("userService")
public class UserService implements IUserService
{
    @Resource
    @Qualifier("UserDao")
    private UserDao userDao;

    private String test = "test";

    public void printTest()
    {
        System.out.println(test);
    }

    @Override
    public boolean addUser(User user)
    {
        userDao.addUser(user);
        return false;
    }
}
