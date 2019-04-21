package com.example.geeknews.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.geeknews.R;
import com.example.geeknews.base.BaseActivity;
import com.example.geeknews.presenter.LoginP;
import com.example.geeknews.utils.ToastUtil;
import com.example.geeknews.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginView, LoginP> implements LoginView {
    @BindView(R.id.bt_1)
    Button mBt1;
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_psd)
    EditText mEtPsd;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    @Override
    protected LoginP initPresenter() {
        return new LoginP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_1)
    public void onViewClicked() {
       // mPresenter.getData();
        mPresenter.login();
    }

    @Override
    public void setData(String str) {
        mBt1.setText(str + "");
    }

    @Override
    public String getUserName() {
        return mEtName.getText().toString().trim();
    }

    @Override
    public String getPsd() {
        return mEtPsd.getText().toString().trim();
    }

    @Override
    public void showToast(String msg) {
        ToastUtil.showShort(msg);
    }
}
