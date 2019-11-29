package com.bw.movie.model.http;

import android.app.Application;
import android.util.Log;

import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;

/**
 * 作者： 姓名
 * 日期： 2019/11/23 09:45
 */
public class BaseApplication extends Application {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        initXGPush();
    }

    private void initXGPush() {
        XGPushConfig.enableDebug(this,true);
        XGPushManager.registerPush(this, new XGIOperateCallback(){
            @Override
            public void onSuccess(Object data, int flag){
                //token在设备卸载重装的时候有可能会变
                Log.e("TPush","注册成功，设备token为："+ data);
                setToken(data.toString());
            }
            @Override
            public void onFail(Object data, int errCode,String msg) {
                Log.e("TPush","注册失败，错误码："+ errCode +",错误信息："+ msg);
            }
        });

//设置账号
        XGPushManager.registerPush(getApplicationContext(),"XINGE");
// 设置标签
        XGPushManager.setTag(this,"XINGE");
    }
    }

