package com.bw.movie.presenter;

import com.bw.movie.model.bean.MovieXiangQBean;
import com.bw.movie.model.http.OkHttpUtils;
import com.bw.movie.view.interfaces.IContractView;

/**
 * 作者： 姓名
 * 日期： 2019/11/15 09:52
 */
public class MovieDetailsPresenter extends BasePresenter<IContractView.iMovieXiang> {

    public void movieDetails(int movieId) {
        OkHttpUtils.getInstance().movieDetails(new OkHttpUtils.IOkCallBack<MovieXiangQBean>() {
            @Override
            public void callSuccess(MovieXiangQBean bean) {
                getView().XiangSuccess(bean);
            }

            @Override
            public void callError(String msg) {

            }
        },MovieXiangQBean.class,movieId);
    }
}
