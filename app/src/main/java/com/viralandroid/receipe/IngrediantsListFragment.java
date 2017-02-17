package com.viralandroid.receipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by T on 14-02-2017.
 */

public class IngrediantsListFragment extends Fragment {
    IngrediantsListAdapter ingrediantsListAdapter;
    ListView listView;
    ArrayList<String> spoons;
    ArrayList<String> items;
    Recipes recipes_obj;
    private int i;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.recipe_page,container,false);
        listView = (ListView) view.findViewById(R.id.recipe_list);

        try {
            Bundle args = getArguments();
            recipes_obj = (Recipes) args.getSerializable("ingredient");
            Log.e("response", recipes_obj.ingredients.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        spoons = new ArrayList<>();
        items  = new ArrayList<>();


//        spoons.add("1 cup");
//        spoons.add("2 teaspoon");
//        spoons.add("1");
//        spoons.add("4");
//        spoons.add("1/2 bunch");
//        spoons.add("200 g");
//        spoons.add("30 g");
//        spoons.add("500 g");
//        spoons.add("1 largen");
//
//        items.add("butternut squash");
//        items.add("dried chilli");
//        items.add("onion");
//        items.add("cloves of garlic");
//        items.add("fresh sage");
//        items.add("vac-packed chestnuts");
//        items.add("parmesan cheese");
//        items.add("all-butter puff pastry");
//        items.add("free-range egg");


        ingrediantsListAdapter = new IngrediantsListAdapter(getActivity(),recipes_obj);
        listView.setAdapter(ingrediantsListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return view;
    }


}
