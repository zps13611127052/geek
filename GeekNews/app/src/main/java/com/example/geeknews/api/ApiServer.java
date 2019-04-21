package com.example.geeknews.api;

import com.example.geeknews.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 张十八 on 2019/4/3.
 */

public interface ApiServer {
    String Url= "http://yun918.cn/study/public/index.php/";
    @FormUrlEncoded
    @POST("login")
    Observable<LoginBean>login(@Field("username") String name,@Field("password")String psd);

}
