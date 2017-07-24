package com.bignerdrunch.android.suspendseilingcalculator.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.bignerdrunch.android.suspendseilingcalculator.database.CeilingDataBaseSchema.*;

/**
 * Created by ar4er25 on 3/15/2017.
 */

public class CeilingBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "ceilingBase.db";
    public CeilingBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + CeilingTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                CeilingTable.Cols.Cd60 + ", " +
                CeilingTable.Cols.Ud28 + ", " +
                CeilingTable.Cols.Area + ", " +
                CeilingTable.Cols.Date + ", " +
                CeilingTable.Cols.Lock + ", " +
                CeilingTable.Cols.Id + ", "  +
                CeilingTable.Cols.Name+ ", " +
                CeilingTable.Cols.Suspend + ", " +
                CeilingTable.Cols.X + ", " +
                CeilingTable.Cols.Y + ", " +
                CeilingTable.Cols.Panel + ", " +
                CeilingTable.Cols.screwWall + ", " +
                CeilingTable.Cols.screwCeiling + ", " +
                CeilingTable.Cols.screwPanel + ", " +
                CeilingTable.Cols.Cd60Size3 + ", " +
                CeilingTable.Cols.Cd60Size4 + ", " +
                CeilingTable.Cols.CONNECTOR + ", " +
                CeilingTable.Cols.CD_STEP + ", " +
                CeilingTable.Cols.PANEL_SIZE + ", " +
                CeilingTable.Cols.PANEL_LAYERS + ", " +
                CeilingTable.Cols.WALL_MATERIAL + ", " +
                CeilingTable.Cols.CEILING_MATERIAL + ", " +
                CeilingTable.Cols.DW_SCREWS_25SIZE + ", " +
                CeilingTable.Cols.DW_SCREWS_40SIZE + ", " +
                CeilingTable.Cols.SCREWS_CONCRETE + ", " +
                CeilingTable.Cols.SCREWS_WOOD + ", " +
                CeilingTable.Cols.SCREWS_DRYWALL +  ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
