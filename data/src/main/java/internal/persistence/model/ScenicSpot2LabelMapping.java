package internal.persistence.model;

/**
 * @author Nandem on 2017-05-08.
 */
public class ScenicSpot2LabelMapping
{
    private int id;
    private int affiliationScenicSpots;
    private int affiliationLabel;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getAffiliationScenicSpots()
    {
        return affiliationScenicSpots;
    }

    public void setAffiliationScenicSpots(int affiliationScenicSpots)
    {
        this.affiliationScenicSpots = affiliationScenicSpots;
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
