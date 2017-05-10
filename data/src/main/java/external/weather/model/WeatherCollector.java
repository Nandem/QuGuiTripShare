package external.weather.model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import string.EncodingUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * 天气采集器抽象接口
 * 由于本系统采用面向接口的设计，故你可以采用不同的数据服务商提供的接口实现，
 * 但必须实现本接口，否则无法接入本系统
 * @author Nandem on 2017-02-13.
 */
public interface WeatherCollector
{
    /**
     * 判断字符串是否以数字开头，主要用在天气代码和天气图标映射处理上
     * @param string 待判断的字符串
     * @return true：以数字开头，false：不是以数字开头
     */
    default boolean isStartwithNumber(String string)
    {
        return string.matches("[0-9]+.*");
    }

    /**
     * 通过url请求网络数据
     * @param url 网络数据url
     * @return 网络数据的字符串
     */
    default String getNetDataByURL(String url)
    {
        OkHttpClient mOkHttpClient=new OkHttpClient();
        Request.Builder requestBuilder = new Request.Builder().url(url);
        //可以省略，默认是GET请求
        requestBuilder.method("GET",null);
        Request request = requestBuilder.build();
        Call mcall= mOkHttpClient.newCall(request);
        try
        {
            Response response = mcall.execute();
            return response.body().string();
        }
        catch(IOException e)
        {
            return "";
        }
        //        return EncodingUtil.transcoding(result, "UTF-8");
    }

    /**
     * 获取实况天气根对象
     * 注：如果接口中的实况天气与预报天气接口一致，
     * 则任意选择本方法或{@link WeatherCollector#getForeastRootJsonObject(String)}之一即可
     * @param cityName 城市名称
     * @return 该城市名称中的根对象
     * @see WeatherCollector#getForeastRootJsonObject(String)
     */
    JSONObject getLiveRootJsonObject(String cityName);

    /**
     * 获取预报天气根对象
     * 注：如果接口中的实况天气与预报天气接口一致，
     * 则任意选择本方法或{@link WeatherCollector#getLiveRootJsonObject(String)}之一即可
     * @param cityName 城市名称
     * @return 该城市名称中的根对象
     * @see WeatherCollector#getLiveRootJsonObject(String)
     */
    JSONArray getForeastRootJsonObject(String cityName);

    /**
     * 获取天气图片
     * @param cityName 城市名
     * @return 天气图片路径
     */
    String getWeatherPicPath(String cityName);

    /**
     * 从已知对象中获取天气图片路径，通常用于通过数组迭代获取连续几天的预报天气中的图片路径
     * @param jsonObject 含有图片路径的Json对象
     * @return 图片路径
     */
    String getWeatherPicPathFromObject(JSONObject jsonObject);

    /**
     * 获取天气中文名称
     * @param cityName 城市名
     * @return 天气中文名称，如晴，阴，雨等
     */
    String getWeatherTxt(String cityName);

    /**
     * 从已有的Json对象中按层次结构获取指定Json对象
     * @param object 目标Json对象
     * @param layers 想要获取的对象在目标对象中的层次结构
     * @return 指定Json对象
     */
    JSONObject getObjectByLayerFromJSONObject(JSONObject object, String... layers);
}
