package com.bignerdrunch.android.suspendseilingcalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bignerdrunch.android.suspendseilingcalculator.database.CeilingBaseHelper;
import com.bignerdrunch.android.suspendseilingcalculator.database.CeilingCursorWrapper;
import com.bignerdrunch.android.suspendseilingcalculator.database.CeilingDataBaseSchema;
import com.bignerdrunch.android.suspendseilingcalculator.database.CeilingDataBaseSchema.CeilingTable;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class CeilingLab {
    private Context mContext;
    private SQLiteDatabase mDatabase;

    private static CeilingLab sCeilingLab;

    private ArrayList<SuspendCeiling> mList;

    private CeilingLab(Context context){
        mContext = context.getApplicationContext();
        mDatabase = new CeilingBaseHelper(mContext)
                .getWritableDatabase();
        mList = new ArrayList<>();
    }

    private static ContentValues getContentValues(SuspendCeiling ceiling){
        ContentValues values = new ContentValues();
        values.put(CeilingTable.Cols.Area, ceiling.getArea());
        values.put(CeilingTable.Cols.Cd60, ceiling.getCd().getCount());
        values.put(CeilingTable.Cols.Date, ceiling.getDate().getTime());
        values.put(CeilingTable.Cols.Id, ceiling.getId().toString());
        values.put(CeilingTable.Cols.Lock, ceiling.getLock().getCount());
        values.put(CeilingTable.Cols.Name, ceiling.getName());
        values.put(CeilingTable.Cols.Panel, ceiling.getPanel().getCount());
        values.put(CeilingTable.Cols.Suspend, ceiling.getSuspend().getCount());
        values.put(CeilingTable.Cols.Ud28, ceiling.getUd28().getCount());
        values.put(CeilingTable.Cols.X, ceiling.getX());
        values.put(CeilingTable.Cols.Y, ceiling.getY());

        return values;
    }


    public void addCeiling(SuspendCeiling sc){
        ContentValues values = getContentValues(sc);
        mDatabase.insert(CeilingTable.NAME, null, values);

    }

    public void updateCeiling (SuspendCeiling sc){
        String uuidString = sc.getId().toString();
        ContentValues values = getContentValues(sc);
        mDatabase.update(CeilingTable.NAME, values,
                CeilingTable.Cols.Id +" = ?",
                new String[] {uuidString});
    }

    public static CeilingLab getCeilingLab(Context context){
        if (sCeilingLab==null){
            sCeilingLab = new CeilingLab(context);
        }
        return sCeilingLab;
    }



    public ArrayList<SuspendCeiling> getList() {
        ArrayList<SuspendCeiling> ceilings = new ArrayList<>();
        CeilingCursorWrapper cursor = quertyCeilings(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                ceilings.add(cursor.getCeiling());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return ceilings;
    }

    public SuspendCeiling getSuspendCeiling(UUID id){
        CeilingCursorWrapper cursor = quertyCeilings(CeilingTable.Cols.Id + " = ?", new String[] {id.toString()});
        try {
            if (cursor.getCount()==0){
                return null;
            }
            cursor.moveToFirst();
            return  cursor.getCeiling();
        }finally {
            cursor.close();
        }
    }


    public void deliteCeiling(SuspendCeiling sc){
        mDatabase.delete(
                CeilingTable.NAME, CeilingTable.Cols.Id + " = ?",
                new String[]{sc.getId().toString()}
        );
    }

    private CeilingCursorWrapper quertyCeilings(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query(
                CeilingTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
        return  new CeilingCursorWrapper(cursor);
    }
}
