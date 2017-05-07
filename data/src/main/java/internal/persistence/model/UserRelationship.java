package internal.persistence.model;

/**
 * @author Nandem on 2017-05-08.
 */
public class UserRelationship
{
    private int id;
    private int userFollow;
    private int userBeFollowed;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getUserFollow()
    {
        return userFollow;
    }

    public void setUserFollow(int userFollow)
    {
        this.userFollow = userFollow;
    }

    public int getUserBeFollowed()
    {
        return userBeFollowed;
    }

    public void setUserBeFollowed(int userBeFollowed)
    {
        this.userBeFollowed = userBeFollowed;
    }
}
