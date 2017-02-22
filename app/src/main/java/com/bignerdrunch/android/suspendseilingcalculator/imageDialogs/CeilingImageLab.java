package com.bignerdrunch.android.suspendseilingcalculator.imageDialogs;

import com.bignerdrunch.android.suspendseilingcalculator.SuspendCeiling;

import java.util.ArrayList;

/**
 * Created by ar4er25 on 2/20/2017.
 */

public class CeilingImageLab {

    private SuspendCeiling mCeiling;
    private ArrayList<SingleImageDialog> mImageList;

    public CeilingImageLab(SuspendCeiling sc) {
        mCeiling = sc;
        mImageList= new ArrayList<>();
        mImageList.add(CdImageDialog.getNewInstance(mCeiling.getCd().toString()));
        mImageList.add(UdImageDialog.getNewInstance(mCeiling.getUd28().toString()));
        mImageList.add(LockImageDialog.getNewInstance(mCeiling.getLock().toString()));
        mImageList.add(SuspendImageDialog.getNewInstance(mCeiling.getSuspend().toString()));
        mImageList.add(PanelImageDialog.getNewInstance(mCeiling.getPanel().toString()));
    }

    public ArrayList<SingleImageDialog> getImageList() {
        return mImageList;
    }
}
