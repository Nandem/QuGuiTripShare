package external.weather;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import external.weather.model.WeatherCollector;

import java.util.HashMap;
import java.util.Map;

/**
 * 和风天气采集器实现类
 * 接口地址
 * 预报天气：https://free-api.heweather.com/v5/weather
 * 实况天气：https://free-api.heweather.com/v5/now
 * 7~10天预报：https://free-api.heweather.com/v5/forecast
 * @author Nandem on 2017-02-13.
 */
public class HeWeatherCollector implements WeatherCollector
{
    private String url = "https://free-api.heweather.com/v5/";
    private String key = "f3d1e2cc1ae94b798a3e18d6028b913d";
    private String mappingFileUrl = "http://files.heweather.com/condition-code.txt";

    /*
     * 此为天气代码和天气图标的映射，键为天气代码，值为天气代码所代表的中文和天气图标url的组合以“#”分割
     * 如key="200" value="有风#http://files.heweather.com/cond_icon/200.png"
     */
    private Map<String, String> weatherCode2PicMapping = new HashMap<String, String>();
    {
        //这里放一个默认值，以防止天气接口挂了没有数据
        //TODO 待做一个默认天气图标，比如笑脸什么的
        weatherCode2PicMapping.put("default", "天气就是你的心情#http://www.nandem.cn");
        String[] temMapping = getTxtWeatherCodeString(mappingFileUrl).split("\n");
        for(String t : temMapping)
        {
            if(isStartwithNumber(t))
            {
                t = t.replace("\t", " ");
                t = t.replace(" ", "#");
                String[] tt = t.split("#");
                weatherCode2PicMapping.put(tt[0], tt[1] + "#" + tt[tt.length - 1]);
            }
        }
    }

    /**
     * 获取天气代码与天气图标url映射文件
     * @param url url
     * @return 经解析后的天气代码与天气图标映射字符串
     */
    private String getTxtWeatherCodeString(String url)
    {
        return getNetDataByURL(url);
    }

    /**
     * 获取数据接口中的天气数据
     * @param url 数据接口路径
     * @return 数据Json字符串
     */
    private String getJsonDataString(String url)
    {
        return getNetDataByURL(url);
    }

    public JSONObject getLiveRootJsonObject(String cityName)
    {
        String fullUrl = url + "now?city=" + cityName + "&key=" + key;
        JSONArray heWeather5Array = JSON.parseArray(JSON.parseObject(getJsonDataString(fullUrl)).get("HeWeather5").toString());
        String heWeather5String = heWeather5Array.get(0).toString();
        return JSON.parseObject(heWeather5String);
    }

    //TODO 预报天气未实现
    public JSONArray getForeastRootJsonObject(String cityName)
    {
        String fullUrl = url + "forecast?city=" + cityName + "&key=" + key;
        JSONArray heWeather5Array = JSON.parseArray(JSON.parseObject(getJsonDataString(fullUrl)).get("HeWeather5").toString());
        String heWeather5String = heWeather5Array.get(0).toString();
        JSONObject heWeather5Object = JSON.parseObject(heWeather5String);
        return JSON.parseArray(heWeather5Object.getString("daily_forecast"));
    }

    public String getWeatherPicPath(String cityName)
    {
        JSONObject cond = getObjectByLayerFromJSONObject(getLiveRootJsonObject(cityName), "now", "cond");
        return weatherCode2PicMapping.get(cond.get("code") == null ? "" : cond.get("code")).split("#")[1];
    }

    public String getWeatherPicPathFromObject(JSONObject jsonObject)
    {
        JSONObject cond = getObjectByLayerFromJSONObject(jsonObject, "cond");
        return weatherCode2PicMapping.get(cond.get("code_d") == null ? "" : cond.get("code_d")).split("#")[1];
    }

    public String getWeatherTxt(String cityName)
    {
        JSONObject cond = getObjectByLayerFromJSONObject(getLiveRootJsonObject(cityName), "now", "cond");
        return weatherCode2PicMapping.get(cond.get("code") == null ? "" : cond.get("code")).split("#")[0];
    }

    /**
     * 从已有的Json对象中按层次结构获取指定Json对象
     * @param object 目标Json对象
     * @param layers 想要获取的对象在目标对象中的层次结构
     * @return 指定Json对象
     */
    public JSONObject getObjectByLayerFromJSONObject(JSONObject object, String... layers)
    {
        /*
         * 这里的代码都是根据数据接口来处理的，没有什么通用的意义
         * 故不必深究原理
         */
        if(layers.length == 0) return object;
        JSONObject tem = JSON.parseObject(object.get(layers[0]).toString());
        int index = 0;
        for(String s : layers)
        {
            if(index == 0)
            {
                index++;
                continue;
            }
            try
            {
                tem = JSON.parseObject(tem.get(s).toString());
            }
            catch(Exception e)
            {
                return JSON.parseObject(tem.get(s).toString());
            }
            index++;
        }
        return tem;
    }
}
