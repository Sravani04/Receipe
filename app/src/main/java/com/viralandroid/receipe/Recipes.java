package com.viralandroid.receipe;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by T on 15-02-2017.
 */

public class Recipes implements Serializable {
    public String id,title,gluten,preparation_time,cooking_time,portions,calories,description;
    public Recipes(JSONObject jsonObject){
        try {
            id = jsonObject.getString("id");
            title = jsonObject.getString("RecipeTitle");
            gluten = jsonObject.getJSONObject("RecipeSummary").getString("RecipeSummaryGluten");
            preparation_time =jsonObject.getJSONObject("RecipeSummary").getString("RecipeSummaryPreparationTime");
            cooking_time =jsonObject.getJSONObject("RecipeSummary").getString("RecipeSummaryCookingTime");
            portions =jsonObject.getJSONObject("RecipeSummary").getString("RecipeSummaryPortions");
            calories =jsonObject.getJSONObject("RecipeSummary").getString("RecipeSummaryCalories");
            description =jsonObject.getJSONObject("RecipeSummary").getString("RecipeSummaryDescription");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
