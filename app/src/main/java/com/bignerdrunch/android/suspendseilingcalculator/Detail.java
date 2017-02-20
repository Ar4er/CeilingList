package com.bignerdrunch.android.suspendseilingcalculator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public abstract class Detail  {

    private static final String JSON_X = "x";
    private static final String JSON_Y = "y";
    private int mX;
    private int mY;
    private int count;
    public abstract int calculateCount(int x, int y);

    public Detail(JSONObject json, String key_count) throws JSONException {
        mX = json.getInt(JSON_X);
        mY = json.getInt(JSON_Y);
        count = json.getInt(key_count);
    }

    public Detail(int x, int y) {
        mX = x;
        mY = y;
        count = calculateCount(mX, mY);
    }

    @Override
    public String toString() {
         int l =(count+"").toCharArray().length;
        char c = (count+"").toCharArray()[l-1];
        if (c=='1') {
            return count + " штука";
        }
        if (c=='2'|c=='3'|c=='4')
            return count + " штуки";
        else return count + " штук";
    }


    public JSONObject toJSON(String s) throws JSONException{
        JSONObject json = new JSONObject();
        json.put(s, count);
        json.put(JSON_X, mX);
        json.put(JSON_Y, mY);
        return json;
    }
}


