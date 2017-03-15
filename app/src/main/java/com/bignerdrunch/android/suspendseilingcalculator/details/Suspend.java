package com.bignerdrunch.android.suspendseilingcalculator.details;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class Suspend extends Detail {

    public Suspend(int x, int y) {
        super(x, y);
    }

    public Suspend(int anInt) {
        super(anInt);
    }

    @Override
    public int calculateCount(int x, int y) {
        int countInOneLine = (x-400)/1000+1;
        int lines = Math.round((y-400)/1000)+1;
        return countInOneLine*lines;
    }
}

