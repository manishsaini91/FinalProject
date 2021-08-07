package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class bluetooth extends AppCompatActivity {
    ImageButton ib;
    BluetoothAdapter ba;
    private Boolean blue=false;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        ib=(ImageButton)findViewById(R.id.imageButton);
        b1=(Button)findViewById(R.id.button23);
        ba=BluetoothAdapter.getDefaultAdapter();
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(blue==false){
                    ba.enable();
                    blue=true;
                    ib.setImageResource(R.drawable.o);

                }
                else {
                    ba.disable();
                    blue=false;
                    ib.setImageResource(R.drawable.i);
                }


            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(bluetooth.this,Menu.class);
                startActivity(i);
                finish();
            }
        });



    }
}