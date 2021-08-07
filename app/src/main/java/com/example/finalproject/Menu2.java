package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu2 extends AppCompatActivity {
    Button b1,b2,b3,b4,b6,b7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
        b1=(Button)findViewById(R.id.button10);
        b2=(Button)findViewById(R.id.button11);
        b3=(Button)findViewById(R.id.button12);
        b4=(Button)findViewById(R.id.button13);

        b6=(Button)findViewById(R.id.button14);
        b7=(Button)findViewById(R.id.button15);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Menu2.this,lightmusic.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Menu2.this,speak.class);
                startActivity(i);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Menu2.this,tiltlight.class);
                startActivity(i);
                finish();

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Menu2.this,vibrate.class);
                startActivity(i);
                finish();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Menu2.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Menu2.this,details.class);
                startActivity(i);
                finish();
            }
        });
    }
}