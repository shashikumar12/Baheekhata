package com.example.centuratechnology.baheekhata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogin extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        etEmail = (EditText) findViewById(R.id.et1);
        etPassword = (EditText) findViewById(R.id.et2);
        btn = (Button) findViewById(R.id.loginButton);
        tv = (TextView) findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!btnet1(etEmail.getText().toString())) {
                    etEmail.setError("Invalid Email");
                } else if (!btnet2(etPassword.getText().toString())) {
                    etPassword.setError("Invalid Password");
                } else {
                    Toast.makeText(UserLogin.this, "Successfully login", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(UserLogin.this, FrontPage.class);
                    startActivity(i);
                }

            }

            public boolean btnet1(String string) {
                //String et1Pattern = "([a-zA-Z](.)[a-zA-Z])*";
                Pattern p = Pattern.compile("^[a-zA-Z0-9.@]{2,25}$");
                Matcher match = p.matcher(etEmail.getText().toString());
                return match.matches();
            }

            public boolean btnet2(String string) {
                //String et1Pattern = "([a-zA-Z](.)[a-zA-Z])*";
                Pattern p = Pattern.compile("^[a-zA-Z0-9.]{2,25}$");
                Matcher match = p.matcher(etPassword.getText().toString());
                return match.matches();
            }
           /* public void onClick(View v) {
                Intent intent = new Intent(UserLogin.this,FrontPage.class);
                startActivity(intent);
            }*/
        });


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserLogin.this, Main.class);
                startActivity(i);
            }
        });


    }
}
