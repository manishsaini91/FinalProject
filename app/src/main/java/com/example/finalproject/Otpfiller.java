package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class Otpfiller extends AppCompatActivity {
    EditText e1;
    Button b1;
    String phone;
    String otp;
    FirebaseAuth firebaseAuth;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpfiller);
        phone=getIntent().getStringExtra("mobile").toString();
        e1=(EditText)findViewById(R.id.editText2);
        t1=(TextView)findViewById(R.id.textView6);
        b1=(Button)findViewById(R.id.button4);
        firebaseAuth=FirebaseAuth.getInstance();
        genotp();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().isEmpty()){
                    Toast.makeText(Otpfiller.this, "Please enter OTP", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(e1.getText().toString().length()!=6){
                        Toast.makeText(Otpfiller.this, "Invalid OTP", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(otp,e1.getText().toString());
                        signInWithPhoneauthcredential(credential);
                    }
                }

            }
        });


    }
    private void genotp(){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,
                60,
                TimeUnit.SECONDS, this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull @NotNull String s, @NonNull @NotNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        otp=s;
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull @org.jetbrains.annotations.NotNull PhoneAuthCredential phoneAuthCredential) {
                        signInWithPhoneauthcredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull @org.jetbrains.annotations.NotNull FirebaseException e) {
                        Toast.makeText(Otpfiller.this, "OTP Mismatch", Toast.LENGTH_SHORT).show();
                    }
                }

        );
    }
    private void signInWithPhoneauthcredential(PhoneAuthCredential credential){
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Otpfiller.this, "Login done", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Otpfiller.this,Menu.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(Otpfiller.this, "Login not done ", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}