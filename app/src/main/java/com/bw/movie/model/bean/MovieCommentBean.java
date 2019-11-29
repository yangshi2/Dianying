package com.bw.movie.model.bean;

import java.util.List;

/**
 * 作者： 姓名
 * 日期： 2019/11/15 13:47
 */
public class MovieCommentBean {
    /**
     * result : [{"commentContent":"1233","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":71,"commentTime":1568186573000,"commentUserId":13465,"commentUserName":"猫生","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":1.5},{"commentContent":"","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":66,"commentTime":1568107767000,"commentUserId":13583,"commentUserName":"叶子","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":0},{"commentContent":"吴老狗","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":52,"commentTime":1568014675000,"commentUserId":13525,"commentUserName":"你猜猜我是谁","greatNum":1,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":5},{"commentContent":"啊啊啊啊","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":51,"commentTime":1568012668000,"commentUserId":13455,"commentUserName":"温文尔雅","greatNum":1,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":0},{"commentContent":"大师傅似的","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-08-26/20190826095630.jpg","commentId":48,"commentTime":1567995740000,"commentUserId":13517,"commentUserName":"高也涵","greatNum":1,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.4}]
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
         * commentContent : 1233
         * commentHeadPic : http://172.17.8.100/images/movie/head_pic/bwjy.jpg
         * commentId : 71
         * commentTime : 1568186573000
         * commentUserId : 13465
         * commentUserName : 猫生
         * greatNum : 0
         * isGreat : 0
         * replyHeadPic : []
         * replyNum : 0
         * score : 1.5
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int isGreat;
        private int replyNum;
        private double score;
        private List<?> replyHeadPic;

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

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }

        public int getReplyNum() {
            return replyNum;
        }

        public void setReplyNum(int replyNum) {
            this.replyNum = replyNum;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public List<?> getReplyHeadPic() {
            return replyHeadPic;
        }

        public void setReplyHeadPic(List<?> replyHeadPic) {
            this.replyHeadPic = replyHeadPic;
        }
    }
}
