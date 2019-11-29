package com.bw.movie.model.bean;

import java.util.List;

/**
 * 作者： 姓名
 * 日期： 2019/11/13 08:58
 */
public class MovieXiangQBean {

    /**
     * result : {"commentNum":5,"duration":"148分钟","imageUrl":"http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg","movieActor":[{"name":"汤姆·克鲁斯","photo":"http://172.17.8.100/images/movie/actor/dzd6qmwj/tangmu.jpg","role":"伊森·亨特"},{"name":"亨利·卡维尔","photo":"http://172.17.8.100/images/movie/actor/dzd6qmwj/hengli.jpg","role":"安格斯·沃克"},{"name":"西蒙·佩吉","photo":"http://172.17.8.100/images/movie/actor/dzd6qmwj/ximeng.jpg","role":"班吉·邓恩"},{"name":"\r\n丽贝卡·弗格森","photo":"http://172.17.8.100/images/movie/actor/dzd6qmwj/libeika.jpg","role":"伊尔莎"}],"movieDirector":[{"name":"克里斯托弗·麦奎里","photo":"http://172.17.8.100/images/movie/director/dzd6qmwj/1.jpg"}],"movieId":16,"movieType":"动作 / 冒险 / 惊悚","name":"碟中谍6：全面瓦解","placeOrigin":"美国","posterList":["http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj2.jpg","http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj3.jpg","http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj4.jpg","http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj5.jpg","http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj6.jpg","http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg"],"releaseTime":1600704000000,"score":8.9,"shortFilmList":[{"imageUrl":"http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj4.jpg","videoUrl":"http://172.17.8.100/video/movie/dzd6qmwj/dzd6qmwj1.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj3.jpg","videoUrl":"http://172.17.8.100/video/movie/dzd6qmwj/dzd6qmwj2.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj5.jpg","videoUrl":"http://172.17.8.100/video/movie/dzd6qmwj/dzd6qmwj3.mp4"}],"summary":"有时好意会造成恶果，人反而被自己所造成的结果所困扰。伊桑·亨特（汤姆·克鲁斯 饰）和他的IMF团队（亚历克·鲍德温、西蒙·佩吉、文·瑞姆斯）将在最新的电影《碟中谍6：全面瓦解》中再度回归，他们会与观众们熟悉的盟友（丽贝卡·弗格森、米歇尔·莫娜汉）一起与时间赛跑，应对一次任务中出现的意外。亨利·卡维尔、安吉拉·贝塞特和凡妮莎·柯比也将加入本片的演员阵容，电影制片人克里斯托夫·迈考利将会再度担任导演。","whetherFollow":2}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ResultBean {
        /**
         * commentNum : 5
         * duration : 148分钟
         * imageUrl : http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg
         * movieActor : [{"name":"汤姆·克鲁斯","photo":"http://172.17.8.100/images/movie/actor/dzd6qmwj/tangmu.jpg","role":"伊森·亨特"},{"name":"亨利·卡维尔","photo":"http://172.17.8.100/images/movie/actor/dzd6qmwj/hengli.jpg","role":"安格斯·沃克"},{"name":"西蒙·佩吉","photo":"http://172.17.8.100/images/movie/actor/dzd6qmwj/ximeng.jpg","role":"班吉·邓恩"},{"name":"\r\n丽贝卡·弗格森","photo":"http://172.17.8.100/images/movie/actor/dzd6qmwj/libeika.jpg","role":"伊尔莎"}]
         * movieDirector : [{"name":"克里斯托弗·麦奎里","photo":"http://172.17.8.100/images/movie/director/dzd6qmwj/1.jpg"}]
         * movieId : 16
         * movieType : 动作 / 冒险 / 惊悚
         * name : 碟中谍6：全面瓦解
         * placeOrigin : 美国
         * posterList : ["http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj2.jpg","http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj3.jpg","http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj4.jpg","http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj5.jpg","http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj6.jpg","http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg"]
         * releaseTime : 1600704000000
         * score : 8.9
         * shortFilmList : [{"imageUrl":"http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj4.jpg","videoUrl":"http://172.17.8.100/video/movie/dzd6qmwj/dzd6qmwj1.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj3.jpg","videoUrl":"http://172.17.8.100/video/movie/dzd6qmwj/dzd6qmwj2.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj5.jpg","videoUrl":"http://172.17.8.100/video/movie/dzd6qmwj/dzd6qmwj3.mp4"}]
         * summary : 有时好意会造成恶果，人反而被自己所造成的结果所困扰。伊桑·亨特（汤姆·克鲁斯 饰）和他的IMF团队（亚历克·鲍德温、西蒙·佩吉、文·瑞姆斯）将在最新的电影《碟中谍6：全面瓦解》中再度回归，他们会与观众们熟悉的盟友（丽贝卡·弗格森、米歇尔·莫娜汉）一起与时间赛跑，应对一次任务中出现的意外。亨利·卡维尔、安吉拉·贝塞特和凡妮莎·柯比也将加入本片的演员阵容，电影制片人克里斯托夫·迈考利将会再度担任导演。
         * whetherFollow : 2
         */

        private int commentNum;
        private String duration;
        private String imageUrl;
        private int movieId;
        private String movieType;
        private String name;
        private String placeOrigin;
        private long releaseTime;
        private double score;
        private String summary;
        private int whetherFollow;
        private List<MovieActorBean> movieActor;
        private List<MovieDirectorBean> movieDirector;
        private List<String> posterList;
        private List<ShortFilmListBean> shortFilmList;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getMovieType() {
            return movieType;
        }

        public void setMovieType(String movieType) {
            this.movieType = movieType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPlaceOrigin() {
            return placeOrigin;
        }

        public void setPlaceOrigin(String placeOrigin) {
            this.placeOrigin = placeOrigin;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public int getWhetherFollow() {
            return whetherFollow;
        }

        public void setWhetherFollow(int whetherFollow) {
            this.whetherFollow = whetherFollow;
        }

        public List<MovieActorBean> getMovieActor() {
            return movieActor;
        }

        public void setMovieActor(List<MovieActorBean> movieActor) {
            this.movieActor = movieActor;
        }

        public List<MovieDirectorBean> getMovieDirector() {
            return movieDirector;
        }

        public void setMovieDirector(List<MovieDirectorBean> movieDirector) {
            this.movieDirector = movieDirector;
        }

        public List<String> getPosterList() {
            return posterList;
        }

        public void setPosterList(List<String> posterList) {
            this.posterList = posterList;
        }

        public List<ShortFilmListBean> getShortFilmList() {
            return shortFilmList;
        }

        public void setShortFilmList(List<ShortFilmListBean> shortFilmList) {
            this.shortFilmList = shortFilmList;
        }

        public static class MovieActorBean {
            /**
             * name : 汤姆·克鲁斯
             * photo : http://172.17.8.100/images/movie/actor/dzd6qmwj/tangmu.jpg
             * role : 伊森·亨特
             */

            private String name;
            private String photo;
            private String role;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }
        }

        public static class MovieDirectorBean {
            /**
             * name : 克里斯托弗·麦奎里
             * photo : http://172.17.8.100/images/movie/director/dzd6qmwj/1.jpg
             */

            private String name;
            private String photo;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }

        public static class ShortFilmListBean {
            /**
             * imageUrl : http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj4.jpg
             * videoUrl : http://172.17.8.100/video/movie/dzd6qmwj/dzd6qmwj1.mp4
             */

            private String imageUrl;
            private String videoUrl;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getVideoUrl() {
                return videoUrl;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
            }
        }
    }
}
