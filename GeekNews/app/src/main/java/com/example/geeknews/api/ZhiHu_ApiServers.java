package com.example.geeknews.api;

import com.example.geeknews.bean.ZhiHuDailyBean.Daily_Bean;
import com.example.geeknews.bean.ZhiHuDailyBean.Daily_Last_Bean;
import com.example.geeknews.bean.ZhiHuDailyBean.Hot_Bean;
import com.example.geeknews.bean.ZhiHuDailyBean.Special_Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by 张十八 on 2019/4/17.
 */

public interface ZhiHu_ApiServers {
    String Url = "http://news-at.zhihu.com/api/4/";
    @GET("news/latest")
    Observable<Daily_Bean> getDailyData();

    @GET("sections")
    Observable<Special_Bean>getSpecialData();

    @GET("news/hot")
    Observable<Hot_Bean>getHotData();

    @GET("news/before/{date}")
    Observable<Daily_Last_Bean>getLastData(@Path("data") String data);
}
