package external.weather.model;

/**
 * 天气bean，封装天气信息，包括温度、湿度等
 * @author Nandem on 2017-02-06.
 */
public class Weather
{
    private String liveT;//实时气温
    private String liveBFT;//实时体感温度(body feeling temperature)
    private String weatherTxt;//实时天气中文名称，如：阴晴等
    private String weatherPicURL;//实时天气图片路径
    private String minT;//最低气温
    private String maxT;//最高气温
    private String humidity;//相对湿度
    private String pm25;//空气质量指数
    private String windForce;//风力

    public String getLiveBFT()
    {
        return liveBFT;
    }

    public void setLiveBFT(String liveBFT)
    {
        this.liveBFT = liveBFT;
    }

    public String getLiveT()
    {
        return liveT;
    }

    public void setLiveT(String liveT)
    {
        this.liveT = liveT;
    }

    public String getMinT()
    {
        return minT;
    }

    public void setMinT(String minT)
    {
        this.minT = minT;
    }


    public String getWeatherTxt()
    {
        return weatherTxt;
    }

    public void setWeatherTxt(String weatherTxt)
    {
        this.weatherTxt = weatherTxt;
    }

    public String getWeatherPicURL()
    {
        return weatherPicURL;
    }

    public void setWeatherPicURL(String weatherPicURL)
    {
        this.weatherPicURL = weatherPicURL;
    }

    public String getMaxT()
    {
        return maxT;
    }

    public void setMaxT(String maxT)
    {
        this.maxT = maxT;
    }

    public String getHumidity()
    {
        return humidity;
    }

    public void setHumidity(String humidity)
    {
        this.humidity = humidity;
    }

    public String getPm25()
    {
        return pm25;
    }

    public void setPm25(String pm25)
    {
        this.pm25 = pm25;
    }

    public String getWindForce()
    {
        return windForce;
    }

    public void setWindForce(String windForce)
    {
        this.windForce = windForce;
    }
}
