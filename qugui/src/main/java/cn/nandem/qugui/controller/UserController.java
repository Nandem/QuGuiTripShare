package cn.nandem.qugui.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Nandem on 2017-02-02.
 */
@Controller
public class UserController
{
    private final Logger logger  =  LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/register")
    public String register()
    {
        logger.debug("注册用户...");
        return "/user/registerResult";
    }

    @RequestMapping("/login")
    public String login()
    {
        logger.info("login...");
        return "/user/login";
    }

    @RequestMapping("/loginResult")
    public String loginResult()
    {
        logger.info("loginResult...");
        return "/user/loginResult";
    }
}
