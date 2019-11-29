package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.weidu_movie.R;
import com.bw.movie.model.bean.FindAllCinemaCommentBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:王帅
 * 时间:2019/11/14
 * 功能:
 */
public class RecyclerAllCinemaCommentAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<FindAllCinemaCommentBean.ResultBean> datas = new ArrayList<>();

    public RecyclerAllCinemaCommentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate
                (R.layout.item_find_all_cinema_comment, viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        myViewHolder.tv_commentUserName.setText(datas.get(i).getCommentUserName()+"");
        myViewHolder.tv_commentContent.setText(datas.get(i).getCommentContent()+"");
        Glide.with(context).load(datas.get(i).getCommentHeadPic())
                .transform(new CircleCrop())
                .into(myViewHolder.iv_commentHeadPic);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addData(List<FindAllCinemaCommentBean.ResultBean> result) {
        if (result!=null && result.size()>0){
            datas.addAll(result);
        }
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_commentTime;
        private final TextView tv_commentUserName;
        private final TextView tv_commentContent;
        private final ImageView iv_commentHeadPic;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_commentTime = itemView.findViewById(R.id.tv_commentTime);
            tv_commentContent = itemView.findViewById(R.id.tv_commentContent);
            iv_commentHeadPic = itemView.findViewById(R.id.iv_commentHeadPic);
            tv_commentUserName = itemView.findViewById(R.id.tv_commentUserName);
        }
    }
}

