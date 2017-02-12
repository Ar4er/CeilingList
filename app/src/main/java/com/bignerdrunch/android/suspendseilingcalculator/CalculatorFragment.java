package com.bignerdrunch.android.suspendseilingcalculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

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
    public static final String EXCEP_DIALOG = "com.bignerdrunch.android.suspendseilingcalculator.EXCEP_DIALOG";

    private SuspendCeiling mSuspendCeiling;
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
                try {
                    int intX = Integer.parseInt(x);
                    int intY = Integer.parseInt(y);
                    if (intX<600||intY<600){
                        throw new NumberFormatException();
                    }
                    mSuspendCeiling = new SuspendCeiling(Integer.parseInt(x), Integer.parseInt(y));
                    CeilingLab.getCeilingLab(getActivity()).getList().add(mSuspendCeiling);
                    mAreaButton.setText(String.format("%.2f m2", mSuspendCeiling.getArea()));
                    mUdButton.setText(mSuspendCeiling.getUd28().toString());
                    mCd60Button.setText(mSuspendCeiling.getCd().toString());
                    mSuspendsButton.setText(mSuspendCeiling.getSuspend().toString());
                    mLocksButton.setText(mSuspendCeiling.getLock().toString());
                    mPanelsButton.setText(mSuspendCeiling.getPanel().toString());
                } catch (NumberFormatException e) {

                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    OrderExceptionDialog dialog = new OrderExceptionDialog();
                    dialog.show(manager, EXCEP_DIALOG);
                }
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
