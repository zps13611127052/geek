package com.example.geeknews.presenter.ZhiHuPresenter;

import com.example.geeknews.api.ResultCallBack;
import com.example.geeknews.base.BasePresenter;
import com.example.geeknews.bean.ZhiHuDailyBean.Special_Bean;
import com.example.geeknews.model.ZhiHuModel.Special_Model;
import com.example.geeknews.view.ZhiHuView.Special_View;

/**
 * Created by 张十八 on 2019/4/17.
 */

public class Special_Presenter extends BasePresenter<Special_View> implements ResultCallBack<Special_Bean>{

    private Special_Model mModel;

    @Override
    public void onSucceed(Special_Bean bean) {
        if (mView!=null){
            mView.onSucceedData(bean);
        }
    }

    @Override
    public void onFail(String msg) {
        if (mView!=null){
            mView.onFaliuedData(msg);
        }
    }

    @Override
    protected void initModel() {
        mModel = new Special_Model();
    }

    public void initData(){
        mModel.initData(this);
    }
}
