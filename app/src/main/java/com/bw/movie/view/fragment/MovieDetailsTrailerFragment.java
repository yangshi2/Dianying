package com.bw.movie.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.presenter.MovieDetailsPresenter;
import com.bw.movie.view.adapter.RecyclerTrailerMovieActorAdapter;
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
public class MovieDetailsTrailerFragment extends Fragment implements IContractView.iMovieXiang {
    Unbinder unbinder;
    @BindView(R.id.recycler_trailer_videoUrl)
    RecyclerView recyclerTrailerVideoUrl;
    private MovieDetailsPresenter movieDetailsPresenter;
    private List<MovieXiangQBean.ResultBean.ShortFilmListBean> shortFilmList;
    private RecyclerTrailerMovieActorAdapter recyclerTrailerMovieActorAdapter;
    private int movieId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_moviedetalis_trailer, null);
        unbinder = ButterKnife.bind(this, inflate);
        Intent intent = getActivity().getIntent();
        movieId = intent.getIntExtra("movieId", 0);
        movieDetailsPresenter = new MovieDetailsPresenter();
        movieDetailsPresenter.attachView(this);
        movieDetailsPresenter.movieDetails(movieId);
        return inflate;
    }

    @Override
    public void XiangSuccess(MovieXiangQBean xiangQBean) {
        Log.e("MyMessage预告",xiangQBean.getResult().getName());
        shortFilmList = xiangQBean.getResult().getShortFilmList();
        recyclerTrailerMovieActorAdapter = new RecyclerTrailerMovieActorAdapter(getContext());
        recyclerTrailerMovieActorAdapter.addData(shortFilmList);
        recyclerTrailerVideoUrl.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        recyclerTrailerVideoUrl.setAdapter(recyclerTrailerMovieActorAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
