package com.example.geeknews.adapter.ZhiHuAdapter;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.geeknews.R;
import com.example.geeknews.bean.ZhiHuDailyBean.Hot_Bean;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by 张十八 on 2019/4/17.
 */

public class Hot_Rly_Adapter extends RecyclerView.Adapter {
    private final FragmentActivity mActivity;
    private final List<Hot_Bean.RecentBean> mList;

    public Hot_Rly_Adapter(FragmentActivity activity, List<Hot_Bean.RecentBean> list) {
        mActivity = activity;
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mActivity).inflate(R.layout.daily_item_buju, null, false);
        viewholder viewholder = new viewholder(inflate);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        viewholder viewholder = (Hot_Rly_Adapter.viewholder) holder;
        viewholder.mName.setText(mList.get(position).getTitle());
        Glide.with(mActivity).load(mList.get(position).getThumbnail()).into(viewholder.mImg_id);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class viewholder extends RecyclerView.ViewHolder {
        private final ImageView mImg_id;
        private final TextView mName;
        public viewholder(View itemView) {
            super(itemView);
            mImg_id = itemView.findViewById(R.id.daily_img_id);
            mName = itemView.findViewById(R.id.daily_title_name);
        }
    }
}
