package com.example.geeknews.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.geeknews.R;
import com.example.geeknews.adapter.ZhiHuAdapter.Vp_ZhiHuDaily_Adapter;
import com.example.geeknews.base.BaseFragment;
import com.example.geeknews.fragment.ZhiHuDailyFragment.Daily_Fragment;
import com.example.geeknews.fragment.ZhiHuDailyFragment.Hot_Fragment;
import com.example.geeknews.fragment.ZhiHuDailyFragment.Special_Fragment;
import com.example.geeknews.presenter.ZhiHuNewsP;
import com.example.geeknews.view.ZhiHuNewsV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by 张十八 on 2019/4/3.
 */

public class ZhiHuNewsFragment extends BaseFragment<ZhiHuNewsV, ZhiHuNewsP> implements ZhiHuNewsV {
    @BindView(R.id.tab_id)
    TabLayout mTabId;
    @BindView(R.id.vp_id)
    ViewPager mVpId;
    Unbinder unbinder;
    private ArrayList<BaseFragment> mFragments;
    private ArrayList<Integer> mTitles;

    @Override
    protected ZhiHuNewsP initPresenter() {
        return new ZhiHuNewsP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zhihunewsfragment;
    }

    @Override
    protected void initView() {
        initTitle();
        initFragment();

        Vp_ZhiHuDaily_Adapter adapter = new Vp_ZhiHuDaily_Adapter(getContext(),getChildFragmentManager(),mTitles,mFragments);
        mVpId.setAdapter(adapter);
        mTabId.setupWithViewPager(mVpId);

    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(new Daily_Fragment());
        mFragments.add(new Special_Fragment());
        mFragments.add(new Hot_Fragment());
    }

    private void initTitle() {
        mTitles = new ArrayList<>();
        mTitles.add(R.string.daily);
        mTitles.add(R.string.special);
        mTitles.add(R.string.hot);
    }
}
