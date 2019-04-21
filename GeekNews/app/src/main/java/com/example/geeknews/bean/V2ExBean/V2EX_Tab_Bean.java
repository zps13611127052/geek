package com.example.geeknews.bean.V2ExBean;

/**
 * Created by 张十八 on 2019/4/19.
 */

public class V2EX_Tab_Bean {
    public String link;
    public String tab;

    public V2EX_Tab_Bean(String link, String tab) {
        this.link = link;
        this.tab = tab;
    }

    @Override
    public String toString() {
        return "V2EX_Tab_Bean{" +
                "link='" + link + '\'' +
                ", tab='" + tab + '\'' +
                '}';
    }
}
