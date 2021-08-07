package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class speak extends AppCompatActivity {
    Button b1,b2;
    EditText e1;
    TextToSpeech ts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speak);
        e1=(EditText)findViewById(R.id.speak);
        b1=(Button)findViewById(R.id.speak1);
        b2=(Button)findViewById(R.id.speak2);
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
                String s1=e1.getText().toString();
                ts.speak(s1,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(speak.this,Menu2.class);
                startActivity(i);
                finish();
            }
        });


    }
}