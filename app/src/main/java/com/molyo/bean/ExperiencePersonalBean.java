package com.molyo.bean;

import java.util.List;

/**
 * Created by gaoleideapple on 16/10/12.
 */

public class ExperiencePersonalBean {

    /**
     * enableFlag : 1
     * id : 1505191151377853a2010b3b432c3f2b
     * title :
     * resCount : 0
     * praiseCount : 16
     * isCollect : 0
     * isLike : 0
     * desc : 不仅有咖啡☕️ My coffee的西餐🍴也是不错滴😋
     * createTime : 2015-05-19 11:51:37
     * userName : 吃货
     * userId : 14071109424283638e3f3c38c1abc525
     * sourceType : 2
     * userImg : http://img10.molyo.com/molyo/head/2015/10/29/1510291454126648a9e52d3473e06aac_m.jpg
     * shopId : 131226112506358a8a73332f0c802737
     * cover : http://img10.molyo.com/molyo/experience/2015/5/19/1505191151378134b8557e7db3c1509e_l.jpg
     * shopName : My Coffee（华侨城店）
     * imgs : ["http://img10.molyo.com/molyo/experience/2015/5/19/1505191151378134b8557e7db3c1509e.jpg"]
     * infoUrl : mExperience/info?id=1505191151377853a2010b3b432c3f2b
     */

    private BodyBean body;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean {
        private String enableFlag;
        private String id;
        private String title;
        private String resCount;
        private String praiseCount;
        private String isCollect;
        private String isLike;
        private String desc;
        private String createTime;
        private String userName;
        private String userId;
        private String sourceType;
        private String userImg;
        private String shopId;
        private String cover;
        private String shopName;
        private String infoUrl;
        private List<String> imgs;

        public String getEnableFlag() {
            return enableFlag;
        }

        public void setEnableFlag(String enableFlag) {
            this.enableFlag = enableFlag;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getResCount() {
            return resCount;
        }

        public void setResCount(String resCount) {
            this.resCount = resCount;
        }

        public String getPraiseCount() {
            return praiseCount;
        }

        public void setPraiseCount(String praiseCount) {
            this.praiseCount = praiseCount;
        }

        public String getIsCollect() {
            return isCollect;
        }

        public void setIsCollect(String isCollect) {
            this.isCollect = isCollect;
        }

        public String getIsLike() {
            return isLike;
        }

        public void setIsLike(String isLike) {
            this.isLike = isLike;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getSourceType() {
            return sourceType;
        }

        public void setSourceType(String sourceType) {
            this.sourceType = sourceType;
        }

        public String getUserImg() {
            return userImg;
        }

        public void setUserImg(String userImg) {
            this.userImg = userImg;
        }

        public String getShopId() {
            return shopId;
        }

        public void setShopId(String shopId) {
            this.shopId = shopId;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getInfoUrl() {
            return infoUrl;
        }

        public void setInfoUrl(String infoUrl) {
            this.infoUrl = infoUrl;
        }

        public List<String> getImgs() {
            return imgs;
        }

        public void setImgs(List<String> imgs) {
            this.imgs = imgs;
        }
    }
}
