package com.bw.movie.presenter;

import com.bw.movie.model.bean.CinemaDetailsBean;
import com.bw.movie.model.http.OkHttpUtils;
import com.bw.movie.view.interfaces.IContractView;

/**
 * 作者:王帅
 * 时间:2019/11/14
 * 功能:
 */
public class CinemaDetailsPresenter extends BasePresenter<IContractView.ICinemaDetailsView> {
    public void cinemaInfo(int userId, String sessionId, int cinemaId) {
        OkHttpUtils.getInstance().cinemaInfo(new OkHttpUtils.IOkCallBack<CinemaDetailsBean>() {
            @Override
            public void callSuccess(CinemaDetailsBean bean) {
                getView().cinemaDetailsSuccess(bean);
            }

            @Override
            public void callError(String msg) {

            }
        }, CinemaDetailsBean.class,userId,sessionId,cinemaId);
    }
}
