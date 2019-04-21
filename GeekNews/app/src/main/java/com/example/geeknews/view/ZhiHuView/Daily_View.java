package com.example.geeknews.view.ZhiHuView;

import com.example.geeknews.base.BaseMvpView;
import com.example.geeknews.bean.ZhiHuDailyBean.Daily_Bean;

/**
 * Created by 张十八 on 2019/4/17.
 */

public interface Daily_View extends BaseMvpView{
    void onSucceedDailyData(Daily_Bean bean);
    void onFaliuedDailyData(String str);
}
