package com.bignerdrunch.android.suspendseilingcalculator;

import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by ar4er25 on 2/10/2017.
 */

public class CeilingListFragment extends ListFragment {

    ArrayList<SuspendCeiling> mCeilings;

    @Override
    public void onResume() {
        super.onResume();
        ((CeilingListAdapter)getListAdapter()).notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        SuspendCeiling sc =((CeilingListAdapter)getListAdapter()).getItem(position);
        Intent i = new Intent(getActivity(), PagerCeilingsActivity.class);
        i.putExtra(PagerCeilingsActivity.EXTRA_UUID, sc.getId());
        startActivity(i);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCeilings = CeilingLab.getCeilingLab(getActivity()).getList();
        CeilingListAdapter adapter = new CeilingListAdapter(mCeilings);
        setListAdapter(adapter);
    }

    private class CeilingListAdapter extends ArrayAdapter<SuspendCeiling>{



        public CeilingListAdapter( ArrayList<SuspendCeiling> Ceilings) {
            super(getActivity(), 0, Ceilings);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null){
                convertView=getActivity()
                        .getLayoutInflater()
                        .inflate(R.layout.list_item_layout, parent, false);
            }



            final SuspendCeiling sc = getItem(position);

            TextView areaTextView = (TextView) convertView.findViewById(R.id.area_string);
            areaTextView.setText(sc.areaToString());
            TextView sizesTextView = (TextView) convertView.findViewById(R.id.sizes_string);
            sizesTextView.setText(sc.toString());
            return convertView;
        }
    }




}
