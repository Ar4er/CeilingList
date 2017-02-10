package com.bignerdrunch.android.suspendseilingcalculator.details;

import com.bignerdrunch.android.suspendseilingcalculator.Detail;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class Panel extends Detail {

    public Panel(int x, int y) {
        super(x, y);
    }

    @Override
    public int calculateCount(int x, int y) {
        return x*y/3000000;
    }

}
