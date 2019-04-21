package com.example.geeknews.api;

import com.example.geeknews.bean.LoginBean;

/**
 * Created by 张十八 on 2019/4/3.
 */

public interface ResultCallBack<T> {
    void onSucceed(T bean);
    void onFail(String msg);
}
