package cn.nandem.qugui.controller;

import cn.nandem.qugui.utils.QuGuiConstants;
import com.alibaba.fastjson.JSON;
import date.TimeUtils;
import internal.persistence.model.User;
import internal.persistence.service.UserService;
import message.Message;
import message.MessageEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Nandem on 2017-02-02.
 */
@RequestMapping("/")
@Controller
public class IndexController
{
    private final Logger logger  =  LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("index")
    public String index()
    {
        return QuGuiConstants.URLS.INDEX;
    }
}
