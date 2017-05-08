package date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Nandem on 2017-05-09.
 */
public class TimeUtils
{
    private static DateFormat dateFormatWithTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static String getCurrentFormatDateWithTime()
    {
        return dateFormatWithTime.format(Calendar.getInstance().getTime());
    }

    public static String getCurrentFormatDate()
    {
        return dateFormat.format(Calendar.getInstance().getTime());
    }
}
