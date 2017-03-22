package com.bignerdrunch.android.suspendseilingcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v4.app.ShareCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.CdImageDialog;
import com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.LockImageDialog;
import com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.PanelImageDialog;
import com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.SingleImageDialog;
import com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.SuspendImageDialog;
import com.bignerdrunch.android.suspendseilingcalculator.imageDialogs.UdImageDialog;

import java.util.UUID;

/**
 * Created by ar4er25 on 3/21/2017.
 */

public class CardSetFragment extends Fragment {
    public static final String UUID_EXTRA ="com.bignerdrunch.android.suspendseilingcalculator.CardSetFragment.UuidExtra";
    public static final String UD_IMAGE = "ud-mage";
    public static final String CD_IMAGE= "cd-image";
    public static final String LOCK_IMAGE = "lock-image";
    public static final String SUSPEND_IMAGE = "suspend-image";
    public static final String PANEL_IMAGE = "panel-image";
    private TextView mCdCountTextView;
    private TextView mUdCountTextView;
    private TextView mLockCountTextView;
    private TextView mSuspendCountTextView;
    private TextView mPanelCountTextView;
    private ImageView mCdImageView;
    private ImageView mUdImageView;
    private ImageView mLockImageView;
    private ImageView mSuspendImageView;
    private ImageView mPanelImageView;
    private SuspendCeiling mSuspendCeiling;
    private CardView mUdCardView;
    private CardView mCdCardView;
    private CardView mLockCardView;
    private CardView mSuspendCardView;
    private CardView mPanelCardView;

    public static CardSetFragment newInstance(UUID uuid){
        Bundle args = new Bundle();
        args.putSerializable(UUID_EXTRA, uuid);
        CardSetFragment cardSetFragment = new CardSetFragment();
        cardSetFragment.setArguments(args);
        return cardSetFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        UUID args = (UUID)getArguments().getSerializable(UUID_EXTRA);
        mSuspendCeiling = CeilingLab.getCeilingLab(getActivity()).getSuspendCeiling(args);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_card_set, container, false);
        mCdCountTextView = (TextView)v.findViewById(R.id.card_set_cd_count_text);
        mCdCountTextView.setText(mSuspendCeiling.getCd().toString());
        mUdCountTextView = (TextView)v.findViewById(R.id.card_set_ud_count_text);
        mUdCountTextView.setText(mSuspendCeiling.getUd28().toString());
        mLockCountTextView = (TextView)v.findViewById(R.id.card_set_lock_count_text);
        mLockCountTextView.setText(mSuspendCeiling.getLock().toString());
        mSuspendCountTextView = (TextView)v.findViewById(R.id.card_set_suspend_count_text);
        mSuspendCountTextView.setText(mSuspendCeiling.getSuspend().toString());
        mPanelCountTextView = (TextView)v.findViewById(R.id.card_set_panel_count_text);
        mPanelCountTextView.setText(mSuspendCeiling.getPanel().toString());
        mCdImageView = (ImageView)v.findViewById(R.id.image_cd);
        mCdImageView.setImageResource(R.drawable.cd_profiil);
        mUdImageView = (ImageView) v.findViewById(R.id.image_ud);
        mUdImageView.setImageResource(R.drawable.ud_image);
        mLockImageView = (ImageView) v.findViewById(R.id.image_lock);
        mLockImageView.setImageResource(R.drawable.lock);
        mSuspendImageView = (ImageView) v.findViewById(R.id.image_suspend);
        mSuspendImageView.setImageResource(R.drawable.suspend);
        mPanelImageView = (ImageView) v.findViewById(R.id.image_panel);
        mPanelImageView.setImageResource(R.drawable.panel);
        mUdCardView = (CardView) v.findViewById(R.id.ud_card_view);
        mUdCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(UdImageDialog.getNewInstance(mSuspendCeiling.getUd28().toString()), UD_IMAGE);

            }
        });
        mCdCardView = (CardView) v.findViewById(R.id.cd_card_view);
        mCdCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(CdImageDialog.getNewInstance(mSuspendCeiling.getCd().toString()), CD_IMAGE);
            }
        });
        mLockCardView = (CardView) v.findViewById(R.id.lock_card_view);
        mLockCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(LockImageDialog.getNewInstance(mSuspendCeiling.getLock().toString()), LOCK_IMAGE);
            }
        });
        mSuspendCardView = (CardView) v.findViewById(R.id.suspend_card_view);
        mSuspendCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(SuspendImageDialog.getNewInstance(mSuspendCeiling.getSuspend().toString()), SUSPEND_IMAGE);
            }
        });
        mPanelCardView = (CardView) v.findViewById(R.id.panel_card_view);
        mPanelCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(PanelImageDialog.getNewInstance(mSuspendCeiling.getPanel().toString()), PANEL_IMAGE);
            }
        });
        return v;
    }
    public void showDialog(SingleImageDialog dialog, String TAG){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        dialog.show(fm, TAG);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.set_of_count_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete_botton_set_menu:
                CeilingLab.getCeilingLab(getActivity()).deliteCeiling(mSuspendCeiling);
                ViewPager vp = (ViewPager) getActivity().findViewById(R.id.ceiling_pager);
                vp.getAdapter().notifyDataSetChanged();
                NavUtils.navigateUpFromSameTask(getActivity());
                return true;
            case R.id.send_button_set_menu:
                Intent intent = ShareCompat.IntentBuilder.from(getActivity())
                        .setType("text/plain")
                        .setText(createMessage())
                        .setSubject(getString(R.string.send_report))
                        .getIntent();
                intent = Intent.createChooser(intent, getString(R.string.send_report));
                startActivity(intent);
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }
    private String createMessage(){

        String result = getString(R.string.message_string,
                mSuspendCeiling.getName(),
                mSuspendCeiling.getCd().toString(),
                mSuspendCeiling.getUd28().toString(),
                mSuspendCeiling.getSuspend().toString(),
                mSuspendCeiling.getLock().toString(),
                mSuspendCeiling.getPanel().toString());
        return result;
    }
}
