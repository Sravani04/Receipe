package com.viralandroid.receipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by T on 15-02-2017.
 */

public class Recipes implements Serializable {
    public String id,title,gluten,preparation_time,cooking_time,portions,calories,description,picture;

    public ArrayList<Steps> steps;

    public ArrayList<Ingredients> ingredients;


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
            picture = jsonObject.getJSONObject("RecipePictureList").getString("RecipePicture");



            ingredients = new ArrayList<>();

            JSONObject data = jsonObject.getJSONObject("RecipeIngredientsList");
            JSONArray results = data.getJSONArray("RecipeIngredient");
            for (int i = 0; i < results.length(); i++) {
                JSONObject result = results.getJSONObject(i);
                ingredients.add(new Ingredients(results.getJSONObject(i)));
            }

            steps = new ArrayList<>();

            JSONObject response = jsonObject.getJSONObject("RecipeStepsList");
            JSONArray steps_data = response.getJSONArray("RecipeStep");
            for (int i = 0; i < steps_data.length(); i++) {
                JSONObject result = steps_data.getJSONObject(i);
                steps.add(new Steps(steps_data.getJSONObject(i)));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }




    public class Ingredients implements Serializable{

        public String ingredient_name,ingredient_quantity;

         public Ingredients(JSONObject jsonObject){
            try {
              ingredient_name = jsonObject.getString("RecipeIngredientsName");
              ingredient_quantity = jsonObject.getString("RecipeIngredientsQuantity");

            }catch (JSONException e){
                e.printStackTrace();
            }

        }

    }

    public class Steps implements Serializable{

        public String step_name,step_description;

        public Steps(JSONObject jsonObject){

            try {
                step_name = jsonObject.getString("RecipeStepName");
                step_description = jsonObject.getString("RecipeStepDescription");

            }catch (JSONException e){
                e.printStackTrace();
            }

        }

    }

}
