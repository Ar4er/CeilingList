package com.bignerdrunch.android.suspendseilingcalculator.imageDialogs;

import android.os.Bundle;

import com.bignerdrunch.android.suspendseilingcalculator.R;

/**
 * Created by ar4er25 on 2/18/2017.
 */

public class PanelImageDialog extends SingleImageDialog {
   public static final String EXTRA_PANEL_DESCRIPTION = "com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.EXTRA_PANEL_DESCRIPTION";

    @Override
    public int getImageId() {
        return R.drawable.panel;
    }

    @Override
    public int getTitle() {
        return R.string.panel_name;
    }

    @Override
    public String getArgKey() {
        return EXTRA_PANEL_DESCRIPTION;
    }

    public static PanelImageDialog getNewInstance(String description) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_PANEL_DESCRIPTION, description);
        PanelImageDialog dialog = new PanelImageDialog();
        dialog.setArguments(args);
        return dialog;

    }
}
