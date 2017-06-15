package com.example.centuratechnology.baheekhata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Help extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        tv = (TextView) findViewById(R.id.tv);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
