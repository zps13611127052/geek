package com.example.geeknews.fragment.ZhiHuDailyFragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geeknews.R;
import com.example.geeknews.adapter.ZhiHuAdapter.Hot_Rly_Adapter;
import com.example.geeknews.base.BaseFragment;
import com.example.geeknews.bean.ZhiHuDailyBean.Hot_Bean;
import com.example.geeknews.presenter.ZhiHuPresenter.Hot_Presenter;
import com.example.geeknews.view.ZhiHuView.Hot_View;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 张十八 on 2019/4/17.
 */

public class Hot_Fragment extends BaseFragment<Hot_View, Hot_Presenter> implements Hot_View {

    @BindView(R.id.recy_id)
    RecyclerView mRecyId;
    Unbinder unbinder;
    private Hot_Rly_Adapter mAdapter;

    @Override
    protected Hot_Presenter initPresenter() {
        return new Hot_Presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.hot_fragment;
    }

    @Override
    protected void initView() {
        mRecyId.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected void initData() {
        mPresenter.initData();
    }

    @Override
    public void onSucceed(Hot_Bean bean) {
        if (bean != null) {
            List<Hot_Bean.RecentBean> list = bean.getRecent();
            mAdapter = new Hot_Rly_Adapter(getActivity(),list);
            mAdapter.notifyDataSetChanged();
            mRecyId.setAdapter(mAdapter);
        }
    }

    @Override
    public void onFaliued(String str) {
        Log.i("Hot_Fragment", "onFaliued: "+str);
    }

}
