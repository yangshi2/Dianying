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
import com.bw.movie.model.bean.MovieXiangQBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 姓名
 * 日期： 2019/11/15 14:15
 */
public class RecyclerIntroduceMovieActorAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<MovieXiangQBean.ResultBean.MovieActorBean> datas = new ArrayList<>();
    public RecyclerIntroduceMovieActorAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_introduce_actor, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tv_introduce_name.setText(datas.get(position).getName().toString());
        Glide.with(context).load(datas.get(position).getPhoto())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .into(myViewHolder.iv_introduce_photo);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addData(List<MovieXiangQBean.ResultBean.MovieActorBean> movieActor) {
        if (movieActor.size()>0 && movieActor!=null){
            datas.addAll(movieActor);
        }
        notifyDataSetChanged();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_introduce_name;
        private final ImageView iv_introduce_photo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_introduce_name = itemView.findViewById(R.id.tv_introduce_name);
            iv_introduce_photo = itemView.findViewById(R.id.iv_introduce_photo);
        }
    }
}
