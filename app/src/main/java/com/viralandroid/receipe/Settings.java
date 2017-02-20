package com.viralandroid.receipe;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by T on 20-02-2017.
 */

public class Settings {

    public  static  final String ingredient_name="ingredient_name";
    public  static  final String ingredient_quantity="ingredient_quantity";

    public  static void SetIngredients(Context context, String name, String quantity){
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(name,ingredient_name);
        editor.putString(quantity,ingredient_quantity);
        editor.clear();
        editor.commit();
    }
    public  static String GetIngredients(Context context) {
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(ingredient_quantity,ingredient_quantity);
    }

}
