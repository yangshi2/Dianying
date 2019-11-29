package com.bw.movie.presenter.wangpresenter;

import com.bw.movie.model.core.DataCall;
import com.bw.movie.model.core.IRequest;

import io.reactivex.Observable;

/**
 * 作者:王帅
 * 时间:2019/11/11
 * 功能:
 */
public class XiangQing3Presenter extends BasePresenter{

    public XiangQing3Presenter(DataCall myCall) {
        super(myCall);
    }

    @Override
    protected Observable getModel(IRequest iRequest, Object... args) {
        return iRequest.MovieList((String)args[0],(String)args[1]);
    }
}
