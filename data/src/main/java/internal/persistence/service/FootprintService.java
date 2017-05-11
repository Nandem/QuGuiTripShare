package internal.persistence.service;

import internal.persistence.dao.FootprintDao;
import internal.persistence.model.Footprint;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Nandem on 2017-05-11.
 */
@Service
@Transactional
public class FootprintService
{
    @Resource
    private FootprintDao footprintDao;

    public boolean createFootprint(Footprint footprint)
    {
        try
        {
            footprintDao.add(footprint);
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }


    public boolean updateFootprint(Footprint footprint)
    {
        try
        {
            footprintDao.modify(footprint);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public List<Footprint> getFootprintListByUser(String affiliationUser)
    {
        return footprintDao.getFootprintListByUser(affiliationUser);
    }

    public Footprint getFootprintById(String footprintID)
    {
        return footprintDao.retrieve(footprintID);
    }
}
