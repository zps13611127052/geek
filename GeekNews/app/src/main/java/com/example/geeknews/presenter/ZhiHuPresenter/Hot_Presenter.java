package com.example.geeknews.presenter.ZhiHuPresenter;

import com.example.geeknews.api.ResultCallBack;
import com.example.geeknews.base.BasePresenter;
import com.example.geeknews.bean.ZhiHuDailyBean.Hot_Bean;
import com.example.geeknews.model.ZhiHuModel.Hot_Model;
import com.example.geeknews.view.ZhiHuView.Hot_View;

/**
 * Created by 张十八 on 2019/4/17.
 */

public class Hot_Presenter extends BasePresenter<Hot_View> implements ResultCallBack<Hot_Bean> {

    private Hot_Model mModel;

    @Override
    public void onSucceed(Hot_Bean bean) {
        if (mView!=null){
            mView.onSucceed(bean);
        }
    }

    @Override
    public void onFail(String msg) {
        if (mView!=null){
            mView.onFaliued(msg);
        }
    }

    @Override
    protected void initModel() {
        mModel = new Hot_Model();
    }
    public void initData(){
        mModel.initData(this);
    }
}
