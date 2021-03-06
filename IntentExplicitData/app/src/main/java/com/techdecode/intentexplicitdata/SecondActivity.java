package com.techdecode.intentexplicitdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewResult = (TextView) findViewById(R.id.textViewResult);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Send_Bundle");

        // Nếu có lấy được bundle
        if (bundle != null) {
            String string = bundle.getString("string");
            textViewResult.setText("aaa");
        }
    }
}