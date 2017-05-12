package internal.persistence.service;

import internal.persistence.dao.FootprintDao;
import internal.persistence.model.Footprint;
import internal.persistence.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    private List<Footprint> getFootprintListByUser(String affiliationUser)
    {
        return footprintDao.getFootprintListByUser(affiliationUser);
    }

    public List<Footprint> getSharedFootprintByUser(String affiliationUser)
    {
        List<Footprint> temFootprintList = new ArrayList<>();
        List<Footprint> oriFootprintList = getFootprintListByUser(affiliationUser);
        for(Footprint f : oriFootprintList)
        {
            if(f.getState() == 0)
                temFootprintList.add(f);
        }
        return temFootprintList;
    }
    public List<Footprint> getNotSharedFootprintByUser(String affiliationUser)
    {
        List<Footprint> temFootprintList = new ArrayList<>();
        List<Footprint> oriFootprintList = getFootprintListByUser(affiliationUser);
        for(Footprint f : oriFootprintList)
        {
            if(f.getState() != 0)
                temFootprintList.add(f);
        }
        return temFootprintList;
    }

    public Footprint getFootprintById(String footprintID)
    {
        return footprintDao.retrieve(footprintID);
    }

    public User getAffiliationUser(String footprintID)
    {
        return footprintDao.getAffiliationUser(footprintID);
    }

    public List<Footprint> getSearchResult(String key)
    {
        return footprintDao.getSearchResult(key);
    }
}
