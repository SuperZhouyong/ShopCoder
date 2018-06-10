package cn.hancang.www.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Description: 保佑无bug
 * Data：2018/6/9-下午2:02
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class WxPayBean {

    /**
     * error : 0
     * result : {"partnerid":"1507318451","appid":"wx54fa8a2ea47c977b","prepayid":"wx09135744382791bc902f30791801682699","package":"Sign=WXPay","noncestr":"LrtslpP4Ur9ZGLM3","timestamp":1528523864,"sign":"67B20AE9528DF40C8BEE00A5F46A81D8"}
     */

    private int error;
    private ResultBean result;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * partnerid : 1507318451
         * appid : wx54fa8a2ea47c977b
         * prepayid : wx09135744382791bc902f30791801682699
         * package : Sign=WXPay
         * noncestr : LrtslpP4Ur9ZGLM3
         * timestamp : 1528523864
         * sign : 67B20AE9528DF40C8BEE00A5F46A81D8
         */

        private String partnerid;
        private String appid;
        private String prepayid;
        @SerializedName("package")
        private String packageX;
        private String noncestr;
        private int timestamp;
        private String sign;

        public String getPartnerid() {
            return partnerid;
        }

        public void setPartnerid(String partnerid) {
            this.partnerid = partnerid;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getPrepayid() {
            return prepayid;
        }

        public void setPrepayid(String prepayid) {
            this.prepayid = prepayid;
        }

        public String getPackageX() {
            return packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public void setNoncestr(String noncestr) {
            this.noncestr = noncestr;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }
    }
}
