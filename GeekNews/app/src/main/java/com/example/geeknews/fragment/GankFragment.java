package com.example.geeknews.fragment;

import com.example.geeknews.R;
import com.example.geeknews.base.BaseFragment;
import com.example.geeknews.presenter.GankP;
import com.example.geeknews.view.GankV;

/**
 * Created by 张十八 on 2019/4/3.
 */

public class GankFragment extends BaseFragment<GankV,GankP>implements GankV {
    @Override
    protected GankP initPresenter() {
        return new GankP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gankfragment;
    }
}
