package com.example.geeknews.presenter.ZhiHuPresenter;

import com.example.geeknews.api.ResultCallBack;
import com.example.geeknews.base.BasePresenter;
import com.example.geeknews.bean.ZhiHuDailyBean.Daily_Last_Bean;
import com.example.geeknews.model.ZhiHuModel.Daily_Last_Model;
import com.example.geeknews.view.ZhiHuView.Daily_Last_View;
import com.example.geeknews.view.ZhiHuView.Daily_View;

/**
 * Created by 张十八 on 2019/4/18.
 */

public class Daily_Last_Presenter extends BasePresenter<Daily_Last_View> implements ResultCallBack<Daily_Last_Bean>{

    private Daily_Last_Model mModel;

    @Override
    protected void initModel() {
        mModel = new Daily_Last_Model();
    }

    public void initData(String data){
        mModel.initData(this,data);
    }

    @Override
    public void onSucceed(Daily_Last_Bean bean) {
        if (mView!=null){
            mView.onSucceedLast(bean);
        }
    }

    @Override
    public void onFail(String msg) {
        if (mView!=null){
            mView.onFaliuedLast(msg);
        }
    }
}
