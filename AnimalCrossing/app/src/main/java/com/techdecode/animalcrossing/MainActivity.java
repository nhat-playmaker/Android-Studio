package com.techdecode.animalcrossing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textViewScore;
    RadioGroup radioGroupChoice;
    RadioButton radioButtonDog, radioButtonSquirrel, radioButtonJaguar;
    ImageButton imageButtonPlay;
    SeekBar seekBarDog, seekBarSquirrel, seekBarJaguar;
    int score = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Initialization();

        seekBarDog.setEnabled(false);
        seekBarSquirrel.setEnabled(false);
        seekBarJaguar.setEnabled(false);

        textViewScore.setText("Score: " + score + "");

        CountDownTimer countDownTimer = new CountDownTimer(60000,
                100) {
            @Override
            public void onTick(long millisUntilFinished) {
                boolean isDone = false;

                if (seekBarDog.getProgress() >= seekBarDog.getMax()) {
                    this.cancel();
                    Toast.makeText(MainActivity.this,
                            "DOG WIN !", Toast.LENGTH_SHORT).show();
                    isDone = true;
                    if (radioButtonDog.isChecked()) {
                        score += 10;
                        Toast.makeText(MainActivity.this,
                                "You guessed correctly", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        score-=10;
                        Toast.makeText(MainActivity.this,
                                "You guessed incorrectly", Toast.LENGTH_SHORT).show();
                    }
                    textViewScore.setText("Score: " + score + "");
                }
                if (seekBarSquirrel.getProgress() >= seekBarSquirrel.getMax()) {
                    this.cancel();
                    Toast.makeText(MainActivity.this,
                            "SQUIRREL WIN !", Toast.LENGTH_SHORT).show();
                    isDone = true;
                    if (radioButtonSquirrel.isChecked()) {
                        score+=10;
                        Toast.makeText(MainActivity.this,
                                "You guessed correctly", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        score-=10;
                        Toast.makeText(MainActivity.this,
                                "You guessed incorrectly", Toast.LENGTH_SHORT).show();
                    }
                    textViewScore.setText("Score: " + score + "");
                }
                if (seekBarJaguar.getProgress() >= seekBarJaguar.getMax()) {
                    this.cancel();
                    Toast.makeText(MainActivity.this,
                            "JAGUAR WIN !", Toast.LENGTH_SHORT).show();
                    isDone = true;
                    if (radioButtonJaguar.isChecked()) {
                        score+=10;
                        Toast.makeText(MainActivity.this,
                                "You guessed correctly", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        score-=10;
                        Toast.makeText(MainActivity.this,
                                "You guessed incorrectly", Toast.LENGTH_SHORT).show();
                    }
                    textViewScore.setText("Score: " + score + "");
                }
                if (isDone) {
                    imageButtonPlay.setVisibility(View.VISIBLE);
                    enableRadioButton();
                }

                int randomRange = 50;
                Random random = new Random();
                int dogSpeed = random.nextInt(randomRange);
                int squirrelSpeed = random.nextInt(randomRange);
                int jaguarSpeed = random.nextInt(randomRange);

                seekBarDog.setProgress(seekBarDog.getProgress()+dogSpeed);
                seekBarSquirrel.setProgress(seekBarSquirrel.getProgress()+squirrelSpeed);
                seekBarJaguar.setProgress(seekBarJaguar.getProgress()+jaguarSpeed);
            }

            @Override
            public void onFinish() {

            }
        };

        imageButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButtonDog.isChecked() ||
                    radioButtonSquirrel.isChecked() ||
                    radioButtonJaguar.isChecked()) {
                        // Khóa lựa chọn các Radio Button
                        disableRadioButton();
                        // Thiết lập các giá trị progress về giá trị khởi tạo
                        seekBarDog.setProgress(0);
                        seekBarSquirrel.setProgress(0);
                        seekBarJaguar.setProgress(0);
                        // Ẩn nút Play trong khi chạy
                        imageButtonPlay.setVisibility(View.INVISIBLE);
                        // Khi nhấn nút Play thì bắt đầu chạy
                        countDownTimer.start();
                }
                else {
                    Toast.makeText(MainActivity.this,
                            "Please choose one animal which you lik",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void Initialization() {
        textViewScore = (TextView) findViewById(R.id.textViewScore);
        radioGroupChoice = (RadioGroup) findViewById(R.id.radioGroupChoice);
        radioButtonDog = (RadioButton) findViewById(R.id.radioButtonDog);
        radioButtonSquirrel = (RadioButton) findViewById(R.id.radioButtonSquirrel);
        radioButtonJaguar = (RadioButton) findViewById(R.id.radioButtonJaguar);
        imageButtonPlay = (ImageButton) findViewById(R.id.imageButtonPlayButton);
        seekBarDog = (SeekBar) findViewById(R.id.seekBarDog);
        seekBarSquirrel = (SeekBar) findViewById(R.id.seekBarSquirrel);
        seekBarJaguar = (SeekBar) findViewById(R.id.seekBarJaguar);
    }

    private void enableRadioButton() {
        radioButtonDog.setEnabled(true);
        radioButtonSquirrel.setEnabled(true);
        radioButtonJaguar.setEnabled(true);
    }

    private void disableRadioButton() {
        radioButtonDog.setEnabled(false);
        radioButtonSquirrel.setEnabled(false);
        radioButtonJaguar.setEnabled(false);
    }
}