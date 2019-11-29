package com.bw.movie.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bw.weidu_movie.R;
import com.bw.movie.view.fragment.FragmentCinema;
import com.bw.movie.view.fragment.FragmentMovie;
import com.bw.movie.view.fragment.FragmentMy;

public class HomeActivity extends AppCompatActivity {

    private FrameLayout frame;
    private RadioGroup radio_group;
    private TextView text_dianying;
    private TextView text_yingyuan;
    private TextView text_wode;
    private RadioButton radio_dianying;
    private RadioButton radio_yingyuan;
    private RadioButton radio_wode;
    private FragmentMovie fragmentMovie;

    private FragmentManager supportFragmentManager;
    private FragmentCinema fragmentCinema;
    private FragmentMy fragmentMy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        frame = findViewById(R.id.frame);
        text_dianying = findViewById(R.id.text_dianying);
        text_yingyuan = findViewById(R.id.text_yingyuan);
        text_wode = findViewById(R.id.text_wode);
        radio_dianying = findViewById(R.id.radio_dianying);
        radio_yingyuan = findViewById(R.id.radio_yingyuan);
        radio_wode = findViewById(R.id.radio_wode);
        radio_group = findViewById(R.id.radio_group);
        fragmentMovie = new FragmentMovie();
        fragmentCinema = new FragmentCinema();
        fragmentMy = new FragmentMy();
        supportFragmentManager = getSupportFragmentManager();
        Bitmap a = null;
        radio_dianying.setButtonDrawable(new BitmapDrawable(a));
        radio_yingyuan.setButtonDrawable(new BitmapDrawable(a));
        radio_wode.setButtonDrawable(new BitmapDrawable(a));
        supportFragmentManager.beginTransaction()
                .add(R.id.frame, fragmentMovie)
                .add(R.id.frame, fragmentCinema)
                .add(R.id.frame, fragmentMy)
                .show(fragmentMovie)
                .hide(fragmentCinema)
                .hide(fragmentMy)
                .commit();
        radio_dianying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_dianying.setVisibility(View.VISIBLE);
                text_yingyuan.setVisibility(View.INVISIBLE);
                text_wode.setVisibility(View.INVISIBLE);
                radio_dianying.setChecked(true);
                radio_yingyuan.setChecked(false);
                radio_wode.setChecked(false);
                supportFragmentManager.beginTransaction()
                        .show(fragmentMovie)
                        .hide(fragmentCinema)
                        .hide(fragmentMy)
                        .commit();
            }
        });
        radio_yingyuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_yingyuan.setVisibility(View.VISIBLE);
                text_dianying.setVisibility(View.INVISIBLE);
                text_wode.setVisibility(View.INVISIBLE);
                radio_yingyuan.setChecked(true);
                radio_dianying.setChecked(false);
                radio_wode.setChecked(false);
                supportFragmentManager.beginTransaction()
                        .show(fragmentCinema)
                        .hide(fragmentMovie)
                        .hide(fragmentMy)
                        .commit();
            }
        });
        radio_wode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_wode.setVisibility(View.VISIBLE);
                text_yingyuan.setVisibility(View.INVISIBLE);
                text_dianying.setVisibility(View.INVISIBLE);
                radio_wode.setChecked(true);
                radio_yingyuan.setChecked(false);
                radio_dianying.setChecked(false);
                supportFragmentManager.beginTransaction()
                        .show(fragmentMy)
                        .hide(fragmentMovie)
                        .hide(fragmentCinema)
                        .commit();
            }
        });
    }
}
