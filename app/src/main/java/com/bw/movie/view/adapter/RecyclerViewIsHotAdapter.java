package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.model.bean.IsHotMovieBean;
import com.bw.weidu_movie.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 姓名
 * 日期： 2019/11/8 09:03
 */
public class RecyclerViewIsHotAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<IsHotMovieBean.ResultBean> datas = new ArrayList<>();
    public RecyclerViewIsHotAdapter(Context context) {
           this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_ishit_recyclerview, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tv_name.setText(datas.get(position).getName());
        Glide.with(context).load(datas.get(position).getImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(myViewHolder.iv_imageUrl);
        myViewHolder.tv_score.setText(datas.get(position).getScore()+"分");
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addData(List<IsHotMovieBean.ResultBean> isHotResult) {
        if (isHotResult.size() > 0 && isHotResult != null) {
            datas.addAll(isHotResult);
        }
        notifyDataSetChanged();
    }
    private OnItemClickListener mOnItemClickListener;

    public void onItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_name;
        private final ImageView iv_imageUrl;
        private final Button btn_buy_ticket;
        private final TextView tv_score;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            iv_imageUrl = itemView.findViewById(R.id.iv_imageUrl);
            btn_buy_ticket = itemView.findViewById(R.id.btn_buy_ticket);
            tv_score = itemView.findViewById(R.id.tv_score);
        }
    }
}
