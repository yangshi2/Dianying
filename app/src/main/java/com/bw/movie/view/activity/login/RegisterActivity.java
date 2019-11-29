package com.bw.movie.view.activity.login;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bw.movie.model.bean.CodeBean;
import com.bw.movie.model.bean.RegisterBean;
import com.bw.movie.presenter.RegisterPresenter;
import com.bw.movie.view.activity.base.BaseActivity;
import com.bw.movie.view.interfaces.IContractView;
import com.bw.weidu_movie.R;
import com.bw.movie.model.entry.EncryptUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 作者： 姓名
 * 日期： 2019/11/6 14:25
 */
public class RegisterActivity extends BaseActivity<RegisterPresenter> implements IContractView.iMovieRegister {

    @BindView(R.id.er_register_nicheng)
    EditText erRegisterNicheng;
    @BindView(R.id.er_register_youxiang)
    EditText erRegisterYouxiang;
    @BindView(R.id.er_register_mima)
    EditText erRegisterMima;
    @BindView(R.id.et_register_yanzhengma)
    EditText etRegisterYanzhengma;
    @BindView(R.id.btn_sendCode)
    Button btn_sendCode;
    @BindView(R.id.rel)
    RelativeLayout rel;
    @BindView(R.id.btn_login)
    Button btn_login;
    @BindView(R.id.btn_register)
    Button btnRegister;
    private Unbinder bind;

    @Override
    protected int bindLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        bind = ButterKnife.bind(this);
    }

    @Override
    protected RegisterPresenter setPresenter() {
        return new RegisterPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    public void registerSuccess(RegisterBean registerBean) {
        if (registerBean.getStatus().equals("0000")) {
            Toast.makeText(this, registerBean.getMessage(), Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            finish();
        } else {
            Toast.makeText(this, registerBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void sendCode(CodeBean codeBean) {
        if (codeBean.getStatus().equals("0000")) {
            Toast.makeText(this, codeBean.getMessage(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, codeBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }



    @OnClick({R.id.btn_sendCode, R.id.btn_login, R.id.btn_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sendCode:
                String trim = erRegisterYouxiang.getText().toString().trim();
                presenter.sendCode(trim);
                break;
            case R.id.btn_login:
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                break;
            case R.id.btn_register:
                String name = erRegisterNicheng.getText().toString().trim();
                String email = erRegisterYouxiang.getText().toString().trim();
                String mima = erRegisterMima.getText().toString().trim();
                String code = etRegisterYanzhengma.getText().toString().trim();
                String encrypt = EncryptUtil.encrypt(mima);
                if (TextUtils.isEmpty(name)||TextUtils.isEmpty(email)||TextUtils.isEmpty(mima)){
                    Toast.makeText(this, "名字 邮箱 密码输入不能为空!", Toast.LENGTH_SHORT).show();
                    return;
                }
                presenter.movieRegister(name,encrypt,email,code);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
