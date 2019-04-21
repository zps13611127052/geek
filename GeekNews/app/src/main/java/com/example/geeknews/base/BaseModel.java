package com.example.geeknews.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by 张十八 on 2019/4/3.
 */

public class BaseModel {
    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    public void onDestory() {
        mCompositeDisposable.clear();
    }
}
