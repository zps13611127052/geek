package com.example.geeknews.base;

import java.util.ArrayList;

/**
 * Created by 张十八 on 2019/4/3.
 */

public abstract class BasePresenter<V extends BaseMvpView>{
    protected V mView;
    protected ArrayList<BaseModel> mModels = new ArrayList<>();

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    public void bind(V view) {
        this.mView = view;
    }

    public void onDestroy() {
        mView = null;
        if (mModels.size()>0){
            for (BaseModel model:mModels) {
                model.onDestory();
            }
        }
    }
}
