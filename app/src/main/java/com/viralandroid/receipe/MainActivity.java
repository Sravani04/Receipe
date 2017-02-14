package com.viralandroid.receipe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    ListView listView;
    MainActivityAdapter  mainActivityAdapter;
    ArrayList<Integer> images;
    ArrayList<String> numbers;
    ArrayList<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.categories_list);
        images = new ArrayList<>();
        numbers = new ArrayList<>();
        names = new ArrayList<>();

        images.add(R.drawable.chocolate_caramel01);
        images.add(R.drawable.easy_curried01);
        images.add(R.drawable.hasselback_potatoes01);

        numbers.add("4");
        numbers.add("3");
        numbers.add("3");

        names.add("Choclate caramel Recipes");
        names.add("Easy curried Recipes");
        names.add("Hasselback potatoes Recipes");

        mainActivityAdapter = new MainActivityAdapter(this,images,numbers,names);
        listView.setAdapter(mainActivityAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,ProductsActivity.class);
                startActivity(intent);
            }
        });
    }
}
