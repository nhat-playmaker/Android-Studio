package com.techdecode.cycleactivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    private String Tag = "First Activity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(Tag, "OnCreat()");

        setContentView(R.layout.first_layout);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TO DO: implement your code here
//                Toast.makeText(FirstActivity.this,
//                        "You have clicked the button",
//                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.setClass(FirstActivity.this,
                        SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(Tag, "OnCreat()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(Tag, "OnResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(Tag, "OnPause()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i(Tag, "OnRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(Tag, "On Destroy()");
    }
}
