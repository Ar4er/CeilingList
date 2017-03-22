package com.bignerdrunch.android.suspendseilingcalculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class PagerCeilingsActivity extends AppCompatActivity {
    private static final String EXTRA_UUID = "com.bignerdrunch.android.suspendseilingcalculator.EXTRA_UUID";

   private ViewPager mViewPager;
   private ArrayList<SuspendCeiling> mCeilings;

    public static Intent newIntent(Context packageContext, UUID ceilingId){
        Intent intent = new Intent(packageContext, PagerCeilingsActivity.class);
        intent.putExtra(EXTRA_UUID, ceilingId);
        return intent;
    }



    @Override
    protected void onCreate(  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.ceiling_pager);
        setContentView(mViewPager);

        final UUID ceilingId = (UUID) getIntent().getSerializableExtra(EXTRA_UUID);

        mCeilings = CeilingLab.getCeilingLab(this).getList();

        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                SuspendCeiling sc = mCeilings.get(position);
                return CardSetFragment.newInstance(sc.getId());
            }

            @Override
            public int getCount() {
                return mCeilings.size();
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                SuspendCeiling sc = mCeilings.get(position);
                setTitle(sc.getName());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        for (int i = 0; i <mCeilings.size() ; i++) {
            if (mCeilings.get(i).getId().equals(ceilingId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }

    }



}
