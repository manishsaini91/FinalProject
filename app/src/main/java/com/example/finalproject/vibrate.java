package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class vibrate extends AppCompatActivity {
    Button b1,b2;
    Vibrator v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrate);
        b1= (Button)findViewById(R.id.button27);
        b2 = (Button)findViewById(R.id.button28);
        v1 = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT>26)
                {
                    v1.vibrate(10000);
                }
                else
                {
                    v1.vibrate(10000);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(vibrate.this,Menu2.class);
                startActivity(i);
                finish();
            }
        });
    }
}