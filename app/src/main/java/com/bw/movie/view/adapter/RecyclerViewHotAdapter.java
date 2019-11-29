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

import com.bw.weidu_movie.R;
import com.bw.movie.model.bean.HotMovieBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 姓名
 * 日期： 2019/11/8 09:03
 */
public class RecyclerViewHotAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<HotMovieBean.ResultBean> datas = new ArrayList<>();
    public RecyclerViewHotAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_ishit_recyclerview, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tv_name.setText(datas.get(position).getName());
        Glide.with(context).load(datas.get(position).getImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(viewHolder.iv_imageUrl);
        viewHolder.tv_score.setText(datas.get(position).getScore()+"分");


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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

    public void addData(List<HotMovieBean.ResultBean> hotResult) {

        if (hotResult.size() > 0 && hotResult != null){
            datas.addAll(hotResult);
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
    private class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_name;
        private final Button btn_buy_ticket;
        private final ImageView iv_imageUrl;
        private final TextView tv_score;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            iv_imageUrl = itemView.findViewById(R.id.iv_imageUrl);
            btn_buy_ticket = itemView.findViewById(R.id.btn_buy_ticket);
            tv_score = itemView.findViewById(R.id.tv_score);
        }
    }
}
