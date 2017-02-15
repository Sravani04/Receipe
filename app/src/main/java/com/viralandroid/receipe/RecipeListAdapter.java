package com.viralandroid.receipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by T on 14-02-2017.
 */

public class RecipeListAdapter extends BaseAdapter {
    LayoutInflater inflater;
    Context context;
    ArrayList<String> mdescription;
    ArrayList<Recipes> recipes;


    public RecipeListAdapter(Context context,ArrayList<Recipes> recipes){
        this.context = context;
        //mdescription = description;
        this.recipes = recipes;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return recipes.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View item_view = inflater.inflate(R.layout.recipes_list,null);
        TextView description = (TextView) item_view.findViewById(R.id.description);
        description.setText(recipes.get(position).description);
        return item_view;
    }
}
