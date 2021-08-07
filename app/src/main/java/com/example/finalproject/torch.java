package com.example.finalproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class torch extends AppCompatActivity {
    TextView tv;
    Button b1,b2,b3;
    CameraManager cm;
    private boolean torch =false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch);
        b1=(Button)findViewById(R.id.button21);
        b2=(Button)findViewById(R.id.button22);
        b3=(Button)findViewById(R.id.button33);
        tv=(TextView)findViewById(R.id.torch1);

        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(torch.this,Menu.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                try{
                    String id=cm.getCameraIdList()[0];
                    cm.setTorchMode(id,true);
                    torch=true;
                }
                catch (CameraAccessException e){

                }
                Toast.makeText(torch.this, "Torch On", Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                try{
                    String id=cm.getCameraIdList()[0];
                    cm.setTorchMode(id,false);
                    torch=false;
                }
                catch (CameraAccessException e){

                }
                Toast.makeText(torch.this, "Torch Off ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}