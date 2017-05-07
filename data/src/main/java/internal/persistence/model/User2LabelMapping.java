package internal.persistence.model;

/**
 * @author Nandem on 2017-05-08.
 */
public class User2LabelMapping
{
    private int id;
    private int affiliationUser;
    private int affiliationLabel;

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

    public int getAffiliationLabel()
    {
        return affiliationLabel;
    }

    public void setAffiliationLabel(int affiliationLabel)
    {
        this.affiliationLabel = affiliationLabel;
    }
}
