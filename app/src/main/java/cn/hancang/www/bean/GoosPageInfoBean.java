package cn.hancang.www.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/5/26-下午5:17
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class GoosPageInfoBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"info":{"store_id":85,"goods_id":2893,"goods_commonid":2897,"goods_name":"赵秀林刻铜桶壶《心经壶》","goods_price":"8000.00","goods_marketprice":"0.00","brand_id":0,"description":"【匠人】铜雕赵秀林\r\n【尺寸】高28.5cm（其中器身高14cm），壶身直径12.7cm，壶口直径8.6cm，重量1005g，容量1700ml。\r\n【规格】1件\r\n【材质】紫铜（纯铜）\r\n【年代】2016年\r\n【工艺】半手工制器，手工凿刻\r\n【作品介绍】壶面绘刻的内容为佛教经典《般若波罗密多心经》全文，共260余字，以及佛章一枚。\r\n【推荐理由】该作品是目前赵秀林所有刻铜茶壶作品里面制作周期、工程量、艺术性最强的一件作品，目前存世三件。\r\n【绍兴铜雕介绍】绍兴铜雕也称\u201c越刻\u201d，是一门使用金属工具对铜制品进行文字或图案凿刻处理的传统手工技艺。她借鉴融贯了越地石、木、砖雕和其它姊妹艺术雕刻表现技法，代表了越地雕刻的最高工艺水平。\r\n    2009年，绍兴铜雕入选浙江省非物质文化遗产保护项目。赵秀林老师是该项目唯一的省级非遗传承人和浙江省工艺美术大师。","goods_storage":1,"is_fav_store":false,"images":[{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410441466502.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410441555465.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410441790607.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410441872504.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442012734.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442227909.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442318410.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442487179.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442424703.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442646886.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442771830.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442879980.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443067936.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443110813.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443254818.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443470613.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443550558.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443650088.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443722427.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443871555.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443944108.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443911854.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410444124532.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410445218785.jpg"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410445528415.jpg"}]}}
     */

    private boolean is_success;
    private String message;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * info : {"store_id":85,"goods_id":2893,"goods_commonid":2897,"goods_name":"赵秀林刻铜桶壶《心经壶》","goods_price":"8000.00","goods_marketprice":"0.00","brand_id":0,"description":"【匠人】铜雕赵秀林\r\n【尺寸】高28.5cm（其中器身高14cm），壶身直径12.7cm，壶口直径8.6cm，重量1005g，容量1700ml。\r\n【规格】1件\r\n【材质】紫铜（纯铜）\r\n【年代】2016年\r\n【工艺】半手工制器，手工凿刻\r\n【作品介绍】壶面绘刻的内容为佛教经典《般若波罗密多心经》全文，共260余字，以及佛章一枚。\r\n【推荐理由】该作品是目前赵秀林所有刻铜茶壶作品里面制作周期、工程量、艺术性最强的一件作品，目前存世三件。\r\n【绍兴铜雕介绍】绍兴铜雕也称\u201c越刻\u201d，是一门使用金属工具对铜制品进行文字或图案凿刻处理的传统手工技艺。她借鉴融贯了越地石、木、砖雕和其它姊妹艺术雕刻表现技法，代表了越地雕刻的最高工艺水平。\r\n    2009年，绍兴铜雕入选浙江省非物质文化遗产保护项目。赵秀林老师是该项目唯一的省级非遗传承人和浙江省工艺美术大师。","goods_storage":1,"is_fav_store":false,"images":[{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410441466502.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410441555465.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410441790607.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410441872504.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442012734.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442227909.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442318410.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442487179.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442424703.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442646886.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442771830.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442879980.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443067936.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443110813.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443254818.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443470613.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443550558.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443650088.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443722427.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443871555.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443944108.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443911854.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410444124532.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410445218785.jpg"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410445528415.jpg"}]}
         */

        private InfoBean info;
        private String share_url ;

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public static class InfoBean {
            /**
             * store_id : 85
             * goods_id : 2893
             * goods_commonid : 2897
             * goods_name : 赵秀林刻铜桶壶《心经壶》
             * goods_price : 8000.00
             * goods_marketprice : 0.00
             * brand_id : 0
             * description : 【匠人】铜雕赵秀林
             【尺寸】高28.5cm（其中器身高14cm），壶身直径12.7cm，壶口直径8.6cm，重量1005g，容量1700ml。
             【规格】1件
             【材质】紫铜（纯铜）
             【年代】2016年
             【工艺】半手工制器，手工凿刻
             【作品介绍】壶面绘刻的内容为佛教经典《般若波罗密多心经》全文，共260余字，以及佛章一枚。
             【推荐理由】该作品是目前赵秀林所有刻铜茶壶作品里面制作周期、工程量、艺术性最强的一件作品，目前存世三件。
             【绍兴铜雕介绍】绍兴铜雕也称“越刻”，是一门使用金属工具对铜制品进行文字或图案凿刻处理的传统手工技艺。她借鉴融贯了越地石、木、砖雕和其它姊妹艺术雕刻表现技法，代表了越地雕刻的最高工艺水平。
             2009年，绍兴铜雕入选浙江省非物质文化遗产保护项目。赵秀林老师是该项目唯一的省级非遗传承人和浙江省工艺美术大师。
             * goods_storage : 1
             * is_fav_store : false
             * images : [{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410441466502.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410441555465.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410441790607.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410441872504.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442012734.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442227909.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442318410.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442487179.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442424703.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442646886.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442771830.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410442879980.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443067936.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443110813.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443254818.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443470613.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443550558.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443650088.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443722427.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443871555.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443944108.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410443911854.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410444124532.JPG"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410445218785.jpg"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410445528415.jpg"}]
             */

            private int store_id;
            private int goods_id;
            private int goods_commonid;
            private String goods_name;
            private String goods_price;
            private String goods_marketprice;
            private int brand_id;
            private String description;
            private int goods_storage;
            private boolean is_fav_store;
            private List<ImagesBean> images;

            public int getStore_id() {
                return store_id;
            }

            public void setStore_id(int store_id) {
                this.store_id = store_id;
            }

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public int getGoods_commonid() {
                return goods_commonid;
            }

            public void setGoods_commonid(int goods_commonid) {
                this.goods_commonid = goods_commonid;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }

            public String getGoods_marketprice() {
                return goods_marketprice;
            }

            public void setGoods_marketprice(String goods_marketprice) {
                this.goods_marketprice = goods_marketprice;
            }

            public int getBrand_id() {
                return brand_id;
            }

            public void setBrand_id(int brand_id) {
                this.brand_id = brand_id;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getGoods_storage() {
                return goods_storage;
            }

            public void setGoods_storage(int goods_storage) {
                this.goods_storage = goods_storage;
            }

            public boolean isIs_fav_store() {
                return is_fav_store;
            }

            public void setIs_fav_store(boolean is_fav_store) {
                this.is_fav_store = is_fav_store;
            }

            public List<ImagesBean> getImages() {
                return images;
            }

            public void setImages(List<ImagesBean> images) {
                this.images = images;
            }

            public static class ImagesBean {
                /**
                 * goodsimage_url : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/85/oss_85_2018070410441466502.JPG
                 */

                private String goodsimage_url;

                public String getGoodsimage_url() {
                    return goodsimage_url;
                }

                public void setGoodsimage_url(String goodsimage_url) {
                    this.goodsimage_url = goodsimage_url;
                }
            }
        }
    }
}
