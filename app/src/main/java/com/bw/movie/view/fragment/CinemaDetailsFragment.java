package com.bw.movie.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.weidu_movie.R;
import com.bw.movie.model.bean.CinemaDetailsBean;
import com.bw.movie.model.bean.UserBean;
import com.bw.movie.presenter.CinemaDetailsPresenter;
import com.bw.movie.view.interfaces.IContractView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class CinemaDetailsFragment extends Fragment implements IContractView.ICinemaDetailsView {

    @BindView(R.id.tv_cinema_address)
    TextView tvCinemaAddress;
    @BindView(R.id.tv_cinema_phone)
    TextView tvCinemaPhone;
    @BindView(R.id.tv_cinema_vehicleRoute)
    TextView tvCinemaVehicleRoute;
    Unbinder unbinder;
    private int userId;
    private String sessionId;
    private CinemaDetailsPresenter cinemaDetailsPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_cinema_details, null);
        unbinder = ButterKnife.bind(this, inflate);
        //获取粘性事件的值
        EventBus.getDefault().register(this);
        //获取影院ID
        Intent intent = getActivity().getIntent();
        int cinemaId = intent.getIntExtra("cinemaId", 0);
        Log.e("MyMessageId",cinemaId+"");
        cinemaDetailsPresenter = new CinemaDetailsPresenter();
        cinemaDetailsPresenter.attachView(this);
        //调用影院详情接口
        cinemaDetailsPresenter.cinemaInfo(userId, sessionId, cinemaId);
        return inflate;
    }

    @Subscribe(threadMode = ThreadMode.ASYNC, sticky = true)
    public void Message(UserBean userBean) {
        userId = userBean.getUserId();
        sessionId = userBean.getSessionId();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //反注册
        EventBus.getDefault().unregister(this);
        //解绑
        unbinder.unbind();
        //解绑P层
        cinemaDetailsPresenter.detachView();
    }

    @Override
    public void cinemaDetailsSuccess(CinemaDetailsBean cinemaDetailsBean) {
        Log.e("MyMessageResult",cinemaDetailsBean.getResult().getName());
        CinemaDetailsBean.ResultBean result = cinemaDetailsBean.getResult();
        tvCinemaAddress.setText(result.getAddress()+"");
        tvCinemaPhone.setText(result.getPhone()+"");
        tvCinemaVehicleRoute.setText(result.getVehicleRoute());
    }

    @Override
    public void cinemaDetailsError(String msg) {

    }
}
