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

public class IngrediantsListAdapter extends BaseAdapter {
    LayoutInflater inflater;
    Context context;
    ArrayList<String> mspoons;
    ArrayList<String> mitems;
    Recipes recipes;
    Products products;

//    ,ArrayList<String> spoons,ArrayList<String> items


    public IngrediantsListAdapter(Context context,Products products){
        this.context = context;
        this.recipes = recipes;
//        mspoons = spoons;
//        mitems = items;
        this.products = products;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return products.ingredients.size();
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
        View item_view = inflater.inflate(R.layout.ingrediants_list,null);
        TextView spoons = (TextView) item_view.findViewById(R.id.spoons);
        TextView item = (TextView) item_view.findViewById(R.id.item);
        spoons.setText(products.ingredients.get(position).value);
        item.setText(products.ingredients.get(position).ingredient);
        return item_view;
    }
}
