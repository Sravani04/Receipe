package com.viralandroid.receipe;

import android.content.Context;

import com.google.gson.JsonObject;

import java.io.Serializable;

/**
 * Created by T on 24-02-2017.
 */

public class Category implements Serializable {
    public String id,title,title_ar,image,count;
    public Category(JsonObject jsonObject, Context context){
        id = jsonObject.get("id").getAsString();
        title = jsonObject.get("title").getAsString();
        title_ar = jsonObject.get("title_ar").getAsString();
        image = jsonObject.get("image").getAsString();
        count = jsonObject.get("count").getAsString();
        if (Session.GetLang(context).equals("ar")) {
            title = title_ar;
        }

    }
}
