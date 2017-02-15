package com.viralandroid.receipe;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by T on 14-02-2017.
 */

public class Categories  {
    public String name,icon;
    public Categories(JSONObject jsonObject){
        try {
            name = jsonObject.getString("name");
            icon = jsonObject.getString("icon");
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

}



//{"Settings":{"MainSettings":{"LogoInactive":"logo","LogoActive":"logo_active"},
//"Category":[{"name":"Fruit recipes","icon":"ic_menu_vegetables",
//"RecipeInfo":[{"RecipePictureList":
// {"RecipePicture":[{"content":"squash_chestnutrolls01"},{"content":"squash_chestnutrolls02"}]},
//        "RecipeTitle":"Squash, sage and chestnut rolls","RecipeStepsList":{"RecipeStep":[{"RecipeStepDescription":"Deseed the squash and cut into 8 wedges, then place in a roasting tray and sprinkle over the chilli, drizzle with oil and season. Toss well, spread evenly and roast for 35 to 40 minutes. Remove and cool.\n\nPeel and finely chop the onion and garlic, pick the sage leaves and roughly chop the chestnuts. Finely grate the Parmesan.\n                    \nAdd a drizzle of oil to a pan and place over a medium heat. Fry the onions for 10 minutes, until soft, then add the garlic, sage and chestnuts. Continue to fry for 3 to 4 minutes, then add to a large bowl.\n                    \nRemove the skin from the squash and mash the flesh together with the Parmesan, then season.\n\nDust a clean surface with flour and roll your pastry into a 30cm x 45cm rectangle, about 5mm thick and cut into two equal pieces.\n                    \nBeat the egg, then brush the longer side of each piece of pastry with the egg. Place your filling down the centre, then fold the pastry over, using egg to seal the edges (press down with a fork).\n                    ",
//        "RecipeStepName":"Step 1:"},{"RecipeStepDescription":"Peel and finely chop the onion and garlic, pick the sage leaves and roughly chop the chestnuts. Finely grate the Parmesan.\n                    ","RecipeStepName":"Step 2:"},{"RecipeStepDescription":"Add a drizzle of oil to a pan and place over a medium heat. Fry the onions for 10 minutes, until soft, then add the garlic, sage and chestnuts. Continue to fry for 3 to 4 minutes, then add to a large bowl.\n                    ","RecipeStepName":"Step 3:"},{"RecipeStepDescription":"Remove the skin from the squash and mash the flesh together with the Parmesan, then season.\n                    ","RecipeStepName":"Step 4:"},{"RecipeStepDescription":"Beat the egg, then brush the longer side of each piece of pastry with the egg. Place your filling down the centre, then fold the pastry over, using egg to seal the edges (press down with a fork).\n                        \nCut each into 8 equal-sized pieces and place on a lined baking tray.\n\nBrush with the egg and bake for 20 to 25 minutes until crisp and golden.\n                    ","RecipeStepName":"Step 5:"},{"RecipeStepDescription":"Beat the egg, then brush the longer side of each piece of pastry with the egg. Place your filling down the centre, then fold the pastry over, using egg to seal the edges (press down with a fork).\n                        \nCut each into 8 equal-sized pieces and place on a lined baking tray.\n\nBrush with the egg and bake for 20 to 25 minutes until crisp and golden.\n                    ","RecipeStepName":"Step 6:"},{"RecipeStepDescription":"Beat the egg, then brush the longer side of each piece of pastry with the egg. Place your filling down the centre, then fold the pastry over, using egg to seal the edges (press down with a fork).\n                        \nCut each into 8 equal-sized pieces and place on a lined baking tray.\n\nBrush with the egg and bake for 20 to 25 minutes until crisp and golden.\n                    ","RecipeStepName":"Step 7:"},{"RecipeStepDescription":"Beat the egg, then brush the longer side of each piece of pastry with the egg. Place your filling down the centre, then fold the pastry over, using egg to seal the edges (press down with a fork).\n                        \nCut each into 8 equal-sized pieces and place on a lined baking tray.\n\nBrush with the egg and bake for 20 to 25 minutes until crisp and golden.\n                    ","RecipeStepName":"Step 8:"}]},
//        "RecipeIngredientsList":{"RecipeIngredient":[{"RecipeIngredientsQuantity":"1 cup","RecipeIngredientsName":"butternut squash"},{"RecipeIngredientsQuantity":"2 teaspoon","Recipes"
