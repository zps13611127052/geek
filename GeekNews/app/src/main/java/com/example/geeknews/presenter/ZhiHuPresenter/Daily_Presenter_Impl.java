package com.example.geeknews.presenter.ZhiHuPresenter;

import com.example.geeknews.api.ResultCallBack;
import com.example.geeknews.base.BasePresenter;
import com.example.geeknews.bean.ZhiHuDailyBean.Daily_Bean;
import com.example.geeknews.model.ZhiHuModel.Daily_Model_impl;
import com.example.geeknews.view.ZhiHuView.Daily_View;

/**
 * Created by 张十八 on 2019/4/17.
 */

public class Daily_Presenter_Impl extends BasePresenter<Daily_View> implements ResultCallBack<Daily_Bean> {

    protected Daily_Model_impl mModel_impl;

    @Override
    public void onSucceed(Daily_Bean bean) {
        if (bean!=null){
            if (mView!=null){
                mView.onSucceedDailyData(bean);
            }
        }
    }

    @Override
    public void onFail(String msg) {
        if (mView!=null){
            mView.onFaliuedDailyData(msg);
        }
    }

    @Override
    protected void initModel() {
        mModel_impl = new Daily_Model_impl();
    }

    public void initdata(){
        mModel_impl.initData(this);
    }
}
