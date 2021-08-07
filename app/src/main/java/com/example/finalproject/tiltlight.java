package com.example.finalproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class tiltlight extends AppCompatActivity implements SensorEventListener {
    ImageView i1;
    MediaPlayer mp;
    SensorManager sm;
    Sensor s;
    CameraManager cm;
    private  boolean torch=false;
    TextView t1;
    Button b1;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiltlight);
        TextView t1=(TextView)findViewById(R.id.textView11);
        mp=MediaPlayer.create(this,R.raw.k);
        b1=(Button)findViewById(R.id.button32);
        i1=(ImageView)findViewById(R.id.tilt);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener((SensorEventListener) this,s,SensorManager.SENSOR_DELAY_NORMAL);
        cm= (CameraManager)getSystemService(CAMERA_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(tiltlight.this,Menu2.class);
                startActivity(i);
                finish();
            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.M)

    public void onSensorChanged(SensorEvent sensorEvent) {
        float x1=sensorEvent.values[0];
        float y1=sensorEvent.values[1];
        float z1=sensorEvent.values[2];
        int x=(int)x1;
        int y=(int)y1;
        int z=(int)z1;
        if(x!=0){
            //mp.start();
            try{
                String id=cm.getCameraIdList()[0];
                cm.setTorchMode(id,true);
                torch=true;

            }
            catch (CameraAccessException e){

            }
            i1.setImageResource(R.drawable.o);
        }
        else{
            //mp.pause();
            try{
                String id =cm.getCameraIdList()[0];
                cm.setTorchMode(id,false);
                torch=false;

            }
            catch (CameraAccessException e){

            }
            i1.setImageResource(R.drawable.i);
        }

    }


    public void onAccuracyChanged(Sensor sensor, int i) {

    }


}