package com.techdecode.popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    Button buttonPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPopup = (Button) findViewById(R.id.buttonPopup);

        buttonPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu();
            }
        });
    }

    private void showMenu() {
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, buttonPopup);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.MenuAdd:
                        buttonPopup.setText("Menu Add");
                        break;
                    case R.id.MenuDelete:
                        buttonPopup.setText("Menu Delete");
                        break;
                    case R.id.MenuFix:
                        buttonPopup.setText("Menu Fix ");
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        popupMenu.show();
    }
}