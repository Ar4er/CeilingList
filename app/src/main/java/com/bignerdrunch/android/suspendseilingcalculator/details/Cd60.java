package com.bignerdrunch.android.suspendseilingcalculator.details;

import com.bignerdrunch.android.suspendseilingcalculator.Detail;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class Cd60 extends Detail {

    public Cd60(int x, int y) {
        super(x, y);
        countOfDownSIde(x, y);
        countOfUpSIde(x, y);
    }

    @Override
    public int calculateCount(int x, int y) {
        return countOfUpSIde(x, y)+countOfDownSIde(x, y);

    }
    public int countOfDownSIde(int x, int y){
        int lines = Math.round(y/400)-1;
        double countInOneLineFullKarkass = x*1.0/3000;
        double result = countInOneLineFullKarkass*lines;
        return (int) Math.round(result);
    }

    public  int countOfUpSIde(int x, int y){
        int lines = Math.round((x-400)/1000)+1;
        double countInOneLineFullKarkass = y*1.0/3000;
        double result =  countInOneLineFullKarkass*lines;
        return (int) Math.round(result);
    }
}
