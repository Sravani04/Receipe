package com.viralandroid.receipe;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

/**
 * Created by T on 21-02-2017.
 */

public class AboutUsFragment extends Fragment {
    ImageView back_btn;
    ArrayList<Settings> settingsfrom_api;
    TextView about;
    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.about_us,container,false);
        back_btn = (ImageView) view.findViewById(R.id.back_btn);
        about = (TextView) view.findViewById(R.id.about);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        settingsfrom_api = new ArrayList<>();
        get_aboutus();
        return view;
    }

    public void get_aboutus(){
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("please wait..");
        progressDialog.setCancelable(false);
        progressDialog.show();
        Ion.with(getContext())
                .load(Session.SERVER_URL+"settings.php")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        if (progressDialog!=null)
                            progressDialog.dismiss();
                        try {
                            Log.e("about_response",result.toString());
                            Log.e("about",result.get("about").toString());
                            about.setText(android.text.Html.fromHtml(result.get("about").getAsString()));
                        } catch(Exception ex){
                            ex.printStackTrace();
                        }
                    }
                });
    }
}
