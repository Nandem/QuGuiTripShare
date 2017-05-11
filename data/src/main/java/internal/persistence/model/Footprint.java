package internal.persistence.model;

/**
 * @author Nandem on 2017-05-08.
 */
public class Footprint
{
    private int id;
    private int affiliationUser;
    private int likeAmount;
    private int commentsAmount;
    private int readAmount;
    private String name;
    private String country;
    private String province;
    private String startDate;
    private String endDate;
    private int state;
    private String describe1 = "describe1";
    private String describe2 = "describe2";
    private String describe3 = "describe3";
    private String describe4 = "describe4";
    private String describe5 = "describe5";
    private String describe6 = "describe6";
    private String image1 = "";
    private String image2 = "";
    private String image3 = "";
    private String image4 = "";
    private String image5 = "";
    private String image6 = "";

    @Override
    public String toString()
    {
        return String.format("{id: %d, affiliationUser: %d, likeAmount: %d, commentsAmount: %d, readAmount: %d, name: %s, country: %s, province: %s, state: %d, startDate: %s,endDate: %s,describe1: %s, describe2: %s, describe3: %s, describe4: %s, describe5: %s, describe6: %s, image1: %s, image2: %s, image3: %s, image4: %s, image5: %s, image6: %s}", id, affiliationUser, likeAmount, commentsAmount, readAmount, name, country, province, state, startDate, endDate, describe1, describe2, describe3, describe4, describe5, describe6, image1, image2, image3, image4, image5, image6);
    }


    public String getStartDate()
    {
        return startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

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

    public int getLikeAmount()
    {
        return likeAmount;
    }

    public void setLikeAmount(int likeAmount)
    {
        this.likeAmount = likeAmount;
    }

    public int getCommentsAmount()
    {
        return commentsAmount;
    }

    public void setCommentsAmount(int commentsAmount)
    {
        this.commentsAmount = commentsAmount;
    }

    public int getReadAmount()
    {
        return readAmount;
    }

    public void setReadAmount(int readAmount)
    {
        this.readAmount = readAmount;
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

    public int getState()
    {
        return state;
    }

    public void setState(int state)
    {
        this.state = state;
    }

    public String getDescribe1()
    {
        return describe1;
    }

    public void setDescribe1(String describe1)
    {
        this.describe1 = describe1;
    }

    public String getDescribe2()
    {
        return describe2;
    }

    public void setDescribe2(String describe2)
    {
        this.describe2 = describe2;
    }

    public String getDescribe3()
    {
        return describe3;
    }

    public void setDescribe3(String describe3)
    {
        this.describe3 = describe3;
    }

    public String getDescribe4()
    {
        return describe4;
    }

    public void setDescribe4(String describe4)
    {
        this.describe4 = describe4;
    }

    public String getDescribe5()
    {
        return describe5;
    }

    public void setDescribe5(String describe5)
    {
        this.describe5 = describe5;
    }

    public String getDescribe6()
    {
        return describe6;
    }

    public void setDescribe6(String describe6)
    {
        this.describe6 = describe6;
    }

    public String getImage1()
    {
        return image1;
    }

    public void setImage1(String image1)
    {
        this.image1 = image1;
    }

    public String getImage2()
    {
        return image2;
    }

    public void setImage2(String image2)
    {
        this.image2 = image2;
    }

    public String getImage3()
    {
        return image3;
    }

    public void setImage3(String image3)
    {
        this.image3 = image3;
    }

    public String getImage4()
    {
        return image4;
    }

    public void setImage4(String image4)
    {
        this.image4 = image4;
    }

    public String getImage5()
    {
        return image5;
    }

    public void setImage5(String image5)
    {
        this.image5 = image5;
    }

    public String getImage6()
    {
        return image6;
    }

    public void setImage6(String image6)
    {
        this.image6 = image6;
    }
}
