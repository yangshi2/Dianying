package com.bw.movie.presenter.wangpresenter;

import com.bw.movie.model.core.DataCall;
import com.bw.movie.model.core.IRequest;

import io.reactivex.Observable;

/**
 * 作者:王帅
 * 时间:2019/11/12
 * 功能:
 */
public class TuiYingYuanPresenter extends BasePresenter{
    public TuiYingYuanPresenter(DataCall myCall) {
        super(myCall);
    }

    @Override
    protected Observable getModel(IRequest iRequest, Object... args) {
        return iRequest.getyingyuan((String)args[0],(String)args[1]);
    }
}
