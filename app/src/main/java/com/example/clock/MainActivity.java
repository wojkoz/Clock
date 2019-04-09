package com.example.clock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.time.*;

public class MainActivity extends AppCompatActivity {
    final static String KEY = "time_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void checkTime(View view) {
            LocalTime time = LocalTime.now(ZoneId.of("Europe/Warsaw")).withNano(0);
            Intent intent = new Intent(this,TimeActivity.class);
            intent.putExtra(KEY, time.toString());
            startActivity(intent);
    }
}
