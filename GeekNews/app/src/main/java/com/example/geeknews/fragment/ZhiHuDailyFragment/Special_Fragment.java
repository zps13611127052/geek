package com.example.geeknews.fragment.ZhiHuDailyFragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geeknews.R;
import com.example.geeknews.adapter.ZhiHuAdapter.Special_Rly_Adapter;
import com.example.geeknews.base.BaseFragment;
import com.example.geeknews.bean.ZhiHuDailyBean.Special_Bean;
import com.example.geeknews.presenter.ZhiHuPresenter.Special_Presenter;
import com.example.geeknews.view.ZhiHuView.Special_View;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 张十八 on 2019/4/17.
 */

public class Special_Fragment extends BaseFragment<Special_View, Special_Presenter> implements Special_View {

    private static final String TAG = "Special_Fragment";
    @BindView(R.id.recy_id)
    RecyclerView mRecyId;
    Unbinder unbinder;
    private Special_Rly_Adapter mAdapter;

    @Override
    protected Special_Presenter initPresenter() {
        return new Special_Presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.special_fragment;
    }

    @Override
    protected void initView() {
        mRecyId.setLayoutManager(new GridLayoutManager(getContext(),2));
    }

    @Override
    protected void initData() {
        mPresenter.initData();
    }

    @Override
    public void onSucceedData(Special_Bean bean) {
        if (bean != null) {
            List<Special_Bean.DataBean> data = bean.getData();
            mAdapter = new Special_Rly_Adapter(getActivity(),data);
            mAdapter.notifyDataSetChanged();
            mRecyId.setAdapter(mAdapter);
        }
    }
    @Override
    public void onFaliuedData(String str) {
        Log.i(TAG, "onFaliuedData: "+str);
    }

}
