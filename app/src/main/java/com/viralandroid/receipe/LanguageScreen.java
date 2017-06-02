package com.viralandroid.receipe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by T on 02-06-2017.
 */

public class LanguageScreen extends Activity {
    TextView eng_btn,arb_btn;
    Locale LAYOUT_DIRECTION_RTL;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language_screen);
        eng_btn = (TextView) findViewById(R.id.eng_btn);
        arb_btn = (TextView) findViewById(R.id.arb_btn);

        eng_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                view.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                Session.SetLang(LanguageScreen.this,"en");
                Intent  intent = new Intent(LanguageScreen.this,ExampleMainActivity.class);
                startActivity(intent);
            }
        });

        arb_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Session.SetLang(LanguageScreen.this,"ar");
                    Intent intent = new Intent(LanguageScreen.this, ExampleMainActivity.class);
                    startActivity(intent);

            }
        });
    }
}
