package com.bw.movie.model.bean;

/**
 * 作者： 姓名
 * 日期： 2019/11/12 13:45
 */
public class WXLoginBean {
    /**
     * result : {"sessionId":"157300737987513675","userId":13675,"userInfo":{"email":"1172269588@qq.com","headPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","id":13675,"lastLoginTime":1569654589000,"nickName":"卞军鹏","sex":1}}
     * message : 登陆成功
     * status : 0000
     */

    private LoginBean.ResultBean result;
    private String message;
    private String status;

    public LoginBean.ResultBean getResult() {
        return result;
    }

    public void setResult(LoginBean.ResultBean result) {
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
         * sessionId : 157300737987513675
         * userId : 13675
         * userInfo : {"email":"1172269588@qq.com","headPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","id":13675,"lastLoginTime":1569654589000,"nickName":"卞军鹏","sex":1}
         */

        private String sessionId;
        private int userId;
        private LoginBean.ResultBean.UserInfoBean userInfo;

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public LoginBean.ResultBean.UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(LoginBean.ResultBean.UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public static class UserInfoBean {
            /**
             * email : 1172269588@qq.com
             * headPic : http://172.17.8.100/images/movie/head_pic/bwjy.jpg
             * id : 13675
             * lastLoginTime : 1569654589000
             * nickName : 卞军鹏
             * sex : 1
             */

            private String email;
            private String headPic;
            private int id;
            private long lastLoginTime;
            private String nickName;
            private int sex;

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getHeadPic() {
                return headPic;
            }

            public void setHeadPic(String headPic) {
                this.headPic = headPic;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getLastLoginTime() {
                return lastLoginTime;
            }

            public void setLastLoginTime(long lastLoginTime) {
                this.lastLoginTime = lastLoginTime;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }
        }
    }
}
