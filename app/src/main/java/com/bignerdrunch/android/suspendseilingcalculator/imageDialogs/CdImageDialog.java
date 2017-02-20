package com.bignerdrunch.android.suspendseilingcalculator.imageDialogs;

import android.os.Bundle;

import com.bignerdrunch.android.suspendseilingcalculator.R;
import com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.SingleImageDialog;

/**
 * Created by ar4er25 on 2/17/2017.
 */

public class CdImageDialog extends SingleImageDialog {
    public static final String EXTRA_CD_DESCRIPTION = "com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.EXTRA_CD_DESCRIPTION";


    @Override
    public int getImageId() {
        return R.drawable.cd_profiil;
    }

    @Override
    public int getTitle() {
        return R.string.cd_name;
    }

    @Override
    public String getArgKey() {
        return EXTRA_CD_DESCRIPTION;
    }
    public static CdImageDialog getNewInstance(String description) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_CD_DESCRIPTION, description);
        CdImageDialog dialog = new CdImageDialog();
        dialog.setArguments(args);
        return dialog;

    }
}
