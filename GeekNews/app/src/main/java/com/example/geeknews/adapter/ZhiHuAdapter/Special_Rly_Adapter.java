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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.geeknews.R;
import com.example.geeknews.bean.ZhiHuDailyBean.Special_Bean;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by 张十八 on 2019/4/17.
 */

public class Special_Rly_Adapter extends RecyclerView.Adapter {
    private final FragmentActivity mActivity;
    private final List<Special_Bean.DataBean> mData;

    public Special_Rly_Adapter(FragmentActivity activity, List<Special_Bean.DataBean> data) {
        mActivity = activity;
        mData = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mActivity).inflate(R.layout.special_buju, null, false);
        viewholder viewholder = new viewholder(inflate);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        viewholder viewholder = (Special_Rly_Adapter.viewholder) holder;
        viewholder.mTitle.setText(mData.get(position).getName());
        viewholder.mName.setText(mData.get(position).getDescription());
//        RoundedCorners roundedCorners = new RoundedCorners(10);
        RequestOptions requestOptions = new RequestOptions().centerCrop();

        Glide.with(mActivity).load(mData.get(position).getThumbnail()).apply(requestOptions).into(viewholder.mImg_id);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class viewholder extends RecyclerView.ViewHolder {

        private final ImageView mImg_id;
        private final TextView mName;
        private final TextView mTitle;

        public viewholder(View itemView) {
            super(itemView);
            mImg_id = itemView.findViewById(R.id.img_id);
            mName = itemView.findViewById(R.id.name);
            mTitle = itemView.findViewById(R.id.title);
        }
    }
}
