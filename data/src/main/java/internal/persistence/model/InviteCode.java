package internal.persistence.model;

/**
 * @author Nandem on 2017-05-08.
 */
public class InviteCode
{
    private int id;
    private String inviteCode;
    private int remainingTimes;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getInviteCode()
    {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode)
    {
        this.inviteCode = inviteCode;
    }

    public int getRemainingTimes()
    {
        return remainingTimes;
    }

    public void setRemainingTimes(int remainingTimes)
    {
        this.remainingTimes = remainingTimes;
    }
}
