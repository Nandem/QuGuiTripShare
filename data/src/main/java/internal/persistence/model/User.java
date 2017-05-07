package internal.persistence.model;

/**
 * 用户基础信息载体类
 * @author Nandem on 2017-02-23.
 */
public class User
{
    private int id;
    private String nickName;
    private String realName;
    private String email;
    private String phoneNumber;
    private String idCardNo;
    private String registerTime;
    private int registerOrder;
    private String meaningOfTrip;
    private String headIcon;
    private String password;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getRealName()
    {
        return realName;
    }

    public void setRealName(String realName)
    {
        this.realName = realName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCardNo()
    {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo)
    {
        this.idCardNo = idCardNo;
    }

    public String getRegisterTime()
    {
        return registerTime;
    }

    public void setRegisterTime(String registerTime)
    {
        this.registerTime = registerTime;
    }

    public int getRegisterOrder()
    {
        return registerOrder;
    }

    public void setRegisterOrder(int registerOrder)
    {
        this.registerOrder = registerOrder;
    }

    public String getMeaningOfTrip()
    {
        return meaningOfTrip;
    }

    public void setMeaningOfTrip(String meaningOfTrip)
    {
        this.meaningOfTrip = meaningOfTrip;
    }

    public String getHeadIcon()
    {
        return headIcon;
    }

    public void setHeadIcon(String headIcon)
    {
        this.headIcon = headIcon;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
