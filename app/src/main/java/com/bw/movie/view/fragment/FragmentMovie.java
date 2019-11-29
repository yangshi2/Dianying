package com.bw.movie.view.fragment;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bw.movie.model.bean.IsHotMovieBean;
import com.bw.movie.model.bean.MovieFragBannerBean;
import com.bw.movie.model.bean.ReserveBean;
import com.bw.movie.model.bean.UpComingBean;
import com.bw.movie.presenter.MovieHomePresenter;
import com.bw.movie.view.activity.MovieDetailsActivity;
import com.bw.movie.view.activity.SearchActivity;
import com.bw.movie.view.activity.shouye.GengDuoActivity;
import com.bw.movie.view.adapter.RecyclerUpComingAdapter;
import com.bw.movie.view.adapter.RecyclerViewHotAdapter;
import com.bw.movie.view.adapter.RecyclerViewIsHotAdapter;
import com.bw.movie.view.interfaces.IBaseView;
import com.bw.movie.view.interfaces.IContractView;
import com.bw.weidu_movie.R;
import com.bw.movie.model.bean.HotMovieBean;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 作者： 姓名
 * 日期： 2019/11/7 10:30
 */
public class FragmentMovie extends Fragment implements IContractView.iMovieView, IBaseView {

    @BindView(R.id.img_location)
    ImageButton imgLocation;
    @BindView(R.id.img_search)
    ImageButton imgSearch;
    @BindView(R.id.banner)
    XBanner banner;
    @BindView(R.id.frag_movie_page)
    TextView fragMoviePage;
    @BindView(R.id.tv_movie_more1)
    TextView tvMovieMore1;

    @BindView(R.id.tv_movie_more2)
    TextView tvMovieMore2;

    @BindView(R.id.tv_movie_more3)
    TextView tvMovieMore3;
    @BindView(R.id.btn_buy_ticket)
    Button btnBuyTicket;
    @BindView(R.id.iv_imageUrl)
    ImageView ivImageUrl;
    @BindView(R.id.recycler_isHit)
    RecyclerView recyclerIsHit;
    @BindView(R.id.recycler_upComing)
    RecyclerView recyclerUpComing;
    @BindView(R.id.recycler_hot)
    RecyclerView recyclerHot;
    @BindView(R.id.textdw)
    TextView textdw;
    private int page = 1;
    private int count = 14;
    private Unbinder unbinder;
    private MovieHomePresenter homePresenter;
    private List<IsHotMovieBean.ResultBean> isHotResult;
    private RecyclerViewIsHotAdapter recyclerViewIsHotAdapter;
    private List<UpComingBean.ResultBean> upComingBeanResult;
    private RecyclerUpComingAdapter recyclerUpComingAdapter;
    private List<HotMovieBean.ResultBean> hotResult;
    private RecyclerViewHotAdapter recyclerViewHotAdapter;
    private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;
    private int GPS_REQUEST_CODE = 10;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_movie, null);
        unbinder = ButterKnife.bind(this, inflate);
        homePresenter = new MovieHomePresenter();
        homePresenter.attachView(this);

        //首页Banner
        homePresenter.movieBenner();
        //正在热映
        homePresenter.IsHotMovie(page, count);
        //即将上映
        homePresenter.upComingMovie(page, count);
        //热门电影
        homePresenter.hotMovie(page, count);
        //点击更多跳到更多页面
        tvMovieMore1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), GengDuoActivity.class));
            }
        });
        tvMovieMore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), GengDuoActivity.class));
            }
        });
        tvMovieMore3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), GengDuoActivity.class));
            }
        });
        imgLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
                    //开启定位权限,200是标识码
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
                } else {
                    MyLocation(getActivity());//开始定位
                }
            }

        });
        return inflate;

    }

    public void MyLocation(final Context context) {
        mlocationClient = new AMapLocationClient(getActivity());
        mLocationOption = new AMapLocationClientOption();
        mlocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation amapLocation) {
                try {
                    if (amapLocation != null) {
                        if (amapLocation.getErrorCode() == 0) {
                            //定位成功回调信息，设置相关消息

                            //获取当前定位结果来源，如网络定位结果，详见定位类型表
                            Log.i("定位类型", amapLocation.getLocationType() + "");
                            Log.i("获取纬度", amapLocation.getLatitude() + "");
                            Log.i("获取经度", amapLocation.getLongitude() + "");
                            Log.i("获取精度信息", amapLocation.getAccuracy() + "");
                            //如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                            Log.i("地址", amapLocation.getAddress());
                            Log.i("国家信息", amapLocation.getCountry());
                            Log.i("省信息", amapLocation.getProvince());
                            Log.i("城市信息", amapLocation.getCity());
                            Log.i("城区信息", amapLocation.getDistrict());
                            Log.i("街道信息", amapLocation.getStreet());
                            Log.i("街道门牌号信息", amapLocation.getStreetNum());
                            Log.i("城市编码", amapLocation.getCityCode());
                            Log.i("地区编码", amapLocation.getAdCode());
                            Log.i("获取当前定位点的AOI信息", amapLocation.getAoiName());
                            Log.i("获取当前室内定位的建筑物Id", amapLocation.getBuildingId());
                            Log.i("获取当前室内定位的楼层", amapLocation.getFloor());
                            Log.i("获取GPS的当前状态", amapLocation.getGpsAccuracyStatus() + "");
                            //获取定位时间
                            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date date = new Date(amapLocation.getTime());
                            Log.i("获取定位时间", df.format(date));
                            textdw.setText(amapLocation.getDistrict());
                            textdw.setTextColor(Color.parseColor("#FFFFFF"));
                            // 停止定位
                            mlocationClient.stopLocation();
                        } else {
                            //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                            Log.e("AmapError", "location Error, ErrCode:"
                                    + amapLocation.getErrorCode() + ", errInfo:"
                                    + amapLocation.getErrorInfo());
                            Toast.makeText(context, "没有权限，请打开权限...", Toast.LENGTH_SHORT).show();
                            new AlertDialog.Builder(context)
                                    .setTitle("定位服务未开启")
                                    .setMessage("请在系统设置中开启定位服务\n" +
                                            "以便为您提供更好的服务")
                                    .setPositiveButton("设置", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                            startActivityForResult(intent, GPS_REQUEST_CODE);
                                        }
                                    })
                                    .show();
                        }
                    }
                } catch (Exception e) {
                }

            }
        });
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationOption.setInterval(5000);
        //设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
        //启动定位
        mlocationClient.startLocation();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
            //开启定位权限,200是标识码
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);

        } else {
            MyLocation(getActivity());//开始定位
            //Toast.makeText(getActivity(),"已开启定位权限",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        // 停止定位
        if (null != mlocationClient) {
            mlocationClient.stopLocation();
        }

    }
    //banner
    @Override
    public void movieBanner(MovieFragBannerBean movieFragBannerBean) {
        List<MovieFragBannerBean.ResultBean> images = movieFragBannerBean.getResult();
        Log.e("hhhhhhhh", images.get(0).getImageUrl());
        banner.setData(images,null);
        banner.setPageChangeDuration(2000);
        banner.setPageTransformer(Transformer.Default);
        banner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(getActivity()).load(images.get(position).getImageUrl()).into((ImageView) view);
                fragMoviePage.setText(images.get(position).getRank()+"/5");
            }
        });
        banner.startAutoPlay();
    }
    //正在热
    @Override
    public void IsHotSuccess(IsHotMovieBean isHotMovieBean) {
        isHotResult = isHotMovieBean.getResult() ;
        recyclerViewIsHotAdapter = new RecyclerViewIsHotAdapter(getActivity());

        recyclerViewIsHotAdapter.addData(isHotResult);
        recyclerIsHit.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recyclerIsHit.setAdapter(recyclerViewIsHotAdapter);

        recyclerViewIsHotAdapter.onItemClickListener(new RecyclerViewIsHotAdapter.OnItemClickListener() {

            private int movieId;
            @Override
            public void onItemClick(int position) {
                movieId = isHotResult.get( position).getMovieId();
                Intent intent = new Intent(getActivity(), MovieDetailsActivity.class);
                intent.putExtra("movieId", movieId);
                startActivity(intent);
            }
        });
    }
    //即将上映
    @Override
    public void upComingSuccess(UpComingBean upComingBean) {
        upComingBeanResult = upComingBean.getResult();
        recyclerUpComingAdapter = new RecyclerUpComingAdapter(getActivity());
        recyclerUpComingAdapter.addData(upComingBeanResult);
        recyclerUpComing.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        recyclerUpComing.setAdapter(recyclerUpComingAdapter)
           ;
        recyclerUpComingAdapter.onItemClickListener(new RecyclerUpComingAdapter.OnItemClickListener() {
            private int movieId;
            @Override
            public void onItemClick(int position) {

                movieId = upComingBean.getResult().get(position).getMovieId();
                Intent intent = new Intent(getActivity(), MovieDetailsActivity.class);
                intent.putExtra("movieId",movieId);
                startActivity(intent);
            }

            @Override
            public void appointmentClick(int movieId) {

            }
        });
    }

    //热门电影
    @Override
    public void hotSuccess(HotMovieBean hotMovieBean) {

        hotResult = hotMovieBean.getResult();
        recyclerViewHotAdapter = new RecyclerViewHotAdapter(getActivity());
        recyclerViewHotAdapter.addData(hotResult);
        recyclerHot.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerHot.setAdapter(recyclerViewHotAdapter);

        Glide.with(getActivity()).load(hotResult.get(1).getHorizontalImage())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .into(ivImageUrl);
        recyclerViewHotAdapter.onItemClickListener(new RecyclerViewHotAdapter.OnItemClickListener() {

            private int movieId;

            @Override
            public void onItemClick(int position) {
                movieId = hotMovieBean.getResult().get(position).getMovieId();
                Intent intent = new Intent(getActivity(), MovieDetailsActivity.class);
                intent.putExtra("movieId", movieId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void reserveSuccess(ReserveBean reserveBean) {

    }

    @OnClick({R.id.img_location, R.id.img_search, R.id.tv_movie_more1, R.id.tv_movie_more2, R.id.tv_movie_more3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_location:
                break;
            case R.id.img_search:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
            case R.id.tv_movie_more1:
                break;
            case R.id.tv_movie_more2:
                break;
            case R.id.tv_movie_more3:
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        homePresenter.detachView();
    }
}
