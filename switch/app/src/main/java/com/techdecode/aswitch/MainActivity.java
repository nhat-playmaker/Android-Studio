package com.techdecode.aswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch switchWifi;
    CheckBox checkBoxAndroid, checkBox_iOS, checkBoxWindows;
    Button buttonConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchWifi = (Switch) findViewById(R.id.switchWifi);
        checkBoxAndroid = (CheckBox) findViewById(R.id.checkBoxAndroid);
        checkBox_iOS = (CheckBox) findViewById(R.id.checkBoxiOS);
        checkBoxWindows = (CheckBox) findViewById(R.id.checkBoxWindows);
        buttonConfirm = (Button) findViewById(R.id.buttonConfirm);


        switchWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this,
                            "Wifi mode ON", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this,
                            "Wifi mode OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkBoxAndroid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this,
                            "You've chosen Android", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,
                            "You have just unchecked Android", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String notification = "You have chosen: ";
                if (checkBoxAndroid.isChecked()) notification += checkBoxAndroid.getText()+"\n";
                if (checkBox_iOS.isChecked()) notification += checkBox_iOS.getText()+"\n";
                if (checkBoxWindows.isChecked()) notification += checkBoxWindows.getText()+"\n";

                Toast.makeText(MainActivity.this,
                        notification, Toast.LENGTH_LONG).show();
            }
        });
    }
}