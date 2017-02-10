package com.bignerdrunch.android.suspendseilingcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class ButtonCalculatorFragment extends Fragment {

    Button mButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.calculator_button, container, false);
        mButton = (Button)v.findViewById(R.id.main_calculator_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CalculatorActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        return v;
    }


}
