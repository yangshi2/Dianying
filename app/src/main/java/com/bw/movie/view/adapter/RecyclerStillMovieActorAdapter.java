package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.weidu_movie.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 姓名
 * 日期： 2019/11/15 15:45
 */
public class RecyclerStillMovieActorAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<String> datas = new ArrayList<>();
    public RecyclerStillMovieActorAdapter(Context context) {
         this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_still_listurl, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        for (int j = 0; j < datas.size(); j++) {
            Glide.with(context).load(datas.get(position))
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher_round)
                    .into(myViewHolder.iv_still_imageUrl);
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addData(List<String> posterList) {
        if (posterList.size()>0 && posterList!=null){
            datas.addAll(posterList);
        }
        notifyDataSetChanged();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv_still_imageUrl;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_still_imageUrl = itemView.findViewById(R.id.iv_still_imageUrl);
        }
    }
}
