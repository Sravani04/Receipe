package com.viralandroid.receipe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by T on 14-02-2017.
 */

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, ExampleMainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1500);

//        Ion.with(this).load("http://clients.yellowsoft.in/test/recipes_settings.xml").asString().setCallback(new FutureCallback<String>() {
//            @Override
//            public void onCompleted(Exception e, String result) {
//                if(e==null){
//
//                    XmlToJson xmlToJson = new XmlToJson.Builder(result).build();
//                    JSONObject jsonObject = xmlToJson.toJson();
//
//                    Log.e("json res",jsonObject.toString());
//                    Intent intent = new Intent(SplashActivity.this, ExampleMainActivity.class);
//                    try {
//                        intent.putExtra("json",jsonObject.getJSONObject("Settings").toString());
//                    } catch (JSONException e1) {
//                        e1.printStackTrace();
//                    }
//                    startActivity(intent);
//                    finish();
//
//                }
//
//            }
//        });

    }

    }


