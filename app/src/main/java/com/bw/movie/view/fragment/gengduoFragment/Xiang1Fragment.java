package com.bw.movie.view.fragment.gengduoFragment;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.weidu_movie.R;
import com.bw.movie.model.core.DataCall;
import com.bw.movie.model.wangben.Bean;
import com.bw.movie.model.wangben.YingXiang;
import com.bw.movie.presenter.wangpresenter.XiangQing1Presenter;
import com.bw.movie.view.adapter.wangadapter.Xiang1Adapter;

import java.util.List;

public class Xiang1Fragment extends Fragment {
    private XiangQing1Presenter xiangQing1Presenter;
    private RecyclerView recy_view;
    private Xiang1Adapter xiang1Adapter;
    private View inflate;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_xiang1, container, false);
        xiangQing1Presenter = new XiangQing1Presenter(new MyCall());
        recy_view = inflate.findViewById(R.id.recy_view);
        xiangQing1Presenter.getData("1","5");
        xiang1Adapter = new Xiang1Adapter(getContext());
        recy_view.setAdapter(xiang1Adapter);
        recy_view.setLayoutManager(new LinearLayoutManager(getContext()));

        return inflate;
    }

    class MyCall implements DataCall<List<YingXiang>> {


        @Override
        public void Seccess(List<YingXiang> yingXiangs) {
            xiang1Adapter.addAll(yingXiangs);
        }

        @Override
        public void Fails(Bean b) {

        }
    }


}