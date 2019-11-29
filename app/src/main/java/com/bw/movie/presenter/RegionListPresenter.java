package com.bw.movie.presenter;

import com.bw.movie.model.bean.CinemaByRegionBean;
import com.bw.movie.model.bean.RegionListBean;
import com.bw.movie.model.http.OkHttpUtils;
import com.bw.movie.view.interfaces.IContractView;

/**
 * 作者： 姓名
 * 日期： 2019/11/15 09:10
 */
public class RegionListPresenter extends BasePresenter<IContractView.IRegionListView> {

    public void cinemaByRegion(int regionId) {
        OkHttpUtils.getInstance().cinemaByRegion(new OkHttpUtils.IOkCallBack<CinemaByRegionBean>() {
            @Override
            public void callSuccess(CinemaByRegionBean bean) {
                getView().cinemaByRegionSuccess(bean);
            }

            @Override
            public void callError(String msg) {

            }
        }, CinemaByRegionBean.class,regionId);
    }


    public void regionList() {
        OkHttpUtils.getInstance().regionList(new OkHttpUtils.IOkCallBack<RegionListBean>() {
            @Override
            public void callSuccess(RegionListBean bean) {
                getView().regionSuccess(bean);
            }

            @Override
            public void callError(String msg) {

            }
        }, RegionListBean.class);
    }
}
