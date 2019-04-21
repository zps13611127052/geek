package com.example.geeknews.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geeknews.R;
import com.example.geeknews.adapter.ZhiHuAdapter.WeChatAdapter.Wx_Rly_Adapter;
import com.example.geeknews.base.BaseFragment;
import com.example.geeknews.bean.WeChatBean.WeChat_Bean;
import com.example.geeknews.presenter.WeChatP;
import com.example.geeknews.view.WeChatV;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 张十八 on 2019/4/3.
 */

public class WeChatFragment extends BaseFragment<WeChatV, WeChatP> implements WeChatV, OnRefreshListener, OnLoadmoreListener {
    private static final String TAG = "WeChatFragment";
    @BindView(R.id.recy_id)
    RecyclerView mRecyId;

    @BindView(R.id.scrim_id)
    SmartRefreshLayout mScrimId;

    private int num = 10;
    private int page = 1;
    private List<WeChat_Bean.NewslistBean> mList;

    @Override
    protected WeChatP initPresenter() {
        return new WeChatP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wechatfragment;
    }

    @Override
    protected void initData() {
        mPresenter.initData(num, page);
    }

    @Override
    protected void initView() {
        mRecyId.setLayoutManager(new LinearLayoutManager(getContext()));

        mScrimId.setOnRefreshListener(this).setOnLoadmoreListener(this);
        mScrimId.setRefreshHeader(new BezierRadarHeader(getContext()).setEnableHorizontalDrag(true));
        mScrimId.setRefreshFooter(new BallPulseFooter(getContext()).setSpinnerStyle(SpinnerStyle.Scale));
    }

    @Override
    public void onSucceedWeChatData(WeChat_Bean bean) {
        if (bean != null && bean.getCode() == 200) {
            mList = bean.getNewslist();
            Wx_Rly_Adapter adapter = new Wx_Rly_Adapter(getActivity(), mList);
            adapter.notifyDataSetChanged();
            mRecyId.setAdapter(adapter);
        }
    }

    @Override
    public void onFaliuedWeChatData(String str) {
        Log.i(TAG, "onFaliuedWeChatData: " + str);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mList.clear();
        page = 1;
        mPresenter.initData(num,page);
        refreshlayout.finishRefresh(2000);
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        page++;
        mPresenter.initData(num,page);

        refreshlayout.finishRefresh(3000);
    }
}
