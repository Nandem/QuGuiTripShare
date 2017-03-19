package cn.nandem.qugui.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Nandem on 2017-02-02.
 */
@RequestMapping("/user")
@Controller
public class UserController
{
    private final Logger logger  =  LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/register")
    public String register()
    {
        logger.debug("注册用户...");
        return "/user/register";
    }

    @RequestMapping("/registerResult")
    public String registerResult(Model model)
    {
        if(true)
        {
            //注册成功界面，即个人主页
            return this.profile();
        }
        else
        {
            model.addAttribute("message", "注册失败");
            //注册失败界面，即提示信息页面
            return "/message";
        }
    }

    @RequestMapping("/login")
    public String login()
    {
        logger.info("login...");
        return "/user/login";
    }

    @RequestMapping("/loginResult")
    public String loginResult(Model model, String userName, String password)
    {
        if(userName.trim().equals("Nandem") && password.trim().equals("nandem123"))
        {
            //登录成功界面，即个人主页
            return this.profile();
        }
        else
        {
            model.addAttribute("message", "登录失败");
            //注册失败界面，即提示信息页面
            return "/message";
        }
    }

    @RequestMapping("/profile")
    public String profile()
    {
        return "/user/profile";
    }
}
