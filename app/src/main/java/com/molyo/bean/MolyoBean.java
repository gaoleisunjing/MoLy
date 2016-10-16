package com.molyo.bean;

import java.util.List;

/**
 * Created by gaoleideapple on 16/10/10.
 */

public class MolyoBean {

    /**
     * result :
     * stat : 00
     */

    private HeadBean head;
    /**
     * currentPage : 1
     * totalPages : 3
     * totalRecords : 22
     * subjectList : [{"subId":"151009101424604b80873d8cd08acc24","isNew":"1","title":"文艺潮地","subTitle":"OCT创意园吃喝攻略","type":"shop","tag":"商圈","img":"http://img10.molyo.com/molyo/subject/cover/2015/10/13/151013103315734396d33d46fa4118fc_l.jpg"},{"subId":"15092410004240208aabc1f44853b1b0","isNew":"1","title":"轻酌小酒享生活","subTitle":"最具格调清吧推荐","type":"shop","tag":"小酌","img":"http://img10.molyo.com/molyo/subject/cover/2015/9/24/1509241003365847acb109ff9cbd95c4_l.jpg"},{"subId":"1509021047410432a15463e96f56ad8c","isNew":"1","title":"细品醇香浓郁的咖啡","subTitle":"深圳精品咖啡指南","type":"shop","tag":"咖啡馆","img":"http://img10.molyo.com/molyo/subject/cover/2015/9/18/1509181722047123b4e9cf7dc2e98270_l.jpg"},{"subId":"150831113143063aa12cdf697535db01","isNew":"1","title":"舌尖上的异国之旅","subTitle":"海上世界美食地图","type":"shop","tag":"商圈","img":"http://img10.molyo.com/molyo/subject/cover/2015/9/1/1509011016135895be9585501de50c7c_l.jpg"},{"subId":"150827164859848c9f2d9824749deca0","isNew":"1","title":"沉浸于文字的世界","subTitle":"深圳十大特色书吧","type":"shop","tag":"书吧","img":"http://img10.molyo.com/molyo/subject/cover/2015/9/10/150910173226661eaa5f1ee871622d57_l.jpg"},{"subId":"151207151909129ab2caf3f8ddd6d512","isNew":"0","title":"不做闷骚技术宅","subTitle":"科技园放松小憩之地","type":"shop","tag":"商圈","img":"http://img10.molyo.com/molyo/subject/cover/2015/12/8/151208173020813a91e9346dd5585522_l.jpg"},{"subId":"1512011752333129a145e4c574af372b","isNew":"0","title":"欲罢不能的新鲜美味","subTitle":"海鲜美食大盘点","type":"shop","tag":"正餐","img":"http://img10.molyo.com/molyo/subject/cover/2015/12/4/151204164641488fa0c372ef61421077_l.jpg"},{"subId":"151130140335585b8003cdda175891e4","isNew":"0","title":"唤醒午后味蕾","subTitle":"高逼格下午茶攻略","type":"shop","tag":"下午茶","img":"http://img10.molyo.com/molyo/subject/cover/2015/12/1/1512011101132730be0dc7da818eacd3_l.jpg"}]
     */

    private BodyBean body;

    public HeadBean getHead() {
        return head;
    }

    public void setHead(HeadBean head) {
        this.head = head;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class HeadBean {
        private String result;
        private String stat;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }
    }

    public static class BodyBean {
        private String currentPage;
        private String totalPages;
        private String totalRecords;
        /**
         * subId : 151009101424604b80873d8cd08acc24
         * isNew : 1
         * title : 文艺潮地
         * subTitle : OCT创意园吃喝攻略
         * type : shop
         * tag : 商圈
         * img : http://img10.molyo.com/molyo/subject/cover/2015/10/13/151013103315734396d33d46fa4118fc_l.jpg
         */

        private List<SubjectListBean> subjectList;

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

        public List<SubjectListBean> getSubjectList() {
            return subjectList;
        }

        public void setSubjectList(List<SubjectListBean> subjectList) {
            this.subjectList = subjectList;
        }

        public static class SubjectListBean {
            private String subId;
            private String isNew;
            private String title;
            private String subTitle;
            private String type;
            private String tag;
            private String img;

            public String getSubId() {
                return subId;
            }

            public void setSubId(String subId) {
                this.subId = subId;
            }

            public String getIsNew() {
                return isNew;
            }

            public void setIsNew(String isNew) {
                this.isNew = isNew;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSubTitle() {
                return subTitle;
            }

            public void setSubTitle(String subTitle) {
                this.subTitle = subTitle;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
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
