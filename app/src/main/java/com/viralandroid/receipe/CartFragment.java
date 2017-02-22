package com.viralandroid.receipe;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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
    Recipes recipes_obj;
    TextView clear_list;
    @Override
    public void onCreate(final Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_list);
        listView = (ListView) findViewById(R.id.cart_list);
        back_btn = (ImageView) findViewById(R.id.back_btn);
        clear_list = (TextView) findViewById(R.id.clear_list);

        try {
            recipes_obj = (Recipes) getIntent().getSerializableExtra("recipe");
        } catch (Exception e) {
            e.printStackTrace();
        }

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
                CartFragment.this.onBackPressed();
            }
        });

        clear_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("clear_response",recipes_obj.ingredients.toString());
                recipes_obj.ingredients.clear();
                cartAdapter.notifyDataSetChanged();
            }
        });

        cartAdapter = new CartAdapter(this,recipes_obj);
        listView.setAdapter(cartAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }
}
