package com.bw.movie.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.presenter.MovieDetailsPresenter;
import com.bw.movie.view.adapter.RecyclerIntroduceMovieActorAdapter;
import com.bw.movie.view.adapter.RecyclerIntroduceMovieDirectorAdapter;
import com.bw.weidu_movie.R;
import com.bw.movie.model.bean.MovieXiangQBean;
import com.bw.movie.view.interfaces.IContractView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者： 姓名
 * 日期： 2019/11/15 09:59
 */
public class MovieDetailsIntroduceFragment extends Fragment implements IContractView.iMovieXiang {
    @BindView(R.id.tv_introduce_summary)
    TextView tvIntroduceSummary;
    @BindView(R.id.recycler_introduce_movieDirector)
    RecyclerView recyclerIntroduceMovieDirector;
    @BindView(R.id.recycler_introduce_movieActor)
    RecyclerView recyclerIntroduceMovieActor;
    private Unbinder bind;
    private MovieDetailsPresenter movieDetailsPresenter;
    private RecyclerIntroduceMovieDirectorAdapter recyclerIntroduceMovieDirectorAdapter;
    private RecyclerIntroduceMovieActorAdapter recyclerIntroduceMovieActorAdapter;
    //导演Bean
    private List<MovieXiangQBean.ResultBean.MovieDirectorBean> movieDirector;
    //演员的Bean
    private List<MovieXiangQBean.ResultBean.MovieActorBean> movieActor;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_moviedetalis_introduce, null);
        bind = ButterKnife.bind(this, inflate);
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        movieDetailsPresenter = new MovieDetailsPresenter();
        movieDetailsPresenter.attachView(this);
        movieDetailsPresenter.movieDetails(movieId);
        return inflate;
    }

    @Override
    public void XiangSuccess(MovieXiangQBean xiangQBean) {
        //导演详情介绍
        tvIntroduceSummary.setText(xiangQBean.getResult().getSummary());
        movieDirector = xiangQBean.getResult().getMovieDirector();
        recyclerIntroduceMovieDirectorAdapter = new RecyclerIntroduceMovieDirectorAdapter(getContext());
        recyclerIntroduceMovieDirectorAdapter.addData(movieDirector);
        recyclerIntroduceMovieDirector.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        recyclerIntroduceMovieDirector.setAdapter(recyclerIntroduceMovieDirectorAdapter);

        //演员详情介绍
        movieActor = xiangQBean.getResult().getMovieActor();
        recyclerIntroduceMovieActorAdapter = new RecyclerIntroduceMovieActorAdapter(getContext());
        recyclerIntroduceMovieActorAdapter.addData(movieActor);
        recyclerIntroduceMovieActor.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerIntroduceMovieActor.setAdapter(recyclerIntroduceMovieActorAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }
}
