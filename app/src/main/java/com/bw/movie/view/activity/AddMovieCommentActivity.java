package com.bw.movie.view.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.view.activity.base.BaseActivity;
import com.bw.weidu_movie.R;
import com.bw.movie.model.bean.AddMovieCommentBean;
import com.bw.movie.model.bean.UserBean;
import com.bw.movie.presenter.AddMovieCommentPresenter;
import com.bw.movie.view.interfaces.IContractView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 作者： 姓名
 * 日期： 2019/11/15 10:05
 */
public class AddMovieCommentActivity extends BaseActivity<AddMovieCommentPresenter> implements IContractView.IAddMovieCommentView {
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.et_add_moviecomment_score)
    EditText etAddMoviecommentScore;
    @BindView(R.id.et_add_moviecomment)
    EditText etAddMoviecomment;
    @BindView(R.id.btn_submit_comment)
    Button btnSubmitComment;
    private String name;
    private int movieId;
    private Unbinder bind;
    private int userId;
    private String sessionId;

    @Override
    protected int bindLayout() {
        return R.layout.activity_addmoviecomment;
    }

    @Override
    protected void initView() {
        bind = ButterKnife.bind(this);
    }

    @Override
    protected AddMovieCommentPresenter setPresenter() {
        return new AddMovieCommentPresenter();
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        movieId = intent.getIntExtra("movieId", 0);
        tvName.setText(name);
    }

    @Override
    public void addMovieCommentSuccess(AddMovieCommentBean addMovieCommentBean) {
        if (addMovieCommentBean.getStatus().equals("0000")) {
            Toast.makeText(this, addMovieCommentBean.getMessage(), Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, addMovieCommentBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void Message(UserBean userBean) {
        userId = userBean.getUserId();
        sessionId = userBean.getSessionId();
    }


    @OnClick(R.id.btn_submit_comment)
    public void onClick() {
        String addMoviecomment = etAddMoviecomment.getText().toString().trim();
        String addMoviecommentscore = etAddMoviecommentScore.getText().toString().trim();
        if (TextUtils.isEmpty(addMoviecomment) || TextUtils.isEmpty(addMoviecommentscore)) {
            Toast.makeText(this, "输入的内容不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        presenter.addMovieComment(userId,sessionId,movieId,addMoviecomment,Double.parseDouble(addMoviecommentscore));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
