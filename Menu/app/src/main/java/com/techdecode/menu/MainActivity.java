package com.techdecode.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSettings:
                Toast.makeText(MainActivity.this,
                        "You chose Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuShare:
                Toast.makeText(MainActivity.this,
                        "You chose Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuSearch:
                Toast.makeText(MainActivity.this,
                        "You chose Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuContactEmail:
                Toast.makeText(MainActivity.this,
                        "You chose Contact Email", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuContactPhone:
                Toast.makeText(MainActivity.this,
                        "You chose Contact Phone", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}