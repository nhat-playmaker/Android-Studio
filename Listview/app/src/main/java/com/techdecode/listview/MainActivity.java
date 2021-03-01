package com.techdecode.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewSubject;
    Button buttonAdd, buttonUpdate, buttonDelete;
    EditText editTextSubject;
    ArrayList<String> arrayCourse;
    int positionItemChoice = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewSubject = (ListView) findViewById(R.id.listViewSubject);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);
        editTextSubject = (EditText) findViewById(R.id.editTextSubject);

        arrayCourse = new ArrayList<>();

        arrayCourse.add("PHP");
        arrayCourse.add("Java Script");
        arrayCourse.add("HTML5");
        arrayCourse.add("Android");
        arrayCourse.add("Unity");

        final ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1, arrayCourse);

        listViewSubject.setAdapter(adapter);

        listViewSubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // position -> trả về vị trí click trên list view
                editTextSubject.setText(arrayCourse.get(position));
                positionItemChoice = position;
            }
        });

        listViewSubject.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "Long click: " + arrayCourse.get(position), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = editTextSubject.getText().toString();
                arrayCourse.add(subject);
                // Cập nhật lại adapter
                adapter.notifyDataSetChanged();
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (positionItemChoice != -1) {
                    arrayCourse.set(positionItemChoice, editTextSubject.getText().toString());
                    adapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this,
                            "Update completed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (positionItemChoice != -1) {
                    String saveCourseForNotification = arrayCourse.get(positionItemChoice);
                    arrayCourse.remove(positionItemChoice);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this,
                            "Remove " + saveCourseForNotification + " completed",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}