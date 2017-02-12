package com.welive.coolweather;

import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(PreferenceManager.getDefaultSharedPreferences(this).getString("weather",null)!=null){
            WeatherActivity.intentAction(this,"");
            finish();
        }
    }
}
