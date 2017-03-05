package data.internal.persistence.service;

import internal.persistence.model.User;
import internal.persistence.service.impl.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author Nandem on 2017-02-23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-mybatis.xml")
public class TestUserService
{
    @Resource
    private UserService userService;
    @Resource
    private SqlSessionFactoryBean sqlSessionFactoryBean;
    @Test
    public void testUserService() throws Exception
    {
        User user = new User();
        user.setNickName("木格窗");
        user.setPassword("root");

        userService.addUser(user);
    }
}
