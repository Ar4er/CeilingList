package com.bignerdrunch.android.suspendseilingcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.NavUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.CdImageDialog;
import com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.LockImageDialog;
import com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.PanelImageDialog;
import com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.SingleImageDialog;
import com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.SuspendImageDialog;
import com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.UdImageDialog;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class CalculatorFragment extends Fragment {
    public static final String EXCEP_DIALOG = "com.bignerdrunch.android.suspendseilingcalculator.EXCEP_DIALOG";
    public static final String CD_IMAGE = "com.bignerdrunch.android.suspendseilingcalculator.cd-image";
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.calculator_fragment , container, false);
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
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

                    mSuspendCeiling = new SuspendCeiling(intX, intY);
                    CeilingLab.getCeilingLab(getActivity()).addCeiling(mSuspendCeiling);
                    mAreaButton.setText(String.format("%.2f m2", mSuspendCeiling.getArea()));
                    mUdButton.setText(mSuspendCeiling.getUd28().toString());
                    mUdButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showDialog(UdImageDialog.getNewInstance(mSuspendCeiling.getUd28().toString()), SetOfCountsFragment.UD_IMAGE);
                        }
                    });
                    mCd60Button.setText(mSuspendCeiling.getCd().toString());
                    mCd60Button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                           showDialog(CdImageDialog.getNewInstance(mSuspendCeiling.getCd().toString()), SetOfCountsFragment.CD_IMAGE);
                        }
                    });
                    mSuspendsButton.setText(mSuspendCeiling.getSuspend().toString());
                    mSuspendsButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showDialog(SuspendImageDialog.getNewInstance(mSuspendCeiling.getSuspend().toString()), SetOfCountsFragment.SUSPEND_IMAGE);
                        }
                    });
                    mLocksButton.setText(mSuspendCeiling.getLock().toString());
                    mLocksButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showDialog(LockImageDialog.getNewInstance(mSuspendCeiling.getLock().toString()), SetOfCountsFragment.LOCK_IMAGE);
                        }
                    });
                    mPanelsButton.setText(mSuspendCeiling.getPanel().toString());
                    mPanelsButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showDialog(PanelImageDialog.getNewInstance(mSuspendCeiling.getPanel().toString()), SetOfCountsFragment.LOCK_IMAGE);
                        }
                    });
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.list_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_new_ceiling:
                Intent intent = new Intent(getActivity(), CalculatorActivity.class);
                startActivity(intent);
                return true;
            case android.R.id.home:
                if (NavUtils.getParentActivityName(getActivity()) != null) {
                    NavUtils.navigateUpFromSameTask(getActivity());
                } return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
    public void showDialog(SingleImageDialog dialog, String TAG){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        dialog.show(fm, TAG);
    }

}
