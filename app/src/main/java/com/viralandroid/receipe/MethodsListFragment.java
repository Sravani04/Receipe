package com.viralandroid.receipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by T on 14-02-2017.
 */

public class MethodsListFragment extends Fragment {
    MethodsListAdapter methodsListAdapter;
    ImageView recipe_like,recipe_share;
    ListView listView;
    ArrayList<String> steps;
    ArrayList<String> description;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.recipe_page,container,false);
        listView = (ListView) view.findViewById(R.id.recipe_list);
        steps = new ArrayList<>();
        description = new ArrayList<>();

        steps.add("Step1:");
        steps.add("Step2:");


        description.add("Deseed the squash and cut into 8 wedges, then place in a roasting tray and sprinklw over the chilli, drizzle with oil and season. Toss well, spread evenly and roast for 35 to 40 minutes. Remove and cool.");
        description.add("Deseed the squash and cut into 8 wedges, then place in a roasting tray and sprinklw over the chilli, drizzle with oil and season. Toss well, spread evenly and roast for 35 to 40 minutes. Remove and cool.");

        methodsListAdapter = new MethodsListAdapter(getActivity(),steps,description);
        listView.setAdapter(methodsListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        return view;
    }
}
