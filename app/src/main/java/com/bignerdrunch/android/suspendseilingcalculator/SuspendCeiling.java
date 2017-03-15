package com.bignerdrunch.android.suspendseilingcalculator;

import com.bignerdrunch.android.suspendseilingcalculator.details.Cd60;
import com.bignerdrunch.android.suspendseilingcalculator.details.Lock;
import com.bignerdrunch.android.suspendseilingcalculator.details.Panel;
import com.bignerdrunch.android.suspendseilingcalculator.details.Suspend;
import com.bignerdrunch.android.suspendseilingcalculator.details.Ud28;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class SuspendCeiling implements Serializable{


    private Ud28 mUd28;
    private Cd60 mCd;
    private Lock mLock;
    private Suspend mSuspend;
    private Panel mPanel;
    private double mArea;
    private int mX;
    private int mY;
    private Date mDate;
    private UUID mId;
    private String mName;

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
    public SuspendCeiling(UUID id){
        mId = id;
    }

    public void setArea(double area) {
        mArea = area;
    }

    public void setCd(Cd60 cd) {
        mCd = cd;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public void setLock(Lock lock) {
        mLock = lock;
    }

    public void setPanel(Panel panel) {
        mPanel = panel;
    }

    public void setSuspend(Suspend suspend) {
        mSuspend = suspend;
    }

    public void setUd28(Ud28 ud28) {
        mUd28 = ud28;
    }

    public void setX(int x) {
        mX = x;
    }

    public void setY(int y) {
        mY = y;
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
        return String.format("%d * %d",   mX, mY);
    }

     public String areaToString(){
         return String.format("%.1f m2", mArea);
     }

    public String getFormatDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d, yyyy");
        return  simpleDateFormat.format(mDate);
    }
    public String getName() {
        if (mName == null) {
            double x = mX / 1000.0;
            double y = mY / 1000.0;
            return String.format("потолок %.1f * %.1f", x, y);
        }
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}


