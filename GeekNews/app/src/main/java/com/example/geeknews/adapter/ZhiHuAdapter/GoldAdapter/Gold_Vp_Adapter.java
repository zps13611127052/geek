package com.example.geeknews.adapter.ZhiHuAdapter.GoldAdapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.geeknews.base.BaseFragment;
import com.example.geeknews.bean.GoldBean.Gold_Show_Bean;

import java.util.ArrayList;

/**
 * Created by 张十八 on 2019/4/19.
 */

public class Gold_Vp_Adapter extends FragmentStatePagerAdapter {
    private final ArrayList<Gold_Show_Bean> mTitles;
    private final ArrayList<BaseFragment> mFragments;
    private ArrayList<String> mNewList = new ArrayList<>();
    public Gold_Vp_Adapter(FragmentManager fm, ArrayList<Gold_Show_Bean> titles, ArrayList<BaseFragment> fragments) {
        super(fm);
        mTitles = titles;
        mFragments = fragments;


        for (int i = 0; i < mTitles.size(); i++) {
            if (mTitles.get(i).isChecked){
                mNewList.add(mTitles.get(i).title);
            }
        }

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
        return mNewList.get(position);
    }
}
