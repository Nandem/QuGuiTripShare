package message;

import org.junit.Test;

/**
 * @author Nandem on 2017-05-09.
 */
public class MessageEnumTest
{
    @Test
    public void test()
    {
        MessageEnum a = MessageEnum.NAME_OR_PASSWORD_WRONG;
        MessageEnum b = MessageEnum.USER_ALREADY_EXIST;

        System.out.println(a.getCode());
        System.out.println(a.getContent());
        System.out.println(b.getCode());
        System.out.println(b.getContent());
    }
}
