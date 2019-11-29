package com.bw.movie.view.adapter.wangadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.model.bean.RegionListBean;
import com.bw.weidu_movie.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerRegionAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<RegionListBean.ResultBean> datas = new ArrayList<>();

    public RecyclerRegionAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_region, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        myViewHolder.tv_regionName.setText(datas.get(i).getRegionName());

        myViewHolder.tv_regionName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(i,datas.get(i).getRegionId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    private OnItemClickListener mOnItemClickListener;

    public void onItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position, int regionId);
    }

    public void addData(List<RegionListBean.ResultBean> result) {
        if (result.size()>0 && result != null){
            datas.addAll(result);
        }
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_regionName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_regionName = itemView.findViewById(R.id.tv_regionName);
        }
    }
}
