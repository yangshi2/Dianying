package com.bw.movie.model.http;

import com.bw.movie.model.api.IApi;
import com.bw.movie.model.bean.AddMovieCommentBean;
import com.bw.movie.model.bean.CinemaByRegionBean;
import com.bw.movie.model.bean.CinemaDetailsBean;
import com.bw.movie.model.bean.CodeBean;
import com.bw.movie.model.bean.FindAllCinemaCommentBean;
import com.bw.movie.model.bean.IsHotMovieBean;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.bean.MovieCommentBean;
import com.bw.movie.model.bean.MovieFragBannerBean;
import com.bw.movie.model.bean.RegionListBean;
import com.bw.movie.model.bean.RegisterBean;
import com.bw.movie.model.bean.SearchBean;
import com.bw.movie.model.bean.UpComingBean;

import com.bw.movie.model.bean.HotMovieBean;
import com.bw.movie.model.bean.MovieXiangQBean;
import com.bw.movie.model.url.CantantUrl;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者： 姓名
 * 日期： 2019/11/5 16:01
 */
public class OkHttpUtils<B> {

    private static OkHttpUtils okHttpUtils = new OkHttpUtils();
    private final OkHttpClient okHttpClient;
    private final Retrofit retrofit;
    private final IApi iApi;
    private Observable<MovieXiangQBean> qBeanObservable;

    public static OkHttpUtils getInstance(){
        return okHttpUtils;
    }
    private OkHttpUtils(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(CantantUrl.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        iApi = retrofit.create(IApi.class);
    }

    public void movielogin(IOkCallBack iOkCallBack, Class<B> loginBeanClass, String etLoginZhanghao, String etLoginMima) {
        Observable<LoginBean> login = iApi.movieLogin(etLoginZhanghao, etLoginMima);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        iOkCallBack.callSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void movieBanner(IOkCallBack<MovieFragBannerBean> hhhhhhhh, Class<B> movieFragBannerBeanClass) {
        Observable<MovieFragBannerBean> movieBanner = iApi.movieBanner();
        movieBanner.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieFragBannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieFragBannerBean movieFragBannerBean) {
                        hhhhhhhh.callSuccess(movieFragBannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void IsHotMovie(IOkCallBack<IsHotMovieBean> isHotMovieBeanIOkCallBack, Class<B> isHotMovieBeanClass, int page, int count) {
        Observable<IsHotMovieBean> hitMovie = iApi.isHotMovie(page, count);
        hitMovie.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new Observer<IsHotMovieBean>() {
                  @Override
                  public void onSubscribe(Disposable d) {

                  }

                  @Override
                  public void onNext(IsHotMovieBean isHotMovieBean) {
                      isHotMovieBeanIOkCallBack.callSuccess(isHotMovieBean);
                  }

                  @Override
                  public void onError(Throwable e) {

                  }

                  @Override
                  public void onComplete() {

                  }
              });
    }

    public void upComingMovie(IOkCallBack<UpComingBean> upComingBeanIOkCallBack, Class<B> upComingBeanClass, int page, int count) {
        Observable<UpComingBean> upComingMovie = iApi.upComingMovie(page, count);
        upComingMovie.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Observer<UpComingBean>() {
                   @Override
                   public void onSubscribe(Disposable d) {

                   }

                   @Override
                   public void onNext(UpComingBean upComingBean) {
                       upComingBeanIOkCallBack.callSuccess(upComingBean);
                   }

                   @Override
                   public void onError(Throwable e) {

                   }

                   @Override
                   public void onComplete() {

                   }
               });

    }

    public void hotMovie(IOkCallBack<HotMovieBean> hotMovieBeanIOkCallBack, Class<B> hotMovieBeanClass, int page, int count) {
        Observable<HotMovieBean> hotMovie = iApi.hotMovie(page, count);
        hotMovie.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new Observer<HotMovieBean>() {
                  @Override
                  public void onSubscribe(Disposable d) {

                  }

                  @Override
                  public void onNext(HotMovieBean hotMovieBean) {
                      hotMovieBeanIOkCallBack.callSuccess(hotMovieBean);
                  }

                  @Override
                  public void onError(Throwable e) {

                  }

                  @Override
                  public void onComplete() {

                  }
              });
    }
    //注册
    public void movieRegister(IOkCallBack<RegisterBean> registerBeanIOkCallBack, Class<B> registerBeanClass, String name, String encrypt, String email, String code) {
        Observable<RegisterBean> movieRegister = iApi.movieRegister(name, email, encrypt, code);
        movieRegister.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                          registerBeanIOkCallBack.callSuccess(registerBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //发送验证码
    public void sendCode(IOkCallBack<CodeBean> codeBeanIOkCallBack, Class<B> codeBeanClass, String trim) {
        Observable<CodeBean> codeBeanObservable = iApi.sendCode(trim);
        codeBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CodeBean codeBean) {
                            codeBeanIOkCallBack.callSuccess(codeBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //查询电影信息明细
    public void cinemaInfo(final IOkCallBack iOkCallBack, Class<B> bean, int userId,String sessionId,int cinemaId) {
        Observable<CinemaDetailsBean> cinemaInfo = iApi.cinemaInfo(userId, sessionId, cinemaId);
        cinemaInfo.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CinemaDetailsBean>() {

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemaDetailsBean cinemaDetailsBean) {
                        iOkCallBack.callSuccess(cinemaDetailsBean);
                    }
                });
    }
    //查询影院用户评论列表
    public void findAllCinemaComment(final IOkCallBack iOkCallBack, Class<B> bean, int userId, String sessionId,int cinemaId, int page, int count) {
        Observable<FindAllCinemaCommentBean> allCinemaComment = iApi.findAllCinemaComment(userId, sessionId, cinemaId, page, count);
        allCinemaComment.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindAllCinemaCommentBean>() {
                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindAllCinemaCommentBean findAllCinemaCommentBean) {
                        iOkCallBack.callSuccess(findAllCinemaCommentBean);
                    }
                });
    }
    public void search(IOkCallBack<SearchBean> searchBeanIOkCallBack, Class<B> searchBeanClass, String keyword, int page, int count) {
        Observable<SearchBean> searchBeanObservable = iApi.movieSearch(keyword, page, count);
        searchBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SearchBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SearchBean searchBean) {
                        searchBeanIOkCallBack.callSuccess(searchBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public void cinemaByRegion(IOkCallBack<CinemaByRegionBean> cinemaByRegionBeanIOkCallBack, Class<B> cinemaByRegionBeanClass, int regionId) {
        Observable<CinemaByRegionBean> cinemaByRegion = iApi.cinemaByRegion(regionId);
        cinemaByRegion.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CinemaByRegionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemaByRegionBean cinemaByRegionBean) {
                        cinemaByRegionBeanIOkCallBack.callSuccess(cinemaByRegionBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    public void regionList(IOkCallBack<RegionListBean> regionListBeanIOkCallBack, Class<B> regionListBeanClass) {
        Observable<RegionListBean> regionList = iApi.regionList();
        regionList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegionListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegionListBean regionListBean) {
                        regionListBeanIOkCallBack.callSuccess(regionListBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
    //影片评论回复
    public void movieComment(IOkCallBack<MovieCommentBean> movieCommentBeanIOkCallBack, Class<B> movieCommentBeanClass, int movieId, int page, int count) {
        Observable<MovieCommentBean> movieComment = iApi.movieComment(movieId, page, count);
        movieComment.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieCommentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieCommentBean movieCommentBean) {
                        movieCommentBeanIOkCallBack.callSuccess(movieCommentBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void movieDetails(IOkCallBack<MovieXiangQBean> movieXiangQBeanIOkCallBack, Class<B> movieXiangQBeanClass, int movieId) {
        qBeanObservable = iApi.movieXiang(movieId);
        qBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieXiangQBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieXiangQBean xiangQBean) {
                         movieXiangQBeanIOkCallBack.callSuccess(xiangQBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //添加用户对影片的评论
    public void addMovieComment(IOkCallBack<AddMovieCommentBean> addMovieCommentBeanIOkCallBack, Class<B> addMovieCommentBeanClass, int userId, String sessionId, int movieId, String addMoviecomment, Double addMoviecommentscore) {
        Observable<AddMovieCommentBean> addMovieCommentBeanObservable = iApi.addMovieComment(userId, sessionId, movieId, addMoviecomment, addMoviecommentscore);
        addMovieCommentBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddMovieCommentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AddMovieCommentBean addMovieCommentBean) {
                        addMovieCommentBeanIOkCallBack.callSuccess(addMovieCommentBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public interface IOkCallBack<B> {
        void callSuccess(B bean);

        void callError(String msg);
    }
}
