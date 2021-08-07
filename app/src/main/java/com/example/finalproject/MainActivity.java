package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1=(Button)findViewById(R.id.button);
        Button b2=(Button)findViewById(R.id.button2);
        TextView t1=(TextView)findViewById(R.id.textView);
        TextView t2=(TextView)findViewById(R.id.textView2);
        TextView t3=(TextView)findViewById(R.id.textView3);
        TextView t4=(TextView)findViewById(R.id.textView4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,OTPLogin.class);
                startActivity(i);
                finish();


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent j=new Intent(MainActivity.this,gmaillogin.class);
                    startActivity(j);
            }
        });

    }
}