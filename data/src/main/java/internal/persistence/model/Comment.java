package internal.persistence.model;

/**
 * @author Nandem on 2017-05-08.
 */
public class Comment
{
    private int id;
    private int affiliationFootprint;
    private int affiliationUser;
    private String time;
    private String content;
    private String like;
    private String unlike;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getAffiliationFootprint()
    {
        return affiliationFootprint;
    }

    public void setAffiliationFootprint(int affiliationFootprint)
    {
        this.affiliationFootprint = affiliationFootprint;
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

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getLike()
    {
        return like;
    }

    public void setLike(String like)
    {
        this.like = like;
    }

    public String getUnlike()
    {
        return unlike;
    }

    public void setUnlike(String unlike)
    {
        this.unlike = unlike;
    }
}
