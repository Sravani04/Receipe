package com.viralandroid.receipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

/**
 * Created by T on 14-02-2017.
 */

public class IngrediantsListFragment extends Fragment {
    IngrediantsListAdapter ingrediantsListAdapter;
    ImageView ingrediants_like,ingrediants_share;
    ListView listView;
    ArrayList<String> spoons;
    ArrayList<String> items;
    ArrayList<Categories> categoriesfrom_api;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.ingrediants_page,container,false);
        listView = (ListView) view.findViewById(R.id.ingrediants_list);

        spoons = new ArrayList<>();
        items  = new ArrayList<>();
        categoriesfrom_api = new ArrayList<>();

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

        ingrediantsListAdapter = new IngrediantsListAdapter(getActivity(),categoriesfrom_api);


        listView.setAdapter(ingrediantsListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        //get_ingrediants_list();
        return view;
    }

    public void get_ingrediants_list(){
        Ion.with(getActivity())
                .load("http://clients.yellowsoft.in/test/recipes_settings.xml")
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        JsonObject jsonObject = result.get(0).getAsJsonObject();
                        JsonArray RecipeIngredientsList = jsonObject.get("RecipeIngredientsList").getAsJsonArray();
                        for (int i = 0; i < RecipeIngredientsList.size(); i++) {
                            Categories categories = new Categories(RecipeIngredientsList.get(i).getAsJsonObject(), getActivity());
                            categoriesfrom_api.add(categories);
                        }

                        ingrediantsListAdapter.notifyDataSetChanged();
                    }
                });
    }
}
