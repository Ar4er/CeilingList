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
    private double mX;
    private double mY;
    private Date mDate;
    private UUID mId;
    private String mName;

    public SuspendCeiling(double x, double y) {
        mId = UUID.randomUUID();
        mX = x;
        mY = y;
        int xMM =(int) x*1000;
        int yMM =(int) y*1000;
        mUd28 = new Ud28(xMM, yMM);
        mCd = new Cd60(xMM, yMM);
        mLock = new Lock(xMM, yMM);
        mSuspend = new Suspend(xMM, yMM);
        mPanel = new Panel(xMM, yMM);
        mDate = new Date();
        mArea = mX*mY;
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

    public void setX(double x) {
        mX = x;
    }

    public void setY(double y) {
        mY = y;
    }

    public double getX() {
        return mX;
    }

    public double getY() {return mY;}

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
        return String.format("%.1f * %.1f",   mX, mY);
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
            return String.format("потолок %.1f * %.1f", mX, mY);
        }
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}


