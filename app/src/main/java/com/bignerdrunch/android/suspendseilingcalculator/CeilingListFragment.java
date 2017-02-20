package com.bignerdrunch.android.suspendseilingcalculator;

import android.support.v4.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
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
        setHasOptionsMenu(true);
        mCeilings = CeilingLab.getCeilingLab(getActivity()).getList();
        CeilingListAdapter adapter = new CeilingListAdapter(mCeilings);
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View v = inflater.inflate(R.layout.list_fragment, container, false);
        Button mNewCeilingButton =(Button) v.findViewById(R.id.new_button);
        mNewCeilingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CalculatorActivity.class);
                startActivity(intent);
            }
        });
        ListView listView = (ListView)v.findViewById(android.R.id.list);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
              MenuInflater inflater1 = mode.getMenuInflater();
                inflater1.inflate(R.menu.ceiling_list_item_context, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_item_delete_ceiling:
                     CeilingListAdapter adapter = (CeilingListAdapter) getListAdapter();
                        CeilingLab ceilingLab = CeilingLab.getCeilingLab(getActivity());
                        for (int i = adapter.getCount()-1; i >=0 ; i--) {
                           if (getListView().isItemChecked(i)){
                               ceilingLab.deliteCeiling(adapter.getItem(i));
                           }
                        }
                        mode.finish();
                        adapter.notifyDataSetChanged();
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
         return v;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case (R.id.menu_new_ceiling):
            Intent intent = new Intent(getActivity(), CalculatorActivity.class);
            startActivity(intent);
                return true;
       default:
          return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.list_menu, menu);
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

    @Override
    public void onPause() {
        super.onPause();
        CeilingLab.getCeilingLab(getActivity()).saveList();
    }
}
