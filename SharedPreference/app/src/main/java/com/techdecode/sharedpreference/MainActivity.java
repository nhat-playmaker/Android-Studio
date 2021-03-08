package com.techdecode.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    Button buttonConfirm;
    EditText editTextUsername, editTextPassword;
    CheckBox checkBoxRemember;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);

        buttonConfirm = (Button) findViewById(R.id.buttonConfirm);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        checkBoxRemember = (CheckBox) findViewById(R.id.checkBoxRemember);

        // Lấy giá trị
        editTextUsername.setText(sharedPreferences.getString("username", ""));
        editTextPassword.setText(sharedPreferences.getString("password", ""));
        checkBoxRemember.setChecked(sharedPreferences.getBoolean("checked", false));

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                if (username.equals("nhat-playmaker") && password.equals("Vannhat_1504")) {
                    Toast.makeText(MainActivity.this,
                            "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    // Nếu có nhấn checkBox --> tiến hành lưu
                    if (checkBoxRemember.isChecked()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", username);
                        editor.putString("password", password);
                        editor.putBoolean("checked", true);
                        editor.commit();
                    }
                    else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("username");
                        editor.remove("password");
                        editor.remove("checked");
                        editor.commit();
                    }

                }
                else {
                    Toast.makeText(MainActivity.this,
                            "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}