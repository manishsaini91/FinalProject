package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import org.jetbrains.annotations.NotNull;

public class gmaillogin extends AppCompatActivity {
    SignInButton s1;
    FirebaseAuth f1;
    GoogleSignInClient googleSignInClient;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmaillogin);
        s1 = (SignInButton) findViewById(R.id.signIn);
        b1=(Button)findViewById(R.id.button29);
        f1 = FirebaseAuth.getInstance();
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("951554420309-e7if9ksid47sd8bq62dolurfibmuhh5i.apps.googleusercontent.com").requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(gmaillogin.this, googleSignInOptions);
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = googleSignInClient.getSignInIntent();
                startActivityForResult(i, 99);
            }

        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(gmaillogin.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        FirebaseUser firebaseUser = f1.getCurrentUser();
        if (firebaseUser != null) {
            Intent j = new Intent(gmaillogin.this, Menu.class);
            startActivity(j);
            finish();
        }

    }

    @Override

    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99) {

            Task<GoogleSignInAccount> signInAccountTask = GoogleSignIn.getSignedInAccountFromIntent(data);
            if (signInAccountTask.isSuccessful()) {
                Toast.makeText(this, "google sign is done", Toast.LENGTH_SHORT).show();
                try {
                    GoogleSignInAccount googleSignInAccount = signInAccountTask.getResult(ApiException.class);
                    if (googleSignInAccount != null) {
                        AuthCredential authCredential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(), null);
                        f1.signInWithCredential(authCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(gmaillogin.this, "firebase updated", Toast.LENGTH_SHORT).show();
                                    Intent m = new Intent(gmaillogin.this, Menu.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(m);
                                } else {
                                    Toast.makeText(gmaillogin.this, "firebase not login", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                } catch (ApiException e) {
                    e.fillInStackTrace();
                }

            }
        }
    }
}