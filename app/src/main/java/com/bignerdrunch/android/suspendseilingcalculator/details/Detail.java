package com.bignerdrunch.android.suspendseilingcalculator.details;

import android.content.res.Resources;

import com.bignerdrunch.android.suspendseilingcalculator.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public abstract class Detail implements Serializable {


    protected int mX;
    protected int mY;
    private int count;
    private int mCeilingLong;
    private int mCeilingWidth;
    public abstract int calculateCount(int x, int y);


    public Detail(int x, int y, double size){
        mX = x;
        mY = y;
    }

    public Detail (Detail detail){}
    public Detail(int c){
        count = c;
    }

    public Detail(int x, int y) {
        mX = x;
        mY = y;
        count = calculateCount(mX, mY);
    }

    public void setLongWidth(){
        if (mX<mY) {
            mCeilingLong = mY;
            mCeilingWidth = mX;
        }else {
            mCeilingLong = mX;
            mCeilingWidth = mY;
        }
    }


    public int getCount() {
        return count;
    }

    public int getCeilingLong() {
        return mCeilingLong;
    }

    public void setCeilingLong(int ceilingLong) {
        mCeilingLong = ceilingLong;
    }

    public int getCeilingWidth() {
        return mCeilingWidth;
    }

    public void setCeilingWidth(int ceilingWidth) {
        mCeilingWidth = ceilingWidth;
    }

    public void setCount(int count) {
        this.count = count;
    }
}


