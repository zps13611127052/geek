package com.example.geeknews.adapter.ZhiHuAdapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.geeknews.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by 张十八 on 2019/4/17.
 */

public class Vp_ZhiHuDaily_Adapter extends FragmentPagerAdapter {
    private final Context mContext;
    private final ArrayList<Integer> mTitles;
    private final ArrayList<BaseFragment> mFragments;

    public Vp_ZhiHuDaily_Adapter(Context context, FragmentManager fm, ArrayList<Integer> titles, ArrayList<BaseFragment> fragments) {
        super(fm);
        mContext = context;
        mTitles = titles;
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(mTitles.get(position));
    }
}
