package com.viralandroid.receipe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by T on 13-02-2017.
 */

public class ProductsActivity extends Activity {
    ListView listView;
    ProductsAdapter productsAdapter;
    ArrayList<Integer> images;
    ArrayList<String>  titles;
    ArrayList<String>  time;
    ImageView back_btn;
    JSONArray jsonArray;
    JSONObject jsonObject;
    ArrayList<Recipes> recipes;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_list);
        listView = (ListView) findViewById(R.id.products_list);
        try {
            jsonArray = new JSONArray(getIntent().getStringExtra("recipe"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        back_btn = (ImageView) findViewById(R.id.back_btn);
        images = new ArrayList<>();
        titles = new ArrayList<>();
        time = new ArrayList<>();

        images.add(R.drawable.gennaros_pasta01);
        images.add(R.drawable.gennaros_pasta01);
        images.add(R.drawable.gennaros_pasta01);

        titles.add("Squash, sage and chestnut rolls");
        titles.add("Leftover squash pancakes");
        titles.add("chestnut rolls");

        time.add("60 mins");
        time.add("30 mins");
        time.add("15 mins");

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        recipes  = new ArrayList<>();

        try {
            for (int i =0;i<getIntent().getStringExtra("recipe").length();i++) {
                recipes.add(new Recipes(jsonArray.getJSONObject(i)));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        productsAdapter = new ProductsAdapter(this,recipes);
        listView.setAdapter(productsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ProductsActivity.this,RecipeFragment.class);
                try {
                    intent.putExtra("recipe",recipes.get(i));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                startActivity(intent);
            }
        });



    }
}
