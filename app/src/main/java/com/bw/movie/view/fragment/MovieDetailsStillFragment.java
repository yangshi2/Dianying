package com.bw.movie.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.presenter.MovieDetailsPresenter;
import com.bw.movie.view.adapter.RecyclerStillMovieActorAdapter;
import com.bw.weidu_movie.R;
import com.bw.movie.model.bean.MovieXiangQBean;
import com.bw.movie.view.interfaces.IContractView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * 作者： 姓名
 * 日期： 2019/11/15 09:59
 */
public class MovieDetailsStillFragment extends Fragment implements IContractView.iMovieXiang {

    Unbinder unbinder;
    @BindView(R.id.recycler_still_posterList)
    RecyclerView recyclerStillPosterList;
    private MovieDetailsPresenter movieDetailsPresenter;
    private RecyclerStillMovieActorAdapter recyclerStillMovieActorAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_moviedetalis_still, null);
        unbinder = ButterKnife.bind(this, inflate);
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        movieDetailsPresenter = new MovieDetailsPresenter();
        movieDetailsPresenter.attachView(this);
        movieDetailsPresenter.movieDetails(movieId);
        return inflate;
    }

    @Override
    public void XiangSuccess(MovieXiangQBean xiangQBean) {
        List<String> posterList = xiangQBean.getResult().getPosterList();
        //电影预告
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerStillMovieActorAdapter = new RecyclerStillMovieActorAdapter(getContext());
        recyclerStillMovieActorAdapter.addData(posterList);
        recyclerStillPosterList.setLayoutManager(gridLayoutManager);
        recyclerStillPosterList.setAdapter(recyclerStillMovieActorAdapter);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
