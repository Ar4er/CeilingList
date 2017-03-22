package com.bignerdrunch.android.suspendseilingcalculator.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.bignerdrunch.android.suspendseilingcalculator.SuspendCeiling;
import com.bignerdrunch.android.suspendseilingcalculator.database.CeilingDataBaseSchema.CeilingTable;
import com.bignerdrunch.android.suspendseilingcalculator.details.Cd60;
import com.bignerdrunch.android.suspendseilingcalculator.details.Lock;
import com.bignerdrunch.android.suspendseilingcalculator.details.Panel;
import com.bignerdrunch.android.suspendseilingcalculator.details.Suspend;
import com.bignerdrunch.android.suspendseilingcalculator.details.Ud28;

import java.util.Date;
import java.util.UUID;

/**
 * Created by ar4er25 on 3/15/2017.
 */

public class CeilingCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public CeilingCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public SuspendCeiling getCeiling(){
        String uuidString = getString(getColumnIndex(CeilingTable.Cols.Id));
        SuspendCeiling ceiling = new SuspendCeiling(UUID.fromString(uuidString));
        ceiling.setName(getString(getColumnIndex(CeilingTable.Cols.Name)));
        ceiling.setDate(new Date(getLong(getColumnIndex(CeilingTable.Cols.Date))));
        ceiling.setArea(getDouble(getColumnIndex(CeilingTable.Cols.Area)));
        ceiling.setCd(new Cd60(getInt(getColumnIndex(CeilingTable.Cols.Cd60))));
        ceiling.setUd28(new Ud28(getInt(getColumnIndex(CeilingTable.Cols.Ud28))));
        ceiling.setLock(new Lock(getInt(getColumnIndex(CeilingTable.Cols.Lock))));
        ceiling.setSuspend(new Suspend(getInt(getColumnIndex(CeilingTable.Cols.Suspend))));
        ceiling.setPanel(new Panel(getInt(getColumnIndex(CeilingTable.Cols.Panel))));
        ceiling.setX(getDouble(getColumnIndex(CeilingTable.Cols.X)));
        ceiling.setY(getDouble(getColumnIndex(CeilingTable.Cols.Y)));

        return ceiling;
    }
}
