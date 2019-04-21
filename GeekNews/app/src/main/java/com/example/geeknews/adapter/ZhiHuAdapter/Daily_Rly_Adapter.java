package com.example.geeknews.adapter.ZhiHuAdapter;

import android.content.Context;
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
import com.example.geeknews.bean.ZhiHuDailyBean.Daily_Bean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

/**
 * Created by 张十八 on 2019/4/17.
 */

public class Daily_Rly_Adapter extends RecyclerView.Adapter {
    private final FragmentActivity mActivity;
    private final List<Daily_Bean.StoriesBean> mItems;
    private final List<Daily_Bean.TopStoriesBean> mTop_items;
    private final String mDate;
    private int mposition;

    public Daily_Rly_Adapter(FragmentActivity activity, List<Daily_Bean.StoriesBean> items, List<Daily_Bean.TopStoriesBean> top_items, String date) {
        mActivity = activity;
        mItems = items;
        mTop_items = top_items;
        mDate = date;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mActivity);
        if (viewType == 1){
            View inflate = inflater.inflate(R.layout.daily_banner_buju, null, false);
            viewholder_banner viewholder_banner = new viewholder_banner(inflate);
            return viewholder_banner;
        }else if (viewType == 2){
            View inflate = inflater.inflate(R.layout.daily_time_buju, null, false);
            viewholder_time viewholder_time = new viewholder_time(inflate);
            return viewholder_time;
        }else {
            View inflate = inflater.inflate(R.layout.daily_item_buju, null, false);
            viewholder_item viewholder_item = new viewholder_item(inflate);
            return viewholder_item;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == 1){
           viewholder_banner viewholder_banner = (Daily_Rly_Adapter.viewholder_banner) holder;
           viewholder_banner.mBanner_id.setImages(mTop_items)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            Daily_Bean.TopStoriesBean bean = (Daily_Bean.TopStoriesBean) path;
                            Glide.with(mActivity).load(bean.getImage()).into(imageView);
                        }
                    }).start();
        }else if (type == 2){
            viewholder_time viewholder_time = (Daily_Rly_Adapter.viewholder_time) holder;
            viewholder_time.mTime.setText(mDate);
        }else {
            viewholder_item viewholder_item = (Daily_Rly_Adapter.viewholder_item) holder;
            mposition = position-1;
            if (mTop_items.size()>0){
                mposition-=1;
            }
            viewholder_item.mTitle.setText(mItems.get(mposition).getTitle());
            Glide.with(mActivity).load(mItems.get(mposition).getImages().get(0)).into(viewholder_item.mImg_id_item);
        }
    }

    @Override
    public int getItemCount() {

        if (mItems.size()>0){
            return mItems.size()+2;
        }else {
            return mItems.size()+1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mTop_items.size()>0){
           if (position == 0){
               return 1;
           }else if (position == 1){
               return 2;
           }else {
               return 3;
           }
       }else {
            if (position == 0){
                return 2;
            }else {
                return 3;
            }
       }

    }

    class viewholder_banner extends RecyclerView.ViewHolder {
        private final Banner mBanner_id;
        public viewholder_banner(View itemView) {
            super(itemView);
            mBanner_id = itemView.findViewById(R.id.daily_banner_id);
        }
    }

    class viewholder_time extends RecyclerView.ViewHolder {
        private final TextView mTime;
        public viewholder_time(View itemView) {
            super(itemView);
            mTime = itemView.findViewById(R.id.daily_time);
        }
    }

    class viewholder_item extends RecyclerView.ViewHolder {
        private final ImageView mImg_id_item;
        private final TextView mTitle;
        public viewholder_item(View itemView) {
            super(itemView);
            mImg_id_item = itemView.findViewById(R.id.daily_img_id);
            mTitle = itemView.findViewById(R.id.daily_title_name);
        }
    }
}
