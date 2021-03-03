package com.techdecode.galleryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridViewGallery;
    ArrayList<Images> imagesArrayList;
    ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridViewGallery = (GridView) findViewById(R.id.gridViewGallery);
        imagesArrayList = new ArrayList<>();

        imagesArrayList.add(new Images("pic1", R.drawable.a));
        imagesArrayList.add(new Images("pic2", R.drawable.b));
        imagesArrayList.add(new Images("pic3", R.drawable.c));
        imagesArrayList.add(new Images("pic4", R.drawable.d));
        imagesArrayList.add(new Images("pic5", R.drawable.e));
        imagesArrayList.add(new Images("pic6", R.drawable.f));
        imagesArrayList.add(new Images("pic7", R.drawable.a));
        imagesArrayList.add(new Images("pic8", R.drawable.b));
        imagesArrayList.add(new Images("pic9", R.drawable.c));

        adapter = new ImageAdapter(MainActivity.this,
                R.layout.line_image,
                imagesArrayList);

        gridViewGallery.setAdapter(adapter);

        gridViewGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        imagesArrayList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}