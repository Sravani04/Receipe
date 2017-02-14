package com.viralandroid.receipe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by T on 14-02-2017.
 */

public class CartFragment extends Activity {
    CartAdapter cartAdapter;
    ListView listView;
    ArrayList<String> spoons;
    ArrayList<String> items;
    ImageView back_btn;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_list);
        listView = (ListView) findViewById(R.id.cart_list);
        back_btn = (ImageView) findViewById(R.id.back_btn);

        spoons = new ArrayList<>();
        items  = new ArrayList<>();

        spoons.add("1 cup");
        spoons.add("2 teaspoon");
        spoons.add("1");
        spoons.add("4");
        spoons.add("1/2 bunch");
        spoons.add("200 g");
        spoons.add("30 g");
        spoons.add("500 g");
        spoons.add("1 largen");

        items.add("butternut squash");
        items.add("dried chilli");
        items.add("onion");
        items.add("cloves of garlic");
        items.add("fresh sage");
        items.add("vac-packed chestnuts");
        items.add("parmesan cheese");
        items.add("all-butter puff pastry");
        items.add("free-range egg");

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartFragment.this,RecipeFragment.class);
                startActivity(intent);
            }
        });

        cartAdapter = new CartAdapter(this,spoons,items);
        listView.setAdapter(cartAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }
}
