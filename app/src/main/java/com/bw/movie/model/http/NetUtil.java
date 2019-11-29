package com.bw.movie.model.http;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者:王帅
 * 时间:2019/11/11
 * 功能:
 */
public class NetUtil {

    private static NetUtil netUtil;
    private final Retrofit retrofit;

    private NetUtil(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("http://172.17.8.100/movieApi/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }
    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }
    public static NetUtil getInstance(){
        if (netUtil==null){
            netUtil = new NetUtil();
        }
        return netUtil;
    }
}
