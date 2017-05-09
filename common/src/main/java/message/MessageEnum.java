package message;

/**
 * @author Nandem on 2017-05-09.
 */
public enum MessageEnum
{
    INTERNAL_ERROR(0, "系统内部错误"),
    NAME_OR_PASSWORD_WRONG(1, "用户名或密码错误"),
    USER_ALREADY_EXIST(2, "该用户已存在"),
    REGISTER_SUCCESS(3, "注册成功"),
    REGISTER_FAIL(4, "注册失败"),
    USER_DATA_ERROR(5, "用户数据异常")
    ;

    private int code;
    private String content;
    private MessageEnum(int code, String content)
    {
        this.code = code;
        this.content = content;
    }

    public int getCode()
    {
        return this.code;
    }

    public String getContent()
    {
        return this.content;
    }
}
