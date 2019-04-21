package com.example.geeknews.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by 张十八 on 2019/4/19.
 */

public class SimpleToachHelperCallBack extends ItemTouchHelper.Callback {

    private TouchCallBack mCallBack;
    private boolean mSwipeable;

    public SimpleToachHelperCallBack(TouchCallBack callBack){
        this.mCallBack = callBack;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int item = ItemTouchHelper.DOWN | ItemTouchHelper.UP;
        int left = ItemTouchHelper.LEFT;
        return makeMovementFlags(item,left);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        mCallBack.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mCallBack.onItemDelete(viewHolder.getAdapterPosition());
    }


    //长按
    @Override
    public boolean isLongPressDragEnabled() {
        return super.isLongPressDragEnabled();
    }


    //支持滑动
    @Override
    public boolean isItemViewSwipeEnabled() {
        return mSwipeable;
    }

    public void setSwipeable(boolean enable){
        mSwipeable = enable;
    }
}
