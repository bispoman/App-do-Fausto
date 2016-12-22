package com.example.danielbispo.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;
import com.example.danielbispo.myapplication.R;
import com.google.firebase.database.DatabaseReference;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {

    ToggleButton b;
    Button b2;
    Button b3;
    Button b4;
    Button b6;
    Button b7;
    MediaPlayer mp;
    MediaPlayer mpovo;
    MediaPlayer mpning;
    Intent intent;

    int counter2 = 0;
    int counter = 0;
    private TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView) findViewById(R.id.textView2);
        b = (ToggleButton) findViewById(R.id.toggleButton);
        b2 = (Button) findViewById(R.id.button);
        b3 = (Button) findViewById(R.id.button2);
        b4 = (Button) findViewById(R.id.button4);
        b6 = (Button) findViewById(R.id.button3);
        b7 = (Button) findViewById(R.id.button5);
        mp = MediaPlayer.create(this, R.raw.faustaoerou);
        mpovo = MediaPlayer.create(this, R.raw.meuovo);
        mpning = MediaPlayer.create(this, R.raw.ninguemacertou);
        intent = new Intent(getApplicationContext(), com.example.danielbispo.myapplication.DisplayMessageActivity.class);

        b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View view){
                if (counter2 == 2){
                    mpning.start();
                    counter2 = 0;
                }else {
                    mp.start();
                    counter2++;
                }
                }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(view.getContext())
                        .setTitle(getString(R.string.notify_title))
                        .setMessage(getString(R.string.notify_message))
                        .setPositiveButton(getString(R.string.eramelhormarretar), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                mp.start();
                                finish();
                            }
                        })
                        .setNegativeButton(getString(R.string.eramelhormarretarmesmo), null)
                        .setCancelable(false)
                        .show();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), getText(R.string.mensagemDoTouste), Toast.LENGTH_SHORT ).show();
            }
        });


        b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                counter++;
                if (isChecked) {
                    text1.setText(R.string.errou);
                } else {
                    text1.setText(R.string.ninguem);
                }
                if (counter == 5) {
                    text1.setText(R.string.ovo);
                    mpovo.start();
                    counter = 0;
                }
            }
        });

        final String[] imagens = {"http://www.g17.com.br/imagens/noticias/2013/abril/faustao.jpg",
                "https://planetamorumbi.files.wordpress.com/2009/04/faustao.jpg",
                "http://www.goionews.com.br/bdimages/20160405/FAUST%C3%83O.jpg",
                "http://vejasp.abril.com.br/blogs/pop/files/2015/03/faustao-popp.jpg"};

        CarouselView carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(imagens.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                Glide.with(MainActivity.this).load(imagens[position]).into(imageView);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mpning.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
