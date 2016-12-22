package com.example.danielbispo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    Button butn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);


        butn1 = (Button) findViewById(R.id.button6);


        butn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeScreen("R.raw.meuovo");
            }
        });

    }

    void changeScreen(String soundSource){
        Intent intent = new Intent(getApplicationContext(), com.example.danielbispo.myapplication.Player.class);
        intent.putExtra("sound", soundSource);
        startActivity(intent);
    }
}
