package com.example.geeknews.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geeknews.R;
import com.example.geeknews.base.BaseActivity;
import com.example.geeknews.base.BasePresenter;
import com.example.geeknews.presenter.WeChat.KongPresenter;
import com.example.geeknews.view.WeChat.KongView;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CalendarActivity extends BaseActivity<KongView,KongPresenter> implements View.OnClickListener {


    @BindView(R.id.toolbar_id)
    Toolbar mToolbarId;
    @BindView(R.id.dataView_id)
    MaterialCalendarView mDataViewId;
    @BindView(R.id.regit_data)
    TextView mRegitData;
    @BindView(R.id.toolbar_img)
    ImageView mToolbarImg;
    private CalendarDay mDate;

    @Override
    protected KongPresenter initPresenter() {
        return new KongPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_calendar;
    }

    @Override
    protected void initView() {
        mDataViewId.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                mDate = date;
            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mRegitData.setOnClickListener(this);

        mToolbarImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regit_data:
                String ss = "";
                Date date = mDate.getDate();
                SimpleDateFormat format = new SimpleDateFormat("yyyy--MM--dd");
                String format1 = format.format(date);
                char[] chars = format1.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (Character.isDigit(chars[i])){
                        ss += chars[i]+"";
                    }
                }
                Toast.makeText(this, ss, Toast.LENGTH_SHORT).show();
                EventBus.getDefault().postSticky(ss);
                finish();
                break;
        }
    }
}
