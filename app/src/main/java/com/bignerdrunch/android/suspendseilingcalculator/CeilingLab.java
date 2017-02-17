package com.bignerdrunch.android.suspendseilingcalculator;

import android.content.Context;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class CeilingLab {
    private static final String FILENAME = "ceilings.json";

    private static CeilingLab sCeilingLab;
    private Context mContext;
    private ArrayList<SuspendCeiling> mList;
    private CeilingJSONSerializer mSerializer;

    private CeilingLab(Context context){
        mContext = context;
       mSerializer = new CeilingJSONSerializer(context, FILENAME);
        try {
            mList = mSerializer.loadCrimes();
        } catch (Exception e) {
            mList = new ArrayList<>();
         }

    }
    public void saveList(){
        try {
            mSerializer.saveCeylings(mList);
        }catch (Exception e){}
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
