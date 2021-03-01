package com.techdecode.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Biến checkId trả về ID của radioButton đang được chọn trong RadioGroup
                switch (checkedId) {
                    case R.id.radioButtonAndroid:
                        Toast.makeText(MainActivity.this,
                                "You've chosen Android", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton_iOS:
                        Toast.makeText(MainActivity.this,
                                "You've chosen iOS", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonWindows:
                        Toast.makeText(MainActivity.this,
                                "You've chosen Windows", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

    }
}