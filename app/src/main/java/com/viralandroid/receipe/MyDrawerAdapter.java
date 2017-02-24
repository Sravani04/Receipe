package com.viralandroid.receipe;

/**
 * Created by T on 18-02-2017.
 */

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyDrawerAdapter extends BaseAdapter {

    private Context context;
    private String[] titles;
    private int[] images;
    private LayoutInflater inflater;
    private int[] selectedposition;
    ArrayList<Categories>categories;
    ArrayList<Category> category;


//    public MyDrawerAdapter(Context context, String[] titles, int[] images,
//                           int[] selectedposition) {
//        // TODO Auto-generated constructor stub
//        this.context = context;
//        this.titles = titles;
//        this.images = images;
//        this.inflater = LayoutInflater.from(this.context);
//        this.selectedposition = selectedposition;
//    }

    public MyDrawerAdapter(Context context, ArrayList<Category>category,int[] images,
                           int[] selectedposition) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.titles = titles;
        this.images = images;
        this.category = category;
        this.inflater = LayoutInflater.from(this.context);
        this.selectedposition = selectedposition;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return category.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        ViewHolder mViewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.drawer_list, null);
            mViewHolder = new ViewHolder();
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.tvTitle = (TextView) convertView
                .findViewById(R.id.textView1);
        mViewHolder.ivIcon = (ImageView) convertView
                .findViewById(R.id.imageView1);

//        mViewHolder.tvTitle.setText(titles[position]);
//        mViewHolder.ivIcon.setImageResource(images[position]);

        mViewHolder.tvTitle.setText(category.get(position).title);
//        mViewHolder.ivIcon.setImageResource(images[position]);
        Picasso.with(context).load(category.get(position).image).placeholder(R.drawable.placeholder).into(mViewHolder.ivIcon);


        //Highlight the selected list item
        if (position == selectedposition[0]) {
            convertView.setBackgroundColor(Color.WHITE);
            mViewHolder.tvTitle.setTextColor(Color.BLUE);
        } else {
            convertView.setBackgroundColor(Color.TRANSPARENT);
            mViewHolder.tvTitle.setTextColor(Color.WHITE);
        }

        return convertView;
    }

    private class ViewHolder {
        TextView tvTitle;
        ImageView ivIcon;
    }
}

