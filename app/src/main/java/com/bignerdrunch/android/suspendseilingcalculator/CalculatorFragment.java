package com.bignerdrunch.android.suspendseilingcalculator;

import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class CalculatorFragment extends Fragment {

    private SuspendSeiling mSuspendSeiling;
    private String x;
    private  String y;
    private EditText editX;
    private EditText editY;
    private Button clulateOrderButton;
    private Button mUdButton;
    private Button mAreaButton;
    private Button mCd60Button;
    private Button mLocksButton;
    private Button mSuspendsButton;
    private Button mPanelsButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.calculator_fragment , container, false);
        editX = (EditText) v.findViewById(R.id.edit_X);
        editX.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                x = s.toString();
            }
        });

        editY = (EditText) v.findViewById(R.id.edit_Y);
        editY.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                y = s.toString();
            }
        });
        clulateOrderButton =(Button) v.findViewById(R.id.calculate_order_button);
        clulateOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSuspendSeiling = new SuspendSeiling(Integer.parseInt(x), Integer.parseInt(y));
                SeilingLab.getSeilingLab(getActivity()).getList().add(mSuspendSeiling);
                mAreaButton.setText(String.format("%.2f m2", mSuspendSeiling.getArea()));
                mUdButton.setText(mSuspendSeiling.getUd28().toString());
                mCd60Button.setText(mSuspendSeiling.getCd().toString());
                mSuspendsButton.setText(mSuspendSeiling.getSuspend().toString());
                mLocksButton.setText(mSuspendSeiling.getLock().toString());
                mPanelsButton.setText(mSuspendSeiling.getPanel().toString());
            }
        });

        mUdButton = (Button)v.findViewById(R.id.ud_button);
        mAreaButton = (Button)v.findViewById(R.id.area_button);
        mCd60Button = (Button)v.findViewById(R.id.cd60_button);
        mLocksButton = (Button)v.findViewById(R.id.locks_button);
        mSuspendsButton = (Button)v.findViewById(R.id.suspends_button);
        mPanelsButton = (Button)v.findViewById(R.id.panels_button);

        return v;
    }
}
