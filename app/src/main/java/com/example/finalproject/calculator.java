package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class calculator extends AppCompatActivity {
    EditText e1,e2;
    TextView t1;
    Button b1,b2,b3,b4,b5;
    TextToSpeech ts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Button b1=(Button)findViewById(R.id.button15);
        Button b2=(Button)findViewById(R.id.button16);
        Button b3=(Button)findViewById(R.id.button17);
        Button b4=(Button)findViewById(R.id.button18);
        Button b5=(Button)findViewById(R.id.button24);
        e1=(EditText)findViewById(R.id.editText3);
        e2=(EditText)findViewById(R.id.editText4);
        t1=(TextView)findViewById(R.id.result);
        ts=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                ts.setLanguage(Locale.ENGLISH);
                ts.setSpeechRate(0.8f);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                Float f1=Float.parseFloat(s1);
                Float f2=Float.parseFloat(s2);
                Float f3=f1+f2;
                String s3=Float.toString(f3);
                t1.setText(s3);
                ts.speak("The result is"+ s3,TextToSpeech.QUEUE_FLUSH,null);
                Toast.makeText(calculator.this, "The result is : " + s3, Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                Float f1=Float.parseFloat(s1);
                Float f2=Float.parseFloat(s2);
                Float f3=f1-f2;
                final String s3=Float.toString(f3);
                t1.setText(s3);
                ts.speak("The result is "+ s3,TextToSpeech.QUEUE_FLUSH,null);
                Toast.makeText(calculator.this, "The result is : " + s3, Toast.LENGTH_SHORT).show();
            }


        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                Float f1=Float.parseFloat(s1);
                Float f2=Float.parseFloat(s2);
                Float f3=f1*f2;
                final String s3=Float.toString(f3);
                t1.setText(s3);
                ts.speak("The result is "+ s3,TextToSpeech.QUEUE_FLUSH,null);

                Toast.makeText(calculator.this, "The result is : " + s3, Toast.LENGTH_SHORT).show();
            }

        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                Float f1=Float.parseFloat(s1);
                Float f2=Float.parseFloat(s2);
                Float f3=f1/f2;
                final String s3=Float.toString(f3);
                t1.setText(s3);
                ts.speak("The result is "+ s3,TextToSpeech.QUEUE_FLUSH,null);
                Toast.makeText(calculator.this, "The result is : " + s3, Toast.LENGTH_SHORT).show();
            }

        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(calculator.this,Menu.class);
                startActivity(i);
                finish();
            }
        });

    }



}