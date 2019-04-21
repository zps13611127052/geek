package com.example.geeknews.api;
import com.example.geeknews.bean.WeChatBean.WeChat_Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 张十八 on 2019/4/18.
 */

public interface WeChatServers {
    String Url = "http://api.tianapi.com/";
    @GET("wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c")
    Observable<WeChat_Bean> getWeChatData(@Query("num") int num, @Query("page") int page);
}
