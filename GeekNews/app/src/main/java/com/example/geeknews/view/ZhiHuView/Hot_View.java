package com.example.geeknews.view.ZhiHuView;

import com.example.geeknews.base.BaseMvpView;
import com.example.geeknews.bean.ZhiHuDailyBean.Hot_Bean;

/**
 * Created by 张十八 on 2019/4/17.
 */

public interface Hot_View extends BaseMvpView{
    void onSucceed(Hot_Bean bean);
    void onFaliued(String str);
}
