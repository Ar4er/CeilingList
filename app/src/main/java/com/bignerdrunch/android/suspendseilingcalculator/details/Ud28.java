package com.bignerdrunch.android.suspendseilingcalculator.details;

import com.bignerdrunch.android.suspendseilingcalculator.Detail;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class Ud28 extends Detail {

    public Ud28(int x, int y) {
        super(x, y);
    }

    @Override
    public int calculateCount(int x, int y) {
        return (x+y)*2/3000+1;
    }
}
