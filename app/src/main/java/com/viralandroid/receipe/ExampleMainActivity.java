package com.viralandroid.receipe;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ExampleMainActivity extends FragmentActivity implements
        NavigationDrawerFragment.NavigationDrawerCallbacks,HomeFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the
     * navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in
     * {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    ArrayList<Categories> categories;
    JSONObject jsonObject;
    JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_activity);

        try {
            jsonObject = new JSONObject(getIntent().getStringExtra("json"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

//        Bundle bundle = new Bundle();
//        bundle.putSerializable("response",jsonObject.toString());
//        mNavigationDrawerFragment.setArguments(bundle);



        mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        mTitle = getTitle();

        // Set up the drawer.
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationDrawerFragment.update_navigation(jsonObject);
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer,mDrawerLayout);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container,HomeFragment.newInstance(jsonObject)).commit();


    }

    DrawerLayout mDrawerLayout;


    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.container,HomeFragment.newInstance(jsonObject)).commit();

//        if (position == 0) {
//            fragmentManager.beginTransaction().replace(R.id.container, HomeFragment.newInstance()).commit();
//        }
//
    }

    //Get the title of current fragment
    public void onSectionAttached(int number) {
        System.out.println(mTitle);
        switch (number) {
            case 1:
                mTitle = getString(R.string.fruit_recipe);
                break;
            case 2:
                mTitle = getString(R.string.beef_recipe);
                break;
            case 3:
                mTitle = getString(R.string.pasta_recipe);
                break;
        }
    }

    //Change the title of page to current fragments title
    public void restoreActionBar() {
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
//        actionBar.setDisplayShowTitleEnabled(true);
//        actionBar.setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
          //  getMenuInflater().inflate(R.menu.main, menu);
            //restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void menu_clicked() {
        mDrawerLayout.openDrawer(GravityCompat.START);
    }
}
