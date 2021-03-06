package com.techdecode.intentdataresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    Button buttonConfirm;
    EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        buttonConfirm = (Button) findViewById(R.id.buttonConfirm);
        editTextName = (EditText) findViewById(R.id.editTextName);

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("newName", name);
                setResult(RESULT_OK, intent);
                // Terminate screen hiện tại
                finish();
            }
        });

    }
}