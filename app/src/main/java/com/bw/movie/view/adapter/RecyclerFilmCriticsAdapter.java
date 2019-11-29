package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.model.bean.MovieCommentBean;
import com.bw.weidu_movie.R;
import com.bw.movie.view.DateUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 姓名
 * 日期： 2019/11/15 13:53
 */
public class RecyclerFilmCriticsAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<MovieCommentBean.ResultBean> datas = new ArrayList<>();
    public RecyclerFilmCriticsAdapter(Context context) {
         this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate
                (R.layout.item_filmcritics, parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tv_commentUserName.setText(datas.get(position).getCommentUserName()+"");
        myViewHolder.tv_commentContent.setText(datas.get(position).getCommentContent()+"");
        String times = DateUtils.times(datas.get(position).getCommentTime());
        myViewHolder.tv_commentTime.setText(times);
        Glide.with(context).load(datas.get(position).getCommentHeadPic())
                .transform(new CircleCrop())
                .into(myViewHolder.iv_commentHeadPic);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addData(List<MovieCommentBean.ResultBean> commentBeanResult) {
        if (commentBeanResult!=null && commentBeanResult.size()>0){
            datas.addAll(commentBeanResult);
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
