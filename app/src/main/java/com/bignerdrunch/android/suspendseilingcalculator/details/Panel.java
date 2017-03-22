package com.bignerdrunch.android.suspendseilingcalculator.details;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class Panel extends Detail {

    public Panel(int x, int y) {
        super(x, y);
    }

    public  Panel(int anInt) {
        super(anInt);
    }

    @Override
    public int calculateCount(int x, int y) {
        int count;
        int area = x*y;
        if (area<3000000) {
              count = 1;
        }
        count = area/3000000+1;

        return count;
    }

}
