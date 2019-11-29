package com.bw.movie.presenter.wangpresenter;

import com.bw.movie.model.core.DataCall;
import com.bw.movie.model.core.IRequest;
import com.bw.movie.model.http.NetUtil;
import com.bw.movie.model.wangben.Bean;
import com.bw.movie.model.wangben.YingXiang;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者:王帅
 * 时间:2019/11/11
 * 功能:
 */
public abstract class BasePresenter {
    private DataCall myCall;
    public BasePresenter(DataCall myCall) {
        this.myCall = myCall;
    }
    public void getData(Object...args){
        IRequest iRequest = NetUtil.getInstance().create(IRequest.class);
        getModel(iRequest,args)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Bean<List<YingXiang>>>() {
                    @Override
                    public void accept(Bean<List<YingXiang>> listBean) throws Exception {
                        if (listBean.status.equals("0000")){
                            myCall.Seccess(listBean.result);
                        }else {
                            myCall.Fails(listBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });
    }
    protected abstract Observable getModel(IRequest iRequest, Object...args);
}
