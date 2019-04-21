package com.example.geeknews.model.ZhiHuModel;

import com.example.geeknews.api.ApiServer;
import com.example.geeknews.api.ResultCallBack;
import com.example.geeknews.api.ZhiHu_ApiServers;
import com.example.geeknews.base.BaseModel;
import com.example.geeknews.bean.ZhiHuDailyBean.Special_Bean;

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

public class Special_Model extends BaseModel {

    public void initData(final ResultCallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ZhiHu_ApiServers.Url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ZhiHu_ApiServers servers = retrofit.create(ZhiHu_ApiServers.class);
        Observable<Special_Bean> data = servers.getSpecialData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Special_Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Special_Bean value) {
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
