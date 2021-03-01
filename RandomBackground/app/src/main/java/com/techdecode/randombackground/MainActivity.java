package com.techdecode.randombackground;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayoutBackground;
    ArrayList<Integer> arrayImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutBackground = (LinearLayout) findViewById(R.id.linearLayout);

        arrayImage = new ArrayList<>();
        arrayImage.add(R.drawable.background_1);
        arrayImage.add(R.drawable.background_2);
        arrayImage.add(R.drawable.background_3);
        arrayImage.add(R.drawable.background_4);
        arrayImage.add(R.drawable.background_5);

        Random random = new Random();
        int pos = random.nextInt(arrayImage.size());

        linearLayoutBackground.setBackgroundResource(arrayImage.get(pos));
    }
}