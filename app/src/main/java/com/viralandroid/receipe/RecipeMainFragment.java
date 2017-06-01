package com.viralandroid.receipe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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
    Products products_obj;
    Products image;
    ImageView recipe_video;

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
        recipe_video = (ImageView) view.findViewById(R.id.recipe_video);

        try {
            products_obj = (Products) getArguments().getSerializable("product");
        } catch (Exception e) {
            e.printStackTrace();
        }


        recipe_gluten.setText(products_obj.price);
        recipe_ct.setText(products_obj.time1);
        recipe_calories.setText(products_obj.calories);
        product_title.setText(products_obj.title);
        category_title.setText(products_obj.title);
        recipe_portions.setText(products_obj.time2);
        Picasso.with(getContext()).load((String) getArguments().getSerializable("image")).placeholder(R.drawable.placeholder).into(product_image);
        recipe_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHandler db = new DatabaseHandler(getContext());
                if(!db.getFavorites(products_obj.id)) {
                    Log.e("liked",products_obj.id);
                    db.addFavorites(products_obj);
                    recipe_like.setImageResource(R.drawable.fav_added2x);
                }
                else {
                    db.deleteFavorites(products_obj);
                    Log.e("delete",products_obj.id);
                    recipe_like.setImageResource(R.drawable.fav);
                }

//                recipe_like.setImageResource(R.drawable.fav_added2x);
            }
        });

        DatabaseHandler db = new DatabaseHandler(getContext());
        if(db.getFavorites(products_obj.id))
            recipe_like.setImageResource(R.drawable.fav_added2x);
        else
            recipe_like.setImageResource(R.drawable.fav);





        reset_icons(1);
        RecipeListFragment recipeListFragment = new RecipeListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("product",products_obj);
        recipeListFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.recipe_frame,recipeListFragment).commit();

        recipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset_icons(1);
                RecipeListFragment recipeListFragment = new RecipeListFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("product",products_obj);
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
                bundle.putSerializable("ingredient",products_obj);
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
                bundle.putSerializable("method",products_obj);
                methodsListFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.recipe_frame,methodsListFragment).commit();
            }
        });

        recipe_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             get_favourites();
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
                i.putExtra(Intent.EXTRA_SUBJECT,products_obj.title);
                i.putExtra(Intent.EXTRA_TEXT,android.text.Html.fromHtml(products_obj.description).toString());
                getActivity().startActivity(Intent.createChooser(i,"Share via"));
            }
        });

        recipe_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),YoutubePlayer.class);
                intent.putExtra("video",products_obj.script);
                startActivity(intent);
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
                recipe_image.setImageResource(R.drawable.ingredients2x3);
                recipes.setBackgroundColor(Color.parseColor("#f2ea2f"));
                recipe_title.setTextColor(Color.parseColor("#ffa500"));
                ingrediants.setBackgroundColor(Color.parseColor("#d3d3d3"));
                methods.setBackgroundColor(Color.parseColor("#d3d3d3"));
                ingrediiants_image.setImageResource(R.drawable.tab_bar_ingredients2x1);
                methods_image.setImageResource(R.drawable.tab_bar_recipe);
                break;
            case  2:
                recipe_image.setImageResource(R.drawable.tab_bar_summary2);
                methods_image.setImageResource(R.drawable.tab_bar_recipe);
                ingrediiants_image.setImageResource(R.drawable.ingredients_active);
                ingrediants.setBackgroundColor(Color.parseColor("#f2ea2f"));
                ingrediants_title.setTextColor(Color.parseColor("#ffa500"));
                recipes.setBackgroundColor(Color.parseColor("#d3d3d3"));
                methods.setBackgroundColor(Color.parseColor("#d3d3d3"));
                break;
            case  3:
                ingrediiants_image.setImageResource(R.drawable.tab_bar_ingredients2x1);
                recipe_image.setImageResource(R.drawable.tab_bar_summary2);
                methods_image.setImageResource(R.drawable.ingredients2x);
                methods.setBackgroundColor(Color.parseColor("#f2ea2f"));
                methods_title.setTextColor(Color.parseColor("#ffa500"));
                ingrediants.setBackgroundColor(Color.parseColor("#d3d3d3"));
                recipes.setBackgroundColor(Color.parseColor("#d3d3d3"));
                break;
        }

    }

    public void get_favourites(){
        AlertDialog.Builder builder2 = new AlertDialog.Builder(getContext());
        builder2.setMessage("Do you want to add ingredients to favourites?");
        builder2.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ShoppingCartFragment shoppingCartFragment = new ShoppingCartFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("cart",products_obj);
                shoppingCartFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container,shoppingCartFragment).addToBackStack("cart").commit();
            }
        });
        builder2.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//        onViewHolderBound();
                //Toast.makeText(getContext(), "U Clicked Cancel ", Toast.LENGTH_LONG).show();
            }

        });

        builder2.show();
    }


}
