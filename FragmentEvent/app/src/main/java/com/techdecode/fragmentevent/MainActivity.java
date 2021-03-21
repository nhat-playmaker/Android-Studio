package com.techdecode.fragmentevent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewMain;
    Button buttonMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewMain = findViewById(R.id.TextViewMain);
        buttonMain = findViewById(R.id.button);

        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Communicate vói fragmentA trong MainActivity
                FragmentA fragmentA = (FragmentA) getSupportFragmentManager().findFragmentById(R.id.fragmentA);
                assert fragmentA != null;
                //fragmentA.textViewA.setText("Thay đổi bởi MainActivity");
                fragmentA.ganNoiDung("Thay đổi bởi MainActivity");

            }
        });

    }
}