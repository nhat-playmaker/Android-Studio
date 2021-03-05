package com.techdecode.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView textViewTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTime = (TextView) findViewById(R.id.textViewTime);

        // Chọn Java.until
        Calendar calendar = Calendar.getInstance();

        textViewTime.append(calendar.getTime()+"\n");
        textViewTime.append(calendar.get(Calendar.DATE)+"\n");
        textViewTime.append(calendar.get(Calendar.DAY_OF_WEEK)+"\n");
        // Note: Month is count from 0 --> correct month = Calendar.Month+1
        textViewTime.append(calendar.get(Calendar.MONTH)+"\n");
        textViewTime.append(calendar.get(Calendar.YEAR)+"\n");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        textViewTime.append(dateFormat.format(calendar.getTime()) + "\n");

        // a là định dạng chọn (SA hoặc CH, tương đương AM/PM)
        SimpleDateFormat hourFormat = new SimpleDateFormat("hh:ss a");
        textViewTime.append(hourFormat.format(calendar.getTime()) + "\n");
    }
}