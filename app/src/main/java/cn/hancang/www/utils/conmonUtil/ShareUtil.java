package cn.hancang.www.utils.conmonUtil;

import android.content.Context;
import android.text.TextUtils;

import cn.hancang.www.R;

import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * @data 2017/4/24 0024
 * @aurher Administrator
 */

public class ShareUtil {

//    private static OnekeyShare oks = new OnekeyShare();

    /*  public static void showShare(Context mContext) {
                OnekeyShare oks = new OnekeyShare();
                //关闭sso授权
                oks.disableSSOWhenAuthorize();
                // title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
                oks.setTitle("标题");
                // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
                oks.setTitleUrl("http://sharesdk.cn");
                // text是分享文本，所有平台都需要这个字段
                oks.setText("我是分享文本");
                //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
                oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
                // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
                //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
                // url仅在微信（包括好友和朋友圈）中使用
                oks.setUrl("http://sharesdk.cn");
                // comment是我对这条分享的评论，仅在人人网和QQ空间使用
                oks.setComment("我是测试评论文本");
                // site是分享此内容的网站名称，仅在QQ空间使用
                oks.setSite("ShareSDK");
                // siteUrl是分享此内容的网站地址，仅在QQ空间使用
                oks.setSiteUrl("http://sharesdk.cn");
                // 启动分享GUI
                oks.show(mContext);
            }*/
   /* public static  void showShare(Context mContext,String platform) {
        OnekeyShare oks = new OnekeyShare();
        //指定分享的平台，如果为空，还是会调用九宫格的平台列表界面
        if (platform != null) {
            oks.setPlatform(platform);
        }
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(mContext.getResources().getString(R.string.share_title));
        // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
        oks.setTitleUrl(mContext.getResources().getString(R.string.share_url));
        // text是分享文本，所有平台都需要这个字段
        oks.setText(mContext.getResources().getString(R.string.share_content));
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl(mContext.getResources().getString(R.string.img_url));
//        oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(mContext.getResources().getString(R.string.share_url));
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
//        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(mContext.getResources().getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl(mContext.getResources().getString(R.string.share_url));

        //启动分享
        oks.show(mContext);
    }*/
    public static void showShareURL(Context mContext, String platform, String shareUrl) {
//        oks = new OnekeyShare();
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        //指定分享的平台，如果为空，还是会调用九宫格的平台列表界面
        if (platform != null) {
            oks.setPlatform(platform);
        }
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(mContext.getResources().getString(R.string.share_title));
        // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
//        oks.setTitleUrl(shareUrl);
        // text是分享文本，所有平台都需要这个字段
        oks.setText(mContext.getResources().getString(R.string.share_content));
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
//        oks.setImageUrl(mContext.getResources().getString(R.string.img_url));
        // url仅在微信（包括好友和朋友圈）中使用
//        oks.setUrl(shareUrl);
        oks.setImageUrl(shareUrl);
        // site是分享此内容的网站名称，仅在QQ空间使用
//        oks.setSite(mContext.getResources().getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
//        oks.setSiteUrl(shareUrl);
        //启动分享
        LogUtils.logd(mContext == null ? "我mContext是空的" : "我mContext不是空的");
        LogUtils.logd(oks == null ? "我是oks空的" : "我oks不是空的");
        LogUtils.logd(TextUtils.isEmpty(shareUrl) ? "我是shareUrl空的" : "我shareUrl不是空的");
        oks.show(mContext);
    }
}
