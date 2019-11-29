package com.bw.movie.view.activity.shouye;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.androidkun.xtablayout.XTabLayout;
import com.bw.movie.view.fragment.gengduoFragment.Xiang1Fragment;
import com.bw.movie.view.fragment.gengduoFragment.Xiang3Fragment;
import com.bw.weidu_movie.R;
import com.bw.movie.view.activity.HomeActivity;
import com.bw.movie.view.fragment.gengduoFragment.Xiang2Fragment;

import java.util.ArrayList;
import java.util.List;

public class GengDuoActivity extends AppCompatActivity {
    private ImageView fan;
    private XTabLayout tab_gengduo;
    private ViewPager vp;
    private List<String>strings;
    private List<Fragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geng_duo);
        tab_gengduo = findViewById(R.id.tab_gengduo);
        vp = findViewById(R.id.view_pager_moviemore);
        fan = findViewById(R.id.fan);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GengDuoActivity.this, HomeActivity.class));
            }
        });
        list = new ArrayList<>();
        list.add(new Xiang1Fragment());
        list.add(new Xiang2Fragment());
        list.add(new Xiang3Fragment());
        strings = new ArrayList<>();
        strings.add("正在热映");
        strings.add("即将上映");
        strings.add("热门电影");
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return strings.get(position);
            }
        });
        tab_gengduo.setupWithViewPager(vp);
    }

}
