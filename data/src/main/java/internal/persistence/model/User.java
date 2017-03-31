package internal.persistence.model;

/**
 * 用户基础信息载体类
 * @author Nandem on 2017-02-23.
 */
public class User
{
    private int id;//用户id，主要用作数据库主键
    private String nickName = "";//昵称
    private String userID = "";//用户ID，全站唯一，注意与主键区分
    private String idCard = "";//身份证号码（用来防止敌特渗透，网络爱国人人有责）
    private String tel = "";//电话号码
    private String email = "";//电子邮箱
    private String password = "";//密码
    private String headIconPath = "";//用户头像路径（如果可能的话，将会把头像什么的存在别的服务器）
    private String registerDate = "";//用户注册日期

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getRegisterDate()
    {
        return registerDate;
    }

    public void setRegisterDate(String registerDate)
    {
        this.registerDate = registerDate;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getUserID()
    {
        return userID;
    }

    public void setUserID(String userID)
    {
        this.userID = userID;
    }

    public String getIdCard()
    {
        return idCard;
    }

    public void setIdCard(String idCard)
    {
        this.idCard = idCard;
    }

    public String getHeadIconPath()
    {
        return headIconPath;
    }

    public void setHeadIconPath(String headIconPath)
    {
        this.headIconPath = headIconPath;
    }

    public String getTel()
    {
        return tel;
    }

    public void setTel(String tel)
    {
        this.tel = tel;
    }
}
