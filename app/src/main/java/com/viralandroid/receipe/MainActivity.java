package com.viralandroid.receipe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity  {
    ListView listView;
    MainActivityAdapter  mainActivityAdapter;
    ArrayList<Integer> images;
    ArrayList<String> numbers;
    ArrayList<String> names;
    ArrayList<Categories> categories;
    JSONObject jsonObject;
    JSONArray  jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.categories_list);
        try {
            jsonObject = new JSONObject(getIntent().getStringExtra("json"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        images = new ArrayList<>();
        numbers = new ArrayList<>();
        names = new ArrayList<>();

//        images.add(R.drawable.chocolate_caramel01);
//        numbers.add("4");

//
//        names.add("Choclate caramel Recipes");
//        names.add("Easy curried Recipes");
//        names.add("Hasselback potatoes Recipes");

        categories= new ArrayList<>();
        try {
            jsonArray = jsonObject.getJSONArray("Category");
            for (int i =0;i<jsonObject.getJSONArray("Category").length();i++) {
                categories.add(new Categories(jsonArray.getJSONObject(i)));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }



        mainActivityAdapter = new MainActivityAdapter(this,categories);
        listView.setAdapter(mainActivityAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,ProductsActivity.class);
                try {
//                    Log.e("recipe response",jsonArray.getJSONObject(i).getJSONArray("RecipeInfo").toString());
                    intent.putExtra("recipe",jsonArray.getJSONObject(i).getJSONArray("RecipeInfo").toString());
                    intent.putExtra("category",categories.get(i));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                startActivity(intent);
            }
        });
    }
}
