package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hbb20.CountryCodePicker;


public class OTPLogin extends AppCompatActivity {
    CountryCodePicker cpp;
    EditText e1;
    Button b1;
    TextView t1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otplogin);
        t1=(TextView)findViewById(R.id.textView5);
        e1=(EditText)findViewById(R.id.editText);
        b1=(Button)findViewById(R.id.button3);
        cpp=(CountryCodePicker)findViewById(R.id.ccp);
        cpp.registerCarrierNumberEditText(e1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(OTPLogin.this ,Otpfiller.class);
                i.putExtra("mobile",cpp.getFullNumberWithPlus().trim());
                startActivity(i);
            }
        });
    }
}