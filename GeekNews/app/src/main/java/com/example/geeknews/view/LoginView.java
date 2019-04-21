package com.example.geeknews.view;

import com.example.geeknews.base.BaseMvpView;

/**
 * Created by 张十八 on 2019/4/3.
 */

public interface LoginView extends BaseMvpView {
    void setData(String str);

    String getUserName();
    String getPsd();

    void showToast(String msg);
}
