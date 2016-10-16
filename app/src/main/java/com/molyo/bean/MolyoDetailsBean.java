package com.molyo.bean;

import java.util.List;

/**
 * Created by gaoleideapple on 16/10/11.
 */

public class MolyoDetailsBean {


    /**
     * enableFlag : 1
     * id : 131226112506358a8a73332f0c802737
     * name : My Coffee
     * introduce : 高文安的咖啡工作室
     * address : 华侨城LOFT创意文化园F-1栋101-104号
     * area : 南山
     * phone : 0755-86095101
     * consumeMin : 30
     * consumeMax : 50
     * longitude : 113.993413
     * latitude : 22.537404
     * tipsDesc : 交通：侨城东地铁站A出口出来直走，看见康佳集团右转，步行500米
     推荐：菠萝油¥6、意大利咖啡¥38（可免费续一杯）、皇家滚石36元
     其它：两层的大空间极具设计感，是创意园区内人流量较多的咖啡店
     * tipsUrl : mShop/tip/info?shopId=131226112506358a8a73332f0c802737&hasTip=1&netWork=null
     * isCollect : 0
     * category : [{"id":"9","name":"西餐"},{"id":"1","name":"咖啡馆"}]
     * payAble : 0
     * openTimes : [{"id":"150914155922081e9af012f304dab582","startDate":"周一","endDate":"周日","time":"10:00~24:00"}]
     * imgs : [{"mImg":"http://img10.molyo.com/molyo/shop/2014/12/12/140429132821439f9a83622a192be0a9_l.jpg","bImg":"http://img10.molyo.com/molyo/shop/2014/12/12/140429132821439f9a83622a192be0a9_xl.jpg"},{"mImg":"http://img10.molyo.com/molyo/shop/2014/12/12/1404291328383314895995407019cc56_l.jpg","bImg":"http://img10.molyo.com/molyo/shop/2014/12/12/1404291328383314895995407019cc56_xl.jpg"},{"mImg":"http://img10.molyo.com/molyo/shop/2014/12/12/14042913283758818c7ef976c3bef38a_l.jpg","bImg":"http://img10.molyo.com/molyo/shop/2014/12/12/14042913283758818c7ef976c3bef38a_xl.jpg"}]
     * hotExps : [{"id":"1505191151377853a2010b3b432c3f2b","title":"","userId":"14071109424283638e3f3c38c1abc525","img":"http://img10.molyo.com/molyo/experience/2015/5/19/1505191151378134b8557e7db3c1509e_m.jpg","userImg":"http://img10.molyo.com/molyo/head/2015/10/29/1510291454126648a9e52d3473e06aac_m.jpg","desc":"不仅有咖啡☕️Mycoffee的西餐🍴也是不错滴😋","userName":"吃货","createTime":"2015年5月19日 11:51","isPraise":"0","praiseCount":"16"}]
     * collectCount : 43
     * collectUserList : [{"userId":"160624150448974e80191a21c84ba1ba","nickName":"王岚💯","img":"http://img10.molyo.com/molyo/head/2016/6/24/160624150449021684f256266b0fd5bd_m.jpg"},{"userId":"160615082053862ca8dad3e0248bba75","nickName":"Rainmentary","img":"http://img10.molyo.com/molyo/head/2016/6/15/1606150820540796b29cdd026277d1c0_m.jpg"},{"userId":"150518104203436784e556ec1a1d5fc9","nickName":"sktylo","img":"http://img10.molyo.com/molyo/head/2015/6/9/1506091511108872a613d8c7810bd29e_m.jpg"},{"userId":"160226125423521eb88564c35f39ffae","nickName":"Lcwa.","img":"http://img10.molyo.com/molyo/head/2016/2/26/1602261254235690ab3d0aa4c3bc4bd3_m.jpg"},{"userId":"1602292326390605b26d2745cb10989f","nickName":"粉红粉红的回忆","img":"http://img10.molyo.com/molyo/head/2016/2/29/160229232639108192cb3a9f59623871_m.jpg"},{"userId":"1602111915092347a2a23af0b97098a5","nickName":"Z  c","img":"http://img10.molyo.com/molyo/head/2016/2/11/16021119150929109a323f273a7f6662_m.jpg"},{"userId":"151202183223102daece7da03e91da04","nickName":"喜喜哥哥","img":"http://www.molyo.com/images/nopic/head_m.png"}]
     * active : {}
     * packages : {"list":[],"totalRecords":0}
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
        private String name;
        private String introduce;
        private String address;
        private String area;
        private String phone;
        private String consumeMin;
        private String consumeMax;
        private String longitude;
        private String latitude;
        private String tipsDesc;
        private String tipsUrl;
        private String isCollect;
        private String payAble;
        private String collectCount;
        /**
         * list : []
         * totalRecords : 0
         */

        private PackagesBean packages;
        /**
         * id : 9
         * name : 西餐
         */

        private List<CategoryBean> category;
        /**
         * id : 150914155922081e9af012f304dab582
         * startDate : 周一
         * endDate : 周日
         * time : 10:00~24:00
         */

        private List<OpenTimesBean> openTimes;
        /**
         * mImg : http://img10.molyo.com/molyo/shop/2014/12/12/140429132821439f9a83622a192be0a9_l.jpg
         * bImg : http://img10.molyo.com/molyo/shop/2014/12/12/140429132821439f9a83622a192be0a9_xl.jpg
         */

        private List<ImgsBean> imgs;
        /**
         * id : 1505191151377853a2010b3b432c3f2b
         * title :
         * userId : 14071109424283638e3f3c38c1abc525
         * img : http://img10.molyo.com/molyo/experience/2015/5/19/1505191151378134b8557e7db3c1509e_m.jpg
         * userImg : http://img10.molyo.com/molyo/head/2015/10/29/1510291454126648a9e52d3473e06aac_m.jpg
         * desc : 不仅有咖啡☕️Mycoffee的西餐🍴也是不错滴😋
         * userName : 吃货
         * createTime : 2015年5月19日 11:51
         * isPraise : 0
         * praiseCount : 16
         */

        private List<HotExpsBean> hotExps;
        /**
         * userId : 160624150448974e80191a21c84ba1ba
         * nickName : 王岚💯
         * img : http://img10.molyo.com/molyo/head/2016/6/24/160624150449021684f256266b0fd5bd_m.jpg
         */

        private List<CollectUserListBean> collectUserList;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getConsumeMin() {
            return consumeMin;
        }

        public void setConsumeMin(String consumeMin) {
            this.consumeMin = consumeMin;
        }

        public String getConsumeMax() {
            return consumeMax;
        }

        public void setConsumeMax(String consumeMax) {
            this.consumeMax = consumeMax;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getTipsDesc() {
            return tipsDesc;
        }

        public void setTipsDesc(String tipsDesc) {
            this.tipsDesc = tipsDesc;
        }

        public String getTipsUrl() {
            return tipsUrl;
        }

        public void setTipsUrl(String tipsUrl) {
            this.tipsUrl = tipsUrl;
        }

        public String getIsCollect() {
            return isCollect;
        }

        public void setIsCollect(String isCollect) {
            this.isCollect = isCollect;
        }

        public String getPayAble() {
            return payAble;
        }

        public void setPayAble(String payAble) {
            this.payAble = payAble;
        }

        public String getCollectCount() {
            return collectCount;
        }

        public void setCollectCount(String collectCount) {
            this.collectCount = collectCount;
        }

        public PackagesBean getPackages() {
            return packages;
        }

        public void setPackages(PackagesBean packages) {
            this.packages = packages;
        }

        public List<CategoryBean> getCategory() {
            return category;
        }

        public void setCategory(List<CategoryBean> category) {
            this.category = category;
        }

        public List<OpenTimesBean> getOpenTimes() {
            return openTimes;
        }

        public void setOpenTimes(List<OpenTimesBean> openTimes) {
            this.openTimes = openTimes;
        }

        public List<ImgsBean> getImgs() {
            return imgs;
        }

        public void setImgs(List<ImgsBean> imgs) {
            this.imgs = imgs;
        }

        public List<HotExpsBean> getHotExps() {
            return hotExps;
        }

        public void setHotExps(List<HotExpsBean> hotExps) {
            this.hotExps = hotExps;
        }

        public List<CollectUserListBean> getCollectUserList() {
            return collectUserList;
        }

        public void setCollectUserList(List<CollectUserListBean> collectUserList) {
            this.collectUserList = collectUserList;
        }

        public static class PackagesBean {
            private int totalRecords;
            private List<?> list;

            public int getTotalRecords() {
                return totalRecords;
            }

            public void setTotalRecords(int totalRecords) {
                this.totalRecords = totalRecords;
            }

            public List<?> getList() {
                return list;
            }

            public void setList(List<?> list) {
                this.list = list;
            }
        }

        public static class CategoryBean {
            private String id;
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class OpenTimesBean {
            private String id;
            private String startDate;
            private String endDate;
            private String time;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getStartDate() {
                return startDate;
            }

            public void setStartDate(String startDate) {
                this.startDate = startDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }
        }

        public static class ImgsBean {
            private String mImg;
            private String bImg;

            public String getMImg() {
                return mImg;
            }

            public void setMImg(String mImg) {
                this.mImg = mImg;
            }

            public String getBImg() {
                return bImg;
            }

            public void setBImg(String bImg) {
                this.bImg = bImg;
            }
        }

        public static class HotExpsBean {
            private String id;
            private String title;
            private String userId;
            private String img;
            private String userImg;
            private String desc;
            private String userName;
            private String createTime;
            private String isPraise;
            private String praiseCount;

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

            public String getUserImg() {
                return userImg;
            }

            public void setUserImg(String userImg) {
                this.userImg = userImg;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getIsPraise() {
                return isPraise;
            }

            public void setIsPraise(String isPraise) {
                this.isPraise = isPraise;
            }

            public String getPraiseCount() {
                return praiseCount;
            }

            public void setPraiseCount(String praiseCount) {
                this.praiseCount = praiseCount;
            }
        }

        public static class CollectUserListBean {
            private String userId;
            private String nickName;
            private String img;

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }
    }
}
