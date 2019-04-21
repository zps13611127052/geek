package com.example.geeknews.presenter;

import com.example.geeknews.api.ResultCallBack;
import com.example.geeknews.base.BasePresenter;
import com.example.geeknews.bean.WeChatBean.WeChat_Bean;
import com.example.geeknews.model.WeChat.WeChat_Model;
import com.example.geeknews.view.WeChatV;

/**
 * Created by 张十八 on 2019/4/3.
 */

public class WeChatP extends BasePresenter<WeChatV> implements ResultCallBack<WeChat_Bean> {

    private WeChat_Model mModel;

    @Override
    protected void initModel() {
        mModel = new WeChat_Model();
    }
    public void initData(int num,int page){
        mModel.initData(this,num,page);
    }

    @Override
    public void onSucceed(WeChat_Bean bean) {
        if (mView!=null){
            mView.onSucceedWeChatData(bean);
        }
    }

    @Override
    public void onFail(String msg) {
        if (mView!=null){
            mView.onFaliuedWeChatData(msg);
        }
    }
}
