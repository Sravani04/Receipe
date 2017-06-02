package com.viralandroid.receipe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

/**
 * Created by T on 14-02-2017.
 */

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

//        final Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(SplashActivity.this, LanguageScreen.class);
//                startActivity(intent);
//                finish();
//            }
//        }, 1500);

        get_words();


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

    public void get_words(){
        Ion.with(this)
                .load(Session.SERVER_URL+"words-json.php")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        Session.SetEnWords(SplashActivity.this,result.get("en").getAsJsonObject().toString());
                        Session.SetArWords(SplashActivity.this,result.get("ar").getAsJsonObject().toString());
                        Intent intent = new Intent(SplashActivity.this, LanguageScreen.class);
                        startActivity(intent);
                        finish();
                    }
                });
    }

    }


