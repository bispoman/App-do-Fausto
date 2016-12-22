package com.example.danielbispo.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Player extends AppCompatActivity {

    String audio;
    MediaPlayer meuplei;
    Button play, pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        play = (Button) findViewById(R.id.button7);
        pause = (Button) findViewById(R.id.button8);
        //Bundle extras = getIntent().getExtras();
        Intent extra = getIntent();
        int audio = extra.getIntExtra("sound", 0);
        meuplei = MediaPlayer.create(getApplicationContext(), audio);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meuplei.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meuplei.pause();
            }
        });

    }
}
