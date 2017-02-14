package com.viralandroid.receipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by T on 13-02-2017.
 */

public class ProductsAdapter extends BaseAdapter {
    LayoutInflater inflater;
    Context context;
    ArrayList<Integer> mimages;
    ArrayList<String> mtitles;
    ArrayList<String> mtime;

    public ProductsAdapter(Context context,ArrayList<Integer> images,ArrayList<String> titles,ArrayList<String> time){
        this.context = context;
        mimages = images;
        mtitles = titles;
        mtime   = time;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mimages.size();
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
        View item_view = inflater.inflate(R.layout.products,null);
        ImageView product_image = (ImageView) item_view.findViewById(R.id.product_image);
        TextView  product_title = (TextView) item_view.findViewById(R.id.product_title);
        TextView  product_time  = (TextView) item_view.findViewById(R.id.product_time);
        product_image.setImageResource(mimages.get(position));
        product_title.setText(mtitles.get(position));
        product_time.setText(mtime.get(position));

        return item_view;
    }
}
