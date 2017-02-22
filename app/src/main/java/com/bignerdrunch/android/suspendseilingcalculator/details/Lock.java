package com.bignerdrunch.android.suspendseilingcalculator.details;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class Lock extends Detail {

    public Lock(int x, int y) {
        super(x, y);
    }

    public Lock(JSONObject json, String key_count) throws JSONException {
        super(json, key_count);
    }

    @Override
    public int calculateCount(int x, int y) {
        int xLines = Math.round(y/400)-1;
        int yLines = Math.round((x-400)/1000)+1;
        return xLines*yLines;
    }
}
