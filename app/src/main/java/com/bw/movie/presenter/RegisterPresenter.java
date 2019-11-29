package com.bw.movie.presenter;

import com.bw.movie.model.bean.CodeBean;
import com.bw.movie.model.bean.RegisterBean;
import com.bw.movie.model.http.OkHttpUtils;
import com.bw.movie.view.interfaces.IContractView;

/**
 * 作者： 姓名
 * 日期： 2019/11/12 13:52
 */
public class RegisterPresenter extends BasePresenter<IContractView.iMovieRegister> {

    public void sendCode(String trim) {
        OkHttpUtils.getInstance().sendCode(new OkHttpUtils.IOkCallBack<CodeBean>() {
            @Override
            public void callSuccess(CodeBean bean) {
                 getView().sendCode(bean);
            }

            @Override
            public void callError(String msg) {

            }
        },CodeBean.class,trim);
    }

    public void movieRegister(String name, String email, String encrypt, String code) {
        OkHttpUtils.getInstance().movieRegister(new OkHttpUtils.IOkCallBack<RegisterBean>() {
            @Override
            public void callSuccess(RegisterBean bean) {
                getView().registerSuccess(bean);
            }

            @Override
            public void callError(String msg) {

            }
        },RegisterBean.class,name,encrypt,email,code);
    }
}
