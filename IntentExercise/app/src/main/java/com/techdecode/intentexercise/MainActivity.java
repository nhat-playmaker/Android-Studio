package com.techdecode.intentexercise;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> arrayName;
    ImageView imageViewGoc, imageViewNhan;
    int REQUEST_CODE = 123;
    String tenHinhGoc = "";
    TextView textViewScore;
    int totalScore = 100;
    SharedPreferences sharedPreferencesSaveScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewGoc = (ImageView) findViewById(R.id.imageViewGoc);
        imageViewNhan = (ImageView) findViewById(R.id.imageViewNhan);
        textViewScore = (TextView) findViewById(R.id.textViewScore);

        sharedPreferencesSaveScore = getSharedPreferences("Score", MODE_PRIVATE);

        totalScore = sharedPreferencesSaveScore.getInt("Score", 100);

        textViewScore.setText(totalScore+"");

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

                // Cộng điểm
                totalScore+=10;
                LuuDiem();

                // Đổi ảnh gốc
                CountDownTimer countDownTimer = new CountDownTimer(1000, 100) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        // Trộn mảng
                        Collections.shuffle(arrayName);
                        tenHinhGoc = arrayName.get(0);
                        // Convert chuỗi tên file hình và định dạng file hình về dạng mã của tấm hình
                        int idHinh = getResources().getIdentifier(arrayName.get(0), "drawable", getPackageName());
                        imageViewGoc.setImageResource(idHinh);
                    }
                };
                countDownTimer.start();
            }
            else {
                Toast.makeText(MainActivity.this,
                        "Sai rồi!", Toast.LENGTH_SHORT).show();

                // Trừ điểm
                totalScore -= 5;
                LuuDiem();
            }

            textViewScore.setText(totalScore+"");
        }

        // Kiểm tra trường hợp chưa chọn nhưng lại bấm Back về
        if (requestCode == REQUEST_CODE && resultCode == RESULT_CANCELED) {
            Toast.makeText(MainActivity.this, "Bạn chưa chọn hình =)))", Toast.LENGTH_SHORT).show();
            totalScore-=15;
            LuuDiem();
            textViewScore.setText(totalScore+"");
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.reload, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuReload) {
            // Trộn mảng
            Collections.shuffle(arrayName);
            tenHinhGoc = arrayName.get(0);
            // Convert chuỗi tên file hình và định dạng file hình về dạng mã của tấm hình
            int idHinh = getResources().getIdentifier(arrayName.get(0), "drawable", getPackageName());
            imageViewGoc.setImageResource(idHinh);
        }
        return super.onOptionsItemSelected(item);
    }

    private void LuuDiem() {
        SharedPreferences.Editor editor = sharedPreferencesSaveScore.edit();
        editor.putInt("Score", totalScore);
        editor.commit();
    }

}