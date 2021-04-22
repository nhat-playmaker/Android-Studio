package com.techdecode.dialogfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DeleteData {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentDialog fragmentDialog = new FragmentDialog();
                fragmentDialog.show(getSupportFragmentManager(), "dialog");
            }
        });
    }

    @Override
    public void GiaTriXoa(boolean delete) {
        if (delete) Toast.makeText(this, "Bạn chọn xóa", Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "Bạn chọn không xóa", Toast.LENGTH_SHORT).show();
    }
}