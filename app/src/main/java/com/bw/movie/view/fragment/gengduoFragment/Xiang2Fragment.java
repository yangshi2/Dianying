package com.bw.movie.view.fragment.gengduoFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.weidu_movie.R;

public class Xiang2Fragment extends Fragment {

    private View inflate;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_xiang2, container, false);
        return inflate;
    }


}
