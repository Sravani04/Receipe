package com.viralandroid.receipe;

import android.content.Context;

import com.google.gson.JsonObject;

/**
 * Created by T on 15-03-2017.
 */

public class Settings {
    public static String logo,title,title_ar,about,about_ar,whatwedo,whatwedo_ar,contact,contact_ar,terms,terms_ar,itunes_link,playstore_link;
    public Settings(JsonObject jsonObject, Context context){
         logo = jsonObject.get("logo").getAsString();
        title = jsonObject.get("title").getAsString();
        title_ar = jsonObject.get("title_ar").getAsString();
        about = jsonObject.get("about").getAsString();
        about_ar = jsonObject.get("about_ar").getAsString();
        whatwedo = jsonObject.get("whatwedo").getAsString();
        whatwedo_ar = jsonObject.get("whatwedo_ar").getAsString();
        contact = jsonObject.get("contact").getAsString();
        contact_ar = jsonObject.get("contact_ar").getAsString();
        terms = jsonObject.get("terms").getAsString();
        terms_ar = jsonObject.get("terms_ar").getAsString();
        itunes_link = jsonObject.get("itunes_link").getAsString();
        playstore_link = jsonObject.get("playstore_link").getAsString();
    }
}
