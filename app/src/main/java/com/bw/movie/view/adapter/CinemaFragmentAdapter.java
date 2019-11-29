package com.bw.movie.view.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 作者:王帅
 * 时间:2019/11/14
 * 功能:
 */
public class CinemaFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public CinemaFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
