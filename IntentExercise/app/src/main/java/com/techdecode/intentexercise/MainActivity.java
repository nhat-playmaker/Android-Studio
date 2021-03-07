package com.techdecode.intentexercise;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> arrayName;
    ImageView imageViewGoc, imageViewNhan;
    int REQUEST_CODE = 123;
    String tenHinhGoc = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewGoc = (ImageView) findViewById(R.id.imageViewGoc);
        imageViewNhan = (ImageView) findViewById(R.id.imageViewNhan);

        // Khởi tạo một mảng chuỗi chứa danh sách tên các file hình được định nghĩa trong strings.xml của Resource
        String[] mangTen = getResources().getStringArray(R.array.list_name);

        // Chuyển mảng chuỗi về dạng ArrayList -> chứa giá trị tên của các tấm hình
        arrayName = new ArrayList<>(Arrays.asList(mangTen));

        // Trộn mảng
        Collections.shuffle(arrayName);

        tenHinhGoc = arrayName.get(0);

        // Convert chuỗi tên file hình và định dạng file hình về dạng mã của tấm hình
        int idHinh = getResources().getIdentifier(arrayName.get(0), "drawable", getPackageName());
        imageViewGoc.setImageResource(idHinh);

        imageViewNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data!=null) {
            String tenHinhNhan = data.getStringExtra("tenhinhchon");
            int idHinhNhan = getResources().getIdentifier(tenHinhNhan, "drawable", getPackageName());
            imageViewNhan.setImageResource(idHinhNhan);

            // So sánh kết quả
            if (tenHinhGoc.equals(tenHinhNhan)) {
                Toast.makeText(MainActivity.this,
                        "Chính xác!", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(MainActivity.this,
                        "Sai rồi!", Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}