package internal.persistence.service;

import internal.persistence.dao.InviteCodeDao;
import internal.persistence.model.InviteCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Nandem on 2017-05-09.
 */
@Service
@Transactional
public class InviteCodeService
{
    @Resource
    private InviteCodeDao inviteCodeDao;

    public int retrieveRemainingTimes(String inviteCode)
    {
        try
        {
            return inviteCodeDao.retrieveRemainingTimes(inviteCode);
        }
        catch(Exception e)
        {
            return -1;
        }
    }

    public boolean decreaseTimes(String inviteCode)
    {
        try
        {
            inviteCodeDao.decreaseTimes(inviteCode);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public boolean add(InviteCode inviteCode)
    {
        try
        {
            inviteCodeDao.add(inviteCode);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
