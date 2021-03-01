package com.techdecode.learnactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity2 extends AppCompatActivity {

    public static int requestCode = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        // Get intent from activity1, because activity1 has created the new intent
        // which was set a new class is the layout of activity2
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");

        EditText editText = findViewById(R.id.editText);
//      String s = editText.getText().toString();
        editText.setText(data);

        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TO DO: implement your code here!
                String s = editText.getText().toString();
                Intent intent1 = new Intent();
                intent1.putExtra("data", s);
                setResult(requestCode, intent1);

                // terminate the activity2 --> use "finish" function
                finish();
            }
        });

    }
}