package internal.persistence.model;

/**
 * @author Nandem on 2017-05-08.
 */
public class Notification
{
    private int id;
    private int affiliationUser;
    private String time;
    private int state;
    private String content;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getAffiliationUser()
    {
        return affiliationUser;
    }

    public void setAffiliationUser(int affiliationUser)
    {
        this.affiliationUser = affiliationUser;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public int getState()
    {
        return state;
    }

    public void setState(int state)
    {
        this.state = state;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }
}
