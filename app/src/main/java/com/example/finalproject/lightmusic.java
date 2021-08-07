package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class lightmusic extends AppCompatActivity implements SensorEventListener {
    ImageView i1;
    MediaPlayer mp;
    SensorManager sm;
    Sensor s;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lightmusic);
        i1=(ImageView)findViewById(R.id.light);
        b1=(Button)findViewById(R.id.button30);
        mp=MediaPlayer.create(this,R.raw.k);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(lightmusic.this,Menu2.class);startActivity(i);
                finish();
            }
        });

    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.values[0]>5){
            //mp.pause();
            i1.setImageResource(R.drawable.i);
        }
        else{
            //mp.start();
            i1.setImageResource(R.drawable.o);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}