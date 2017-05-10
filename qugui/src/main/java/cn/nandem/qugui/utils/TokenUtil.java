package cn.nandem.qugui.utils;

import java.security.MessageDigest;
import java.util.Random;

/**
 * @author Nandem on 2017-05-10.
 */
public class TokenUtil
{
    private static String BASE_STR = "WoDeMingZiShiYeMing_ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static Random random = new Random();
    private static final String ENCRY_MODEL = "MD5";

    public static String generateToken(String nickName, String password)
    {
        return md5(nickName + getRandomString(random.nextInt(BASE_STR.length())) + password);
    }

    public static String getRandomString(int length)
    {
        //length表示生成字符串的长度
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < length; i++)
        {
            int number = random.nextInt(BASE_STR.length());
            sb.append(BASE_STR.charAt(number));
        }
        return sb.toString();
    }

    private static String md5(String str)
    {
        return encrypt(ENCRY_MODEL, str);
    }

    private static String encrypt(String algorithm, String str)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(str.getBytes());
            StringBuffer sb = new StringBuffer();
            byte[] bytes = md.digest();
            for(int i = 0; i < bytes.length; i++)
            {
                int b = bytes[i] & 0xFF;
                if(b < 0x10)
                {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(b));
            }
            return sb.toString();
        }
        catch(Exception e)
        {
            return "";
        }
    }
}
