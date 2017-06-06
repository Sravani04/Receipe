package com.viralandroid.receipe;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import org.json.JSONObject;

/**
 * Created by T on 01-06-2017.
 */

public class Session {
    public static String SERVER_URL = "http://halachef.com/api/";

    public  static  final String lang="lan";
    public  static  final String Words_en="en";
    public  static  final String Words_ar="ar";

    public  static void SetLang(Context context, String ar){
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(lang,ar);
        editor.commit();
    }

    public  static String GetLang(Context context) {
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(lang,"-1");
    }

    public  static void SetEnWords(Context context, String en){
        Log.e("engres",en);
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(Words_en,en);
        editor.commit();
    }

    public  static String GetEnWords(Context context) {
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(Words_en,"-1");
    }

    public  static void SetArWords(Context context, String ar){
        Log.e("arabicres",ar);
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(Words_ar,ar);
        editor.commit();
    }

    public  static String GetArWords(Context context) {
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(Words_ar,"-1");
    }

    public static String GetWord(Context context,String word){
        if (Session.GetLang(context).equals("ar")){
            try {
                Log.e("ar_words",GetArWords(context));
                JSONObject jsonObject = new JSONObject(GetArWords(context));
                return jsonObject.getString(word);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            try {
                JSONObject jsonObject = new JSONObject(GetEnWords(context));
                return jsonObject.getString(word);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return word;
    }





}
