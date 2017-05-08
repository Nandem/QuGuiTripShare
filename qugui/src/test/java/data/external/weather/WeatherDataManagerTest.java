package data.external.weather;

import external.weather.WeatherDataManager;
import external.weather.model.Weather;
import org.junit.Test;

import java.util.List;

/**
 * 天气数据来源于和风天气
 * 接口地址
 * 预报天气：https://free-api.heweather.com/v5/weather
 * 实况天气：https://free-api.heweather.com/v5/now
 * 7~10天预报：https://free-api.heweather.com/v5/forecast
 *
 * @author Nandem on 2017-02-05.
 */
public class WeatherDataManagerTest
{
    @Test
    public void testGetDocument()
    {
//        WeatherDataManager.getInstance().getLiveWeather("成都");
        List<Weather> tem = WeatherDataManager.getInstance().getForecastWeather("成都");
        System.out.println(tem.size());

    }
}
