package Image;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 路径工具，处理一些路径相关问题
 *
 * @author Nandem on 2017/3/28.
 */
public class ImageUtil extends BaseImageUtil
{
    private final static String BASE_ICON_PATH = "E:\\Nandem\\Java\\QuGuiTripShare\\Images\\";
    private final static String ICON_FORMAT = ".png";

    /**
     * 将base64字符串保存为图片。
     * 注意，实际上可以完全不需要将base64字符串转换为图片，但是基于数据库存储空间和方便以后查看的角度考虑，
     * 还是决定保存在某个路径下。
     * @param id id
     * @param headIconString 队伍图标base64字符串
     * @return true：保存成功，false：保存失败。
     */
    public boolean saveImage(String id, String headIconString, ImageType imageType)
    {
        return saveImage(imageType.getTypeContent(), id, headIconString);
    }

    /**
     * 从保存图片的路径下获取指定图片的base64字符串
     * @param id 图片id，即想要获取的图片的所属id。
     * @return 成功则返回对应图片的base64字符串，否则返回空字符串。
     */
    public String getImage(String id, ImageType imageType)
    {
        return getIconString(imageType.getTypeContent(), id);
    }

    private boolean saveImage(String type, String id, String iconString)
    {
        iconString = iconString.replace("data:image/png;base64,", "");
        try
        {
            convertByteToImage(BASE_ICON_PATH + type + "/" + id + ICON_FORMAT, iconString);
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    private String getIconString(String type, String id)
    {
        try
        {
            return convertImageToByte(BASE_ICON_PATH + type + "/" + id + ICON_FORMAT);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }

    private static volatile ImageUtil instance;
    private Lock lock = new ReentrantLock();

    private ImageUtil() {}

    public static ImageUtil getInstance()
    {
        if(instance == null)
        {
            synchronized(ImageUtil.class)
            {
                if(instance == null)
                {
                    instance = new ImageUtil();
                }
            }
        }
        return instance;
    }

    public static enum ImageType
    {
        HEAD_ICON(1, "headIcons"),
        FOOTPRINT_IMAGE(2, "footprintImages");

        private int typeCode;
        private String typeContent;
        ImageType(int typeCode, String typeContent)
        {
            this.typeCode = typeCode;
            this.typeContent = typeContent;
        }

        public int getTypeCode()
        {
            return this.typeCode;
        }

        public String getTypeContent()
        {
            return this.typeContent;
        }

        public boolean equals(ImageType imageType)
        {
            return this.typeCode == imageType.getTypeCode() && this.typeContent.equals(imageType.getTypeContent());
        }
    }
}
