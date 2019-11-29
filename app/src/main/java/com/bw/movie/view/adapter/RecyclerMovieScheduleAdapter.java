package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.model.bean.MovieScheduleBean;

import java.util.List;

/**
 * 作者： 姓名
 * 日期： 2019/11/19 19:33
 */
public class RecyclerMovieScheduleAdapter extends RecyclerView.Adapter {
    public RecyclerMovieScheduleAdapter(Context context) {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
    private OnItemClickListener mOnItemClickListener;

    public void onItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    @Override
    public int getItemCount() {
        return 0;
    }

    public void addData(List<MovieScheduleBean.ResultBean> result) {

    }
}
