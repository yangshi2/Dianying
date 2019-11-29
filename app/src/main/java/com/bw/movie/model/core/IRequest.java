package com.bw.movie.model.core;

import com.bw.movie.model.wangben.Bean;
import com.bw.movie.model.wangben.YingXiang;
import com.bw.movie.model.wangben.YingYuan;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 作者:王帅
 * 时间:2019/11/11
 * 功能:
 */
public interface IRequest {
    @GET("movie/v2/findHotMovieList")
    Observable<Bean<List<YingXiang>>> MovieList(@Query("page")String page, @Query("count")String count);

    @GET("movie/v2/findReleaseMovieList")
    Observable<Bean<List<YingXiang>>> findRelease(@Query("page")String page, @Query("count")String count);

    @GET("movie/v2/findComingSoonMovieList")
    Observable<Bean<List<YingXiang>>> findComingSoonMovie(@Query("page")String page,@Query("count")String count);

    @GET("cinema/v1/findRecommendCinemas")
    Observable<Bean<List<YingYuan>>>getyingyuan(@Query("page")String page, @Query("count")String count);
    @GET("cinema/v1/findNearbyCinemas")
    Observable<Bean<List<YingYuan>>>getFuYingYuan(@Query("page")String page,@Query("count")String count);
}
