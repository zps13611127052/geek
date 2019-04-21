package com.example.geeknews.fragment;

import com.example.geeknews.R;
import com.example.geeknews.base.BaseFragment;
import com.example.geeknews.presenter.EmptyP;
import com.example.geeknews.view.EmptyV;

/**
 * Created by 张十八 on 2019/4/3.
 */

public class SettingFragment extends BaseFragment<EmptyV,EmptyP> implements EmptyV {
    @Override
    protected EmptyP initPresenter() {
        return new EmptyP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_settingfragment;
    }
}
