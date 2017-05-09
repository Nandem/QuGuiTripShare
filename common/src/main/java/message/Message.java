package message;

/**
 * @author Nandem on 2017-05-09.
 */
public class Message
{
    private int messageCode;
    private String messageContent;
    private String messageResult;

    public String getMessageResult()
    {
        return messageResult;
    }

    public void setMessageResult(String messageResult)
    {
        this.messageResult = messageResult;
    }

    public Message(String messageResult, MessageEnum messageEnum)
    {
        this.messageCode = messageEnum.getCode();
        this.messageContent = messageEnum.getContent();
        this.messageResult = messageResult;
    }
    public Message(MessageEnum messageEnum)
    {
        this.messageCode = messageEnum.getCode();
        this.messageContent = messageEnum.getContent();
    }

    public Message(String messageContent)
    {
        this.messageContent = messageContent;
    }

    public Message(int messageCode)
    {
        this.messageCode = messageCode;
    }

    public Message(int messageCode, String messageContent)
    {
        this.messageCode = messageCode;
        this.messageContent = messageContent;
    }

    public int getMessageCode()
    {
        return messageCode;
    }

    public void setMessageCode(int messageCode)
    {
        this.messageCode = messageCode;
    }

    public String getMessageContent()
    {
        return messageContent;
    }

    public void setMessageContent(String messageContent)
    {
        this.messageContent = messageContent;
    }
}
