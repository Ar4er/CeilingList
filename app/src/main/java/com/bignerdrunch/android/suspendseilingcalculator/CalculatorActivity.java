package com.bignerdrunch.android.suspendseilingcalculator;

import android.app.Fragment;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class CalculatorActivity extends SingleFragmentActivity {



    @Override
    public Fragment createFagment() {
        return new CalculatorFragment();
    }
}
