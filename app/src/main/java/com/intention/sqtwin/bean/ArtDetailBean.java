package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/4/27-上午12:59
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class ArtDetailBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"artist_info":{"artist_id":1,"create_time":"2018-04-05 09:37:52","avatar":"5acb04f502753.jpg","name":"张三","resume":"一个程序员","fans_count":0,"auction_count":10,"is_favorite":false},"item_list":[{"id":170,"name":"a10554468 现代 老料阴沉金丝楠木精雕孔雀大明王菩萨护佑平安牌","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215160548766.jpg","start_price":"1000.00","current_price":"1068.00"},{"id":172,"name":"a10540126 现代 苏工摘色精雕和田双色籽料婴戏笔架","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451930107.jpg","start_price":"10000.00","current_price":"13000.00"},{"id":176,"name":"a10540289 建国初 和田白玉志在千里手把件","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215544550180.jpg","start_price":"12000.00","current_price":"12000.00"},{"id":177,"name":"a10570104 现代 留翡淡绿翠富贵平安镯","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215575447308.jpg","start_price":"1000.00","current_price":"1000.00"},{"id":181,"name":"a10540315 现代 俄罗斯鸭蛋青无结构碧玉蛋形大戒面","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050411162327952.jpg","start_price":"1200.00","current_price":"1200.00"},{"id":185,"name":"a10540323 现代 和田墨碧玉苏工高浮雕释迦摩尼像玉牌","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050411261018618.jpg","start_price":"1000.00","current_price":"1000.00"}],"total_page":2}
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
         * artist_info : {"artist_id":1,"create_time":"2018-04-05 09:37:52","avatar":"5acb04f502753.jpg","name":"张三","resume":"一个程序员","fans_count":0,"auction_count":10,"is_favorite":false}
         * item_list : [{"id":170,"name":"a10554468 现代 老料阴沉金丝楠木精雕孔雀大明王菩萨护佑平安牌","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215160548766.jpg","start_price":"1000.00","current_price":"1068.00"},{"id":172,"name":"a10540126 现代 苏工摘色精雕和田双色籽料婴戏笔架","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451930107.jpg","start_price":"10000.00","current_price":"13000.00"},{"id":176,"name":"a10540289 建国初 和田白玉志在千里手把件","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215544550180.jpg","start_price":"12000.00","current_price":"12000.00"},{"id":177,"name":"a10570104 现代 留翡淡绿翠富贵平安镯","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215575447308.jpg","start_price":"1000.00","current_price":"1000.00"},{"id":181,"name":"a10540315 现代 俄罗斯鸭蛋青无结构碧玉蛋形大戒面","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050411162327952.jpg","start_price":"1200.00","current_price":"1200.00"},{"id":185,"name":"a10540323 现代 和田墨碧玉苏工高浮雕释迦摩尼像玉牌","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050411261018618.jpg","start_price":"1000.00","current_price":"1000.00"}]
         * total_page : 2
         */

        private ArtistInfoBean artist_info;
        private int total_page;
        private List<ItemListBean> item_list;

        public ArtistInfoBean getArtist_info() {
            return artist_info;
        }

        public void setArtist_info(ArtistInfoBean artist_info) {
            this.artist_info = artist_info;
        }

        public int getTotal_page() {
            return total_page;
        }

        public void setTotal_page(int total_page) {
            this.total_page = total_page;
        }

        public List<ItemListBean> getItem_list() {
            return item_list;
        }

        public void setItem_list(List<ItemListBean> item_list) {
            this.item_list = item_list;
        }

        public static class ArtistInfoBean {
            /**
             * artist_id : 1
             * create_time : 2018-04-05 09:37:52
             * avatar : 5acb04f502753.jpg
             * name : 张三
             * resume : 一个程序员
             * fans_count : 0
             * auction_count : 10
             * is_favorite : false
             */

            private int artist_id;
            private String create_time;
            private String avatar;
            private String name;
            private String resume;
            private int fans_count;
            private int auction_count;
            private boolean is_favorite;

            public int getArtist_id() {
                return artist_id;
            }

            public void setArtist_id(int artist_id) {
                this.artist_id = artist_id;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getResume() {
                return resume;
            }

            public void setResume(String resume) {
                this.resume = resume;
            }

            public int getFans_count() {
                return fans_count;
            }

            public void setFans_count(int fans_count) {
                this.fans_count = fans_count;
            }

            public int getAuction_count() {
                return auction_count;
            }

            public void setAuction_count(int auction_count) {
                this.auction_count = auction_count;
            }

            public boolean isIs_favorite() {
                return is_favorite;
            }

            public void setIs_favorite(boolean is_favorite) {
                this.is_favorite = is_favorite;
            }
        }

        public static class ItemListBean {
            /**
             * id : 170
             * name : a10554468 现代 老料阴沉金丝楠木精雕孔雀大明王菩萨护佑平安牌
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215160548766.jpg
             * start_price : 1000.00
             * current_price : 1068.00
             */

            private int id;
            private String name;
            private String image;
            private String start_price;
            private String current_price;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getStart_price() {
                return start_price;
            }

            public void setStart_price(String start_price) {
                this.start_price = start_price;
            }

            public String getCurrent_price() {
                return current_price;
            }

            public void setCurrent_price(String current_price) {
                this.current_price = current_price;
            }
        }
    }
}
