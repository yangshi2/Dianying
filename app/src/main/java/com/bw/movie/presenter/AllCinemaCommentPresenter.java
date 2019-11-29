package com.bw.movie.presenter;

import com.bw.movie.model.bean.FindAllCinemaCommentBean;
import com.bw.movie.model.http.OkHttpUtils;
import com.bw.movie.view.interfaces.IContractView;

/**
 * 作者:王帅
 * 时间:2019/11/14
 * 功能:
 */
public class AllCinemaCommentPresenter extends BasePresenter<IContractView.IAllCinemaCommentView> {

    public void allCinemaComment(int userId, String sessionId, int cinemaId, int page, int count){
        OkHttpUtils.getInstance().findAllCinemaComment(new OkHttpUtils.IOkCallBack<FindAllCinemaCommentBean>() {
            @Override
            public void callSuccess(FindAllCinemaCommentBean bean) {
                getView().allCinemaCommentSuccess(bean);
            }

            @Override
            public void callError(String msg) {

            }
        }, FindAllCinemaCommentBean.class,userId,sessionId,cinemaId,page,count);
    }

}
