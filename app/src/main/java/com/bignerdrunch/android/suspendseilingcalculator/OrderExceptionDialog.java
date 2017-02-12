package com.bignerdrunch.android.suspendseilingcalculator;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by ar4er25 on 2/12/2017.
 */

public class OrderExceptionDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View v =getActivity().getLayoutInflater().inflate(R.layout.error_dialog_text, null);

        return new AlertDialog.Builder(getActivity()).
                 setView(v).
                 setTitle(R.string.eror_dialog_title).
                 setPositiveButton(android.R.string.ok, null).create();

    }
}
