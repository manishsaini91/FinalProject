package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        b1=(Button)findViewById(R.id.button5);
        b2=(Button)findViewById(R.id.button6);
        b3=(Button)findViewById(R.id.button7);
        b4=(Button)findViewById(R.id.button8);
        b5=(Button)findViewById(R.id.button9);
        b5.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(Menu.this,Menu2.class);
               startActivity(i);
           }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Menu.this,calculator.class);
                startActivity(i);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Menu.this,torch.class);
                startActivity(i);
                finish();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Menu.this,bluetooth.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Menu.this,music.class);
                startActivity(i);
                finish();
            }
        });

    }
}