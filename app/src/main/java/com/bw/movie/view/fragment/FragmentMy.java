package com.bw.movie.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bw.movie.view.activity.SheZhiActivity;
import com.bw.weidu_movie.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FragmentMy extends Fragment {

    @BindView(R.id.iv_xinxi)
    ImageView ivXinxi;
    @BindView(R.id.iv_head_portrait)
    ImageView ivHeadPortrait;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.user_detailed_information)
    RelativeLayout userDetailedInformation;
    @BindView(R.id.user_movie_tickets)
    LinearLayout userMovieTickets;
    @BindView(R.id.iv_my_attention)
    ImageView ivMyAttention;
    @BindView(R.id.iv_my_reservation)
    ImageView ivMyReservation;
    @BindView(R.id.iv_my_ticket_record)
    ImageView ivMyTicketRecord;
    @BindView(R.id.iv_my_movie_seen)
    ImageView ivMyMovieSeen;
    @BindView(R.id.iv_my_comments)
    ImageView ivMyComments;
    @BindView(R.id.iv_feedback)
    ImageView ivFeedback;
    @BindView(R.id.iv_my_set_up)
    ImageView ivMySetUp;
    @BindView(R.id.liner_shezhi)
    LinearLayout liner_shezhi;
    private View inflate;
    private Unbinder unbinder;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_fragment_my, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        liner_shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SheZhiActivity.class));
            }
        });


        return inflate;

    }

}
