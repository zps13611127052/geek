package com.example.geeknews.model;

import com.example.geeknews.api.ApiServer;
import com.example.geeknews.api.ResultCallBack;
import com.example.geeknews.base.BaseModel;
import com.example.geeknews.bean.LoginBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 张十八 on 2019/4/3.
 */

public class LoginM extends BaseModel {
    public void login(String name, String psd, final ResultCallBack resultCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiServer.Url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiServer server = retrofit.create(ApiServer.class);

        Observable<LoginBean> login = server.login(name, psd);

        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(LoginBean value) {
                        resultCallBack.onSucceed(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        resultCallBack.onFail(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
