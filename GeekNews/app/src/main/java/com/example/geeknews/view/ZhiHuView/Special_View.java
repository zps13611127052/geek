package com.example.geeknews.view.ZhiHuView;

import com.example.geeknews.base.BaseMvpView;
import com.example.geeknews.bean.ZhiHuDailyBean.Special_Bean;

/**
 * Created by 张十八 on 2019/4/17.
 */

public interface Special_View extends BaseMvpView{
    void onSucceedData(Special_Bean bean);
    void onFaliuedData(String str);
}
