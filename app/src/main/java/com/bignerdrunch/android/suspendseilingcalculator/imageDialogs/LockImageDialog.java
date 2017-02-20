package com.bignerdrunch.android.suspendseilingcalculator.imageDialogs;

import android.os.Bundle;

import com.bignerdrunch.android.suspendseilingcalculator.R;

/**
 * Created by ar4er25 on 2/18/2017.
 */

public class LockImageDialog extends SingleImageDialog {
   public static final String EXTRA_LOCK_DESCRIPTION = "com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.EXTRA_LOCK_DESCRIPTION";
    @Override
    public int getImageId() {
        return R.drawable.lock;
    }

    @Override
    public int getTitle() {
        return R.string.lock_name;
    }

    @Override
    public String getArgKey() {
        return EXTRA_LOCK_DESCRIPTION;
    }
    public static LockImageDialog getNewInstance(String description) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_LOCK_DESCRIPTION, description);
        LockImageDialog dialog = new LockImageDialog();
        dialog.setArguments(args);
        return dialog;
    }
}
