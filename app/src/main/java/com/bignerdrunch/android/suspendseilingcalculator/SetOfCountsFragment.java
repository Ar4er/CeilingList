package com.bignerdrunch.android.suspendseilingcalculator;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class SetOfCountsFragment extends Fragment {
    public static final String UUID_EXTRA ="com.bignerdrunch.android.suspendseilingcalculator.UuidExtra";

    private SuspendCeiling mSuspendCeiling;
    private Button mAreaButton;
    private Button mCdButton;
    private Button mUdButton;
    private Button mLocksButton;
    private Button mSuspendsButton;
    private Button mPannelsRutton;
    private TextView mNameTextView;




    public static SetOfCountsFragment newInstance(UUID uuid){
        Bundle args = new Bundle();
        args.putSerializable(UUID_EXTRA, uuid);
        SetOfCountsFragment setOfCountsFragment = new SetOfCountsFragment();
        setOfCountsFragment.setArguments(args);
        return setOfCountsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID args = (UUID)getArguments().getSerializable(UUID_EXTRA);
        mSuspendCeiling = CeilingLab.getCeilingLab(getActivity()).getById(args);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.set_of_items, container, false);

        mAreaButton = (Button) v.findViewById(R.id.area_button);
        mAreaButton.setText(String.format("%.2f m2", mSuspendCeiling.getArea()));
        mCdButton = (Button) v.findViewById(R.id.cd60_button);
        mCdButton.setText(mSuspendCeiling.getCd().toString());
        mUdButton = (Button) v.findViewById(R.id.ud_button);
        mUdButton.setText(mSuspendCeiling.getUd28().toString());
        mLocksButton = (Button) v.findViewById(R.id.locks_button);
        mLocksButton.setText(mSuspendCeiling.getLock().toString());
        mSuspendsButton = (Button) v.findViewById(R.id.suspends_button);
        mSuspendsButton.setText(mSuspendCeiling.getSuspend().toString());
        mPannelsRutton = (Button) v.findViewById(R.id.panels_button);
        mPannelsRutton.setText(mSuspendCeiling.getPanel().toString());

        return v;
    }
}
