package com.example.geeknews.fragment.goldfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.geeknews.R;
import com.example.geeknews.base.BaseFragment;
import com.example.geeknews.base.Constants;
import com.example.geeknews.presenter.EmptyP;
import com.example.geeknews.view.EmptyV;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 张十八 on 2019/4/3.
 */

public class Gold_Detail_Fragment extends BaseFragment<EmptyV, EmptyP> implements EmptyV {

    @BindView(R.id.tv_id)
    TextView mTvId;
    Unbinder unbinder;

    public static Gold_Detail_Fragment newinstance(String text) {
        Gold_Detail_Fragment fragment = new Gold_Detail_Fragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.DATA, text);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected EmptyP initPresenter() {
        return new EmptyP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.gold_detail_fragment;
    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        String data = bundle.getString(Constants.DATA);
        mTvId.setText(data);
    }

}
