package com.welive.coolweather.util;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.welive.coolweather.db.City;
import com.welive.coolweather.db.County;
import com.welive.coolweather.db.Province;
import com.welive.coolweather.gson.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by welive on 2017/2/10.
 *
 * 解析后台类，并将数据进行数据库的存储
 */

public class Utility {
/**
 * 解析和处理服务器返回的省级数据
 */
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0;i<allProvinces.length();i++){
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.setProvinceName(provinceObject.getString("name"));
                    province.save();
                }

                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
            }

        }
        return false;
    }


    /**
     * 解析和处理市级数据
     * @param response
     * @return
     */

    public static boolean handleCityResponse(String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i = 0;i<allCities.length();i++){
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityCode(cityObject.getInt("id"));
                    city.setCityName(cityObject.getString("name"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
            }

        }
        return false;
    }



    /**
     * 解析和处理县级数据
     * @param response
     * @return
     */

    public static boolean handleCountyResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties = new JSONArray(response);
                for (int i = 0;i<allCounties.length();i++){JSONObject countyObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCountyName(countyObject.getString("name"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
            }

        }
        return false;
    }


    public static Weather handleWeatherResponse(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return   null;
    }

}
