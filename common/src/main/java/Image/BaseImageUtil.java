package Image;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * 图标处理基类
 * @author by Nandem on 17-3-30.
 */
public abstract class BaseImageUtil
{
    private static BASE64Encoder encoder = new BASE64Encoder();
    private static BASE64Decoder decoder = new BASE64Decoder();
    /**
     * 将图片转换为BASE64加密字符串.
     * @param imagePath 图片路径.
     * @return 某张图片经过base64转换后的字符串
     */
    public String convertImageToByte(String imagePath) throws Exception
    {
        File file = new File(imagePath);
        BufferedImage bi = null;
        ByteArrayOutputStream baos = null;
        String result = null;
        try
        {
            bi = ImageIO.read(file);
            baos = new ByteArrayOutputStream();
            ImageIO.write(bi, imagePath.split("\\.")[1], baos);
            byte[] bytes = baos.toByteArray();
            result = encoder.encodeBuffer(bytes).trim();
            System.out.println("将图片转换为BASE64加密字符串成功！");
        }
        catch(IOException e)
        {
//            throw new Exception(e);
            return "";
        }
        finally
        {
            try
            {
                if(baos != null)
                {
                    baos.close();
                    baos = null;
                }
            }
            catch(Exception e)
            {
                System.out.println("关闭文件流发生异常: " + e);
            }
        }
        return result;
    }

    /**
     * 将图片流转换为BASE64加密字符串.
     *
     * @param imageInputStream 图片输入流
     * @param format           图片格式.
     * @return 某个图片输入流经过转化后的base64字符串
     */
    public String convertImageStreamToByte(InputStream imageInputStream, String format)
    {
        BufferedImage bi = null;
        ByteArrayOutputStream baos = null;
        String result = null;
        try
        {
            bi = ImageIO.read(imageInputStream);
            baos = new ByteArrayOutputStream();
            ImageIO.write(bi, format == null ? "jpg" : format, baos);
            byte[] bytes = baos.toByteArray();
            result = encoder.encodeBuffer(bytes).trim();
            System.out.println("将图片流转换为BASE64加密字符串成功！");
        }
        catch(IOException e)
        {
            System.out.println("将图片流转换为 BASE64加密字符串失败: " + e);
        }
        finally
        {
            try
            {
                if(baos != null)
                {
                    baos.close();
                    baos = null;
                }
            }
            catch(Exception e)
            {
                System.out.println("关闭文件流发生异常: " + e);
            }
        }
        return result;
    }

    /**
     * 将BASE64加密字符串转换为图片.
     *
     * @param imagePath    图片生成路径.
     * @param base64String 某个图片的base64字符串
     */
    public void convertByteToImage(String imagePath, String base64String) throws Exception
    {
        byte[] bytes = null;
        ByteArrayInputStream byteArrayInputStream = null;
        BufferedImage bi = null;
        File file = null;
        try
        {
            bytes = decoder.decodeBuffer(base64String);
            byteArrayInputStream = new ByteArrayInputStream(bytes);
            bi = ImageIO.read(byteArrayInputStream);
            file = new File(imagePath);
            ImageIO.write(bi, imagePath.split("\\.")[1], file);
            System.out.println("将BASE64加密字符串转换为图片成功！");
        }
        catch(IOException e)
        {
            throw new Exception(e);
        }
        finally
        {
            try
            {
                if(byteArrayInputStream != null)
                {
                    byteArrayInputStream.close();
                    byteArrayInputStream = null;
                }
            }
            catch(Exception e)
            {
                System.out.println("关闭文件流发生异常: " + e);
            }
        }
    }
}
