package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.model.bean.SearchBean;
import com.bw.weidu_movie.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 姓名
 * 日期： 2019/11/12 14:54
 */
public class SearchAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<SearchBean.ResultBean> datas = new ArrayList<>();
    public SearchAdapter(Context context) {
         this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_search, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tv_more_name.setText(datas.get(position).getName());
        viewHolder.tv_more_director.setText("导演："+datas.get(position).getDirector());
        viewHolder.tv_more_score.setText("评分："+datas.get(position).getScore());
        viewHolder.tv_more_starring.setText("主演："+datas.get(position).getStarring());
        Glide.with(context).load(datas.get(position).getImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .into(viewHolder.iv_more_imageUrl);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addData(List<SearchBean.ResultBean> searchBeanResult) {
        if (searchBeanResult.size()>0&&searchBeanResult!=null){
             datas.addAll(searchBeanResult);
        }
        notifyDataSetChanged();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_more_name;
        private final TextView tv_more_director;
        private final TextView tv_more_score;
        private final TextView tv_more_starring;
        private final ImageView iv_more_imageUrl;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_more_name = itemView.findViewById(R.id.tv_more_name);
            tv_more_director = itemView.findViewById(R.id.tv_more_director);
            tv_more_score = itemView.findViewById(R.id.tv_more_score);
            tv_more_starring = itemView.findViewById(R.id.tv_more_starring);
            iv_more_imageUrl = itemView.findViewById(R.id.iv_more_imageUrl);
        }
    }
}
