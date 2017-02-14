package com.bignerdrunch.android.suspendseilingcalculator;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class CeilingLab {

    private static CeilingLab sCeilingLab;
    private Context mContext;
    private ArrayList<SuspendCeiling> mList;

    private CeilingLab(Context context){
        mContext = context;
       mList = new ArrayList<>();
    }

    public void addCeiling(SuspendCeiling sc){
        mList.add(sc);
    }

    public static CeilingLab getCeilingLab(Context context){
        if (sCeilingLab==null){
            sCeilingLab = new CeilingLab(context.getApplicationContext());
        }
        return sCeilingLab;
    }

    public ArrayList<SuspendCeiling> getList() {
        return mList;
    }

    public SuspendCeiling getById(UUID uuid) {
        for (SuspendCeiling suspendCeiling : mList) {
            if ((suspendCeiling.getId()).equals(uuid)) {
                return suspendCeiling;
            }

        }
        return null;
    }
}
