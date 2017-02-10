package com.bignerdrunch.android.suspendseilingcalculator.details;

import com.bignerdrunch.android.suspendseilingcalculator.Detail;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class Lock extends Detail {

    public Lock(int x, int y) {
        super(x, y);
    }

    @Override
    public int calculateCount(int x, int y) {
        int xLines = Math.round(y/400)-1;
        int yLines = Math.round((x-400)/1000)+1;
        return xLines*yLines;
    }
}
