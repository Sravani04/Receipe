package com.viralandroid.receipe;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by T on 22-02-2017.
 */

public class RecipeMainFragment extends Fragment {
    ImageView back_btn;
    ImageView recipe_cart;
    FrameLayout recipe_frame;
    LinearLayout recipes,ingrediants,methods;
    ImageView recipe_image,ingrediiants_image,methods_image;
    TextView recipe_title,ingrediants_title,methods_title;
    TextView category_title,product_title;
    private String holder;
    Recipes recipes_obj;
    ImageView recipe_like,recipe_share;
    TextView recipe_gluten,recipe_ct,recipe_portions,recipe_calories;
    Categories categories;
    ImageView product_image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.recipe_fragment,container,false);
        back_btn = (ImageView) view.findViewById(R.id.back_btn);
        recipe_cart = (ImageView) view.findViewById(R.id.recipe_cart);
        recipe_frame = (FrameLayout) view.findViewById(R.id.recipe_frame);
        recipes = (LinearLayout) view.findViewById(R.id.recipes);
        ingrediants = (LinearLayout) view.findViewById(R.id.ingrediants);
        methods = (LinearLayout) view.findViewById(R.id.methods);
        recipe_image = (ImageView) view.findViewById(R.id.recipe_image);
        ingrediiants_image = (ImageView) view.findViewById(R.id.ingrediants_image);
        methods_image = (ImageView) view.findViewById(R.id.methods_image);
        recipe_title = (TextView) view.findViewById(R.id.recipe_title);
        ingrediants_title  = (TextView) view.findViewById(R.id.ingrediants_title);
        methods_title = (TextView) view.findViewById(R.id.methods_title);
        category_title = (TextView) view.findViewById(R.id.category_title);
        product_title = (TextView) view.findViewById(R.id.product_title);
        recipe_like = (ImageView) view.findViewById(R.id.recipe_like);
        recipe_share = (ImageView) view.findViewById(R.id.recipe_share);
        recipe_gluten = (TextView) view.findViewById(R.id.recipe_gluten);
        recipe_ct = (TextView) view.findViewById(R.id.recipe_ct);
        recipe_portions = (TextView) view.findViewById(R.id.recipe_portions);
        recipe_calories = (TextView) view.findViewById(R.id.recipe_calories);
        product_image = (ImageView) view.findViewById(R.id.product_image);

        try {
            recipes_obj = (Recipes) getArguments().getSerializable("recipe");
        } catch (Exception e) {
            e.printStackTrace();
        }

        recipe_gluten.setText(recipes_obj.gluten);
        recipe_ct.setText(recipes_obj.cooking_time);
        recipe_portions.setText(recipes_obj.portions);
        recipe_calories.setText(recipes_obj.calories);
        product_title.setText(recipes_obj.title);
        Picasso.with(getActivity()).load(recipes_obj.picture).placeholder(R.drawable.gennaros_pasta01).into(product_image);

        reset_icons(1);
        RecipeListFragment recipeListFragment = new RecipeListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("recipe",recipes_obj);
        recipeListFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.recipe_frame,recipeListFragment).commit();

        recipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset_icons(1);
                RecipeListFragment recipeListFragment = new RecipeListFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("recipe",recipes_obj);
                recipeListFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.recipe_frame,recipeListFragment).commit();
            }
        });

        ingrediants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset_icons(2);
                IngrediantsListFragment ingrediantsListFragment = new IngrediantsListFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("ingredient",recipes_obj);
                ingrediantsListFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.recipe_frame,ingrediantsListFragment).commit();
            }
        });

        methods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset_icons(3);
                MethodsListFragment methodsListFragment = new MethodsListFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("method",recipes_obj);
                methodsListFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.recipe_frame,methodsListFragment).commit();
            }
        });

        recipe_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShoppingCartFragment shoppingCartFragment = new ShoppingCartFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("cart",recipes_obj);
                shoppingCartFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container,shoppingCartFragment).addToBackStack("cart").commit();
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getActivity().onBackPressed();
            }
        });


        recipe_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT,recipes_obj.title);
                i.putExtra(Intent.EXTRA_TEXT, recipes_obj.description);
                getActivity().startActivity(Intent.createChooser(i,"Share via"));
            }
        });

        return view;
    }

    private void reset_icons(int pos){

        recipe_image.setImageResource(R.drawable.tab_bar_summary2);
        ingrediiants_image.setImageResource(R.drawable.tab_bar_ingredients2x1);
        methods_image.setImageResource(R.drawable.tab_bar_recipe);

        recipe_title.setTextColor(Color.parseColor("#8a000000"));
        ingrediants_title.setTextColor(Color.parseColor("#8a000000"));
        methods_title.setTextColor(Color.parseColor("#8a000000"));

        switch (pos){
            case  1:
                recipe_image.setImageResource(R.drawable.tab_bar_ingredients2x3);
                recipe_title.setTextColor(Color.parseColor("#ffa500"));
                break;
            case  2:
                ingrediiants_image.setImageResource(R.drawable.tab_bar_ingredients_active);
                ingrediants_title.setTextColor(Color.parseColor("#ffa500"));
                break;
            case  3:
                methods_image.setImageResource(R.drawable.tab_bar_ingredients2x);
                methods_title.setTextColor(Color.parseColor("#ffa500"));
                break;
        }

    }


}
