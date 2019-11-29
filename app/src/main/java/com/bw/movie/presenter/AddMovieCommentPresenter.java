package com.bw.movie.presenter;

import com.bw.movie.model.bean.AddMovieCommentBean;
import com.bw.movie.model.http.OkHttpUtils;
import com.bw.movie.view.interfaces.IContractView;

/**
 * 作者： 姓名
 * 日期： 2019/11/19 18:53
 */
public class AddMovieCommentPresenter extends BasePresenter<IContractView.IAddMovieCommentView> {

    public void addMovieComment(int userId, String sessionId, int movieId, String addMoviecomment, Double addMoviecommentscore) {
        OkHttpUtils.getInstance().addMovieComment(new OkHttpUtils.IOkCallBack<AddMovieCommentBean>() {
            @Override
            public void callSuccess(AddMovieCommentBean bean) {
                getView().addMovieCommentSuccess(bean);
            }

            @Override
            public void callError(String msg) {

            }
        },AddMovieCommentBean.class,userId,sessionId,movieId,addMoviecomment,addMoviecommentscore);
    }
}
