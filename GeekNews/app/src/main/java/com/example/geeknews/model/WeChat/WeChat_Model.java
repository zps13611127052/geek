package com.example.geeknews.model.WeChat;

import com.example.geeknews.api.ResultCallBack;
import com.example.geeknews.api.WeChatServers;
import com.example.geeknews.base.BaseModel;
import com.example.geeknews.bean.WeChatBean.WeChat_Bean;
import com.example.geeknews.presenter.WeChatP;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 张十八 on 2019/4/18.
 */

public class WeChat_Model extends BaseModel {
    public void initData(final ResultCallBack<WeChat_Bean> callBack, final int num, int page) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WeChatServers.Url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeChatServers servers = retrofit.create(WeChatServers.class);

        Observable<WeChat_Bean> data = servers.getWeChatData(num, page);
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeChat_Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WeChat_Bean value) {
                        if (value!=null&&value.getCode()==200){
                            callBack.onSucceed(value);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
