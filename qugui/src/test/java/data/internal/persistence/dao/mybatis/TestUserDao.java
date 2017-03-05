package internal.persistence.dao.mybatis;

import internal.persistence.dao.UserDao;
import internal.persistence.model.User;
import org.junit.Test;

/**
 * @author Nandem on 2017-02-23.
 */
public class TestUserDao
{
    @Test
    public void testAddUser()
    {
        User user = new User();
        user.setNickName("木格窗");
        user.setPassword("root");
    }
}
