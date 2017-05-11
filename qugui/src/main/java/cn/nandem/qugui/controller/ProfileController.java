package cn.nandem.qugui.controller;

import Image.ImageUtil;
import cn.nandem.qugui.utils.QuGuiConstants;
import cn.nandem.qugui.utils.TokenUtil;
import com.alibaba.fastjson.JSON;
import external.weather.WeatherDataManager;
import external.weather.model.Weather;
import internal.persistence.model.Footprint;
import internal.persistence.model.User;
import internal.persistence.service.FootprintService;
import internal.persistence.service.UserService;
import message.Message;
import message.MessageEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Nandem on 2017-05-09.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController
{
    @Resource
    private UserService userService;
    @Resource
    private FootprintService footprintService;

    @RequestMapping(value = "/me")
    public String me(String userID, String password, HttpSession session, Model model)
    {
        User user = userService.getUserByUseIDAndPassword(userID, password);
        if(user == null)
        {
            model.addAttribute(QuGuiConstants.ATTR_NAME_MESSAGE, new Message("未进入个人主页", MessageEnum.USER_DATA_ERROR));
            return QuGuiConstants.URLS.MESSAGE;
        }

        String temHeadIconStr = ImageUtil.getInstance().getImage(user.getId() + "", ImageUtil.ImageType.HEAD_ICON);
        if(!temHeadIconStr.equals(""))
            user.setHeadIcon("data:image/png;base64," + temHeadIconStr);

        user.setPassword("");

        session.setAttribute("user", user);
        session.setAttribute("token", TokenUtil.generateToken(user.getNickName(), user.getPassword()));

        fillScheduling(userID, model);

        return QuGuiConstants.URLS.PROFILE;
    }

    private void fillScheduling(String userID, Model model)
    {
        List<Footprint> footprintList = footprintService.getFootprintListByUser(userID);
        model.addAttribute("footprintList", footprintList);
    }

    @ResponseBody
    @RequestMapping("/updateHeadIcon")
    public boolean updateHeadIcon(String token, String userID, String headIconStr, HttpSession session)
    {
        return session.getAttribute("token").equals(token) && ImageUtil.getInstance().saveImage(userID, headIconStr, ImageUtil.ImageType.HEAD_ICON);
    }


    @ResponseBody
    @RequestMapping("/updatePersonalInfo")
    public boolean updatePersonalInfo(String token, User user, HttpSession session)
    {
        System.out.println(session.getAttribute("token").equals(token));
        return session.getAttribute("token").equals(token) && userService.updateUser(user);
    }

    @ResponseBody
    @RequestMapping("/scenicSpotWeather")
    public String scenicSpotsWeather(String scenicSpot) throws IOException
    {
        Map map = new HashMap();
        Weather weather = WeatherDataManager.getInstance().getLiveWeather(scenicSpot);
        map.put("weather", weather);

        return JSON.toJSONString(map);
    }

    @ResponseBody
    @RequestMapping("/createScheduling")
    public boolean createScheduling(String token, Footprint footprint, HttpSession session) throws IOException
    {
        footprint.setCountry("中国");
        footprint.setProvince("河山");
        footprint.setState(1);
        return session.getAttribute("token").equals(token) && footprintService.createFootprint(footprint);
    }
}
