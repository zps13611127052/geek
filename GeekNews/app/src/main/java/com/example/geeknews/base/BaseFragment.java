package com.example.geeknews.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 张十八 on 2019/4/3.
 */

public abstract class BaseFragment<V extends BaseMvpView,P extends BasePresenter> extends
        Fragment implements BaseMvpView{

    private Unbinder mBind;
    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(), null);
        mBind = ButterKnife.bind(this, inflate);
        mPresenter = initPresenter();
        if (mPresenter!=null){
            mPresenter.bind((V)this);
        }
        initData();
        initView();
        initListener();
        return inflate;
    }

    protected void initData() {

    }

    protected void initListener() {

    }

    protected void initView() {

    }

    protected abstract P initPresenter();

    protected abstract int getLayoutId();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBind.unbind();
        mPresenter.onDestroy();
        mPresenter = null;
    }
}
