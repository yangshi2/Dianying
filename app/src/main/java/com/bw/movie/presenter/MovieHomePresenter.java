package com.bw.movie.presenter;

import android.util.Log;

import com.bw.movie.model.bean.IsHotMovieBean;
import com.bw.movie.model.bean.MovieFragBannerBean;
import com.bw.movie.model.bean.UpComingBean;
import com.bw.movie.model.bean.HotMovieBean;
import com.bw.movie.model.http.OkHttpUtils;
import com.bw.movie.view.interfaces.IContractView;

/**
 * 作者： 姓名
 * 日期： 2019/11/8 08:55
 */
public class MovieHomePresenter extends BasePresenter<IContractView.iMovieView> {

    public void movieBenner() {
        OkHttpUtils.getInstance().movieBanner(new OkHttpUtils.IOkCallBack<MovieFragBannerBean>() {
            @Override
            public void callSuccess(MovieFragBannerBean bean) {
                getView().movieBanner(bean);
                Log.e("hhhhhhhh",bean.getResult().get(0).getImageUrl());
            }

            @Override
            public void callError(String msg) {

            }
        },MovieFragBannerBean.class);
    }

    public void IsHotMovie(int page, int count) {
       OkHttpUtils.getInstance().IsHotMovie(new OkHttpUtils.IOkCallBack<IsHotMovieBean>() {
           @Override
           public void callSuccess(IsHotMovieBean bean) {
               getView().IsHotSuccess(bean);
           }

           @Override
           public void callError(String msg) {

           }
       },IsHotMovieBean.class,page,count);
    }

    public void upComingMovie(int page, int count) {
        OkHttpUtils.getInstance().upComingMovie(new OkHttpUtils.IOkCallBack<UpComingBean>() {
            @Override
            public void callSuccess(UpComingBean bean) {
                getView().upComingSuccess(bean);
            }

            @Override
            public void callError(String msg) {

            }
        }, UpComingBean.class,page,count);
    }

    public void hotMovie(int page, int count) {
        OkHttpUtils.getInstance().hotMovie(new OkHttpUtils.IOkCallBack<HotMovieBean>() {
            @Override
            public void callSuccess(HotMovieBean bean) {
                getView().hotSuccess(bean);
            }

            @Override
            public void callError(String msg) {

            }
        }, HotMovieBean.class,page,count);
    }
}
