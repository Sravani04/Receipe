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
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by T on 21-02-2017.
 */

public class MyFavoritesFragment extends Fragment {
    ImageView back_btn;
    FavoritesAdapter favoritesAdapter;
    ListView listView;
    ArrayList<Products> productsfrom_api;
    ArrayList<String> names;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.my_favorites,container,false);
        back_btn = (ImageView) view.findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        listView = (ListView) view.findViewById(R.id.fav_list);
        productsfrom_api = new ArrayList<>();
        names = new ArrayList<>();

        names.add("example1");
        names.add("example2");
        names.add("example3");

        favoritesAdapter = new FavoritesAdapter(getActivity(),names);
        listView.setAdapter(favoritesAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        get_recipes_multi();
        return view;
    }

    public void get_recipes_multi(){
        Ion.with(getContext())
                .load("http://mamacgroup.com/recipies/api/recipies_multi.php")
                .setBodyParameter("id","1,2,3")
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (int i=0;i<result.size();i++){
                            try {
                                Products products = new Products(result.get(i).getAsJsonObject(),getContext());
                                productsfrom_api.add(products);
                            } catch (JSONException e1) {
                                e1.printStackTrace();
                            }
                            favoritesAdapter.notifyDataSetChanged();

                        }
                    }
                });
    }
}
