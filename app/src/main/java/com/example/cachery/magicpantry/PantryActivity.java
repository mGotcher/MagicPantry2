package com.example.cachery.magicpantry;

        import android.content.Intent;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListView;

        import java.util.ArrayList;
        import java.util.Arrays;

public class pantryActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    EditText editText;
    ArrayList<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantry_activity_main);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setIcon(R.mipmap.ic_launcher);

        //Add items to list
        String[] items={"Apple","Banana","Cinnamon"};
        itemList=new ArrayList<String>(Arrays.asList(items));
        adapter=new ArrayAdapter<String>(this,R.layout.list_layout,R.id.txtview,itemList);

        ListView listV=(ListView)findViewById(R.id.list);
        listV.setAdapter(adapter);
        editText=(EditText)findViewById(R.id.txtInput);
        Button btAdd=(Button)findViewById(R.id.btAdd);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem=editText.getText().toString();
                // add new item to arraylist
                itemList.add(newItem);
                // notify listview of data changed
                adapter.notifyDataSetChanged();
            }

        });

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //Settings on topright corner
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle action bar item clicks here. The action bar will
        //automatically handle clicks on the Home/Up button, so long
        //as upi specify a parent activity in AndroidManifest.xml
        int id = item.getItemId();

        //noninspection SimplifiableIfStatement
        if(id == R.id.action_settings){
            //Intent intent = new Intent(this, SettingsActivity.class);
            //startActivity(intent);
            return true;
        }

        //noninspection SimplifiableIfStatement
        if(id == R.id.action_help){
            Intent intent = new Intent(this, HelpActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}