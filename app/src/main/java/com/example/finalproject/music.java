package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class music extends AppCompatActivity {
    Button b1,b2,b3;
    TextView t1;
    MediaPlayer m1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        b1=(Button)findViewById(R.id.button19);
        b2=(Button)findViewById((R.id.button20));
        b3=(Button)findViewById(R.id.button31);
        t1=(TextView)findViewById(R.id.music);
        m1=MediaPlayer.create(this,R.raw.k);

        String s1="Welcome to our app :  ";
        t1.setText(s1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m1.start();
                Toast.makeText(music.this, "DJ wale plz play song", Toast.LENGTH_SHORT).show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(music.this,Menu.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m1.pause();
                Toast.makeText(music.this, "Plz stop song", Toast.LENGTH_SHORT).show();
            }
        });


    }
}