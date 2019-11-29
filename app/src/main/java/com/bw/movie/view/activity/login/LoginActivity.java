package com.bw.movie.view.activity.login;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.bean.WXLoginBean;
import com.bw.movie.view.activity.base.BaseActivity;
import com.bw.movie.view.interfaces.IContractView;
import com.bw.weidu_movie.R;
import com.bw.movie.model.entry.EncryptUtil;
import com.bw.movie.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoginActivity extends BaseActivity<LoginPresenter> implements IContractView.iMovieLogin {


    @BindView(R.id.et_login_zhanghao)
    EditText etLoginZhanghao;
    @BindView(R.id.et_login_mima)
    EditText etLoginMima;
    @BindView(R.id.btn_forgetPwd)
    Button btnForgetPwd;
    @BindView(R.id.rel)
    RelativeLayout rel;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.view_line1)
    View viewLine1;
    @BindView(R.id.tv_huo)
    TextView tvHuo;
    @BindView(R.id.view_line2)
    View viewLine2;
    @BindView(R.id.btn_VX)
    ImageButton btnVX;
    private Unbinder bind;

    @Override
    protected int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        bind = ButterKnife.bind(this);
    }

    @Override
    protected LoginPresenter setPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    public void loginSuccess(LoginBean loginBean) {
        if (loginBean.getStatus().equals("0000")){
            Toast.makeText(this, loginBean.getMessage(), Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
//            //用户名称
//            intent.putExtra("nickName",loginBean.getResult().getUserInfo().getNickName());
//            //用户头像
//            intent.putExtra("headPic",loginBean.getResult().getUserInfo().getHeadPic());
//            //用户性别
//            intent.putExtra("sex",loginBean.getResult().getUserInfo().getSex());
//            //用户邮箱
//            intent.putExtra("email",loginBean.getResult().getUserInfo().getEmail());
//            startActivity(intent);
//            finish();
        }else {
            Toast.makeText(this, loginBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void loginWXSuccess(WXLoginBean wxLoginBean) {

    }

    @OnClick({R.id.btn_forgetPwd, R.id.tv_register, R.id.btn_login, R.id.btn_VX})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_forgetPwd:
                break;
            case R.id.tv_register:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
            case R.id.btn_login:
                String etLoginZhanghao = this.etLoginZhanghao.getText().toString().trim();
                String etLoginMima = this.etLoginMima.getText().toString().trim();
                String encrypt = EncryptUtil.encrypt(etLoginMima);
                Log.e("MyMessage",encrypt+"");
                if (TextUtils.isEmpty(etLoginZhanghao)||TextUtils.isEmpty(etLoginMima)){
                    Toast.makeText(this, "输入的邮箱不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                presenter.movieLogin(etLoginZhanghao,encrypt);
             case R.id.btn_VX:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
