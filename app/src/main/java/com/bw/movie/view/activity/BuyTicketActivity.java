package com.bw.movie.view.activity;

import android.content.Intent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.view.activity.base.BaseActivity;
import com.bw.weidu_movie.R;
import com.bw.movie.model.bean.MovieScheduleBean;
import com.bw.movie.model.bean.MovieTicketsBean;
import com.bw.movie.model.bean.SeatInfoBean;
import com.bw.movie.presenter.MovieSchedulePresenter;
import com.bw.movie.view.adapter.RecyclerMovieScheduleAdapter;
import com.bw.movie.view.interfaces.IContractView;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * 作者： 姓名
 * 日期： 2019/11/15 09:31
 */
public class BuyTicketActivity extends BaseActivity<MovieSchedulePresenter> implements IContractView.IMovieScheduleView {
    @BindView(R.id.tv_movie_name)
    TextView tvMovieName;
    @BindView(R.id.jcv_movie_video)
    JCVideoPlayer jcvMovieVideo;

    @BindView(R.id.recycler_movie_schedule)
    RecyclerView recyclerMovieSchedule;
    @BindView(R.id.lin_cinema_date)
    LinearLayout linCinemaDate;
    @BindView(R.id.rb_wx_buy_ticket)
    RadioButton rbWxBuyTicket;
    @BindView(R.id.rb_zfb_buy_ticket)
    RadioButton rbZfbBuyTicket;
    @BindView(R.id.lin_pay_method)
    LinearLayout linPayMethod;
    @BindView(R.id.btn_buy_cinema_ticket)
    Button btnBuyCinemaTicket;
    @BindView(R.id.btn_purchaseOrder)
    Button btnPurchaseOrder;
    @BindView(R.id.room_movieSeat)
    RecyclerView roomMovieSeat;
    private Unbinder bind;
    private String videoUrl;
    private String imageUrl;
    private String movieName;
    private List<MovieScheduleBean.ResultBean> result;
    private RecyclerMovieScheduleAdapter movieScheduleAdapter;
    private int id;
    private int userId;
    private String sessionId;

    @Override
    protected int bindLayout() {
        return R.layout.activity_buytickets;
    }

    @Override
    protected void initView() {
        bind = ButterKnife.bind(this);
    }

    @Override
    protected MovieSchedulePresenter setPresenter() {
        return new MovieSchedulePresenter();
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        int cinemaId = intent.getIntExtra("cinemaId", 0);
        videoUrl = intent.getStringExtra("videoUrl");
        imageUrl = intent.getStringExtra("imageUrl");
        movieName = intent.getStringExtra("movieName");
        jcvMovieVideo.setUp(videoUrl, "");
        Glide.with(this).load(imageUrl).into(jcvMovieVideo.ivThumb);
        tvMovieName.setText(movieName);
        presenter.movieSchedule(movieId, cinemaId);
    }

    //排期
    @Override
    public void movieScheduleSuccess(MovieScheduleBean movieScheduleBean) {
        result = movieScheduleBean.getResult();
        if (result.size() > 0) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
            movieScheduleAdapter = new RecyclerMovieScheduleAdapter(this);
            movieScheduleAdapter.addData(result);
            recyclerMovieSchedule.setLayoutManager(linearLayoutManager);
            recyclerMovieSchedule.setAdapter(movieScheduleAdapter);
            movieScheduleAdapter.onItemClickListener(new RecyclerMovieScheduleAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    id = result.get(position).getId();
                    presenter.seatInfo(result.get(position).getHallId());
                }
            });
        } else {
            Toast.makeText(this, "该影院不提供影厅选择", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    //下单
    @Override
    public void buyMovieTicketsSuccess(MovieTicketsBean movieTicketsBean) {
        if (movieTicketsBean.getMessage().equals("0000")){
            Toast.makeText(this,movieTicketsBean.getMessage(), Toast.LENGTH_SHORT).show();
            String orderId = movieTicketsBean.getOrderId();
            presenter.pay(userId,sessionId,1,orderId);
        }
    }

    //选座
    @Override
    public void seatInfoSuccess(SeatInfoBean seatInfoBean) {

    }


}
