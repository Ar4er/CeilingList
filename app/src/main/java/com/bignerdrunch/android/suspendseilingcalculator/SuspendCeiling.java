package com.bignerdrunch.android.suspendseilingcalculator;

import com.bignerdrunch.android.suspendseilingcalculator.details.Cd60;
import com.bignerdrunch.android.suspendseilingcalculator.details.Lock;
import com.bignerdrunch.android.suspendseilingcalculator.details.Panel;
import com.bignerdrunch.android.suspendseilingcalculator.details.Suspend;
import com.bignerdrunch.android.suspendseilingcalculator.details.Ud28;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class SuspendCeiling {

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

        mX = x;
        mY = y;
        mUd28 = new Ud28(mX, mY);
        mCd = new Cd60(mX, mY);
        mLock = new Lock(mX, mY);
        mSuspend = new Suspend(mX, mY);
        mPanel = new Panel(mX, mY);
        mDate = new Date();
        mId = UUID.randomUUID();
        mArea = mX*mY/ 1000000.0;
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


