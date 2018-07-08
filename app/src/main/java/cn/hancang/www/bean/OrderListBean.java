package cn.hancang.www.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/5/10-上午12:31
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class OrderListBean {
    /**
     * is_success : true
     * message : 操作成功
     * data : [{"order_id":138,"order_type":null,"add_time":1530427001,"order_state":10,"order_amount":"18780.00","order_sn":153042700113882516,"count":60,"num":6,"goods_name":"测试商品22","goods_image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050415164838749.jpg"},{"order_id":139,"order_type":null,"add_time":1530435284,"order_state":20,"order_amount":"0.19","order_sn":153043528423769616,"count":19,"num":1,"goods_name":"天然血檀水波纹精雕手串","goods_image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/69/oss_69_2018061516174541681.jpg"}]
     */

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

    public static class DataBean implements Parcelable {
        /**
         * order_id : 138
         * order_type : null
         * add_time : 1530427001
         * order_state : 10
         * order_amount : 18780.00
         * order_sn : 153042700113882516
         * count : 60
         * num : 6
         * goods_name : 测试商品22
         * goods_image : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050415164838749.jpg
         */

        private int order_id;
        private String order_type;
        private int add_time;
        private int order_state;
        private String order_amount;
        private long order_sn;
        private int count;
        private int num;
        private String goods_name;
        private String goods_image;


        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public String getOrder_type() {
            return order_type;
        }

        public void setOrder_type(String order_type) {
            this.order_type = order_type;
        }

        public int getAdd_time() {
            return add_time;
        }

        public void setAdd_time(int add_time) {
            this.add_time = add_time;
        }

        public int getOrder_state() {
            return order_state;
        }

        public void setOrder_state(int order_state) {
            this.order_state = order_state;
        }

        public String getOrder_amount() {
            return order_amount;
        }

        public void setOrder_amount(String order_amount) {
            this.order_amount = order_amount;
        }

        public long getOrder_sn() {
            return order_sn;
        }

        public void setOrder_sn(long order_sn) {
            this.order_sn = order_sn;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGoods_image() {
            return goods_image;
        }

        public void setGoods_image(String goods_image) {
            this.goods_image = goods_image;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.order_id);
            dest.writeString(this.order_type);
            dest.writeInt(this.add_time);
            dest.writeInt(this.order_state);
            dest.writeString(this.order_amount);
            dest.writeLong(this.order_sn);
            dest.writeInt(this.count);
            dest.writeInt(this.num);
            dest.writeString(this.goods_name);
            dest.writeString(this.goods_image);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.order_id = in.readInt();
            this.order_type = in.readString();
            this.add_time = in.readInt();
            this.order_state = in.readInt();
            this.order_amount = in.readString();
            this.order_sn = in.readLong();
            this.count = in.readInt();
            this.num = in.readInt();
            this.goods_name = in.readString();
            this.goods_image = in.readString();
        }

        public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }





}
