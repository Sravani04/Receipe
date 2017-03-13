package com.viralandroid.receipe;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

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
    ArrayList<Products> productsfrom_api;
    Category category;
    String id;
    Products products;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.products_list,container,false);
        listView = (ListView) view.findViewById(R.id.products_list);
        back_btn = (ImageView) view.findViewById(R.id.back_btn);
        category_name = (TextView) view.findViewById(R.id.category_name);

//        try {
//            jsonArray = new JSONArray(getArguments().getString("recipe"));
//            categories_obj = (Categories) getArguments().getSerializable("category");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        category = (Category) getArguments().getSerializable("category_obj");

        category_name.setText(category.title);

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

        productsfrom_api = new ArrayList<>();

//        recipes = new ArrayList<>();
//
//        try {
//            for (int i =0;i<getArguments().getString("recipe").length();i++) {
//                recipes.add(new Recipes(jsonArray.getJSONObject(i)));
//
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        productsAdapter = new ProductsAdapter(getActivity(),productsfrom_api);
        listView.setAdapter(productsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                RecipeMainFragment recipeMainFragment = new RecipeMainFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("product",productsfrom_api.get(i));
                bundle.putSerializable("time2",productsfrom_api.get(i).time2);
                bundle.putSerializable("price",productsfrom_api.get(i).price);
                bundle.putSerializable("calories",productsfrom_api.get(i).calories);
                bundle.putSerializable("image",productsfrom_api.get(i).images.get(i).image);
                bundle.putSerializable("title",productsfrom_api.get(i).title);
                bundle.putSerializable("id",productsfrom_api.get(i).id);
                recipeMainFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container,recipeMainFragment).addToBackStack("recipe").commit();
            }
        });
       get_recipes_multi();
//        get_products();
        return view;
    }

    public void get_products(){
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("please wait..");
        progressDialog.setCancelable(false);
        progressDialog.show();
        Ion.with(getContext())
                .load("http://mamacgroup.com/recipies/api/recipies.php")
                .setBodyParameter("category", category.id)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        if (progressDialog!=null)
                            progressDialog.dismiss();
                        for (int i=0;i<result.size();i++){
                            try {
                                Products products = new Products(result.get(i).getAsJsonObject(),getContext());
                                productsfrom_api.add(products);
                            } catch (JSONException e1) {
                                e1.printStackTrace();
                            }
                            productsAdapter.notifyDataSetChanged();

                        }
                    }
                });
    }

    public void get_recipes_multi(){
        Ion.with(getContext())
                .load("http://mamacgroup.com/recipies/api/recipies_multi.php")
                .setBodyParameter("id",category.id)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (int i=0;i<result.size();i++){
                            Products products = null;
                            try {
                                products = new Products(result.get(i).getAsJsonObject(),getContext());
                            } catch (JSONException e1) {
                                e1.printStackTrace();
                            }
                            productsfrom_api.add(products);
                        }
                        productsAdapter.notifyDataSetChanged();
                    }
                });
    }

}
