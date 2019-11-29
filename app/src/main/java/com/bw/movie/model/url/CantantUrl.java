package com.bw.movie.model.url;

/**
 * date:2019/9/4
 * author:孙杰健(fdg)
 * function:
 */
public class CantantUrl {

    public static boolean isDeBug = true;
    public static String testUrl = "http://172.17.8.100/";
    public static String lineUrl = "http://mobile.bwstudent.com/";
    public static String baseUrl(){
        return isDeBug == true ? testUrl:lineUrl;
    }
    //公共的
    public static final String BASE_URL =  baseUrl();

    //登录
    public static final String LOGIN_URL = "movieApi/user/v2/login";

    //微信登录
    public static final String WXLOGIN_URL = "movieApi/user/v1/weChatBindingLogin";

    //注册
    public static final String REGISTER_URL = "movieApi/user/v2/register";

    //发送验证码
    public static final String SENDCODE_URL = "movieApi/user/v2/sendOutEmailCode";

    //首页展示banner
    public static final String MOVIEBANNER_URL = "movieApi/tool/v2/banner";

    //首页展示正在热映
    public static final String ISHITMOVIE_URL = "movieApi/movie/v2/findReleaseMovieList";

    //首页展示即将上映
    public static final String UPCOMING_URL = "movieApi/movie/v2/findComingSoonMovieList";

    //首页展示热门电影
    public static final String HOT_URL = "movieApi/movie/v2/findHotMovieList";

    //根据电影ID和影院ID查询电影排期列表
    public static final String MovieSchedule_URL = "movieApi/movie/v2/findMovieSchedule";

    //根据影厅id 查询座位信息
    public static final String SeatInfo_URL = "movieApi/movie/v2/findSeatInfo";

    //首页展示热门电影
    public static final String MOVIEDETAILS_URL = "movieApi/movie/v2/findMoviesDetail";

    //查询影片评论回复
    public static final String MovieComment_URL = "movieApi/movie/v2/findAllMovieComment";

    //根据关键字查询电影信息
    public static final String MovieByKeyword_URL = "movieApi/movie/v2/findMovieByKeyword";

    //添加用户对影片的评论
    public static final String AddMovieComment_URL = "movieApi/movie/v1/verify/movieComment";

    //购票下单
    public static final String buyMovieTickets_URL = "movieApi/movie/v2/verify/buyMovieTickets";

    //支付
    public static final String Pay_URL = "movieApi/movie/v2/verify/pay";

    //查询推荐影院信息
    public static final String RecommendCinema_URL = "movieApi/cinema/v1/findRecommendCinemas";

    //添加用户对影片的评论
    public static final String NearbyCinema_URL = "movieApi/cinema/v1/findNearbyCinemas";

    //预约
    public static final String Reserve_URL = "movieApi/movie/v2/verify/reserve";

    //查询系统消息列表
    public static final String SysMsg_URL = "movieApi/tool/v1/verify/findAllSysMsgList";

    //查询影院用户评论列表
    public static final String findAllCinemaComment_URL = "movieApi/cinema/v1/findAllCinemaComment";

    //查询用户关注电影列表
    public static final String UserFollowMovie_URL = "movieApi/user/v2/verify/findUserFollowMovieList";

    //查询新版本
    public static final String Update_URL = "movieApi/tool/v1/findNewVersion";

    //查询电影信息明细
    public static final String CinemaInfo_URL = "movieApi/cinema/v1/findCinemaInfo";

    //查询区域列表
    public static final String RegionList_URL = "movieApi/tool/v2/findRegionList";

    //根据区域查询影院
    public static final String CinemaByRegion_URL = "movieApi/cinema/v2/findCinemaByRegion";
}
