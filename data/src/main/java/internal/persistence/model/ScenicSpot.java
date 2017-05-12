package internal.persistence.model;

/**
 * @author Nandem on 2017-05-08.
 */
public class ScenicSpot
{
    private int id;
    private int likeAmount;
    private String name;
    private String country;
    private String province;
    private String briefIntroduction;
    private String folkCulture;
    private String feature;
    private String officialComments;

    public int getLikeAmount()
    {
        return likeAmount;
    }

    public void setLikeAmount(int likeAmount)
    {
        this.likeAmount = likeAmount;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getBriefIntroduction()
    {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction)
    {
        this.briefIntroduction = briefIntroduction;
    }

    public String getFolkCulture()
    {
        return folkCulture;
    }

    public void setFolkCulture(String folkCulture)
    {
        this.folkCulture = folkCulture;
    }

    public String getFeature()
    {
        return feature;
    }

    public void setFeature(String feature)
    {
        this.feature = feature;
    }

    public String getOfficialComments()
    {
        return officialComments;
    }

    public void setOfficialComments(String officialComments)
    {
        this.officialComments = officialComments;
    }
}
