package com.example.geeknews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by 张十八 on 2019/4/3.
 */

public abstract class BaseActivity<T extends BaseMvpView,P extends BasePresenter>
        extends AppCompatActivity implements BaseMvpView{

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mPresenter = initPresenter();
        if (mPresenter !=null){
            mPresenter.bind((BaseMvpView) this);
        }
        initView();
        initListener();
        initData();
    }

    protected abstract P initPresenter();

    protected void initData() {

    }

    protected void initListener() {

    }

    protected void initView() {

    }

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
        mPresenter = null;
    }
}
