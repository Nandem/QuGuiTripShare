package data.internal.persistence.service;

import internal.persistence.model.ScenicSpot;
import internal.persistence.service.ScenicSpotService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author Nandem on 2017-05-13.
 */
public class ScenicSpotsTest extends BaseTest
{
    @Resource
    private ScenicSpotService scenicSpotService;

    @Test
    public void add()
    {
        ScenicSpot scenicSpot = new ScenicSpot();
        scenicSpot.setBriefIntroduction("111成都真的是一个好地方，真的好");
        scenicSpot.setCountry("中国");
        scenicSpot.setProvince("四川");
        scenicSpot.setName("成都");
        scenicSpot.setFolkCulture("111这是民俗特色介绍");
        scenicSpot.setFeature("111这里是特色介绍");
        scenicSpot.setOfficialComments("111这里是官方的推荐");

        System.out.println(scenicSpotService.add(scenicSpot));
    }
}
