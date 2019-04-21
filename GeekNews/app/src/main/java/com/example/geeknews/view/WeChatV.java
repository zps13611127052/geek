package com.example.geeknews.view;

import com.example.geeknews.base.BaseMvpView;
import com.example.geeknews.bean.WeChatBean.WeChat_Bean;

/**
 * Created by 张十八 on 2019/4/3.
 */

public interface WeChatV extends BaseMvpView {
    void onSucceedWeChatData(WeChat_Bean bean);
    void onFaliuedWeChatData(String str);
}
