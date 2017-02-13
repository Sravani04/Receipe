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

public class MainActivityAdapter extends BaseAdapter {
    LayoutInflater inflater;
    Context context;
    ArrayList<Integer> mimages;
    ArrayList<String> mnumbers;
    ArrayList<String> mnames;

    public MainActivityAdapter(Context context,ArrayList<Integer> images,ArrayList<String> numbers,ArrayList<String> names){
        this.context = context;
        mimages = images;
        mnumbers = numbers;
        mnames = names;
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
        View item_view = inflater.inflate(R.layout.categories_list,null);
        TextView category_count = (TextView) item_view.findViewById(R.id.category_count);
        ImageView category_image = (ImageView) item_view.findViewById(R.id.categories);
        TextView category_title  = (TextView) item_view.findViewById(R.id.category_title);
        category_count.setText(mnumbers.get(position));
        category_image.setImageResource(mimages.get(position));
        category_title.setText(mnames.get(position));
        return item_view;
    }
}
