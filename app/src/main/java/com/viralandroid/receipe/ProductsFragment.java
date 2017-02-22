package com.viralandroid.receipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by T on 22-02-2017.
 */

public class ProductsFragment extends Fragment {
    ListView listView;
    ProductsAdapter productsAdapter;
    ArrayList<Integer> images;
    ArrayList<String> titles;
    ArrayList<String> time;
    ImageView back_btn;
    TextView category_name;
    JSONArray jsonArray;
    JSONObject jsonObject;
    ArrayList<Recipes> recipes;
    Categories categories_obj;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.products_list,container,false);
        listView = (ListView) view.findViewById(R.id.products_list);
        back_btn = (ImageView) view.findViewById(R.id.back_btn);
        category_name = (TextView) view.findViewById(R.id.category_name);

        try {
            jsonArray = new JSONArray(getArguments().getString("recipe"));
            categories_obj = (Categories) getArguments().getSerializable("category");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        category_name.setText(categories_obj.name);

        images = new ArrayList<>();
        titles = new ArrayList<>();
        time   = new ArrayList<>();

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
                getActivity().onBackPressed();
            }
        });

        recipes = new ArrayList<>();

        try {
            for (int i =0;i<getArguments().getString("recipe").length();i++) {
                recipes.add(new Recipes(jsonArray.getJSONObject(i)));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        productsAdapter = new ProductsAdapter(getActivity(),recipes);
        listView.setAdapter(productsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                RecipeMainFragment recipeMainFragment = new RecipeMainFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("recipe",recipes.get(i));
                recipeMainFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container,recipeMainFragment).addToBackStack("recipe").commit();
            }
        });

        return view;
    }

}
