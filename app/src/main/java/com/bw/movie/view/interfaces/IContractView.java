package com.bw.movie.view.interfaces;


import com.bw.movie.model.bean.AddMovieCommentBean;
import com.bw.movie.model.bean.CinemaByRegionBean;
import com.bw.movie.model.bean.CinemaDetailsBean;
import com.bw.movie.model.bean.CodeBean;
import com.bw.movie.model.bean.FindAllCinemaCommentBean;
import com.bw.movie.model.bean.IsHotMovieBean;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.bean.MovieCommentBean;
import com.bw.movie.model.bean.MovieFragBannerBean;
import com.bw.movie.model.bean.MovieTicketsBean;
import com.bw.movie.model.bean.RegionListBean;
import com.bw.movie.model.bean.RegisterBean;
import com.bw.movie.model.bean.ReserveBean;
import com.bw.movie.model.bean.SearchBean;
import com.bw.movie.model.bean.SeatInfoBean;
import com.bw.movie.model.bean.UpComingBean;
import com.bw.movie.model.bean.WXLoginBean;

import com.bw.movie.model.bean.HotMovieBean;
import com.bw.movie.model.bean.MovieScheduleBean;
import com.bw.movie.model.bean.MovieXiangQBean;

/**
 * 作者： 姓名
 * 日期： 2019/11/5 15:57
 */
public interface IContractView {
    //登录
    interface iMovieLogin extends IBaseView {
        void loginSuccess(LoginBean loginBean);

        void loginWXSuccess(WXLoginBean wxLoginBean);
    }

    //注册
    interface iMovieRegister extends IBaseView {
        void registerSuccess(RegisterBean registerBean);

        void sendCode(CodeBean codeBean);

    }

    //首页展示
    interface iMovieView extends IBaseView {
        void movieBanner(MovieFragBannerBean movieFragBannerBean);

        //正在热映
        void IsHotSuccess(IsHotMovieBean isHotMovieBean);

        //即将
        void upComingSuccess(UpComingBean upComingBean);

        //热门电影
        void hotSuccess(HotMovieBean hotMovieBean);

        void reserveSuccess(ReserveBean reserveBean);
    }

    //根据关键字搜索电影信息
    interface iMovieSearch extends IBaseView {
        void searchSuccess(SearchBean searchBean);
    }

    //电影详情
    interface iMovieXiang extends IBaseView {
        void XiangSuccess(MovieXiangQBean xiangQBean);
    }

    //查询区域列表
    interface IRegionListView extends IBaseView {
        void regionSuccess(RegionListBean regionListBean);

        void cinemaByRegionSuccess(CinemaByRegionBean cinemaByRegionBean);
    }

    //电影评论
    interface IMovieCommentView extends IBaseView {
        void movieCommentSuccess(MovieCommentBean movieCommentBean);
    }

    //根据关键字查询电影信息
    interface ICinemaDetailsView extends IBaseView {
        void cinemaDetailsSuccess(CinemaDetailsBean cinemaDetailsBean);

        void cinemaDetailsError(String msg);
    }

    //查询影院用户评论列表
    interface IAllCinemaCommentView extends IBaseView {
        void allCinemaCommentSuccess(FindAllCinemaCommentBean findAllCinemaCommentBean);

        void allCinemaCommentError(String msg);

    }

    //添加用户对影片的评论
    interface IAddMovieCommentView extends IBaseView {
        //电影评论
        void addMovieCommentSuccess(AddMovieCommentBean addMovieCommentBean);
    }

    //根据电影ID和影院ID查询电影排期列表
    interface IMovieScheduleView extends IBaseView{
        //查看电影排期
        void movieScheduleSuccess(MovieScheduleBean movieScheduleBean);
        //下单
        void buyMovieTicketsSuccess(MovieTicketsBean movieTicketsBean);
        //选座
        void seatInfoSuccess(SeatInfoBean seatInfoBean);
        //支付
//        void paySuccess(PayBean payBean);
//        void movieScheduleError(String msg);
    }

}

