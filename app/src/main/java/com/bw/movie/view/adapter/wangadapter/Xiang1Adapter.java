package com.bw.movie.view.adapter.wangadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.model.wangben.YingXiang;
import com.bw.weidu_movie.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:王帅
 * 时间:2019/11/7
 * 功能:
 */
public class Xiang1Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<YingXiang> list;
    private Context context;
    private View inflate;

    public Xiang1Adapter(Context context) {
        this.list = new ArrayList<>();
        this.context = context;
    }
    public void addAll(List<YingXiang> data){
        if (data!=null){
            list.addAll(data);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflate = LayoutInflater.from(context).inflate(R.layout.xiang1_item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder mm;
        mm = new MyViewHolder(inflate);
        mm.doctor_name.setText(list.get(position).director);
        mm.ping_name.setText(list.get(position).name);
        mm.renyuan_name.setText(list.get(position).starring);
        Glide.with(context).load(list.get(position).imageUrl).into(mm.ying1_img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView ying1_name;
        private final ImageView ying1_img;
        private final TextView doctor_name;
        private final TextView renyuan_name;
        private final TextView ping_name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ying1_img = itemView.findViewById(R.id.iv_more_imageUrl);
            ying1_name = itemView.findViewById(R.id.tv_more_name);
            doctor_name = itemView.findViewById(R.id.tv_more_director);
            renyuan_name = itemView.findViewById(R.id.tv_more_starring);
            ping_name = itemView.findViewById(R.id.tv_more_score);
        }
    }
}