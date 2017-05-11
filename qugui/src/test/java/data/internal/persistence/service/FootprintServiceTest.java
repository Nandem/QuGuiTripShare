package data.internal.persistence.service;

import internal.persistence.model.Footprint;
import internal.persistence.service.FootprintService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author Nandem on 2017-05-11.
 */
public class FootprintServiceTest extends BaseTest
{
    @Resource
    private FootprintService footprintService;

    @Test
    public void add()
    {
        Footprint footprint = new Footprint();

        footprint.setAffiliationUser(21);
        footprint.setCommentsAmount(123);
        footprint.setLikeAmount(321);
        footprint.setReadAmount(213);
        footprint.setCountry("中国");
        footprint.setProvince("四川");
        footprint.setName("成都");
        footprint.setState(1);
        footprint.setStartDate("2017-5-11");
        footprint.setEndDate("2017-5-12");
        footprint.setDescribe1("describe1");
        footprint.setDescribe2("describe2");
        footprint.setDescribe3("describe3");
        footprint.setDescribe4("describe4");
        footprint.setDescribe5("describe5");
        footprint.setDescribe6("describe6");
        footprint.setImage1("image1");
        footprint.setImage2("image2");
        footprint.setImage3("image3");
        footprint.setImage4("image4");
        footprint.setImage5("image5");
        footprint.setImage6("image6");

        System.out.println(footprintService.createFootprint(footprint));
    }

    @Test
    public void modify()
    {

        Footprint footprint = new Footprint();
        footprint.setId(1);

        footprint.setAffiliationUser(21);
        footprint.setCommentsAmount(123);
        footprint.setLikeAmount(321);
        footprint.setReadAmount(213);
        footprint.setCountry("中国");
        footprint.setProvince("云南");
        footprint.setName("大理");
//        footprint.setState(1);
//        footprint.setStartDate("2017-5-11");
//        footprint.setEndDate("2017-5-12");
//        footprint.setDescribe1("describe1");
//        footprint.setDescribe2("describe2");
//        footprint.setDescribe3("describe3");
//        footprint.setDescribe4("describe4");
//        footprint.setDescribe5("describe5");
//        footprint.setDescribe6("describe6");
//        footprint.setImage1("image1");
//        footprint.setImage2("image2");
//        footprint.setImage3("image3");
//        footprint.setImage4("image4");
//        footprint.setImage5("image5");
//        footprint.setImage6("image6");

        System.out.println(footprintService.updateFootprint(footprint));
    }
}
