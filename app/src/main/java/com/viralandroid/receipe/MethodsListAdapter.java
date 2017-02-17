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

public class MethodsListAdapter extends BaseAdapter {
    LayoutInflater inflater;
    Context context;
    ArrayList<String> msteps;
    ArrayList<String> mdescription;
    Recipes recipes;


    public  MethodsListAdapter(Context context,Recipes recipes){
        this.context = context;
        //msteps = steps;
        //mdescription = description;
        this.recipes = recipes;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return recipes.steps.size();
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
        View item_view = inflater.inflate(R.layout.methods_list,null);
        TextView steps = (TextView) item_view.findViewById(R.id.steps);
        TextView description = (TextView) item_view.findViewById(R.id.description);
        steps.setText(recipes.steps.get(position).step_name);
        description.setText(recipes.steps.get(position).step_description);
        return item_view;
    }
}
