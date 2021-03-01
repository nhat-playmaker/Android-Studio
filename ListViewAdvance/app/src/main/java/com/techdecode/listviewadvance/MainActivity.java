package com.techdecode.listviewadvance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewFruit;
    ArrayList<Fruit> arrayListFruit;
    FruitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Initialize();

        adapter = new FruitAdapter(MainActivity.this,
                R.layout.fruit_line,
                arrayListFruit);

        listViewFruit.setAdapter(adapter);
    }

    private void Initialize() {
        listViewFruit = (ListView) findViewById(R.id.listViewFruit);
        arrayListFruit = new ArrayList<>();

        Fruit coconuts, grapes, jackfruit, mango, orange;
        coconuts = new Fruit("Dừa Bến Tre",
                "Dừa Bến Tre hơi bị ngon",
                R.drawable.coconuts);
        grapes = new Fruit("Nho tím",
                "Nho tím Ninh Thuận không hạt",
                R.drawable.greape);
        jackfruit = new Fruit("Mít Thái",
                "Xuất xứ Đồng Nai, hạt lép",
                R.drawable.jf);
        mango = new Fruit("Xoài cát Hòa Lộc",
                "Giống Xoài ngon nhất Việt Nam",
                R.drawable.mango);
        orange = new Fruit("Cam Mỹ",
                "Cam nhập khẩu từ Mỹ, nhiều Vitamin C",
                R.drawable.orange);

        arrayListFruit.add(coconuts);
        arrayListFruit.add(grapes);
        arrayListFruit.add(jackfruit);
        arrayListFruit.add(mango);
        arrayListFruit.add(orange);
    }
}