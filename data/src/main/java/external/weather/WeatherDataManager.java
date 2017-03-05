package external.weather;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import external.weather.model.Weather;
import external.weather.model.WeatherCollector;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据管理器，负责调度各个天气接口的具体实现类的方法
 * 考虑到可能使用不同天气数据接口，故这里统一使用接口调度方法
 * 每个方法具体实现，请参照各自实现代码
 * @author Nandem on 2017-02-05.
 */
public class WeatherDataManager
{
    private static volatile WeatherDataManager instance;
    private WeatherCollector weatherCollector = new HeWeatherCollector();

    private WeatherDataManager() { }

    /**
     * 获取唯一实例
     *
     * @return 唯一的utils实例
     */
    public static WeatherDataManager getInstance()
    {
        if(instance == null)
        {
            synchronized(WeatherDataManager.class)
            {
                if(instance == null)
                {
                    instance = new WeatherDataManager();
                }
            }
        }
        return instance;
    }

    /*^_^*--------------------天气接口------------------------------*^_^*/

    /**
     * 根据城市名称获取实时天气
     * 此天气仅表示查询的时刻的实时天气，不表示整天的天气或者预报天气
     * @param cityName 城市名称
     * @return 天气bean
     */
    public Weather getLiveWeather(String cityName)
    {
        synchronized(WeatherDataManager.class)
        {
            Weather weather = new Weather();

            JSONObject rootObject = weatherCollector.getLiveRootJsonObject(cityName);
            JSONObject nowObject = weatherCollector.getObjectByLayerFromJSONObject(rootObject, "now");

            weather.setLiveBFT(nowObject.get("fl").toString());
            weather.setLiveT(nowObject.get("tmp").toString());
            weather.setWeatherTxt(weatherCollector.getWeatherTxt(cityName));
            weather.setWeatherPicURL(weatherCollector.getWeatherPicPath(cityName));
            weather.setHumidity(nowObject.get("hum").toString());

            return weather;
        }
    }

    /**
     * 根据城市名称获取预报天气
     * @param cityName 城市名称
     * @return 未来7~10天预报天气，具体看各自数据接口所提供的数据
     */
    public List<Weather> getForecastWeather(String cityName)
    {
        synchronized(WeatherDataManager.class)
        {
            List<Weather> forecastWeather = new ArrayList<>();

            JSONArray weatherForecastArray = weatherCollector.getForeastRootJsonObject(cityName);

            for(Object weatherObject : weatherForecastArray)
            {
                Weather weather = new Weather();
                weather.setWeatherPicURL(weatherCollector.getWeatherPicPathFromObject(((JSONObject)weatherObject)));
                weather.setWeatherTxt(((JSONObject)weatherObject).getJSONObject("cond").getString("txt_d"));
                weather.setHumidity(((JSONObject)weatherObject).getString("hum"));
                weather.setMaxT(((JSONObject)weatherObject).getJSONObject("tmp").getString("max"));
                weather.setMinT(((JSONObject)weatherObject).getJSONObject("tmp").getString("min"));
                forecastWeather.add(weather);
            }

            return forecastWeather;
        }
    }
}
