package com.example.geeknews.fragment.ZhiHuDailyFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geeknews.R;
import com.example.geeknews.activity.CalendarActivity;
import com.example.geeknews.adapter.ZhiHuAdapter.Daily_Rly_Adapter;
import com.example.geeknews.base.BaseFragment;
import com.example.geeknews.bean.ZhiHuDailyBean.Daily_Bean;
import com.example.geeknews.bean.ZhiHuDailyBean.Daily_Last_Bean;
import com.example.geeknews.presenter.ZhiHuPresenter.Daily_Last_Presenter;
import com.example.geeknews.presenter.ZhiHuPresenter.Daily_Presenter_Impl;
import com.example.geeknews.view.ZhiHuView.Daily_Last_View;
import com.example.geeknews.view.ZhiHuView.Daily_View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 张十八 on 2019/4/17.
 */

public class Daily_Fragment extends BaseFragment<Daily_View, Daily_Presenter_Impl> implements Daily_View ,Daily_Last_View{
    private static final String TAG = "Daily_Fragment";
    @BindView(R.id.recy_id)
    RecyclerView mRecyId;
    @BindView(R.id.floatbutton)
    FloatingActionButton mFloatbutton;
    private ArrayList<Daily_Bean.StoriesBean> mtitles = new ArrayList<>();
    private ArrayList<Daily_Bean.TopStoriesBean> mbanners = new ArrayList<>();
    private Daily_Rly_Adapter mAdapter;
    private String mdata = "";

    @Override
    protected Daily_Presenter_Impl initPresenter() {
        return new Daily_Presenter_Impl();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.daily_fragment;
    }

    @Override
    protected void initData() {
        mPresenter.initdata();
    }

    @Override
    protected void initView() {
//        EventBus.getDefault().register(getActivity());
        mRecyId.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    public void onSucceedDailyData(Daily_Bean bean) {
        if (bean != null) {
            List<Daily_Bean.StoriesBean> items = bean.getStories();
            List<Daily_Bean.TopStoriesBean> top_items = bean.getTop_stories();
            String date = bean.getDate();

            mAdapter = new Daily_Rly_Adapter(getActivity(), items, top_items, date);
            mAdapter.notifyDataSetChanged();
            mRecyId.setAdapter(mAdapter);
        }
    }

    @Override
    public void onFaliuedDailyData(String str) {
        Log.i(TAG, "onFaliuedDailyData: " + str);
    }

    @Override
    protected void initListener() {
        mFloatbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CalendarActivity.class);
                startActivity(intent);
            }
        });
    }

//    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
//    public void getDate(String date){
//        Daily_Last_Presenter presenter = new Daily_Last_Presenter();
//        presenter.initData(date);
//    }

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//       // EventBus.getDefault().unregister(getActivity());
//    }

    @Override
    public void onSucceedLast(Daily_Last_Bean bean) {
        if (bean!=null&&bean.getStories().size()>0){
            List<Daily_Last_Bean.StoriesBean> list = bean.getStories();
            //String date = bean.getDate();

//            mAdapter = new Daily_Rly_Adapter(getActivity(),list, date);
//            mAdapter.notifyDataSetChanged();
//            mRecyId.setAdapter(mAdapter);

        }
    }

    @Override
    public void onFaliuedLast(String str) {

    }
}
