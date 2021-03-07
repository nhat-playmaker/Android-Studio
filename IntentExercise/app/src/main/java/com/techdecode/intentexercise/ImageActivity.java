package com.techdecode.intentexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Collections;

public class ImageActivity extends Activity {

    TableLayout myTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        myTable = (TableLayout) findViewById(R.id.tableLayoutImage);

        int numCols = 3, numRows = 4;

        Collections.shuffle(MainActivity.arrayName);

        for (int i=1; i<=numRows; i++) {
            TableRow tableRow = new TableRow(this);

            for (int j=1; j<=numCols; j++) {
                ImageView imageView = new ImageView(this);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(260, 260);
                imageView.setLayoutParams(layoutParams);

                int locate = numCols * (i - 1) + j - 1;

                int idHinh = getResources().getIdentifier(MainActivity.arrayName.get(locate), "drawable", getPackageName());
                imageView.setImageResource(idHinh);

                // Thêm imageView vào dòng của table
                tableRow.addView(imageView);

                // Bắt sự kiện click vào hình
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.putExtra("tenhinhchon", MainActivity.arrayName.get(locate));
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
            }

            // Thêm tableRow vài tableLayout
            myTable.addView(tableRow);
        }
    }
}