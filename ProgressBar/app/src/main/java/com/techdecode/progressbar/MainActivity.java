package com.techdecode.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonDownload;
    ProgressBar progressBarDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDownload = (Button) findViewById(R.id.button);
        progressBarDownload = (ProgressBar) findViewById(R.id.progressBarDownload);

        buttonDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CountDownTimer countDownTimer = new CountDownTimer(10000,
                        10) {
                    //Note: millisInFuture -> tổng thời gian thực hiện CountDown, đơn vị (ms)
                    //      countDownInterval -> Thời gian thực hiện 1 bước lặp, đơn vị (ms)

                    @Override
                    public void onTick(long millisUntilFinished) {
                        // onTick function -> Hàm thực hiện công việc của mỗi lần lặp
                        int currentProgress = progressBarDownload.getProgress();
                        if (currentProgress >= progressBarDownload.getMax()) {
                            currentProgress = 0;
                        }
                        progressBarDownload.setProgress(currentProgress + 1);
                    }

                    @Override
                    public void onFinish() {
                        // onFinish function -> Hàm thực thi sau khi kết thúc
                        // tổng thời gian thực hiện
                        Toast.makeText(MainActivity.this,
                                "Download completed!!", Toast.LENGTH_SHORT).show();
                    }
                };

                countDownTimer.start();
            }
        });

    }
}