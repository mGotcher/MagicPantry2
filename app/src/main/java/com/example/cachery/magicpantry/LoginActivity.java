package com.example.cachery.magicpantry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = (Button)findViewById(R.id.log_in);
        login.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText uEdit = (EditText)findViewById(R.id.username);
                        EditText pEdit = (EditText)findViewById(R.id.password_prompt);
                        String user = uEdit.getText().toString();
                        //Need to hash and salt the password
                        String pass = pEdit.getText().toString();
                        int result = 0;
                        try {
                            result = queryUsers(user, pass);
                        }catch(IOException e) {
                            System.err.println("File Error:" + e);
                        }
                        if (result == 1) {
                            System.out.println("User Verified");
                        } else if (result == 2) {
                            System.out.println("Incorrect Password");
                        } else if (result == 3) {
                            System.out.println("User Not Found");
                        } else {
                            System.out.println("The File Was Not Read");
                        }
                    }
                }
        );
    }

    //Reads the secret.txt file and searches for the correct user and pass word combo
    private int queryUsers(String user, String pass) throws IOException {
        String line;
        String[] split = new String[2];
        StringBuffer buffer = new StringBuffer();
        InputStream stream = this.getResources().openRawResource(R.raw.secret);
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        if (stream != null) {
            while ((line = reader.readLine()) != null) {
                split = line.split(" ");
                if (user.compareTo(split[0]) == 0) {
                    if (pass.compareTo(split[1]) == 0) {
                        return 1;
                    } else {
                        return 2;
                    }
                }
            }
        }
        stream.close();
        return 3;
    }
}