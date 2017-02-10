package com.bignerdrunch.android.suspendseilingcalculator;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class SeilingLab {

    private static SeilingLab sSeilingLab;
    private Context mContext;
    private ArrayList<SuspendSeiling> mList;

    private SeilingLab(Context context){
        mContext = context;
       mList = new ArrayList<>();
        mList.add(new SuspendSeiling(3000, 5000));
        mList.add(new SuspendSeiling(4000, 8000));

    }

    public static SeilingLab getSeilingLab(Context context){
        if (sSeilingLab==null){
            sSeilingLab = new SeilingLab(context.getApplicationContext());
        }
        return sSeilingLab;
    }

    public ArrayList<SuspendSeiling> getList() {
        return mList;
    }
}
