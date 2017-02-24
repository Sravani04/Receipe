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

public class ShoppingCartAdapter extends BaseAdapter {
    LayoutInflater inflater;
    Context context;
    ArrayList<String> mspoons;
    ArrayList<String> mitems;
    Recipes recipes;
    Products products;

    public ShoppingCartAdapter(Context context,Products products){
        this.context = context;
        this.recipes = recipes;
        this.products = products;
//        mspoons = spoons;
//        mitems  = items;
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
        View item_view = inflater.inflate(R.layout.cart_list_items,null);
        TextView recipe_spoons = (TextView) item_view.findViewById(R.id.recipe_spoons);
        TextView recipe_items = (TextView) item_view.findViewById(R.id.recipe_items);
        recipe_spoons.setText(products.ingredients.get(position).value);
        recipe_items.setText(products.ingredients.get(position).ingredient);
        return item_view;
    }

}
