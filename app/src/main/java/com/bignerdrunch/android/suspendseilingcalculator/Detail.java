package com.bignerdrunch.android.suspendseilingcalculator;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public abstract class Detail  {

    private int mX;
    private int mY;
    private int count;
    public abstract int calculateCount(int x, int y);

    public Detail(int x, int y) {
        mX = x;
        mY = y;
        count = calculateCount(mX, mY);
    }

    @Override
    public String toString() {
        return count +" штук";
    }
}
