package com.bignerdrunch.android.suspendseilingcalculator;

import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.util.ArrayList;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class SeilingListFragment extends ListFragment {

    ArrayList<SuspendSeiling> mArrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mArrayList = SeilingLab.getSeilingLab(getActivity()).getList();
        ArrayAdapter<SuspendSeiling> adapter =
                new ArrayAdapter<SuspendSeiling>(getActivity(), android.R.layout.simple_list_item_1,mArrayList );
        setListAdapter(adapter);
    }
}
