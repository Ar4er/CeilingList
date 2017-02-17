package com.bignerdrunch.android.suspendseilingcalculator;

import com.bignerdrunch.android.suspendseilingcalculator.details.Cd60;
import com.bignerdrunch.android.suspendseilingcalculator.details.Lock;
import com.bignerdrunch.android.suspendseilingcalculator.details.Panel;
import com.bignerdrunch.android.suspendseilingcalculator.details.Suspend;
import com.bignerdrunch.android.suspendseilingcalculator.details.Ud28;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class SuspendCeiling {
    private static final String UD28 = "ud28";
    private static final String CD60 = "cd";
    private static final String LOCK = "lock";
    private static final String SUSPEND = "suspend";
    private static final String PANEL = "panel";
    private static final String AREA = "area";
    private static final String MX = "mx";
    private static final String MY = "my";
    private static final String MDATE = "date";
    private static final String ID = "id";

    private Ud28 mUd28;
    private Cd60 mCd;
    private Lock mLock;
    private Suspend mSuspend;
    private Panel mPanel;
    private double mArea;
    private int mX;
    private int mY;
    private Date mDate;
    UUID mId;

    public SuspendCeiling(int x, int y) {
        mId = UUID.randomUUID();
        mX = x;
        mY = y;
        mUd28 = new Ud28(mX, mY);
        mCd = new Cd60(mX, mY);
        mLock = new Lock(mX, mY);
        mSuspend = new Suspend(mX, mY);
        mPanel = new Panel(mX, mY);
        mDate = new Date();
        mArea = mX*mY/ 1000000.0;
    }
    public SuspendCeiling (JSONObject json) throws  JSONException {
        mId = UUID.fromString(json.getString(ID));
        mX = json.getInt(MX);
        mY = json.getInt(MY);
        mDate = new Date(json.getLong(MDATE));
        mArea = json.getDouble(AREA);
        mCd = new Cd60(json.getJSONObject(CD60), CD60);
        mUd28 = new Ud28(json.getJSONObject(CD60), CD60);
        mLock = new Lock(json.getJSONObject(LOCK), LOCK);
        mPanel = new Panel(json.getJSONObject(PANEL), PANEL);
        mSuspend = new Suspend(json.getJSONObject(SUSPEND), SUSPEND);
    }

    public JSONObject toJSON()throws JSONException{
        JSONObject  json = new JSONObject();
        json.put(UD28, mUd28.toJSON(UD28));
        json.put(CD60, mCd.toJSON(CD60));
        json.put(LOCK, mLock.toJSON(LOCK));
        json.put(SUSPEND, mSuspend.toJSON(SUSPEND));
        json.put(PANEL, mPanel.toJSON(PANEL));
        json.put(AREA, mArea);
        json.put(MX, mX);
        json.put(MY, mY);
        json.put(MDATE, mDate.getTime());
        json.put(ID, mId.toString());
        return json;

    }



    public int getX() {
        return mX;
    }

    public int getY() {return mY;}

    public UUID getId() {
        return mId;
    }

    public Panel getPanel() {
        return mPanel;
    }

    public Suspend getSuspend() {
        return mSuspend;
    }

    public Lock getLock() {return mLock;}

    public Ud28 getUd28() {
        return mUd28;
    }

    public double getArea() {
        return mArea;
    }

    public Cd60 getCd() {
        return mCd;
    }

    public Date getDate() {
        return mDate;
    }

    @Override
    public String toString() {
        return String.format(" потолок %d * %d",   mX, mY);
    }

     public String areaToString(){
         return mArea+" M2";
     }

    public String getFormatDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d, yyyy");
        return  simpleDateFormat.format(mDate);
    }


}


