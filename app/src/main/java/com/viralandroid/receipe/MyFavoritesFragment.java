package com.viralandroid.receipe;

import android.app.ProgressDialog;
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

import com.google.gson.JsonArray;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by T on 21-02-2017.
 */

public class MyFavoritesFragment extends Fragment {
    ImageView back_btn;
    FavoritesAdapter favoritesAdapter;
    ListView listView;
    ArrayList<Products> productsfrom_api;
    ArrayList<String> names;
    String fav_ids = "";
    Category category;
    TextView category_name;
    Products products;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.products_list,container,false);

        DatabaseHandler db = new DatabaseHandler(getContext());

        Log.d("Reading: ", "Reading all Favorites..");
        List<Products> products = db.getAllFavorites();
        fav_ids = "0";
        for (Products pr : products) {
            String log = "Id: " + pr.getID() + " ,Title: " + pr.getTitle() + " ,Script: " + pr.getScript();
            Log.d("Title: ", log);
           // if(fav_ids.equals("0"))
             //   fav_ids=pr.id;
            //else
                fav_ids=fav_ids+","+pr.getID();
        }


        back_btn = (ImageView) view.findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        category_name = (TextView) view.findViewById(R.id.category_name);
        listView = (ListView) view.findViewById(R.id.products_list);
        productsfrom_api = new ArrayList<>();

        category = (Category) getArguments().getSerializable("category_obj");
        category_name.setText(category.title);

        favoritesAdapter = new FavoritesAdapter(getActivity(),productsfrom_api);
        listView.setAdapter(favoritesAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                RecipeMainFragment recipeMainFragment = new RecipeMainFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("product",productsfrom_api.get(i));
                bundle.putSerializable("time2",productsfrom_api.get(i).time2);
                bundle.putSerializable("price",productsfrom_api.get(i).price);
                bundle.putSerializable("calories",productsfrom_api.get(i).calories);
                //bundle.putSerializable("image",productsfrom_api.get(i).images.get(i).image);
                bundle.putSerializable("title",productsfrom_api.get(i).title);
                bundle.putSerializable("id",productsfrom_api.get(i).id);
                recipeMainFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container,recipeMainFragment).addToBackStack("recipe").commit();
            }
        });
        if(fav_ids.equals("0")){

        }else{
            get_recipes_multi();
        }

        return view;
    }


    public void get_recipes_multi(){
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("please wait..");
        progressDialog.setCancelable(false);
        progressDialog.show();
        Log.e("id",fav_ids);
        Ion.with(getContext())
                .load("http://mamacgroup.com/recipies/api/recipies_multi.php")
                .setBodyParameter("id",fav_ids)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        if (progressDialog!=null)
                            progressDialog.dismiss();
                        if (e!=null){
                            e.printStackTrace();
                        }else {
                            Log.e("response",result.toString());
                            for (int i = 0; i < result.size(); i++) {
                                try {
                                    Products products = new Products(result.get(i).getAsJsonObject(), getContext());
                                    productsfrom_api.add(products);
                                } catch (JSONException e1) {
                                    e1.printStackTrace();
                                }
                                favoritesAdapter.notifyDataSetChanged();

                            }
                        }
                    }
                });
    }
}
