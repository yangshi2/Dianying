package com.bw.movie.presenter;

import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.http.OkHttpUtils;
import com.bw.movie.view.interfaces.IContractView;

/**
 * 作者： 姓名
 * 日期： 2019/11/6 13:55
 */
public class LoginPresenter extends BasePresenter<IContractView.iMovieLogin> {

    public void movieLogin(String etLoginZhanghao, String encrypt) {
        OkHttpUtils.getInstance().movielogin(new OkHttpUtils.IOkCallBack<LoginBean>() {
            @Override
            public void callSuccess(LoginBean bean) {
                getView().loginSuccess(bean);
            }

            @Override
            public void callError(String msg) {

            }

        },LoginBean.class,etLoginZhanghao,encrypt);
    }
}
