package com.viralandroid.receipe;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by T on 13-02-2017.
 */

public class ProductsActivity extends Activity {
    ListView listView;
    ProductsAdapter productsAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_list);
        listView = (ListView) findViewById(R.id.products_list);



    }
}
