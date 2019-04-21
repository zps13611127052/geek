package com.example.geeknews.bean.GoldBean;

import java.io.Serializable;

/**
 * Created by 张十八 on 2019/4/19.
 */

public class Gold_Show_Bean implements Serializable{
    public String title;
    public boolean isChecked;

    public Gold_Show_Bean(String title, boolean isChecked) {
        this.title = title;
        this.isChecked = isChecked;
    }
}
