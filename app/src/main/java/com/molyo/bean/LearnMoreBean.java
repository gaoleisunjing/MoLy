package com.molyo.bean;

import java.util.List;

/**
 * Created by gaoleideapple on 16/10/12.
 */

public class LearnMoreBean {

    /**
     * currentPage : 1
     * totalPages : 1
     * totalRecords : 3
     * list : [{"id":"160815180413318abde5795d4fb93ff6","title":"","resCount":"0","praiseCount":"0","isCollect":"0","isPraise":"0","desc":"罐装零食招代理微信hy908088","createTime":"2016-08-15 18:04:13","userName":"晓晓","userId":"16081518000966869677394cbdca6841","sourceType":"2","userImg":"http://img10.molyo.com/molyo/head/2016/8/15/16081518000972299f743adb9560c6fa_m.jpg","shopId":"131226112506358a8a73332f0c802737","cover":"http://img10.molyo.com/molyo/experience/2016/8/15/160815180413326aa22a37d5a829b20f_l.jpg","shopName":"My Coffee","img":"http://img10.molyo.com/molyo/experience/2016/8/15/160815180413326aa22a37d5a829b20f_m.jpg","imgNum":"2"},{"id":"1505191151377853a2010b3b432c3f2b","title":"","resCount":"0","praiseCount":"16","isCollect":"0","isPraise":"0","desc":"不仅有咖啡☕️Mycoffee的西餐🍴也是不错滴😋","createTime":"2015-05-19 11:51:37","userName":"吃货","userId":"14071109424283638e3f3c38c1abc525","sourceType":"2","userImg":"http://img10.molyo.com/molyo/head/2015/10/29/1510291454126648a9e52d3473e06aac_m.jpg","shopId":"131226112506358a8a73332f0c802737","cover":"http://img10.molyo.com/molyo/experience/2015/5/19/1505191151378134b8557e7db3c1509e_l.jpg","shopName":"My Coffee","img":"http://img10.molyo.com/molyo/experience/2015/5/19/1505191151378134b8557e7db3c1509e_m.jpg","imgNum":"1"},{"id":"1407110208377465ae8fcc3897d93742","title":"espresso","resCount":"1","praiseCount":"5","isCollect":"0","isPraise":"0","desc":"这间咖啡店比较洋气，装修的也很有艺术，不知道有没有人注意到他们店二楼的沙发后面没有脚的直接就靠地了。看着有点不稳的感觉，其实坐上去很宽敞，但有种想后仰的感觉O(∩_∩)O~来到这间打着咖啡名号的店，肯...","createTime":"2014-07-11 02:08:37","userName":"沉思的忧伤","userId":"1404092151286007b8a58cb42d5b7fdd","sourceType":"2","userImg":"http://img10.molyo.com/molyo/head/2015/3/20/150320120338295692e12f54d466e4a7_m.jpg","shopId":"131226112506358a8a73332f0c802737","cover":"http://img10.molyo.com/molyo/experience/2014/12/12/1407110206542588b78427dc0ec2f7fd_l.jpg","shopName":"My Coffee","img":"http://img10.molyo.com/molyo/experience/2014/12/12/1407110206542588b78427dc0ec2f7fd_m.jpg","imgNum":"3"}]
     */

    private BodyBean body;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean {
        private String currentPage;
        private String totalPages;
        private String totalRecords;
        /**
         * id : 160815180413318abde5795d4fb93ff6
         * title :
         * resCount : 0
         * praiseCount : 0
         * isCollect : 0
         * isPraise : 0
         * desc : 罐装零食招代理微信hy908088
         * createTime : 2016-08-15 18:04:13
         * userName : 晓晓
         * userId : 16081518000966869677394cbdca6841
         * sourceType : 2
         * userImg : http://img10.molyo.com/molyo/head/2016/8/15/16081518000972299f743adb9560c6fa_m.jpg
         * shopId : 131226112506358a8a73332f0c802737
         * cover : http://img10.molyo.com/molyo/experience/2016/8/15/160815180413326aa22a37d5a829b20f_l.jpg
         * shopName : My Coffee
         * img : http://img10.molyo.com/molyo/experience/2016/8/15/160815180413326aa22a37d5a829b20f_m.jpg
         * imgNum : 2
         */

        private List<ListBean> list;

        public String getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(String currentPage) {
            this.currentPage = currentPage;
        }

        public String getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(String totalPages) {
            this.totalPages = totalPages;
        }

        public String getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(String totalRecords) {
            this.totalRecords = totalRecords;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private String id;
            private String title;
            private String resCount;
            private String praiseCount;
            private String isCollect;
            private String isPraise;
            private String desc;
            private String createTime;
            private String userName;
            private String userId;
            private String sourceType;
            private String userImg;
            private String shopId;
            private String cover;
            private String shopName;
            private String img;
            private String imgNum;

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

            public String getIsPraise() {
                return isPraise;
            }

            public void setIsPraise(String isPraise) {
                this.isPraise = isPraise;
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

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getImgNum() {
                return imgNum;
            }

            public void setImgNum(String imgNum) {
                this.imgNum = imgNum;
            }
        }
    }
}
