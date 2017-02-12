package com.bignerdrunch.android.suspendseilingcalculator;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class PagerCeilingsActivity extends FragmentActivity {
    public static final String EXTRA_UUID = "com.bignerdrunch.android.suspendseilingcalculator.EXTRA_UUID";

    ViewPager mViewPager;
    ArrayList<SuspendCeiling> mCeilings;



    @Override
    protected void onCreate(  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.ceiling_pager);
        setContentView(mViewPager);

        mCeilings = CeilingLab.getCeilingLab(this).getList();

        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                SuspendCeiling sc = mCeilings.get(position);
                return SetOfCountsFragment.newInstance(sc.getId());
            }

            @Override
            public int getCount() {
                return mCeilings.size();
            }
        });

        UUID uuid = (UUID) getIntent().getSerializableExtra(EXTRA_UUID);
        for (int i = 0; i <mCeilings.size() ; i++) {
            if (mCeilings.get(i).getId().equals(uuid)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }

    }



}
