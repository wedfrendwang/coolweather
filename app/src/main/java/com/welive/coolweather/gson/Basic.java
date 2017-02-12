package com.welive.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by welive on 2017/2/12.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;
    @SerializedName("id")
    public String weatherId;
    public Update update;
    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
