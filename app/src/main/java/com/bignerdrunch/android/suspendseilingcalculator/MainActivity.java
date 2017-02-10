package com.bignerdrunch.android.suspendseilingcalculator;

import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getFragmentManager();
        Fragment listFragment = fm.findFragmentById(R.id.activity_main);

        if (listFragment==null){
            listFragment = new SeilingListFragment();
            fm.beginTransaction().add(R.id.activity_main, listFragment).commit();

        }
    }
}
