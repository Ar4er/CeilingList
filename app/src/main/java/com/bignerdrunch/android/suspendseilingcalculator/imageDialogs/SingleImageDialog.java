package com.bignerdrunch.android.suspendseilingcalculator.imageDialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdrunch.android.suspendseilingcalculator.R;

import java.util.Date;
import java.util.UUID;

/**
 * Created by ar4er25 on 2/17/2017.
 */

public abstract class SingleImageDialog extends DialogFragment {
    private UUID mId;

    public SingleImageDialog(){
        mId = UUID.randomUUID();
    }

    public abstract int getImageId();
    public abstract int getTitle();
    public abstract String getArgKey();


    public UUID getmId() {
        return mId;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.image_dialog, null);
        ImageView imageView = (ImageView) v.findViewById(R.id.image_dialog_drawable);
        imageView.setImageResource(getImageId());
        TextView textView = (TextView) v.findViewById(R.id.image_dialog_string);
        textView.setText((String) getArguments().getSerializable(getArgKey()));

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(getTitle())
                .setPositiveButton(android.R.string.ok, null).create();
    }
}
