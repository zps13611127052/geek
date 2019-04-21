package com.example.geeknews.view.ZhiHuView;

import com.example.geeknews.base.BaseMvpView;
import com.example.geeknews.bean.ZhiHuDailyBean.Daily_Last_Bean;

/**
 * Created by 张十八 on 2019/4/18.
 */

public interface Daily_Last_View extends BaseMvpView{
    void onSucceedLast(Daily_Last_Bean bean);
    void onFaliuedLast(String str);
}
