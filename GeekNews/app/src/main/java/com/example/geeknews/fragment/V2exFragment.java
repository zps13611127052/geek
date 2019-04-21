package com.example.geeknews.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;

import com.example.geeknews.R;
import com.example.geeknews.adapter.ZhiHuAdapter.V2EXAdapter.V2EX_Vp_Adapter;
import com.example.geeknews.base.BaseFragment;
import com.example.geeknews.bean.V2ExBean.V2EX_Tab_Bean;
import com.example.geeknews.fragment.v2exfragment.V2EX_Fragment_item;
import com.example.geeknews.presenter.V2exP;
import com.example.geeknews.view.V2exV;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by 张十八 on 2019/4/3.
 */

public class V2exFragment extends BaseFragment<V2exV, V2exP> implements V2exV {
    private static final String TAG = "V2exFragment";
    @BindView(R.id.tab_id)
    TabLayout mTabId;
    @BindView(R.id.img_id)
    ImageView mImgId;
    @BindView(R.id.vp_id)
    ViewPager mVpId;
    private String mUrl = "https://www.v2ex.com/";
    private  ArrayList<V2EX_Tab_Bean> mTab_list = new ArrayList<>();

    @Override
    protected V2exP initPresenter() {
        return new V2exP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_v2exfragment;
    }

    @Override
    protected void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document doc = Jsoup.connect(mUrl).get();
                    Element tabs = doc.select("div#Tabs").first();
                    Elements allTabs = tabs.select("a[href]");
                    for (Element emt :allTabs) {
                        String href = emt.attr("href");
                        String tab = emt.text();
                        V2EX_Tab_Bean bean = new V2EX_Tab_Bean(href,tab);
                        mTab_list.add(bean);
                    }
                     final ArrayList<BaseFragment> mFragments = new ArrayList<>();
                    for (int i = 0; i < mTab_list.size(); i++) {
                        Log.i(TAG, "initView: "+mTab_list.get(i).toString());
                        V2EX_Fragment_item item = new V2EX_Fragment_item(mTab_list.get(i).tab);
                        mFragments.add(item);
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            V2EX_Vp_Adapter adapter = new V2EX_Vp_Adapter(getChildFragmentManager(),mTab_list,mFragments);
                            mVpId.setAdapter(adapter);
                            mTabId.setupWithViewPager(mVpId);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
