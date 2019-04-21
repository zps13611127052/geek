package com.example.geeknews.model.ZhiHuModel;

import com.example.geeknews.api.ResultCallBack;
import com.example.geeknews.api.ZhiHu_ApiServers;
import com.example.geeknews.base.BaseModel;
import com.example.geeknews.bean.ZhiHuDailyBean.Hot_Bean;
import com.example.geeknews.presenter.ZhiHuPresenter.Hot_Presenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 张十八 on 2019/4/17.
 */

public class Hot_Model extends BaseModel {

    public void initData(final ResultCallBack<Hot_Bean> callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ZhiHu_ApiServers.Url)
                .build();

        ZhiHu_ApiServers servers = retrofit.create(ZhiHu_ApiServers.class);
        Observable<Hot_Bean> data = servers.getHotData();

        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Hot_Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Hot_Bean value) {
                        if (value!=null){
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
