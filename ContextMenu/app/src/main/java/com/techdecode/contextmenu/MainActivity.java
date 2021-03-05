package com.techdecode.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonColor;
    ConstraintLayout constraintLayoutScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonColor = (Button) findViewById(R.id.buttonColor);
        constraintLayoutScreen = (ConstraintLayout) findViewById(R.id.constraintLayout);

        registerForContextMenu(buttonColor);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Context Menu");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuGreen:
                constraintLayoutScreen.setBackgroundColor(Color.GREEN);
                break;
            case R.id.menuRed:
                constraintLayoutScreen.setBackgroundColor(Color.RED);
                break;
            case R.id.menuYellow:
                constraintLayoutScreen.setBackgroundColor(Color.YELLOW);
                break;
            default:
                break;
        }

        return super.onContextItemSelected(item);
    }
}