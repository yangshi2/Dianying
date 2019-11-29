package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.weidu_movie.R;
import com.bw.movie.model.bean.MovieXiangQBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * 作者： 姓名
 * 日期： 2019/11/15 15:56
 */
public class RecyclerTrailerMovieActorAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<MovieXiangQBean.ResultBean.ShortFilmListBean> datas = new ArrayList<>();
    public RecyclerTrailerMovieActorAdapter(Context context) {
        this.context = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_trailer_video, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.jcp_trailer_videoUrl.setUp(datas.get(position).getVideoUrl(),"预告"+"("+(position+1)+")");
        Glide.with(context).load(datas.get(position).getImageUrl())
                .into(myViewHolder.jcp_trailer_videoUrl.ivThumb);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addData(List<MovieXiangQBean.ResultBean.ShortFilmListBean> shortFilmList) {
        if (shortFilmList.size()>0 && shortFilmList!=null){
            datas.addAll(shortFilmList);
        }
        notifyDataSetChanged();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final JCVideoPlayer jcp_trailer_videoUrl;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            jcp_trailer_videoUrl = itemView.findViewById(R.id.jcp_trailer_videoUrl);
        }
    }
}
