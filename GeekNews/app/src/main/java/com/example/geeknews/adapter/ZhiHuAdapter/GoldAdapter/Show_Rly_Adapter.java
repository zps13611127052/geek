package com.example.geeknews.adapter.ZhiHuAdapter.GoldAdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.geeknews.R;
import com.example.geeknews.bean.GoldBean.Gold_Show_Bean;
import com.example.geeknews.widget.TouchCallBack;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 张十八 on 2019/4/19.
 */

public class Show_Rly_Adapter extends RecyclerView.Adapter implements TouchCallBack{
    private ArrayList<Gold_Show_Bean> mBean;

    public Show_Rly_Adapter(ArrayList<Gold_Show_Bean> bean) {
        mBean = bean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_item_buju, null, false);
        viewholder viewholder = new viewholder(inflate);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        viewholder viewholder = (Show_Rly_Adapter.viewholder) holder;
        viewholder.mtv.setText(mBean.get(position).title);
        viewholder.sc.setChecked(mBean.get(position).isChecked);
        viewholder.sc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mBean.get(position).isChecked = isChecked;

            }
        });
    }

    @Override
    public int getItemCount() {
        return mBean.size();
    }

    @Override
    public void onItemMove(int fromposition, int toposition) {
        Collections.swap(mBean,fromposition,toposition);
        notifyItemMoved(fromposition,toposition);
    }

    @Override
    public void onItemDelete(int delposition) {
        mBean.remove(delposition);
        notifyItemRemoved(delposition);
    }


    class viewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_id)
        TextView mtv;
        @BindView(R.id.sc)
        Switch sc;
        public viewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
