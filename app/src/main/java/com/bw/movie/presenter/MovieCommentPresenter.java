package com.bw.movie.presenter;

import com.bw.movie.model.bean.MovieCommentBean;
import com.bw.movie.model.http.OkHttpUtils;
import com.bw.movie.view.interfaces.IContractView;

/**
 * 作者： 姓名
 * 日期： 2019/11/15 10:23
 */
public class MovieCommentPresenter extends BasePresenter<IContractView.IMovieCommentView> {

    public void movieComment(int movieId, int page, int count) {
        OkHttpUtils.getInstance().movieComment(new OkHttpUtils.IOkCallBack<MovieCommentBean>() {
            @Override
            public void callSuccess(MovieCommentBean bean) {
                getView().movieCommentSuccess(bean);
            }

            @Override
            public void callError(String msg) {

            }
        },MovieCommentBean.class,movieId,page,count);
    }
}
