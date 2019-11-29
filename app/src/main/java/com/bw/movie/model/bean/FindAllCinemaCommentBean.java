package com.bw.movie.model.bean;

import java.util.List;

/**
 * 作者:王帅
 * 时间:2019/11/14
 * 功能:
 */
public class FindAllCinemaCommentBean {

    /**
     * result : [{"commentContent":"�ܺ�","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":53,"commentTime":1570842026000,"commentUserId":13544,"commentUserName":"woailuo","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"实时热点排行榜--百度搜索风云榜","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-09-24/20190924150832.png","commentId":44,"commentTime":1570602371000,"commentUserId":13669,"commentUserName":"ddds","greatHeadPic":[],"greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-21/20191021111633.jpg","commentId":42,"commentTime":1570602020000,"commentUserId":13609,"commentUserName":"wanggangwang","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"很棒哦！！","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-09-24/20190924144829.jpg","commentId":37,"commentTime":1568891242000,"commentUserId":13596,"commentUserName":"欢喜就好","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"棒棒打","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-21/20191021103912.jpg","commentId":36,"commentTime":1568877381000,"commentUserId":13602,"commentUserName":"kongxiangwei","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"耐思","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-21/20191021103604.jpg","commentId":31,"commentTime":1568788312000,"commentUserId":13605,"commentUserName":"青柠味的小狗蛋","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-21/20191021100613.png","commentId":22,"commentTime":1567561874000,"commentUserId":13519,"commentUserName":"张茂森","greatHeadPic":[],"greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"${title}","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-21/20191021133745.png","commentId":21,"commentTime":1567473435000,"commentUserId":13514,"commentUserName":"乔总","greatHeadPic":[],"greatNum":2,"hotComment":0,"isGreat":0},{"commentContent":"你傻逼把","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-09-07/20190907140903.jpg","commentId":12,"commentTime":1567341399000,"commentUserId":13472,"commentUserName":"红衣佳人白衣友","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commentContent : �ܺ�
         * commentHeadPic : http://172.17.8.100/images/movie/head_pic/bwjy.jpg
         * commentId : 53
         * commentTime : 1570842026000
         * commentUserId : 13544
         * commentUserName : woailuo
         * greatHeadPic : []
         * greatNum : 0
         * hotComment : 0
         * isGreat : 0
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int hotComment;
        private int isGreat;
        private List<?> greatHeadPic;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentHeadPic() {
            return commentHeadPic;
        }

        public void setCommentHeadPic(String commentHeadPic) {
            this.commentHeadPic = commentHeadPic;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getCommentUserName() {
            return commentUserName;
        }

        public void setCommentUserName(String commentUserName) {
            this.commentUserName = commentUserName;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public int getHotComment() {
            return hotComment;
        }

        public void setHotComment(int hotComment) {
            this.hotComment = hotComment;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }

        public List<?> getGreatHeadPic() {
            return greatHeadPic;
        }

        public void setGreatHeadPic(List<?> greatHeadPic) {
            this.greatHeadPic = greatHeadPic;
        }
    }
}
