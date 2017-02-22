package com.bignerdrunch.android.suspendseilingcalculator.imageDialogs;

import android.os.Bundle;

import com.bignerdrunch.android.suspendseilingcalculator.R;

import java.util.UUID;

/**
 * Created by ar4er25 on 2/18/2017.
 */


public class SuspendImageDialog extends SingleImageDialog {
    public static final String EXTRA_SUSPEND_DESCRIPTION = "com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.EXTRA_SUSPEND_DESCRIPTION";





    @Override
    public int getImageId() {
        return R.drawable.suspend;
    }

    @Override
    public int getTitle() {
        return R.string.suspend_name;
    }

    @Override
    public String getArgKey() {
        return EXTRA_SUSPEND_DESCRIPTION;
    }

    public static SuspendImageDialog getNewInstance(String description){
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_SUSPEND_DESCRIPTION, description);
        SuspendImageDialog dialog = new SuspendImageDialog();
        dialog.setArguments(args);
        return dialog;
    }


}
