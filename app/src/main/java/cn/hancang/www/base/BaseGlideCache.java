package cn.hancang.www.base;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.module.GlideModule;
import cn.hancang.www.app.BaseApplication;
import cn.hancang.www.utils.conmonUtil.LogUtils;

import java.io.File;

/**
 * @data 2017/6/8 0008
 * @aurher Administrator
 */

public class BaseGlideCache implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
//        File storageDirectory = Environment.getExternalStorageDirectory();
        File storageDirectory = new File(BaseApplication.getAppContext().getCacheDir(), "cache");
        String downLoadDirectoryPath = storageDirectory.getAbsolutePath() + "/GlideCache";
        int cacheSize = 100 * 100 * 1000;
        builder.setDiskCache(new DiskLruCacheFactory(downLoadDirectoryPath, cacheSize));
        LogUtils.logd("GliderPath-------1" + downLoadDirectoryPath + (new File(downLoadDirectoryPath)).exists());
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
//        glide.register(GlideUrl.class, InputStream.class,new OkHttpUrlLoader.f );
    }
}
