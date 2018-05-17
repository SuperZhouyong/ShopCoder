package com.intention.sqtwin.bean;

import java.util.List;

/**
 *
 * @aurher Administrator
 */

public class AllRegion {




    private boolean is_success;
    private String message;
    private List<DataBean> data;

    public boolean isIs_success() {
        return is_success;
    }

    public void setIs_success(boolean is_success) {
        this.is_success = is_success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * area_id : 1
         * area_name : 北京
         * area_parent_id : 0
         * area_deep : 1
         * city : [{"area_id":36,"area_name":"北京市","area_parent_id":1,"area_deep":2,"area":[{"area_id":37,"area_name":"东城区","area_parent_id":36,"area_deep":3},{"area_id":38,"area_name":"西城区","area_parent_id":36,"area_deep":3},{"area_id":41,"area_name":"朝阳区","area_parent_id":36,"area_deep":3},{"area_id":42,"area_name":"丰台区","area_parent_id":36,"area_deep":3},{"area_id":43,"area_name":"石景山区","area_parent_id":36,"area_deep":3},{"area_id":44,"area_name":"海淀区","area_parent_id":36,"area_deep":3},{"area_id":45,"area_name":"门头沟区","area_parent_id":36,"area_deep":3},{"area_id":46,"area_name":"房山区","area_parent_id":36,"area_deep":3},{"area_id":47,"area_name":"通州区","area_parent_id":36,"area_deep":3},{"area_id":48,"area_name":"顺义区","area_parent_id":36,"area_deep":3},{"area_id":49,"area_name":"昌平区","area_parent_id":36,"area_deep":3},{"area_id":50,"area_name":"大兴区","area_parent_id":36,"area_deep":3},{"area_id":51,"area_name":"怀柔区","area_parent_id":36,"area_deep":3},{"area_id":52,"area_name":"平谷区","area_parent_id":36,"area_deep":3},{"area_id":53,"area_name":"密云县","area_parent_id":36,"area_deep":3},{"area_id":54,"area_name":"延庆县","area_parent_id":36,"area_deep":3},{"area_id":566,"area_name":"其他","area_parent_id":36,"area_deep":3}]}]
         */

        private int area_id;
        private String area_name;
        private int area_parent_id;
        private int area_deep;
        private List<CityBean> city;

        public int getArea_id() {
            return area_id;
        }

        public void setArea_id(int area_id) {
            this.area_id = area_id;
        }

        public String getArea_name() {
            return area_name;
        }

        public void setArea_name(String area_name) {
            this.area_name = area_name;
        }

        public int getArea_parent_id() {
            return area_parent_id;
        }

        public void setArea_parent_id(int area_parent_id) {
            this.area_parent_id = area_parent_id;
        }

        public int getArea_deep() {
            return area_deep;
        }

        public void setArea_deep(int area_deep) {
            this.area_deep = area_deep;
        }

        public List<CityBean> getCity() {
            return city;
        }

        public void setCity(List<CityBean> city) {
            this.city = city;
        }

        public static class CityBean {
            /**
             * area_id : 36
             * area_name : 北京市
             * area_parent_id : 1
             * area_deep : 2
             * area : [{"area_id":37,"area_name":"东城区","area_parent_id":36,"area_deep":3},{"area_id":38,"area_name":"西城区","area_parent_id":36,"area_deep":3},{"area_id":41,"area_name":"朝阳区","area_parent_id":36,"area_deep":3},{"area_id":42,"area_name":"丰台区","area_parent_id":36,"area_deep":3},{"area_id":43,"area_name":"石景山区","area_parent_id":36,"area_deep":3},{"area_id":44,"area_name":"海淀区","area_parent_id":36,"area_deep":3},{"area_id":45,"area_name":"门头沟区","area_parent_id":36,"area_deep":3},{"area_id":46,"area_name":"房山区","area_parent_id":36,"area_deep":3},{"area_id":47,"area_name":"通州区","area_parent_id":36,"area_deep":3},{"area_id":48,"area_name":"顺义区","area_parent_id":36,"area_deep":3},{"area_id":49,"area_name":"昌平区","area_parent_id":36,"area_deep":3},{"area_id":50,"area_name":"大兴区","area_parent_id":36,"area_deep":3},{"area_id":51,"area_name":"怀柔区","area_parent_id":36,"area_deep":3},{"area_id":52,"area_name":"平谷区","area_parent_id":36,"area_deep":3},{"area_id":53,"area_name":"密云县","area_parent_id":36,"area_deep":3},{"area_id":54,"area_name":"延庆县","area_parent_id":36,"area_deep":3},{"area_id":566,"area_name":"其他","area_parent_id":36,"area_deep":3}]
             */

            private int area_id;
            private String area_name;
            private int area_parent_id;
            private int area_deep;
            private List<AreaBean> area;

            public int getArea_id() {
                return area_id;
            }

            public void setArea_id(int area_id) {
                this.area_id = area_id;
            }

            public String getArea_name() {
                return area_name;
            }

            public void setArea_name(String area_name) {
                this.area_name = area_name;
            }

            public int getArea_parent_id() {
                return area_parent_id;
            }

            public void setArea_parent_id(int area_parent_id) {
                this.area_parent_id = area_parent_id;
            }

            public int getArea_deep() {
                return area_deep;
            }

            public void setArea_deep(int area_deep) {
                this.area_deep = area_deep;
            }

            public List<AreaBean> getArea() {
                return area;
            }

            public void setArea(List<AreaBean> area) {
                this.area = area;
            }

            public static class AreaBean {
                /**
                 * area_id : 37
                 * area_name : 东城区
                 * area_parent_id : 36
                 * area_deep : 3
                 */

                private int area_id;
                private String area_name;
                private int area_parent_id;
                private int area_deep;

                public int getArea_id() {
                    return area_id;
                }

                public void setArea_id(int area_id) {
                    this.area_id = area_id;
                }

                public String getArea_name() {
                    return area_name;
                }

                public void setArea_name(String area_name) {
                    this.area_name = area_name;
                }

                public int getArea_parent_id() {
                    return area_parent_id;
                }

                public void setArea_parent_id(int area_parent_id) {
                    this.area_parent_id = area_parent_id;
                }

                public int getArea_deep() {
                    return area_deep;
                }

                public void setArea_deep(int area_deep) {
                    this.area_deep = area_deep;
                }
            }
        }
    }
}
