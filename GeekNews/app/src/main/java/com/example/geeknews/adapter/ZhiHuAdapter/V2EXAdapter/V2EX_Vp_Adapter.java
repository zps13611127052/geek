package com.example.geeknews.adapter.ZhiHuAdapter.V2EXAdapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.geeknews.base.BaseFragment;
import com.example.geeknews.bean.V2ExBean.V2EX_Tab_Bean;

import java.util.ArrayList;

/**
 * Created by 张十八 on 2019/4/19.
 */

public class V2EX_Vp_Adapter extends FragmentPagerAdapter {
    private final ArrayList<V2EX_Tab_Bean> mTab_list;
    private final ArrayList<BaseFragment> mFragments;

    public V2EX_Vp_Adapter(FragmentManager fm, ArrayList<V2EX_Tab_Bean> tab_list, ArrayList<BaseFragment> fragments) {
        super(fm);
        mTab_list = tab_list;
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
        return mTab_list.get(position).tab;
    }
}
