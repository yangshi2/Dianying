package com.bw.movie.view.fragment.yingyuanfragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.model.wangben.Bean;
import com.bw.weidu_movie.R;
import com.bw.movie.model.core.DataCall;
import com.bw.movie.model.wangben.YingYuan;
import com.bw.movie.presenter.wangpresenter.TuiYingYuanPresenter;
import com.bw.movie.view.adapter.wangadapter.YingYuanAdapter;

import java.util.List;

public class Fragment_Tui extends Fragment {
    private RecyclerView recy_view;
    private View inflate;
    private TuiYingYuanPresenter tuiYingYuanPresenter;
    private YingYuanAdapter yingYuanAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment__tui, container, false);
        recy_view = inflate.findViewById(R.id.recy_view);
        tuiYingYuanPresenter = new TuiYingYuanPresenter(new MyCall());
        yingYuanAdapter = new YingYuanAdapter(getActivity());
        recy_view.setAdapter(yingYuanAdapter);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recy_view.setLayoutManager(linearLayoutManager);
        tuiYingYuanPresenter.getData("1","5");

        return inflate;
    }
    class MyCall implements DataCall<List<YingYuan>>{

        @Override
        public void Seccess(List<YingYuan> yingYuans) {
            yingYuanAdapter.addAll(yingYuans);

        }

        @Override
        public void Fails(Bean b) {

        }
    }
}
