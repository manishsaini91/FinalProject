package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class details extends AppCompatActivity {
    TextView t1,t2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        t1=(TextView)findViewById(R.id.textView9);
        t2=(TextView)findViewById(R.id.textView12);
        b1=(Button)findViewById(R.id.details);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(details.this,Menu2.class);
                startActivity(i);
                finish();
            }
        });


    }
}