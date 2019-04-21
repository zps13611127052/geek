package com.example.geeknews.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.geeknews.R;
import com.example.geeknews.base.BaseActivity;
import com.example.geeknews.fragment.AboutFragment;
import com.example.geeknews.fragment.CollecFragment;
import com.example.geeknews.fragment.GankFragment;
import com.example.geeknews.fragment.GoldFragment;
import com.example.geeknews.fragment.SettingFragment;
import com.example.geeknews.fragment.V2exFragment;
import com.example.geeknews.fragment.WeChatFragment;
import com.example.geeknews.fragment.ZhiHuNewsFragment;
import com.example.geeknews.presenter.MainP;
import com.example.geeknews.view.MainView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainView, MainP> implements MainView {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.fragment_container)
    FrameLayout mFragmentContainer;
    @BindView(R.id.na)
    NavigationView mNa;
    @BindView(R.id.dr)
    DrawerLayout mDr;
    @BindView(R.id.ToolBarTitle)
    TextView mToolBarTitle;
    @BindView(R.id.search_view)
    MaterialSearchView mSearchView;
    private ArrayList<Fragment> mFragments;
    private ArrayList<Integer> mTitles;
    private FragmentManager mManager;
    private final int TYPE_ZHIHU = 0;
    private final int TYPE_WECHART = 1;
    private final int TYPE_GANK = 2;
    private final int TYPE_GOLD = 3;
    private final int TYPE_V2EX = 4;
    private final int TYPE_COLLEC = 5;
    private final int TYPE_SETTING = 6;
    private final int TYPE_ABOUT = 7;
    private int mListFragmentPosition;
    private MenuItem mSearchitem;

    @Override
    protected MainP initPresenter() {
        return new MainP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        //给toolbar标题设置白色

        mManager = getSupportFragmentManager();
        mToolbar.setTitle("");
        mToolBarTitle.setTextColor(getResources().getColor(R.color.write));
        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDr, mToolbar, R.string.about, R.string.about);
        //给侧滑按钮设置白色
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.write));
        mDr.addDrawerListener(toggle);
        toggle.syncState();

        initTitles();
        initFragment();
        addFirstFragment();
    }

    private void addFirstFragment() {
        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.add(R.id.fragment_container, mFragments.get(0));
        transaction.commit();
        mToolBarTitle.setText(R.string.zhihu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);

        mSearchitem = menu.findItem(R.id.action_search);
        mSearchitem.setVisible(false);
        mSearchView.setMenuItem(mSearchitem);

        return true;
    }

    private void initTitles() {
        mTitles = new ArrayList<>();
        mTitles.add(R.string.zhihu);
        mTitles.add(R.string.wechat);
        mTitles.add(R.string.gank);
        mTitles.add(R.string.gold);
        mTitles.add(R.string.v2ex);
        mTitles.add(R.string.collect);
        mTitles.add(R.string.setting);
        mTitles.add(R.string.about);
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(new ZhiHuNewsFragment());
        mFragments.add(new WeChatFragment());
        mFragments.add(new GankFragment());
        mFragments.add(new GoldFragment());
        mFragments.add(new V2exFragment());
        mFragments.add(new CollecFragment());
        mFragments.add(new SettingFragment());
        mFragments.add(new AboutFragment());

    }

    @Override
    protected void initListener() {
        super.initListener();
        mNa.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId != R.id.info_title && itemId != R.id.options_title) {
                    item.setChecked(true);
                    switch (itemId) {
                        case R.id.zhihu: {
                            switchFragment(TYPE_ZHIHU);
                            mToolBarTitle.setText(R.string.zhihu);
                            break;
                        }
                        case R.id.wechat: {
                            switchFragment(TYPE_WECHART);
                            mToolBarTitle.setText(R.string.wechat);
                            break;
                        }
                        case R.id.gank: {
                            switchFragment(TYPE_GANK);
                            mToolBarTitle.setText(R.string.gank);
                            break;
                        }
                        case R.id.gold: {
                            switchFragment(TYPE_GOLD);
                            mToolBarTitle.setText(R.string.gold);
                            break;
                        }
                        case R.id.v2ex: {
                            switchFragment(TYPE_V2EX);
                            mToolBarTitle.setText(R.string.v2ex);
                            break;
                        }
                        case R.id.collect: {
                            switchFragment(TYPE_COLLEC);
                            mToolBarTitle.setText(R.string.collect);
                            break;
                        }
                        case R.id.setting: {
                            switchFragment(TYPE_SETTING);
                            mToolBarTitle.setText(R.string.setting);
                            break;
                        }
                        case R.id.about: {
                            switchFragment(TYPE_ABOUT);
                            mToolBarTitle.setText(R.string.about);
                            break;
                        }
                    }
                    mDr.closeDrawer(Gravity.LEFT);
                } else {
                    item.setChecked(false);
                }
                return false;
            }
        });
    }

    private void switchFragment(int type) {
        //要显示的fragment
        Fragment fragment = mFragments.get(type);
        Fragment hideFragment = mFragments.get(mListFragmentPosition);
        //开启事务
        FragmentTransaction transaction = mManager.beginTransaction();
        if (!fragment.isAdded()) {
            transaction.add(R.id.fragment_container, fragment);
        }

        transaction.hide(hideFragment);
        transaction.show(fragment);
        transaction.commit();
        mListFragmentPosition = type;

        if (type == TYPE_WECHART || type == TYPE_GANK){
            mSearchitem.setVisible(true);
        }else {
            mSearchitem.setVisible(false);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
