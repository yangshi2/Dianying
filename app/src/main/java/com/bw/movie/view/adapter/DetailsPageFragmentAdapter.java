package com.bw.movie.view.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 作者： 姓名
 * 日期： 2019/11/15 09:58
 */
public class DetailsPageFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> detailsPageFragments;

    public DetailsPageFragmentAdapter(FragmentManager fm, List<Fragment> detailsPageFragments) {
        super(fm);
        this.detailsPageFragments = detailsPageFragments;
    }

    @Override
    public Fragment getItem(int i) {
        return detailsPageFragments.get(i);
    }

    @Override
    public int getCount() {
        return detailsPageFragments.size();
    }
}