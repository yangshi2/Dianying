package com.bw.movie.model.api;


import com.bw.movie.model.bean.CinemaByRegionBean;
import com.bw.movie.model.bean.CodeBean;
import com.bw.movie.model.bean.IsHotMovieBean;
import com.bw.movie.model.bean.MovieCommentBean;
import com.bw.movie.model.bean.MovieFragBannerBean;
import com.bw.movie.model.bean.RegionListBean;
import com.bw.movie.model.bean.SearchBean;
import com.bw.movie.model.bean.UpComingBean;
import com.bw.movie.model.bean.AddMovieCommentBean;

import com.bw.movie.model.bean.CinemaDetailsBean;

import com.bw.movie.model.bean.FindAllCinemaCommentBean;
import com.bw.movie.model.bean.HotMovieBean;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.bean.MovieScheduleBean;
import com.bw.movie.model.bean.MovieTicketsBean;
import com.bw.movie.model.bean.MovieXiangQBean;
import com.bw.movie.model.bean.RegisterBean;
import com.bw.movie.model.bean.SeatInfoBean;
import com.bw.movie.model.bean.WXLoginBean;
import com.bw.movie.model.url.CantantUrl;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 作者： 姓名
 * 日期： 2019/11/6 11:54
 */
public interface IApi {
    @FormUrlEncoded
    //登录
    @POST(CantantUrl.LOGIN_URL)
    Observable<LoginBean>movieLogin(@Field("email")String email,@Field("pwd")String pwd);

    //微信登录
    @FormUrlEncoded
    @POST(CantantUrl.WXLOGIN_URL)
    Observable<WXLoginBean>movieWXLogin(@Field("code") String code);

    //发送验证码
    @FormUrlEncoded
    @POST(CantantUrl.SENDCODE_URL)
    Observable<CodeBean>sendCode(@Field("email") String email);

    //注册
    @FormUrlEncoded
    @POST(CantantUrl.REGISTER_URL)
    Observable<RegisterBean>movieRegister(@Field("nickName") String nickName,
                                          @Field("pwd") String pwd,
                                          @Field("email") String email,
                                          @Field("code") String code);
    //首页展示Banner
    @GET(CantantUrl.MOVIEBANNER_URL)
    Observable<MovieFragBannerBean> movieBanner();

    //首页正在热映
    @GET(CantantUrl.ISHITMOVIE_URL)
    Observable<IsHotMovieBean>isHotMovie(@Query("page")int page, @Query("count")int count);

    //首页即将上映
    @GET(CantantUrl.UPCOMING_URL)
    Observable<UpComingBean> upComingMovie(@Query("page") int page,
                                           @Query("count") int count);

    //首页展示热门电影
    @GET(CantantUrl.HOT_URL)
    Observable<HotMovieBean> hotMovie(@Query("page") int page,
                                      @Query("count") int count);

    //根据关键字查询电影信息
    @GET(CantantUrl.MovieByKeyword_URL)
    Observable<SearchBean> movieSearch(@Query("keyword") String keyword,
                                       @Query("page") int page,
                                       @Query("count") int count);


    //电影详情
    @GET(CantantUrl.MOVIEDETAILS_URL)
    Observable<MovieXiangQBean> movieXiang(@Query("movieId") int movieId);

    //查询影片评论回复
    @GET(CantantUrl.MovieComment_URL)
    Observable<MovieCommentBean> movieComment(@Query("movieId") int movieId,
                                              @Query("page") int page,
                                              @Query("count") int count);
    //根据区域查询影院
    @GET(CantantUrl.CinemaByRegion_URL)
    Observable<CinemaByRegionBean> cinemaByRegion(@Query("regionId") int regionId);

    //查询区域列表
    @GET(CantantUrl.RegionList_URL)
    Observable<RegionListBean> regionList();

    //查询电影信息明细
    @GET(CantantUrl.CinemaInfo_URL)
    Observable<CinemaDetailsBean> cinemaInfo(@Header("userId") int userId,
                                             @Header("sessionId") String sessionId,
                                             @Query("cinemaId") int cinemaId);

    //查询影院用户评论列表
    @GET(CantantUrl.findAllCinemaComment_URL)
    Observable<FindAllCinemaCommentBean> findAllCinemaComment(@Header("userId") int userId,
                                                              @Header("sessionId") String sessionId,
                                                              @Query("cinemaId") int cinemaId,
                                                              @Query("page") int page,
                                                              @Query("count") int count);

    //添加用户对影片的评论
    @FormUrlEncoded
    @POST(CantantUrl.AddMovieComment_URL)
    Observable<AddMovieCommentBean> addMovieComment(@Header("userId") int userId,
                                                    @Header("sessionId") String sessionId,
                                                    @Field("movieId") int movieId,
                                                    @Field("commentContent") String commentContent,
                                                    @Field("score") double score);

    //根据电影ID和影院ID查询电影排期列表
    @GET(CantantUrl.MovieSchedule_URL)
    Observable<MovieScheduleBean> movieSchedule(@Query("movieId") int movieId,
                                                @Query("cinemaId") int cinemaId);

    //购票下单
    @FormUrlEncoded
    @POST(CantantUrl.buyMovieTickets_URL)
    Observable<MovieTicketsBean> buyMovieTickets(@Header("userId") int userId,
                                                 @Header("sessionId") String sessionId,
                                                 @Field("scheduleId") int scheduleId,
                                                 @Field("seat") String seat,
                                                 @Field("sign") String sign);

    //根据影厅id 查询座位信息
    @GET(CantantUrl.SeatInfo_URL)
    Observable<SeatInfoBean> seatInfo(@Query("hallId") int hallId);

}
