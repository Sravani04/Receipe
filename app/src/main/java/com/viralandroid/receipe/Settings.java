package com.viralandroid.receipe;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by T on 20-02-2017.
 */

public class Settings {

    public  static  final String cat_id="cat_id";
    public  static  final String cat_name="cat_name";

    public  static void SetCatId(Context context,String id,String cat_name){
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(cat_id,id);
        editor.commit();
    }

    public  static String GetCatId(Context context) {
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(cat_id,cat_id + "1");
    }

}
