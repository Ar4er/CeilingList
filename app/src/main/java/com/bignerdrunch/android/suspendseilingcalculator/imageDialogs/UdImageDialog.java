package com.bignerdrunch.android.suspendseilingcalculator.imageDialogs;

import android.os.Bundle;

import com.bignerdrunch.android.suspendseilingcalculator.R;
import com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.SingleImageDialog;

/**
 * Created by ar4er25 on 2/17/2017.
 */


public class UdImageDialog extends SingleImageDialog {
    public static final String EXTRA_UD_DESCRIPTION = " com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.Ud-description";

    @Override
    public int getImageId() {
        return R.drawable.ud_image;
    }

    @Override
    public int getTitle() {
        return R.string.ud_name;
    }

    @Override
    public String getArgKey() {
        return EXTRA_UD_DESCRIPTION;
    }

    public static UdImageDialog getNewInstance(String description){
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_UD_DESCRIPTION, description);
        UdImageDialog dialog = new UdImageDialog();
        dialog.setArguments(args);
        return dialog;
    }
}
