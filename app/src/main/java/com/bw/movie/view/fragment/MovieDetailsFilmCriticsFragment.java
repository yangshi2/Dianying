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

import com.bw.movie.model.bean.MovieCommentBean;
import com.bw.movie.view.adapter.RecyclerFilmCriticsAdapter;
import com.bw.weidu_movie.R;
import com.bw.movie.presenter.MovieCommentPresenter;
import com.bw.movie.view.interfaces.IContractView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者： 姓名
 * 日期： 2019/11/15 09:59
 */
public class MovieDetailsFilmCriticsFragment extends Fragment implements IContractView.IMovieCommentView {
    @BindView(R.id.recycler_filmcritics_moviecomment)
    RecyclerView recyclerFilmcriticsMoviecomment;
    Unbinder unbinder;
    private int page = 1;
    private List<MovieCommentBean.ResultBean> commentBeanResult;
    private MovieCommentPresenter movieCommentPresenter;
    private int count = 5;
    private RecyclerFilmCriticsAdapter recyclerFilmCriticsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_moviedetalis_filmcritics, null);
        unbinder = ButterKnife.bind(this, inflate);
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        Log.e("movieId影评",movieId+"");
        movieCommentPresenter = new MovieCommentPresenter();
        movieCommentPresenter.attachView(this);
        movieCommentPresenter.movieComment(movieId,page,count);
        return inflate;
    }


    @Override
    public void movieCommentSuccess(MovieCommentBean movieCommentBean) {
        Log.e("MyMessage影评",movieCommentBean.getResult().get(0).getCommentUserName());
        commentBeanResult =  movieCommentBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        recyclerFilmCriticsAdapter = new RecyclerFilmCriticsAdapter(getActivity());
        recyclerFilmCriticsAdapter.addData(commentBeanResult);
        recyclerFilmcriticsMoviecomment.setLayoutManager(linearLayoutManager);
        recyclerFilmcriticsMoviecomment.setAdapter(recyclerFilmCriticsAdapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
