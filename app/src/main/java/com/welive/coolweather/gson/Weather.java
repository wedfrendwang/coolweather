package com.welive.coolweather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by welive on 2017/2/12.
 *
 * 请求服务器的后台的天气的数据
 * 解析格式
 *
 */

public class Weather{

    public String status;
    public Basic basic;
    public AQI aqi;
    public Now now;
    public Suggestion suggestion;
    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;
}
