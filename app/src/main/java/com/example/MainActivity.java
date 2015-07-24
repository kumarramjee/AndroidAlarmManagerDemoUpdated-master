package com.example;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends Activity {
TextView textt;
    private PendingIntent pendingIntent;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textt=(TextView)findViewById(R.id.textt);

        Intent myIntent = new Intent(MainActivity.this, MyReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, myIntent, 0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, (System.currentTimeMillis() + (1000 * 60 * 1)), pendingIntent);


        textt.setText("Your App  generate notification after " + (System.currentTimeMillis() + (1000 * 60 * 1))+" seconds");



    } //end onCreate


}