package com.viralandroid.receipe;

/**
 * Created by T on 18-02-2017.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ListView listView;
    MainActivityAdapter  mainActivityAdapter;
    ArrayList<Integer> images;
    ArrayList<String> numbers;
    ArrayList<String> names;
    ArrayList<Categories> categories;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ImageView menu_btn;



    /**
     * Returns a new instance of this fragment for the given section number.
     * @param
     * @param
     */
    public static HomeFragment newInstance(JSONObject jsonObject){
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("paramkey", jsonObject.toString()); // you use key to later grab the value
        fragment.setArguments(bundle);
        return fragment;
    }

    public HomeFragment() {
    }


NavigationDrawerCallbacks mCallbacks;
    public  interface NavigationDrawerCallbacks {
        /**
         * Called when an item in the navigation drawer is selected.
         */
        void menu_clicked();

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallbacks = (NavigationDrawerCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(
                    "Activity must implement NavigationDrawerCallbacks.");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }



    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main, container,
                false);
        listView = (ListView) rootView.findViewById(R.id.categories_list);
        menu_btn = (ImageView) rootView.findViewById(R.id.menu_btn);

        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    mCallbacks.menu_clicked();
            }
        });

        images = new ArrayList<>();
        numbers = new ArrayList<>();
        names = new ArrayList<>();
        categories = new ArrayList<>();

        images.add(R.drawable.gennaros_pasta01);
        images.add(R.drawable.gennaros_pasta01);

        numbers.add("3");
        numbers.add("4");

        names.add("Fruit recipes");
        names.add("Beef recipes");

        String value = getArguments().getString("paramkey");


        try {
            jsonObject = new JSONObject(value);
            jsonArray = jsonObject.getJSONArray("Category");
            for (int i =0;i<jsonObject.getJSONArray("Category").length();i++) {
                categories.add(new Categories(jsonArray.getJSONObject(i)));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        mainActivityAdapter = new MainActivityAdapter(getActivity(),categories);

        listView.setAdapter(mainActivityAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ProductsFragment productsFragment = new ProductsFragment();
                Bundle bundle = new Bundle();
                try {
                    bundle.putString("recipe",jsonArray.getJSONObject(i).getJSONArray("RecipeInfo").toString());
                    bundle.putSerializable("category",categories.get(i));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                productsFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container,productsFragment).addToBackStack("category").commit();
            }
        });


        return rootView;
    }



}
