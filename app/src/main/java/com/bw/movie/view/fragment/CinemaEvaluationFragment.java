package com.bw.movie.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.weidu_movie.R;
import com.bw.movie.model.bean.FindAllCinemaCommentBean;
import com.bw.movie.model.bean.UserBean;
import com.bw.movie.presenter.AllCinemaCommentPresenter;
import com.bw.movie.presenter.SyLinearLayoutManager;
import com.bw.movie.view.adapter.RecyclerAllCinemaCommentAdapter;
import com.bw.movie.view.interfaces.IContractView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class CinemaEvaluationFragment extends Fragment implements IContractView.IAllCinemaCommentView {
@BindView(R.id.recycler_AllCinemaComment)
RecyclerView recyclerAllCinemaComment;
            Unbinder unbinder;
private AllCinemaCommentPresenter allCinemaCommentPresenter;
//用户登录的信息
private String sessionId;
private int userId;
//设置条目与页数
private int page = 1;
private int count = 10;
private List<FindAllCinemaCommentBean.ResultBean> result;
private RecyclerAllCinemaCommentAdapter recyclerAllCinemaCommentAdapter;

@Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_cinema_evaluation, null);
        unbinder = ButterKnife.bind(this, inflate);
        Intent intent = getActivity().getIntent();
        int cinemaId = intent.getIntExtra("cinemaId", 0);
        allCinemaCommentPresenter = new AllCinemaCommentPresenter();
        allCinemaCommentPresenter.attachView(this);
        allCinemaCommentPresenter.allCinemaComment(userId,sessionId,cinemaId,page,count);
        return inflate;
        }

@Subscribe(threadMode = ThreadMode.ASYNC,sticky = true)
public void Message(UserBean userBean){
        userId = userBean.getUserId();
        sessionId = userBean.getSessionId();
        }

@Override
public void allCinemaCommentSuccess(FindAllCinemaCommentBean findAllCinemaCommentBean) {
        result = findAllCinemaCommentBean.getResult();
        SyLinearLayoutManager syLinearLayoutManager = new SyLinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        //查询影院评论适配器
        recyclerAllCinemaCommentAdapter = new RecyclerAllCinemaCommentAdapter(getContext());
        recyclerAllCinemaCommentAdapter.addData(result);
        recyclerAllCinemaComment.setLayoutManager(syLinearLayoutManager);
        recyclerAllCinemaComment.setAdapter(recyclerAllCinemaCommentAdapter);
        }

@Override
public void allCinemaCommentError(String msg) {

        }

@Override
public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        allCinemaCommentPresenter.detachView();
        }
        }
