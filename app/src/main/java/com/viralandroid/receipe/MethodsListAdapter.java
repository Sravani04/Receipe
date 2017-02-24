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
    Products products;


    public  MethodsListAdapter(Context context,Products products){
        this.context = context;
        //msteps = steps;
        //mdescription = description;
        this.recipes = recipes;
        this.products = products;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return products.methods.size();
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
        steps.setText(products.methods.get(position).method);
        description.setText(products.methods.get(position).value);
        return item_view;
    }
}
