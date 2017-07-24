package com.bignerdrunch.android.suspendseilingcalculator.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.bignerdrunch.android.suspendseilingcalculator.Materials;
import com.bignerdrunch.android.suspendseilingcalculator.SuspendCeiling;
import com.bignerdrunch.android.suspendseilingcalculator.database.CeilingDataBaseSchema.CeilingTable;
import com.bignerdrunch.android.suspendseilingcalculator.details.Cd60;
import com.bignerdrunch.android.suspendseilingcalculator.details.Connector;
import com.bignerdrunch.android.suspendseilingcalculator.details.Lock;
import com.bignerdrunch.android.suspendseilingcalculator.details.Panel;
import com.bignerdrunch.android.suspendseilingcalculator.details.Screw;
import com.bignerdrunch.android.suspendseilingcalculator.details.ScrewCeiling;
import com.bignerdrunch.android.suspendseilingcalculator.details.ScrewPanel;
import com.bignerdrunch.android.suspendseilingcalculator.details.ScrewWall;
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
        ceiling.setCd(new Cd60(getInt(getColumnIndex(CeilingTable.Cols.Cd60)),
                getInt(getColumnIndex(CeilingTable.Cols.Cd60Size3)),
                getInt(getColumnIndex(CeilingTable.Cols.Cd60Size4))));
        ceiling.setUd28(new Ud28(getInt(getColumnIndex(CeilingTable.Cols.Ud28))));
        ceiling.setLock(new Lock(getInt(getColumnIndex(CeilingTable.Cols.Lock))));
        ceiling.setSuspend(new Suspend(getInt(getColumnIndex(CeilingTable.Cols.Suspend))));
        ceiling.setPanel(new Panel(getInt(getColumnIndex(CeilingTable.Cols.Panel))));
        ceiling.setX(getDouble(getColumnIndex(CeilingTable.Cols.X)));
        ceiling.setY(getDouble(getColumnIndex(CeilingTable.Cols.Y)));
        ceiling.setScrewCeiling(new ScrewCeiling(getInt(getColumnIndex(CeilingTable.Cols.screwCeiling))));
        ceiling.setScrewWall(new ScrewWall(getInt(getColumnIndex(CeilingTable.Cols.screwWall))));
        ceiling.setScrewPanel(new ScrewPanel(getInt(getColumnIndex(CeilingTable.Cols.screwPanel)),
                getInt(getColumnIndex(CeilingTable.Cols.DW_SCREWS_25SIZE)),
                getInt(getColumnIndex(CeilingTable.Cols.DW_SCREWS_40SIZE))));
        ceiling.setConector(new Connector(getInt(getColumnIndex(CeilingTable.Cols.CONNECTOR))));
        ceiling.setCdStep(getInt(getColumnIndex(CeilingTable.Cols.CD_STEP)));
        ceiling.setPanelSize(getInt(getColumnIndex(CeilingTable.Cols.PANEL_SIZE)));
        ceiling.setPanelLayers(getInt(getColumnIndex(CeilingTable.Cols.PANEL_LAYERS)));
        ceiling.setWallMaterial(Materials.valueOf(getString(getColumnIndex(CeilingTable.Cols.WALL_MATERIAL))));
        ceiling.setCeilingBaseMaterial(Materials.valueOf(getString(getColumnIndex(CeilingTable.Cols.CEILING_MATERIAL))));
        ceiling.setScrewConcrete(new Screw(getInt(getColumnIndex(CeilingTable.Cols.SCREWS_CONCRETE))));
        ceiling.setScrewsWood(new Screw(getInt(getColumnIndex(CeilingTable.Cols.SCREWS_WOOD))));
        ceiling.setScrewsDryWolls(new Screw(getInt(getColumnIndex(CeilingTable.Cols.SCREWS_DRYWALL))));


        return ceiling;
    }
}
