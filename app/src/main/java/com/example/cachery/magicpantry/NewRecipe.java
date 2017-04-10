package com.example.cachery.magicpantry;

/**
 * Created by cachery on 4/8/17.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;


import static android.R.attr.button;

public class NewRecipe extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton search = (ImageButton) findViewById(R.id.searchbutton);
        ImageButton menu = (ImageButton) findViewById(R.id.menuicon);
        final EditText textview1 = (EditText) findViewById(R.id.textview1);
        final EditText textview2 = (EditText) findViewById(R.id.textview2);
        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textview1.setText("Fire");
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textview2.setText("Fire");
            }
        });
    }

}
