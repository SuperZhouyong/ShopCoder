package cn.hancang.www.bean;

/**
 * Description: 绝无Bug
 * Data：2018/5/29 0029-上午 11:32
 * Blog：Super简单
 * Author: ZhouYong
 */

public class NormalBankInfoBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"bank_account_name":"都是对的是的","bank_name":"招商","bank_card_number":"4646 6434 3466 4646 4646 4646"}
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
         * bank_account_name : 都是对的是的
         * bank_name : 招商
         * bank_card_number : 4646 6434 3466 4646 4646 4646
         */

        private String bank_account_name;
        private String bank_name;
        private String bank_card_number;

        public String getBank_account_name() {
            return bank_account_name;
        }

        public void setBank_account_name(String bank_account_name) {
            this.bank_account_name = bank_account_name;
        }

        public String getBank_name() {
            return bank_name;
        }

        public void setBank_name(String bank_name) {
            this.bank_name = bank_name;
        }

        public String getBank_card_number() {
            return bank_card_number;
        }

        public void setBank_card_number(String bank_card_number) {
            this.bank_card_number = bank_card_number;
        }
    }
}
