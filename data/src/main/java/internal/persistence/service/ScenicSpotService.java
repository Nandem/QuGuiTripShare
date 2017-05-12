package internal.persistence.service;

import internal.persistence.dao.ScenicSpotDao;
import internal.persistence.model.ScenicSpot;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Nandem on 2017-05-13.
 */
@Service
public class ScenicSpotService
{
    @Resource
    private ScenicSpotDao scenicSpotDao;

    public boolean add(ScenicSpot scenicSpot)
    {
        try
        {
            scenicSpotDao.add(scenicSpot);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public boolean updateScenicSpot(ScenicSpot scenicSpot)
    {
        try
        {
            scenicSpotDao.modify(scenicSpot);
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public ScenicSpot retrieve(String id)
    {
        return scenicSpotDao.retrieve(id);
    }

    public List<ScenicSpot> retriveAll()
    {
        return scenicSpotDao.retrieveAll();
    }
}
