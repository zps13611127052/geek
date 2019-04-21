package com.example.geeknews.presenter;

import android.text.TextUtils;

import com.example.geeknews.api.ResultCallBack;
import com.example.geeknews.base.BasePresenter;
import com.example.geeknews.bean.LoginBean;
import com.example.geeknews.model.LoginM;
import com.example.geeknews.utils.Logger;
import com.example.geeknews.view.LoginView;

/**
 * Created by 张十八 on 2019/4/3.
 */

public class LoginP extends BasePresenter<LoginView> {

    private LoginM mMainM;

    public void getData(){
        //假设获取网络数据
        String data = "123456";
        if (mView!=null){
            mView.setData(data);
        }
    }

    public void login() {
        String name = mView.getUserName();
        String psd = mView.getPsd();

        if (TextUtils.isEmpty(name)||TextUtils.isEmpty(psd)){
            //ToastUtil.showShort("账号或者密码不能为空");
            mView.showToast("账号或者密码不能为空");
            return;
        }

        //网络请求
        mMainM.login(name,psd, new ResultCallBack<LoginBean>() {
            @Override
            public void onSucceed(LoginBean bean) {
                Logger.logD("tag",bean.toString());
                if (bean!=null){
                    if (bean.getCode()==200){
                        if (mView!=null){
                            mView.showToast("登录成功");
                        }
                    }else {
                        if (mView!=null){
                            mView.showToast("登录失败");

                        }
                    }
                }
            }

            @Override
            public void onFail(String msg) {
                Logger.logD("tag",msg);
                if (mView!=null){
                    mView.showToast("失败");
                }
            }
        });
    }

    @Override
    protected void initModel() {
        mMainM = new LoginM();
        mModels.add(mMainM);
    }
}
