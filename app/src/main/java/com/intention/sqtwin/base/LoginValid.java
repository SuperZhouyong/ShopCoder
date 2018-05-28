package com.intention.sqtwin.base;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;

import com.intention.sqtwin.ui.myinfo.activity.LoginActivity;
import com.intention.sqtwin.utils.conmonUtil.UserUtil;
import com.toptechs.libaction.action.Valid;

/**
 * Description: 绝无Bug
 * Data：2018/5/28 0028-下午 14:39
 * Blog：Super简单
 * Author: ZhouYong
 */

public class LoginValid implements Valid {
    private Context context;
//    private String Tag;

    public LoginValid(Context context) {
        this.context = context;
    }





    @Override
    public boolean check() {
        return UserUtil.getLoginInfo() != null && !TextUtils.isEmpty(String.valueOf(UserUtil.getLoginInfo().getMember_id()));
    }

    @Override
    public void doValid() {
        LoginActivity.start((BaseActivity) context);
    }
}
