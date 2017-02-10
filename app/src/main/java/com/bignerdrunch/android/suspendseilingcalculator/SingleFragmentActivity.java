package com.bignerdrunch.android.suspendseilingcalculator;

import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.app.FragmentManager;
import android.os.Bundle;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public abstract class SingleFragmentActivity extends FragmentActivity {
    public abstract Fragment createFagment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_c);

        if (fragment==null){
            fragment = createFagment();
            fm.beginTransaction()
                    .add(R.id.fragment_c, fragment)
                    .commit();

        }
    }


}
