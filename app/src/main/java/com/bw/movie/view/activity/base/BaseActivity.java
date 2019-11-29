package com.bw.movie.view.activity.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bw.movie.presenter.BasePresenter;
import com.bw.movie.view.interfaces.IBaseView;

/**
 * 作者： 姓名
 * 日期： 2019/11/5 15:57
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    public P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        initView();
        presenter = setPresenter();
        presenter.attachView(this);
        initData();
    }
    protected  abstract int bindLayout();
    protected  abstract void initView();
    protected  abstract P setPresenter();
    protected  abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
