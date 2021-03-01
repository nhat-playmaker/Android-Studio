package com.techdecode.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    RelativeLayout relativeLayout;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView3);
        relativeLayout = (RelativeLayout) findViewById(R.id.background);
        imageButton = (ImageButton) findViewById(R.id.imageButton);

        imageView.setImageResource(R.drawable.catt);
        relativeLayout.setBackgroundColor(Color.rgb(200, 150, 0));

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setBackgroundResource(R.drawable.catt);
            }
        });
    }
}