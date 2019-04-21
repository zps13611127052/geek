package com.example.geeknews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.geeknews.R;
import com.example.geeknews.adapter.ZhiHuAdapter.GoldAdapter.Show_Rly_Adapter;
import com.example.geeknews.base.BaseActivity;
import com.example.geeknews.base.Constants;
import com.example.geeknews.bean.GoldBean.Gold_Show_Bean;
import com.example.geeknews.presenter.EmptyP;
import com.example.geeknews.view.EmptyV;
import com.example.geeknews.widget.SimpleToachHelperCallBack;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.transform.Result;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends BaseActivity<EmptyV, EmptyP> implements EmptyV {

    @BindView(R.id.toolbar_id)
    Toolbar mToolbarId;
    @BindView(R.id.recy_id)
    RecyclerView mRecyId;
    private ArrayList<Gold_Show_Bean> mBean;

    @Override
    protected EmptyP initPresenter() {
        return new EmptyP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_show;
    }

    @Override
    protected void initView() {
        mBean = (ArrayList<Gold_Show_Bean>) getIntent().getSerializableExtra(Constants.DATA);

        mToolbarId.setTitle("首页特别展示");
        mToolbarId.setNavigationIcon(R.drawable.back);
        setSupportActionBar(mToolbarId);

        mToolbarId.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAct();
            }
        });

        mRecyId.setLayoutManager(new LinearLayoutManager(this));

        Show_Rly_Adapter adapter = new Show_Rly_Adapter(mBean);
        mRecyId.setAdapter(adapter);
        mRecyId.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        SimpleToachHelperCallBack callBack = new SimpleToachHelperCallBack(adapter);
        callBack.setSwipeable(false);
        ItemTouchHelper helper = new ItemTouchHelper(callBack);
        helper.attachToRecyclerView(mRecyId);
    }

    private void finishAct() {
        Intent intent = new Intent();
        intent.putExtra(Constants.DATA,mBean);
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        finishAct();
    }
}