package com.bignerdrunch.android.suspendseilingcalculator;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.CdImageDialog;
import com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.LockImageDialog;
import com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.PanelImageDialog;
import com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.SingleImageDialog;
import com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.SuspendImageDialog;
import com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.UdImageDialog;

import java.util.UUID;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class SetOfCountsFragment extends Fragment {
    public static final String UUID_EXTRA ="com.bignerdrunch.android.suspendseilingcalculator.UuidExtra";
    public static final String CD_IMAGE= "cd-image";
    public static final String UD_IMAGE = "ud-mage";
    public static final String LOCK_IMAGE = "lock-image";
    public static final String SUSPEND_IMAGE = "suspend-image";
    public static final String PANEL_IMAGE = "panel-image";
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
        setHasOptionsMenu(true);
        UUID args = (UUID)getArguments().getSerializable(UUID_EXTRA);
        mSuspendCeiling = CeilingLab.getCeilingLab(getActivity()).getById(args);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.set_of_items, container, false);
        if (NavUtils.getParentActivityName(getActivity())!=null) {
            getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mAreaButton = (Button) v.findViewById(R.id.area_button);
        mAreaButton.setText(String.format("%.2f m2", mSuspendCeiling.getArea()));
        mCdButton = (Button) v.findViewById(R.id.cd60_button);
        mCdButton.setText(mSuspendCeiling.getCd().toString());
        mCdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(CdImageDialog.getNewInstance(mSuspendCeiling.getCd().toString()), CD_IMAGE);
            }
        });
        mUdButton = (Button) v.findViewById(R.id.ud_button);
        mUdButton.setText(mSuspendCeiling.getUd28().toString());
        mUdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(UdImageDialog.getNewInstance(mSuspendCeiling.getUd28().toString()), UD_IMAGE);
            }
        });
        mLocksButton = (Button) v.findViewById(R.id.locks_button);
        mLocksButton.setText(mSuspendCeiling.getLock().toString());
        mLocksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(LockImageDialog.getNewInstance(mSuspendCeiling.getLock().toString()), LOCK_IMAGE);
            }
        });
        mSuspendsButton = (Button) v.findViewById(R.id.suspends_button);
        mSuspendsButton.setText(mSuspendCeiling.getSuspend().toString());
        mSuspendsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(SuspendImageDialog.getNewInstance(mSuspendCeiling.getSuspend().toString()), SUSPEND_IMAGE);
            }
        });
        mPannelsRutton = (Button) v.findViewById(R.id.panels_button);
        mPannelsRutton.setText(mSuspendCeiling.getPanel().toString());
        mPannelsRutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(PanelImageDialog.getNewInstance(mSuspendCeiling.getPanel().toString()), PANEL_IMAGE);
            }
        });

        return v;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                if (NavUtils.getParentActivityName(getActivity())!=null){
                    NavUtils.navigateUpFromSameTask(getActivity());
                }
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    public void showDialog(SingleImageDialog dialog, String TAG){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        dialog.show(fm, TAG);
    }

}
