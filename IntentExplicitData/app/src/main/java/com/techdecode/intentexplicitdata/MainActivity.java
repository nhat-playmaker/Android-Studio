package com.techdecode.intentexplicitdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    Button buttonMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonMain = (Button) findViewById(R.id.buttonMain);

        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("string", "Test");
                bundle.putInt("int", 124);
                String[] arrayCourse = {"Android", "iOS", "ReactJS", "PHP", "Java Script"};
                bundle.putStringArray("Array String", arrayCourse);
                student hocsinh = new student("ABC", 2021);
                bundle.putSerializable("Class", hocsinh);

                intent.putExtra("Send_Bundle", bundle);

                startActivity(intent);
            }
        });

    }
}