package com.techdecode.globalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewInfo;
    EditText editTextName, editTextPhoneNumber, editTextMail;
    Button buttonConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Initialize();

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = editTextName.getText().toString();
                String eMail = editTextMail.getText().toString();
                String phoneNumber = editTextPhoneNumber.getText().toString();

                String text_hoten = getResources().getString(R.string.text_hoten);
                String text_sodienthoai = getResources().getString(R.string.text_sodienthoai);

                textViewInfo.setText(text_hoten + fullName +
                        "\nEmail: " + eMail + "\n" + text_sodienthoai + phoneNumber);
            }
        });
    }

    private void Initialize() {
        textViewInfo = (TextView) findViewById(R.id.textViewInfo);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextMail = (EditText) findViewById(R.id.editTextMail);
        editTextPhoneNumber = (EditText) findViewById(R.id.editTextPhoneNumber);
        buttonConfirm = (Button) findViewById(R.id.buttonConfirm);
    }
}