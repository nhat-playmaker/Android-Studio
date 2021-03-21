package com.techdecode.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        buttonAddA.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentA fragmentA = new FragmentA();
//                // Add fragmentA.xml vào vùng của FrameLayout (id là FrameContent)
//                fragmentTransaction.add(R.id.frameContent, fragmentA);
//                fragmentTransaction.commit();
//            }
//        });
//
//        buttonAddB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentB fragmentB = new FragmentB();
//                fragmentTransaction.add(R.id.frameContent, fragmentB);
//                fragmentTransaction.commit();
//            }
//        });

    }

    public void AddFragment(View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;

        switch (view.getId()) {
            case R.id.buttonAddA:
                fragment = new FragmentA();
                break;
            case R.id.buttonAddB:
                fragment = new FragmentB();
                break;
        }

        fragmentTransaction.replace(R.id.frameContent, fragment);
        fragmentTransaction.commit();
    }
}