package com.bw.movie.view.activity;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.model.bean.SearchBean;
import com.bw.movie.presenter.SearchPresenter;
import com.bw.movie.view.activity.base.BaseActivity;
import com.bw.movie.view.adapter.SearchAdapter;
import com.bw.movie.view.interfaces.IContractView;
import com.bw.weidu_movie.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 作者： 姓名
 * 日期： 2019/11/12 14:47
 */
public class SearchActivity extends BaseActivity<SearchPresenter> implements IContractView.iMovieSearch {
    @BindView(R.id.et_movie_thekeyword)
    EditText etMovieThekeyword;
    @BindView(R.id.iv_search_movie)
    ImageView ivSearchMovie;
    @BindView(R.id.search_recycle)
    RecyclerView searchRecycle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    private int page = 1;
    private int count = 5;
    private Unbinder bind;
    private List<SearchBean.ResultBean> searchBeanResult;
    private SearchAdapter searchAdapter;

    @Override
    protected int bindLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        bind = ButterKnife.bind(this);
    }

    @Override
    protected SearchPresenter setPresenter() {
        return new SearchPresenter();
    }

    @Override
    protected void initData() {
        etMovieThekeyword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String keyword = etMovieThekeyword.getText().toString().trim();
                presenter.movieSearch(keyword, page, count);
            }
        });
    }

    @Override
    public void searchSuccess(SearchBean searchBean) {
        if (searchBean.getMessage().equals("未查到相关电影")) {
            Toast.makeText(this, searchBean.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        } else {
            searchBeanResult = searchBean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
            searchAdapter = new SearchAdapter(this);
            searchAdapter.addData(searchBeanResult);
            searchRecycle.setLayoutManager(linearLayoutManager);
            searchRecycle.setAdapter(searchAdapter);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }


    @OnClick(R.id.iv_back)
    public void onClick() {
        startActivity(new Intent(SearchActivity.this, HomeActivity.class));
    }
}
