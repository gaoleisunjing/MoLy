package com.molyo.bean;

import java.util.List;

/**
 * Created by gaoleideapple on 16/10/9.
 */

public class CityBean {


    private BodyBean body;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean {
        /**
         * id : guangzhou
         * name : 广州
         * enableFlag : 1
         * simpleCode : G
         * img : http://img10.molyo.com/molyo/area/select/2015/9/10/15091010434062318e41d448cec25978_135x188.png
         */

        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private String id;
            private String name;
            private String enableFlag;
            private String simpleCode;
            private String img;

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

            public String getEnableFlag() {
                return enableFlag;
            }

            public void setEnableFlag(String enableFlag) {
                this.enableFlag = enableFlag;
            }

            public String getSimpleCode() {
                return simpleCode;
            }

            public void setSimpleCode(String simpleCode) {
                this.simpleCode = simpleCode;
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
