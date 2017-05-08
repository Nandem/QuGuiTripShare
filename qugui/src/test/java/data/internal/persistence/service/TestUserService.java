package data.internal.persistence.service;

import date.TimeUtils;
import internal.persistence.model.User;
import internal.persistence.service.UserService;
import message.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
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

    @Test
    public void testLogin()
    {
        System.out.println(userService.login("nandem@126.com", "nandem1123"));
        System.out.println(userService.login("13551274792", "nandem1123"));
        System.out.println(userService.login("叶明", "nandem1123"));
        System.out.println(userService.login("木格窗", "nandem1123"));
    }

    @Test
    public void testRegister()
    {
        User user = new User();
        user.setEmail("nandem@126.com");
        user.setHeadIcon("no icon in database");
        user.setIdCardNo("320123199304014811");
        user.setMeaningOfTrip("你离开我，就是旅行的意义");
        user.setNickName("木格窗");
        user.setPassword("nandem123");
        user.setPhoneNumber("13551274792");
        user.setRealName("叶明");
        user.setRegisterOrder(userService.getRegisterOrder());
        user.setRegisterTime(TimeUtils.getCurrentFormatDateWithTime());

        Message message = userService.register(user);

        System.out.println(message.getMessageContent());
    }
}
