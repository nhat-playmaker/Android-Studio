package com.techdecode.dialogcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textViewLogIn;
    EditText editTextUserName, editTextPassword;
    Button buttonYes, buttonNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewLogIn = (TextView) findViewById(R.id.textViewLogin);

        textViewLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogLogin();
            }
        });
    }

    private void DialogLogin() {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_custom);
        dialog.setCanceledOnTouchOutside(false);

        editTextUserName = (EditText) dialog.findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) dialog.findViewById(R.id.editTextPassword);
        buttonYes = (Button) dialog.findViewById(R.id.ButtonYes);
        buttonNo = (Button) dialog.findViewById(R.id.ButtonNo);

        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();

                if (userName.equals("nhat-playmaker") && password.equals("Vannhat_1504")) {
                    Toast.makeText(MainActivity.this,
                            "Log-in success!", Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                }
                else {
                    Toast.makeText(MainActivity.this,
                            "Username or password is incorrect!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}