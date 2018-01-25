package com.example.meng.videolive.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.meng.videolive.ui.LiveFragment;
import com.example.meng.videolive.utils.BuildUrl;


/**
 * Created by 小萌神_0 on 2016/5/27.
 *
 */
public class PagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = PagerAdapter.class.getSimpleName();
    private LiveFragment mDota2Live = null;
    private LiveFragment mLolLive = null;
    private LiveFragment mPlayerUnknowLive = null;
    private LiveFragment mLive = null;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    private final String[] titles = {"推荐", "DOTA2", "LOL", "大逃杀"};

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                if (mLive == null){
                    String url = BuildUrl.getDouyuLiveChannel();
                    Log.d(TAG, "mLive:" + url);
                    mLive = LiveFragment.newInstance(url);
                }
                return mLive;
            case 1:
                if (mDota2Live == null){
                    String url = BuildUrl.getDouyuDota2SubChannel();
                    Log.d(TAG, "mDota2Live:" + url);
                    mDota2Live = LiveFragment.newInstance(url);
                }
                return mDota2Live;
            case 2:
                if (mLolLive == null){
                    String url = BuildUrl.getDouyuLOLSubChannel();
                    Log.d(TAG, "mLolLive:" + url);
                    mLolLive = LiveFragment.newInstance(url);
                }
                return mLolLive;
            case 3:
                if (mPlayerUnknowLive == null){
                    String url = BuildUrl.getDouyuPlayerUnknowChannel();
                    Log.d(TAG, "mPlayerUnknowLive:" + url);
                    mPlayerUnknowLive = LiveFragment.newInstance(url);
                }
                return mPlayerUnknowLive;
            default:
                return null;
        }
    }
}
