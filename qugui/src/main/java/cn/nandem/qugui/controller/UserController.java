package cn.nandem.qugui.controller;

import cn.nandem.qugui.utils.QuGuiConstants;
import cn.nandem.qugui.utils.TokenUtil;
import com.alibaba.fastjson.JSON;
import date.TimeUtils;
import internal.persistence.model.User;
import internal.persistence.service.InviteCodeService;
import internal.persistence.service.UserService;
import message.Message;
import message.MessageEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Nandem on 2017-02-02.
 */
@RequestMapping("/user")
@Controller
public class UserController
{
    private final Logger logger  =  LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;
    @Resource
    private InviteCodeService inviteCodeService;

    @RequestMapping("/link/register")
    public String registerLink()
    {
        logger.debug("进入用户注册页面...");
        return QuGuiConstants.URLS.REGISTER;
    }

    @ResponseBody
    @RequestMapping("/validation/duplication")
    public boolean duplicationValidation(String account)
    {
        return userService.duplicationValidation(account);
    }

    @ResponseBody
    @RequestMapping("/register")
    public String register(String inviteCode, User user, HttpSession session)
    {
        logger.debug("注册用户...");
        Map map = new HashMap();

        int rt = inviteCodeService.retrieveRemainingTimes(inviteCode);
        if(rt > 0)
        {
            int registerOrder = userService.getRegisterOrder() + 1;
            String currentDateWithTime = TimeUtils.getCurrentFormatDateWithTime();

            user.setRegisterOrder(registerOrder);
            user.setRegisterTime(currentDateWithTime);
            user.setHeadIcon("");

            if(userService.register(user))
            {
                //TODO 注册成功
                map.put("registerCode", 1);
                map.put("registerOrder", registerOrder);
                map.put("registerDate", currentDateWithTime.split(" ")[0]);
                //注册成功后，验证码使用次数减少一次
                inviteCodeService.decreaseTimes(inviteCode);
                User userWidthID = userService.getUserByAccountAndPassword(user.getEmail(), user.getPassword());
                session.setAttribute("user", userWidthID);
                map.put("result", userWidthID);
            }
            else
            {
                //TODO 注册失败
                map.put("registerCode", 2);
                map.put("error", MessageEnum.REGISTER_FAIL.getContent());
            }

        }
        else
        {
            map.put("registerCode", 0);
        }

        return JSON.toJSONString(map);
    }

    @RequestMapping("/link/login")
    public String loginLink()
    {
        logger.info("进入登录页面...");
        return QuGuiConstants.URLS.LOGIN;
    }

    @ResponseBody
    @RequestMapping("/login")
    public String login(String account, String password, HttpSession session)
    {
        logger.info("LOGIN...");
        Map map = new HashMap<>();
        User user = userService.getUserByAccountAndPassword(account, password);
        //登录失败的处理
        if(user == null)
        {
            map.put("resultCode", false);
            map.put("result", new Message(MessageEnum.NAME_OR_PASSWORD_WRONG));
            return JSON.toJSONString(map);
        }
        else
        {
            map.put("resultCode", true);
            map.put("result", user);
            session.setAttribute("user", user);
            //TODO 千万要注意，下面这句代码是用来设置session的过期时间的，目的是测试登录控制是否正确执行。
            session.setMaxInactiveInterval(30);
            session.setAttribute("token", TokenUtil.generateToken(user.getNickName(), user.getPassword()));
            return JSON.toJSONString(map);
        }
    }

}
