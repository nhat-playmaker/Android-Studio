package com.techdecode.testuiapp;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static TextView
            textViewTemperatureValue,
            textViewHumidityValue,
            textViewAQINumber,
            textViewNotification,
            textViewPM25Value,
            textViewPM100Value,
            textViewCO2Value,
            textViewHCHOValue,
            textViewTVOCValue;

    public static FrameLayout
            frameLayoutAQI,
            frameLayoutIconBackground,
            frameLayoutFaceAttitude;

    boolean isRunningTimer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Initialize();

        fetchData process = new fetchData();

        process.execute();

    }

    private void Initialize() {
        textViewTemperatureValue = findViewById(R.id.textViewTemperatureValue);
        textViewHumidityValue = findViewById(R.id.textViewHumidityValue);
        textViewAQINumber = findViewById(R.id.textViewAQINumber);
        textViewNotification = findViewById(R.id.textViewNotification);
        textViewPM25Value = findViewById(R.id.textViewPM25Value);
        textViewPM100Value = findViewById(R.id.textViewPM100Value);
        textViewCO2Value = findViewById(R.id.textViewCO2Value);
        textViewHCHOValue = findViewById(R.id.textViewHCHOValue);
        textViewTVOCValue = findViewById(R.id.textViewTVOCValue);
    }

    private void startTimer() {

    }
}
