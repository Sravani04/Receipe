package com.viralandroid.receipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by T on 14-03-2017.
 */

public class FavoritesAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<String> mnames;

    protected FavoritesAdapter(Context context,ArrayList<String> names){
        this.context = context;
        inflater = LayoutInflater.from(context);
        mnames = names;
    }

    @Override
    public int getCount() {
        return mnames.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        View item_view = inflater.inflate(R.layout.favorites_list,null);
        TextView item_title = (TextView) item_view.findViewById(R.id.item_name);
        item_title.setText(mnames.get(i));
        return item_view;
    }
}
