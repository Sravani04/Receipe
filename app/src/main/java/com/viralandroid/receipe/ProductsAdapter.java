package com.viralandroid.receipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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
    ArrayList<Products> products;
    public ProductsAdapter(Context context,ArrayList<Products> products){
        this.context = context;
//        mimages = images;
//        mtitles = titles;
//        mtime   = time;
        this.products = products;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return products.size();
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
        //product_image.setImageResource(mimages.get(position));
        product_title.setText(products.get(position).title);
        product_time.setText(products.get(position).time1);
        Picasso.with(context).load(products.get(position).images.get(0).image).placeholder(R.drawable.placeholder).into(product_image);
        //product_time.setText(mtime.get(position));

        return item_view;
    }
}
