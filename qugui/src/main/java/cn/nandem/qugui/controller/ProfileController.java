package cn.nandem.qugui.controller;

import Image.ImageUtil;
import cn.nandem.qugui.utils.QuGuiConstants;
import cn.nandem.qugui.utils.TokenUtil;
import com.alibaba.fastjson.JSON;
import external.weather.WeatherDataManager;
import external.weather.model.Weather;
import internal.persistence.model.Footprint;
import internal.persistence.model.ScenicSpot;
import internal.persistence.model.User;
import internal.persistence.service.FootprintService;
import internal.persistence.service.ScenicSpotService;
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
import java.util.*;

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
    @Resource
    private ScenicSpotService scenicSpotService;

    @RequestMapping(value = "/me")
    public String me(String userID, String password, HttpSession session, Model model)
    {
        User user = userService.getUserByUseIDAndPassword(userID, password);
        if(user == null)
        {
            model.addAttribute(QuGuiConstants.ATTR_NAME_MESSAGE, new Message("无法进入个人主页", MessageEnum.USER_DATA_ERROR));
            return QuGuiConstants.URLS.MESSAGE;
        }

        String temHeadIconStr = ImageUtil.getInstance().getImage(user.getId() + "", ImageUtil.ImageType.HEAD_ICON);
        if(!temHeadIconStr.equals(""))
            user.setHeadIcon("data:image/png;base64," + temHeadIconStr);

        user.setPassword("");

        session.setAttribute("user", user);
        session.setAttribute("token", TokenUtil.generateToken(user.getNickName(), user.getPassword()));

        fillScenicSpot(model);
        fillFootprint(userID, model);
        fillScheduling(userID, model);

        return QuGuiConstants.URLS.PROFILE;
    }

    private void fillScenicSpot(Model model)
    {
        List<ScenicSpot> scenicSpotList = scenicSpotService.retriveAll();
        model.addAttribute("scenicSpotList", scenicSpotList);
    }

    private void fillFootprint(String userID, Model model)
    {
        List<Footprint> footprintListShared = footprintService.getSharedFootprintByUser(userID);
        footprintListShared.sort(Comparator.comparing(Footprint::getEndDate));

        model.addAttribute("footprintListShared", footprintListShared);
    }

    private void fillScheduling(String userID, Model model)
    {
        List<Footprint> footprintListNotShared = footprintService.getNotSharedFootprintByUser(userID);
        footprintListNotShared.sort((o1, o2) -> new Integer(o1.getState()).compareTo(o2.getState()));

        model.addAttribute("footprintListNotShared", footprintListNotShared);
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
        footprint.setSummary("一个人，一条路，人在途中，心随景动，从起点，到尽头。");
        footprint.setDescribe1("（未填写）:请输入50字以上描述");
        footprint.setDescribe2("（未填写）:请输入50字以上描述");
        footprint.setDescribe3("（未填写）:请输入50字以上描述");
        footprint.setDescribe4("（未填写）:请输入50字以上描述");
        footprint.setDescribe5("（未填写）:请输入50字以上描述");
        footprint.setDescribe6("（未填写）:请输入50字以上描述");
        footprint.setState(1);
        return session.getAttribute("token").equals(token) && footprintService.createFootprint(footprint);
    }

    @RequestMapping("/link/share")
    public String linkShare(String token, String footprintID, Model model, HttpSession session)
    {
        if(!session.getAttribute("token").equals(token))
        {
            Message message = new Message("无法分享", MessageEnum.TOKEN_INVALIDATE);
            model.addAttribute(QuGuiConstants.ATTR_NAME_MESSAGE, message);
            return QuGuiConstants.URLS.MESSAGE;
        }
        Footprint footprint = footprintService.getFootprintById(footprintID);
        footprint.setImage1("data:image/png;base64," + ImageUtil.getInstance().getImage(footprint.getId() + "-1", ImageUtil.ImageType.FOOTPRINT_IMAGE));
        footprint.setImage2("data:image/png;base64," + ImageUtil.getInstance().getImage(footprint.getId() + "-2", ImageUtil.ImageType.FOOTPRINT_IMAGE));
        footprint.setImage3("data:image/png;base64," + ImageUtil.getInstance().getImage(footprint.getId() + "-3", ImageUtil.ImageType.FOOTPRINT_IMAGE));
        footprint.setImage4("data:image/png;base64," + ImageUtil.getInstance().getImage(footprint.getId() + "-4", ImageUtil.ImageType.FOOTPRINT_IMAGE));
        footprint.setImage5("data:image/png;base64," + ImageUtil.getInstance().getImage(footprint.getId() + "-5", ImageUtil.ImageType.FOOTPRINT_IMAGE));
        footprint.setImage6("data:image/png;base64," + ImageUtil.getInstance().getImage(footprint.getId() + "-6", ImageUtil.ImageType.FOOTPRINT_IMAGE));
        model.addAttribute("footprint", footprint);
        return QuGuiConstants.URLS.SHARE;
    }

    @ResponseBody
    @RequestMapping("/share")
    public boolean share(String token, Footprint footprint, HttpSession session)
    {
        if(!session.getAttribute("token").equals(token))
        {
            return false;
        }
        else
        {
            Footprint footprint1 = footprintService.getFootprintById(String.valueOf(footprint.getId()));
            copyFootprint(footprint1, footprint, 0);
            return footprintService.updateFootprint(footprint1);
        }
    }

    @ResponseBody
    @RequestMapping("/cache")
    public boolean cache(String token, Footprint footprint, HttpSession session)
    {
        if(!session.getAttribute("token").equals(token))
        {
            return false;
        }
        else
        {
            Footprint footprint1 = footprintService.getFootprintById(String.valueOf(footprint.getId()));
            copyFootprint(footprint1, footprint, 3);
            return footprintService.updateFootprint(footprint1);
        }
    }

    private void copyFootprint(Footprint footprint1, Footprint footprint, int state)
    {
        footprint1.setDescribe1(footprint.getDescribe1());
        footprint1.setDescribe2(footprint.getDescribe2());
        footprint1.setDescribe3(footprint.getDescribe3());
        footprint1.setDescribe4(footprint.getDescribe4());
        footprint1.setDescribe5(footprint.getDescribe5());
        footprint1.setDescribe6(footprint.getDescribe6());
        footprint1.setState(state);
    }

    @RequestMapping("/location")
    public String location(String footprintID, Model model)
    {
        User user = footprintService.getAffiliationUser(footprintID);
        user.setHeadIcon("data:image/png;base64," + ImageUtil.getInstance().getImage(String.valueOf(user.getId()), ImageUtil.ImageType.HEAD_ICON));
        Footprint footprint = footprintService.getFootprintById(footprintID);
        footprint.setReadAmount(footprint.getReadAmount() + 1);
        footprintService.updateFootprint(footprint);
        footprint.setImage1("data:image/png;base64," + ImageUtil.getInstance().getImage(footprint.getId() + "-1", ImageUtil.ImageType.FOOTPRINT_IMAGE));
        footprint.setImage2("data:image/png;base64," + ImageUtil.getInstance().getImage(footprint.getId() + "-2", ImageUtil.ImageType.FOOTPRINT_IMAGE));
        footprint.setImage3("data:image/png;base64," + ImageUtil.getInstance().getImage(footprint.getId() + "-3", ImageUtil.ImageType.FOOTPRINT_IMAGE));
        footprint.setImage4("data:image/png;base64," + ImageUtil.getInstance().getImage(footprint.getId() + "-4", ImageUtil.ImageType.FOOTPRINT_IMAGE));
        footprint.setImage5("data:image/png;base64," + ImageUtil.getInstance().getImage(footprint.getId() + "-5", ImageUtil.ImageType.FOOTPRINT_IMAGE));
        footprint.setImage6("data:image/png;base64," + ImageUtil.getInstance().getImage(footprint.getId() + "-6", ImageUtil.ImageType.FOOTPRINT_IMAGE));

        model.addAttribute("footprint", footprint);
        model.addAttribute("user", user);

        return QuGuiConstants.URLS.LOCATION;
    }

    @RequestMapping("/scenicSpot")
    public String scenicSpot(String scenicSpotID, Model model)
    {
        ScenicSpot scenicSpot = scenicSpotService.retrieve(scenicSpotID);
        model.addAttribute("scenicSpot", scenicSpot);

        return QuGuiConstants.URLS.SCENICSPOT;
    }
}
