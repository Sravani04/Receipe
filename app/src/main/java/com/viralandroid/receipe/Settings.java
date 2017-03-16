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
        if (jsonObject.has("title_ar")){
            title_ar = "no-title";
        }else {
            title_ar = jsonObject.get("title_ar").getAsString();
        }
        if (jsonObject.has("about")){
            about = "0";
        }else {
            about = jsonObject.get("about").getAsString();
        }
        if (jsonObject.has("about_ar")){
            about_ar = "0";
        }else {
            about_ar = jsonObject.get("about_ar").getAsString();
        }
        if (jsonObject.has("whatwedo")){
            whatwedo = "0";
        }else {
            whatwedo = jsonObject.get("whatwedo").getAsString();
        }
        if (jsonObject.has("whatwedo_ar")){
            whatwedo_ar = "0";
        }else {
            whatwedo_ar = jsonObject.get("whatwedo_ar").getAsString();
        }
        if (jsonObject.has("contact")){
            contact = "0";
        }else {
            contact = jsonObject.get("contact").getAsString();
        }
        if (jsonObject.has("contact_ar")){
            contact_ar = "0";
        }else {
            contact_ar = jsonObject.get("contact_ar").getAsString();
        }
        if (jsonObject.has("terms")){
            terms = "0";
        }else {
            terms = jsonObject.get("terms").getAsString();
        }
        if (jsonObject.has("terms_ar")){
            terms_ar = "0";
        }else {
            terms_ar = jsonObject.get("terms_ar").getAsString();
        }
        if (jsonObject.has("itunes_link")){
            itunes_link = "no-link";
        }else {
            itunes_link = jsonObject.get("itunes_link").getAsString();
        }
        if (jsonObject.has("playstore_link")){
            playstore_link  = "no-link";
        }else {
            playstore_link = jsonObject.get("playstore_link").getAsString();
        }
    }
}
