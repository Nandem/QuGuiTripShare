package cn.nandem.qugui.controller;

import cn.nandem.qugui.utils.QuGuiConstants;
import internal.persistence.model.User;
import internal.persistence.service.UserService;
import message.Message;
import message.MessageEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author Nandem on 2017-05-09.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController
{
    @Resource
    private UserService userService;

    @RequestMapping("/me")
    public String me(String userID, String password, HttpSession session, Model model)
    {
        User user = userService.getUserByUseIDAndPassword(userID, password);
        if(user == null)
        {
            model.addAttribute(QuGuiConstants.ATTR_NAME_MESSAGE, new Message("未进入个人主页", MessageEnum.USER_DATA_ERROR));
            return QuGuiConstants.URLS.MESSAGE;
        }

        session.setAttribute("user", user);

        return QuGuiConstants.URLS.PROFILE;
    }


}
