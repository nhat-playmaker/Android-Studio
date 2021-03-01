package com.techdecode.learnactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class activity1 extends AppCompatActivity {
    // Global variables
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity1_layout);

        textView = findViewById(R.id.textView);
//        textView.setText("AAA");
//        String s = textView.getText().toString();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If click the button, new intent was created.
                Intent intent = new Intent();
                // This intent was set the new class from activity2
                intent.setClass(activity1.this,
                        activity2.class);

                String s = textView.getText().toString();
                intent.putExtra("data", s);

                /* Start activity from the new intent, if we don't want to take information from
                   Activity2, we call "startActivity(intent)", otherwise, we call
                   "startActivityForResult(intent, requestCode)"
                */

                // startActivity(intent);
                startActivityForResult(intent, activity2.requestCode);
            }
        });
    }

    /*
        This function is used to process data which return from activity2.
        If activity2 send nothing, please comment the following function
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == activity2.requestCode) {
            String s = data.getStringExtra("data");
            textView.setText(s);
        }
    }
}
