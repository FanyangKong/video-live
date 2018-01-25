package com.example.meng.videolive.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.astuetz.PagerSlidingTabStrip;
import com.example.meng.videolive.R;
import com.example.meng.videolive.adapter.PagerAdapter;

/**
 * Created by uspai.taobao.com on 2016/6/22.
 *
 */
public class HeadPagerFragment extends Fragment {
    private View mView;
    private PagerSlidingTabStrip mPagerSlidingTabStrip;
    private DisplayMetrics dm;
    private LinearLayout root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_head_pager, container, false);
            ViewPager viewPager = inflater.inflate(R.layout.separate_viewpager, null).findViewById(R.id.view_pager);
            root = mView.findViewById(R.id.root);
            //mPagerSlidingTabStrip = (PagerSlidingTabStrip) mView.findViewById(R.id.tab_host);
            // 代码生成 mPagerSlidingTabStrip
            mPagerSlidingTabStrip = new PagerSlidingTabStrip(getActivity());
            mPagerSlidingTabStrip.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 140));
            mPagerSlidingTabStrip.setShouldExpand(true);
            mPagerSlidingTabStrip.setAllCaps(true);
            mPagerSlidingTabStrip.setTextSize(60);
            mPagerSlidingTabStrip.setTextColor(Color.BLACK);
            mPagerSlidingTabStrip.setDividerColor(Color.BLUE);
            mPagerSlidingTabStrip.setDividerPadding(30);
            mPagerSlidingTabStrip.setIndicatorColor(Color.RED);
            mPagerSlidingTabStrip.setIndicatorHeight(15);
            mPagerSlidingTabStrip.setUnderlineColor(Color.BLUE);

            if (viewPager != null) {
                viewPager.setAdapter(new PagerAdapter(getFragmentManager()));
                viewPager.setOffscreenPageLimit(1);
                mPagerSlidingTabStrip.setViewPager(viewPager);
            }

            root.addView(mPagerSlidingTabStrip);
            root.addView(viewPager);
            setTabsValue();
        }

        ViewGroup parent = (ViewGroup) mView.getParent();
        if (parent != null) {
            parent.removeView(mView);
        }

        return mView;
    }

    private void setTabsValue() {
        dm = getResources().getDisplayMetrics();

        mPagerSlidingTabStrip.setDividerColor(Color.TRANSPARENT);
        mPagerSlidingTabStrip.setUnderlineHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 1, dm));
        mPagerSlidingTabStrip.setIndicatorHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 2, dm));
        mPagerSlidingTabStrip.setTextSize((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 12, dm));
        mPagerSlidingTabStrip.setIndicatorColor(Color.parseColor("#45c01a"));
        mPagerSlidingTabStrip.setTabBackground(0);
    }
}
