package com.example.andrus.projectnam;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.andrus.projectnam.MainScreen.MainScreenFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showMainScreenFragment();
    }

    private void showMainScreenFragment(){
        MainScreenFragment mainScreenFragment = new MainScreenFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.replace(R.id.mainActivity_frameLayout, mainScreenFragment);

        transaction.commit();
    }
}
