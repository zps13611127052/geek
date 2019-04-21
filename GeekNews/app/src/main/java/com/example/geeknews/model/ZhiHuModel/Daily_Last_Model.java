package com.example.geeknews.model.ZhiHuModel;

import com.example.geeknews.api.ResultCallBack;
import com.example.geeknews.api.ZhiHu_ApiServers;
import com.example.geeknews.base.BaseModel;
import com.example.geeknews.bean.ZhiHuDailyBean.Daily_Last_Bean;
import com.example.geeknews.presenter.ZhiHuPresenter.Daily_Last_Presenter;

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

public class Daily_Last_Model extends BaseModel {

    public void initData(final ResultCallBack<Daily_Last_Bean> callBack, String data) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ZhiHu_ApiServers.Url)
                .build();

        ZhiHu_ApiServers servers = retrofit.create(ZhiHu_ApiServers.class);
        Observable<Daily_Last_Bean> data1 = servers.getLastData(data);
        data1.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Daily_Last_Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Daily_Last_Bean value) {
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
