package com.techdecode.appproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textViewContent;
    Button buttonClickMe;
    Button buttonConfirm;
    EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewContent = (TextView) findViewById(R.id.textViewContent);
        buttonClickMe = (Button) findViewById(R.id.buttonClickMe);
        buttonConfirm = (Button) findViewById(R.id.buttonConfirm);
        editTextName = (EditText) findViewById(R.id.editTextName);

        editTextName.setText("Learning Android is fun :v");

        //textViewContent.setText("Android Studio");
        buttonClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewContent.setText("Learning Android");
            }
        });

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = editTextName.getText().toString();
                Toast.makeText(MainActivity.this, content, Toast.LENGTH_LONG).show();
            }
        });

    }
}