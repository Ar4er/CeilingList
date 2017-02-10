package com.bignerdrunch.android.suspendseilingcalculator;

import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;


import java.util.ArrayList;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class SeilingListFragment extends ListFragment {

    ArrayList<SuspendSeiling> mArrayList;

    @Override
    public void onResume() {
        super.onResume();
        ((ArrayAdapter)getListAdapter()).notifyDataSetChanged();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mArrayList = SeilingLab.getSeilingLab(getActivity()).getList();
        ArrayAdapter<SuspendSeiling> adapter =
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,mArrayList );
        setListAdapter(adapter);
    }
}
