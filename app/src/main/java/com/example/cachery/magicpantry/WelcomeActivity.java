package com.example.cachery.magicpantry;


        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.Button;
        import android.view.View;
        import android.content.Intent;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button login = (Button)findViewById(R.id.button);
        login.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        loginAction(view);
                    }
                }
        );

        Button signup = (Button)findViewById(R.id.button2);
        signup.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        signupAction(view);
                    }
                }
        );
    }

    private int loginAction(View view) {
        Intent iLogin = new Intent(view.getContext(), LoginActivity.class);
        startActivity(iLogin);
        return 0;
    }

    private int signupAction(View view) {
        Intent iSignup = new Intent(view.getContext(), Signup.class);
        startActivity(iSignup);
        return 0;
    }
}
