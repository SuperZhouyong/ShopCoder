package cn.hancang.www.bean;

/**
 * Description: 绝无Bug
 * Data：2018/6/21 0021-上午 11:20
 * Blog：Super简单
 * Author: ZhouYong
 */

public class AliLoginBean {

    /**
     * is_success : true
     * message : 操作成功
     * data : apiname=com.alipay.account.auth&method=alipay.open.auth.sdk.code.get&app_id=2018060160317416&app_name=mc&  biz_type=openservice&pid=2088131106864170&product_id=APP_FAST_LOGIN&scope=auth_user&target_id=150582741927697927&  auth_type=AUTHACCOUNT&sign_type=RSA2&sign=eUegeP3IWnWjfuy%2FAykUY5DSUsLs6KGTNqoNc4V5s%2FZTaKDS7YTuS1MjuN34nt2ddfInDHr3QIJBMzYOrSLuYBWeCVsn  W%2FruEtENaefd5UEH3Wqz6NrLlgwBYJsGQprjJGj1J2fDZ621BNbsgXeKAve3kOlgtEfMB4ZKsy1bOV3P43i3UsZG5cO  UY4Givheh5MDtbP5yq6DHM8JOlo1kxDeWSspI%2FKLabijbSNVB3n88Q6ucdvMsOjB2trABQTU%2BERv1ewTlt9r6s%2BIYwa  HowUuIy35D5GaaKda5PIUFOaol3m%2B07ezXtj3T45wepi0ZOav7KWQoT9uz3XeEAsTvCw%3D%3D
     */

    private boolean is_success;
    private String message;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
