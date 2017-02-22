package com.viralandroid.receipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by T on 21-02-2017.
 */

public class ShoppingCartFragment extends Fragment {
    ShoppingCartAdapter shoppingCartAdapter;
    ListView listView;
    ArrayList<String> spoons;
    ArrayList<String> items;
    ImageView back_btn;
    Recipes recipes;
    TextView clear_list;
    JSONObject jsonObject;
    JSONArray jsonArray;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState){
        final View view  = inflater.inflate(R.layout.cart_list,container,false);
        listView = (ListView) view.findViewById(R.id.cart_list);
        back_btn = (ImageView) view.findViewById(R.id.back_btn);
        clear_list = (TextView) view.findViewById(R.id.clear_list);

        try {
            recipes = (Recipes) getArguments().getSerializable("cart");
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
              getActivity().onBackPressed();
            }
        });

        clear_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("clear",spoons.toString());
                recipes.ingredients.clear();
                shoppingCartAdapter.notifyDataSetChanged();
            }
        });

        shoppingCartAdapter = new ShoppingCartAdapter(getActivity(),recipes);
        listView.setAdapter(shoppingCartAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return view;
    }
}
