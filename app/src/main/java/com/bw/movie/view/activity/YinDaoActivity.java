package com.bw.movie.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;

import com.bw.weidu_movie.R;

public class YinDaoActivity extends AppCompatActivity {
    private RelativeLayout yindaoye;
    private int time=3;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what==1){
                if (time>0){
                    time--;
                    handler.sendEmptyMessageDelayed(1,1000);
                }else {
                    Intent intent = new Intent(YinDaoActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yin_dao);
        yindaoye = findViewById(R.id.yindaoye);
        yindaoye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YinDaoActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        handler.sendEmptyMessageDelayed(1,1000);
    }
}
