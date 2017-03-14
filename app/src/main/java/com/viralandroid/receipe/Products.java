package com.viralandroid.receipe;

import android.content.Context;

import com.google.gson.JsonObject;

import org.json.JSONException;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by T on 24-02-2017.
 */

public class Products  implements Serializable{
    public String id,title,title_ar,price,time1,time2,calories,description,description_ar,script;

    public ArrayList<Images> images;
    public ArrayList<Ingredients> ingredients;
    public ArrayList<Methods> methods;

    public Products(JsonObject jsonObject, Context context) throws JSONException {
        id = jsonObject.get("id").getAsString();
        title = jsonObject.get("title").getAsString();
        title_ar = jsonObject.get("title_ar").getAsString();
        price = jsonObject.get("price").getAsString();
        time1 = jsonObject.get("time1").getAsString();
        time2 = jsonObject.get("time2").getAsString();
        calories = jsonObject.get("calories").getAsString();
        description = jsonObject.get("description").getAsString();
        description_ar = jsonObject.get("description_ar").getAsString();
        script = jsonObject.get("script").getAsString();

        images = new ArrayList<>();
        for(int i=0;i<jsonObject.get("images").getAsJsonArray().size();i++){

            Images comp_image = new Images(jsonObject.get("images").getAsJsonArray().get(i).getAsJsonObject(),context);

            images.add(comp_image);

        }

        ingredients = new ArrayList<>();
        for (int i=0;i<jsonObject.get("ingredients").getAsJsonArray().size();i++){
            Ingredients ingredient = new Ingredients(jsonObject.get("ingredients").getAsJsonArray().get(i).getAsJsonObject(),context);
            ingredients.add(ingredient);
        }

        methods = new ArrayList<>();
        for (int i=0;i<jsonObject.get("methods").getAsJsonArray().size();i++){
            Methods method = new Methods(jsonObject.get("methods").getAsJsonArray().get(i).getAsJsonObject(),context);
            methods.add(method);
        }

    }

    public class Images implements Serializable {

        public String image,thumb;

        public Images(JsonObject jsonObject,Context context){
            image = jsonObject.get("image").getAsString();
            thumb = jsonObject.get("thumb").getAsString();
        }
    }

    public class Ingredients implements Serializable{

        public String ingredient_id,ingredient,ingredient_ar,value,value_ar;

        public Ingredients(JsonObject jsonObject,Context context){
            ingredient_id = jsonObject.get("ingredient_id").getAsString();
            ingredient = jsonObject.get("ingredient").getAsString();
            ingredient_ar = jsonObject.get("ingredient_ar").getAsString();
            value = jsonObject.get("value").getAsString();
            value_ar = jsonObject.get("value_ar").getAsString();
        }
    }

    public class Methods implements Serializable{

        public String method_id,method,method_ar,value,value_ar;

        public Methods(JsonObject jsonObject,Context context){
            method_id = jsonObject.get("method_id").getAsString();
            method = jsonObject.get("method").getAsString();
            method_ar = jsonObject.get("method_ar").getAsString();
            value = jsonObject.get("value").getAsString();
            value_ar = jsonObject.get("value_ar").getAsString();
        }
    }

    public Products(){

    }

    int _id;
    public Products(int id, String title, String script) {
        this._id = id;
        this.title = title;
        this.script = script;
    }

    public Products(String title, String script){
        this.title = title;
        this.script = script;
    }


    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }

    public String getTitle(){
        return this.title;
    }

    // setting title
    public void setTitle(String title){
        this.title = title;
    }

    // getting script
    public String getScript(){
        return this.script;
    }

    // setting script
    public void setScript(String script){
        this.script = script;
    }

}
