package com.bw.movie.view.activity;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.view.activity.base.BaseActivity;
import com.bw.weidu_movie.R;
import com.bw.movie.model.bean.CinemaByRegionBean;
import com.bw.movie.model.bean.RegionListBean;
import com.bw.movie.presenter.RegionListPresenter;
import com.bw.movie.view.adapter.RecyclerRegionCinemaAdapter;
import com.bw.movie.view.adapter.wangadapter.RecyclerRegionAdapter;
import com.bw.movie.view.interfaces.IContractView;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * 作者： 姓名
 * 日期： 2019/11/15 09:07
 */
public class ChoseCinemaActivity extends BaseActivity<RegionListPresenter> implements IContractView.IRegionListView {
    @BindView(R.id.jcvp)
    JCVideoPlayer jcvp;
    @BindView(R.id.tv_cinema_movie_name)
    TextView tvCinemaMovieName;
    @BindView(R.id.tv_cinema_movie_duration)
    TextView tvCinemaMovieDuration;
    @BindView(R.id.tv_cinema_movie_score)
    TextView tvCinemaMovieScore;
    @BindView(R.id.tv_cinema_movie_director)
    TextView tvCinemaMovieDirector;
    @BindView(R.id.btn_chose_region)
    Button btnChoseRegion;
    @BindView(R.id.recycler_cinema_region_cinema)
    RecyclerView recyclerCinemaRegionCinema;
    private String videoUrl;
    private String imageUrl;
    private String movieName;
    private int movieId;
    private double movieScore;
    private Unbinder bind;
    private List<RegionListBean.ResultBean> result;
    private RecyclerRegionAdapter recyclerRegionAdapter;
    private List<CinemaByRegionBean.ResultBean> cinemaByRegionBeanResult;
    private RecyclerRegionCinemaAdapter recyclerRegionCinemaAdapter;


    @Override
    protected int bindLayout() {
        return R.layout.activity_chosecinema;
    }

    @Override
    protected void initView() {
        bind = ButterKnife.bind(this);
    }

    @Override
    protected RegionListPresenter setPresenter() {
        return new RegionListPresenter();
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        videoUrl = intent.getStringExtra("videoUrl");
        imageUrl = intent.getStringExtra("imageUrl");
        movieName = intent.getStringExtra("movieName");
        movieId = intent.getIntExtra("movieId", 0);
        double movieScore = intent.getDoubleExtra("movieScore", 0);
        String movieDuration = intent.getStringExtra("movieDuration");
        String movieDirector = intent.getStringExtra("movieDirector");

        //名字
        tvCinemaMovieName.setText(movieName);
        //评分
        tvCinemaMovieScore.setText(movieScore + "分");
        //时长
        tvCinemaMovieDuration.setText(movieDuration);
        //导演
        tvCinemaMovieDirector.setText(movieDirector);
        //视频
        jcvp.setUp(videoUrl, "");
        Glide.with(this).load(imageUrl).into(jcvp.ivThumb);

    }

    @Override
    public void regionSuccess(RegionListBean regionListBean) {
        result = regionListBean.getResult();
        recyclerRegionAdapter = new RecyclerRegionAdapter(this);
        recyclerRegionAdapter.addData(result);
        recyclerCinemaRegionCinema.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerCinemaRegionCinema.setAdapter(recyclerRegionAdapter);
        recyclerRegionAdapter.onItemClickListener(new RecyclerRegionAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int regionId) {
                btnChoseRegion.setText(result.get(position).getRegionName());
                presenter.cinemaByRegion(regionId);
            }
        });
    }

    @Override
    public void cinemaByRegionSuccess(CinemaByRegionBean cinemaByRegionBean) {
        cinemaByRegionBeanResult = cinemaByRegionBean.getResult();
        recyclerRegionCinemaAdapter = new RecyclerRegionCinemaAdapter(this);
        recyclerRegionCinemaAdapter.addData(cinemaByRegionBeanResult);
        recyclerCinemaRegionCinema.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerCinemaRegionCinema.setAdapter(recyclerRegionCinemaAdapter);
        recyclerRegionCinemaAdapter.onItemClickListener(new RecyclerRegionCinemaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int cinemaId) {
                Intent intent = new Intent(ChoseCinemaActivity.this, BuyTicketActivity.class);
                intent.putExtra("videoUrl", videoUrl);
                intent.putExtra("imageUrl", imageUrl);
                intent.putExtra("movieName", movieName);
                intent.putExtra("movieId", movieId);
                intent.putExtra("cinemaId", cinemaId);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }


    @OnClick(R.id.btn_chose_region)
    public void onClick() {
        presenter.regionList();
    }
}
