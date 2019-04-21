package com.example.geeknews.adapter.ZhiHuAdapter.WeChatAdapter;

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
import com.bumptech.glide.request.RequestOptions;
import com.example.geeknews.R;
import com.example.geeknews.bean.WeChatBean.WeChat_Bean;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by 张十八 on 2019/4/18.
 */

public class Wx_Rly_Adapter extends RecyclerView.Adapter {
    private final FragmentActivity mActivity;
    private final List<WeChat_Bean.NewslistBean> mList;

    public Wx_Rly_Adapter(FragmentActivity activity, List<WeChat_Bean.NewslistBean> list) {
        mActivity = activity;
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mActivity).inflate(R.layout.wechat_buju, null, false);
        viewholder viewholder = new viewholder(inflate);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        viewholder viewholder = (Wx_Rly_Adapter.viewholder) holder;
        viewholder.mAddress.setText(mList.get(position).getDescription());
        viewholder.mTime.setText(mList.get(position).getCtime());
        viewholder.mTitle.setText(mList.get(position).getTitle());
        RequestOptions requestOptions = new RequestOptions().centerCrop();
        Glide.with(mActivity).load(mList.get(position).getPicUrl()).apply(requestOptions).into(viewholder.mImg_id);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class viewholder extends RecyclerView.ViewHolder {

        private final ImageView mImg_id;
        private final TextView mTitle;
        private final TextView mAddress;
        private final TextView mTime;

        public viewholder(View itemView) {
            super(itemView);
            mImg_id = itemView.findViewById(R.id.img_id);
            mTitle = itemView.findViewById(R.id.title);
            mAddress = itemView.findViewById(R.id.address);
            mTime = itemView.findViewById(R.id.time);
        }
    }
}
