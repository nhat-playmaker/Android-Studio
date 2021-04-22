package com.techdecode.fragmentremove;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AddA(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameContent, new FragmentA(), "fragA");
        fragmentTransaction.addToBackStack("PushA");
        fragmentTransaction.commit();
    }

    public void AddB(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameContent, new FragmentB(), "fragB");
        fragmentTransaction.addToBackStack("PushB");
        fragmentTransaction.commit();
    }

    public void AddC(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameContent, new FragmentC(), "fragC");
        fragmentTransaction.addToBackStack("PushC");
        fragmentTransaction.commit();
    }

    public void RemoveA(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = (FragmentA) getSupportFragmentManager().findFragmentByTag("fragA");
        if (fragmentA!=null) {
            fragmentTransaction.remove(fragmentA);
            fragmentTransaction.commit();
        }
        else {
            Toast.makeText(MainActivity.this, "Không có fragment A", Toast.LENGTH_SHORT).show();
        }
    }

    public void RemoveB(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = (FragmentB) getSupportFragmentManager().findFragmentByTag("fragB");
        if (fragmentB!=null) {
            fragmentTransaction.remove(fragmentB);
            fragmentTransaction.commit();
        }
        else {
            Toast.makeText(MainActivity.this, "Không có fragment B", Toast.LENGTH_SHORT).show();
        }
    }

    public void RemoveC(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentC fragmentC = (FragmentC) getSupportFragmentManager().findFragmentByTag("fragC");
        if (fragmentC!=null) {
            fragmentTransaction.remove(fragmentC);
            fragmentTransaction.commit();
        }
        else {
            Toast.makeText(MainActivity.this, "Không có fragment C", Toast.LENGTH_SHORT).show();
        }
    }

    public void Back(View view) {
        getSupportFragmentManager().popBackStack();
    }

    public void Pop(View view) {
        getSupportFragmentManager().popBackStack("PushA", 0);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        }
        else {
            super.onBackPressed();
        }
        super.onBackPressed();
    }
}