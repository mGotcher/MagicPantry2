package com.example.cachery.magicpantry;


        import android.app.Activity;
        import android.graphics.Typeface;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Window;
        import android.widget.TextView;

public class recipe extends Activity {
    TextView t; //makes the xml editable. to edit fonts and colors
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //it extends Activity instead of AppCompatactivity
        setContentView(R.layout.activity_recipe);

        //  t= (TextView) findViewById(R.id.statictextrecipes);
        //   Typeface gothicfont = Typeface.createFromAsset(getApplicationContext().getAssets(), "GOTHIC.ttf");
        //  t.setTypeface(gothicfont);
    }
}