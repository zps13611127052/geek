package com.example.geeknews.fragment.v2exfragment;

import android.annotation.SuppressLint;
import android.widget.TextView;

import com.example.geeknews.R;
import com.example.geeknews.base.BaseFragment;
import com.example.geeknews.presenter.V2EXPresenter.V2EX_Presenter;
import com.example.geeknews.view.V2EXView.V2EX_View;

import butterknife.BindView;

/**
 * Created by 张十八 on 2019/4/19.
 */

@SuppressLint("ValidFragment")
public class V2EX_Fragment_item extends BaseFragment<V2EX_View, V2EX_Presenter> implements V2EX_View {
    @BindView(R.id.tv_id)
    TextView mTvId;
    public String name = "";

    @SuppressLint("ValidFragment")
    public V2EX_Fragment_item(String tab) {
        super();
        name = tab;
    }

    @Override
    protected V2EX_Presenter initPresenter() {
        return new V2EX_Presenter();
    }

    @Override
    protected void initView() {
        mTvId.setText(name);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.v2ex_fragment_item;
    }
}
