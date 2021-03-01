package com.techdecode.saveandrestorestate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Global variables
    TextView textView;
    Button button;
    public int m_lesson = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.message);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_lesson++;
                button.setBackgroundColor(Color.GRAY);
                setMessage();
            }
        });

        setMessage();
    }

    private void setMessage() {
        textView.setText("Lesson: " + m_lesson);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // In this case, savedInstanceState is always different from null,
        // thus, we don't need to check this bundle

        // Get data from the key name "Lesson", which was saved from onSaveInstanceState function
        m_lesson = savedInstanceState.getInt("Lesson");

        // Get data from the key name "Color Code"
        int colorCode = savedInstanceState.getInt("Color Code");
        // Set the saved color to button
        button.setBackgroundColor(colorCode);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        ColorDrawable color = (ColorDrawable) button.getBackground();
        int colorCode = color.getColor();
        outState.putInt("Lesson: ", m_lesson);
        outState.putInt("Color Code", colorCode);
    }
}