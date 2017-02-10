package com.bignerdrunch.android.suspendseilingcalculator;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class CeilingListFragment extends ListFragment {

    ArrayList<SuspendCeiling> mArrayList;

    @Override
    public void onResume() {
        super.onResume();
        ((ArrayAdapter)getListAdapter()).notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(getActivity(), PagerCeilingsActivity.class);
        startActivity(i);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mArrayList = CeilingLab.getCeilingLab(getActivity()).getList();
        ArrayAdapter<SuspendCeiling> adapter =
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,mArrayList );
        setListAdapter(adapter);
    }



}
