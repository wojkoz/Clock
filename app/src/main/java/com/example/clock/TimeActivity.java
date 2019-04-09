package com.example.clock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;


public class TimeActivity extends AppCompatActivity {

    TextView war;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        war = findViewById(R.id.time0);
        Intent intent = getIntent();
        war.setText(intent.getStringExtra(MainActivity.KEY));

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask(){
            @Override
            public void run(){
                nextTime();
            }
        };

        timer.schedule(timerTask,1000,1000);
    }

    private void nextTime(){

        war.setText(String.valueOf(LocalTime.now().withNano(0)));

        TextView lon = findViewById(R.id.time2);
        lon.setText(String.valueOf(LocalTime.now(ZoneId.of("Europe/London")).withNano(0)));

        TextView ny = findViewById(R.id.time1);
        ny.setText(String.valueOf(LocalTime.now(ZoneId.of("America/Indianapolis")).withNano(0)));

        TextView tk = findViewById(R.id.time4);
        tk.setText(String.valueOf(LocalTime.now(ZoneId.of("Asia/Tokyo")).withNano(0)));

    }


}
