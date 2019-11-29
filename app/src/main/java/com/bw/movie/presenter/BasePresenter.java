package com.bw.movie.presenter;

import com.bw.movie.view.interfaces.IBaseView;

/**
 * 作者： 姓名
 * 日期： 2019/11/5 15:57
 */
public class BasePresenter<V extends IBaseView> {
    private V v;
     public void attachView(V iBaseView){
          v = iBaseView;
     }
     public void detachView(){
         this.v = null;
     }
     public V getView(){
         return v;
     }
}
