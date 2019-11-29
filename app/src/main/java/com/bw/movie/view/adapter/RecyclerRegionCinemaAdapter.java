package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.model.bean.CinemaByRegionBean;
import com.bw.weidu_movie.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 姓名
 * 日期： 2019/11/15 09:30
 */
public class RecyclerRegionCinemaAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<CinemaByRegionBean.ResultBean> datas = new ArrayList<>();

    public RecyclerRegionCinemaAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_region_cinema, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tv_region_cinema.setText(datas.get(position).getName());

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(position,datas.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addData(List<CinemaByRegionBean.ResultBean> cinemaByRegionBeanResult) {
        if (cinemaByRegionBeanResult != null && cinemaByRegionBeanResult.size() > 0) {
            datas.addAll(cinemaByRegionBeanResult);
        }
        notifyDataSetChanged();
    }
    private OnItemClickListener mOnItemClickListener;

    public void onItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position,int cinemaId);
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_region_cinema;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_region_cinema = itemView.findViewById(R.id.tv_region_cinema);
        }
    }
}
