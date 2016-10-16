package com.molyo.bean;

/**
 * Created by gaoleideapple on 16/10/13.
 */

public class CollectionPersonalBean {

    /**
     * userId : 1404092151286007b8a58cb42d5b7fdd
     * img : http://img10.molyo.com/molyo/head/2015/3/20/150320120338295692e12f54d466e4a7_m.jpg
     * bImg : http://img10.molyo.com/molyo/head/2015/3/20/150320120338295692e12f54d466e4a7_l.jpg
     * nickName : 沉思的忧伤
     * desc : 每天看到彩虹，噢耶
     * city : 深圳
     * birth : 1984-08-28
     * sex : 0
     * attentionCount : 76
     * fansCount : 35
     * expCount : 6
     * isSetPassword : 0
     */

    private BodyBean body;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean {
        private String userId;
        private String img;
        private String bImg;
        private String nickName;
        private String desc;
        private String city;
        private String birth;
        private String sex;
        private String attentionCount;
        private String fansCount;
        private String expCount;
        private String isSetPassword;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getBImg() {
            return bImg;
        }

        public void setBImg(String bImg) {
            this.bImg = bImg;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getBirth() {
            return birth;
        }

        public void setBirth(String birth) {
            this.birth = birth;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getAttentionCount() {
            return attentionCount;
        }

        public void setAttentionCount(String attentionCount) {
            this.attentionCount = attentionCount;
        }

        public String getFansCount() {
            return fansCount;
        }

        public void setFansCount(String fansCount) {
            this.fansCount = fansCount;
        }

        public String getExpCount() {
            return expCount;
        }

        public void setExpCount(String expCount) {
            this.expCount = expCount;
        }

        public String getIsSetPassword() {
            return isSetPassword;
        }

        public void setIsSetPassword(String isSetPassword) {
            this.isSetPassword = isSetPassword;
        }
    }
}
