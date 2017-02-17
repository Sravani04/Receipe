package com.viralandroid.receipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by T on 14-02-2017.
 */

public class RecipeListFragment extends Fragment {
    RecipeListAdapter recipeListAdapter;
    ListView listView;
    ArrayList<String> description;
    ArrayList<Recipes> recipes;
    Recipes recipes_obj;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.recipe_page,container,false);
        listView = (ListView) view.findViewById(R.id.recipe_list);

        try {
            recipes_obj = (Recipes) getArguments().getSerializable("recipe");
//            Log.e("recipe_response",recipes_obj.description);
        } catch (Exception e) {
            e.printStackTrace();
        }

        description = new ArrayList<>();
        recipes = new ArrayList<>();

//        description.add("Deseed the squash and cut into 8 wedges, then place in a roasting tray and sprinklw over the chilli, drizzle with oil and season. Toss well, spread evenly and roast for 35 to 40 minutes. Remove and cool.");
//        description.add("Peel and finely drop the onion and");

        description.add(recipes_obj.description);

        recipeListAdapter = new RecipeListAdapter(getActivity(),description);
        listView.setAdapter(recipeListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });


        return view;
    }

}
