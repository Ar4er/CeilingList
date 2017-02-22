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

    public Panel(JSONObject json, String key_count) throws JSONException {
        super(json, key_count);
    }

    @Override
    public int calculateCount(int x, int y) {
        return x*y/3000000;
    }

}
