package com.bignerdrunch.android.suspendseilingcalculator;


import android.support.v4.app.Fragment;

public class MainActivity extends SingleFragmentActivity {
    @Override
    public Fragment createFagment() {
       return new CeilingListFragmentRecycler();
    }
}
