package com.example.geeknews.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.geeknews.R;
import com.example.geeknews.activity.ShowActivity;
import com.example.geeknews.adapter.ZhiHuAdapter.GoldAdapter.Gold_Vp_Adapter;
import com.example.geeknews.base.BaseFragment;
import com.example.geeknews.base.Constants;
import com.example.geeknews.bean.GoldBean.Gold_Show_Bean;
import com.example.geeknews.fragment.goldfragment.Gold_Detail_Fragment;
import com.example.geeknews.presenter.GoldP;
import com.example.geeknews.view.GoldV;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 张十八 on 2019/4/3.
 */

public class GoldFragment extends BaseFragment<GoldV, GoldP> implements GoldV {
    @BindView(R.id.tab_id)
    TabLayout mTabId;
    @BindView(R.id.img_id)
    ImageView mImgId;
    @BindView(R.id.vp_id)
    ViewPager mVpId;
    private ArrayList<Gold_Show_Bean> mTitles;
    private ArrayList<BaseFragment> mFragments;
    private ArrayList<Gold_Show_Bean> mBeans;

    @Override
    protected GoldP initPresenter() {
        return new GoldP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goldfragment;
    }

    @Override
    protected void initView() {
        initTitle();
        setFragment();

        mImgId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go2Activity();
            }
        });
    }

    private void setFragment() {
        initFragment();

        Gold_Vp_Adapter adapter = new Gold_Vp_Adapter(getChildFragmentManager(),mTitles,mFragments);
        mVpId.setAdapter(adapter);
        mTabId.setupWithViewPager(mVpId);
    }

    private void go2Activity() {
        Intent intent = new Intent(getContext(), ShowActivity.class);
        intent.putExtra(Constants.DATA,mTitles);
        startActivityForResult(intent,100);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == Activity.RESULT_OK){
            mTitles = (ArrayList<Gold_Show_Bean>) data.getSerializableExtra(Constants.DATA);
            setFragment();
        }
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        for (int i = 0; i < mTitles.size(); i++) {
            if (mTitles.get(i).isChecked){
                mFragments.add(Gold_Detail_Fragment.newinstance(mTitles.get(i).title));
            }
        }
    }

    private void initTitle() {
        mTitles = new ArrayList<>();
        mTitles.add(new Gold_Show_Bean("Android",true));
        mTitles.add(new Gold_Show_Bean("iOS",true));
        mTitles.add(new Gold_Show_Bean("前端",true));
        mTitles.add(new Gold_Show_Bean("后端",true));
        mTitles.add(new Gold_Show_Bean("设计",true));
        mTitles.add(new Gold_Show_Bean("产品",true));
        mTitles.add(new Gold_Show_Bean("阅读",true));
        mTitles.add(new Gold_Show_Bean("工具资源",true));
    }

}
