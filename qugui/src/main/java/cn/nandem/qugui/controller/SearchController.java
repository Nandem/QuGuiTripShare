package cn.nandem.qugui.controller;

import cn.nandem.qugui.utils.QuGuiConstants;
import internal.persistence.model.Footprint;
import internal.persistence.model.ScenicSpot;
import internal.persistence.model.User;
import internal.persistence.service.FootprintService;
import internal.persistence.service.ScenicSpotService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Nandem on 2017-05-12.
 */
@Controller
@RequestMapping("/search")
public class SearchController
{
    @Resource
    private FootprintService footprintService;
    @Resource
    private ScenicSpotService scenicSpotService;

    @RequestMapping("/searchPlace")
    public String searchFromIndex(String key, Model model)
    {
        List<Footprint> footprintList = footprintService.getSearchResult(key);
        model.addAttribute("footprintList", footprintList);
        return QuGuiConstants.URLS.SEARCH;
    }


    @RequestMapping("/searchPlaceFromIntroduction")
    public String searchPlaceFromIntroduction(String key,String scenicSpotID, Model model)
    {
        List<Footprint> footprintList = footprintService.getSearchResult(key);
        model.addAttribute("footprintList", footprintList);

        ScenicSpot scenicSpot = scenicSpotService.retrieve(scenicSpotID);
        scenicSpot.setLikeAmount(scenicSpot.getLikeAmount() + 1);
        scenicSpotService.updateScenicSpot(scenicSpot);

        return QuGuiConstants.URLS.SEARCH;
    }

    @ResponseBody
    @RequestMapping("/like")
    public boolean like(String footprintID)
    {
        Footprint footprint = footprintService.getFootprintById(footprintID);
        User user = footprintService.getAffiliationUser(footprintID);
        footprint.setAffiliationUser(user.getId());
        footprint.setLikeAmount(footprint.getLikeAmount() + 1);
        return footprintService.updateFootprint(footprint);
    }
}
