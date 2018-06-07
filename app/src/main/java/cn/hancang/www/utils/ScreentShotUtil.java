package cn.hancang.www.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import cn.hancang.www.app.BaseApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Description: 绝无Bug
 * Data：2018/4/3 0003-下午 17:50
 * Blog：Super简单
 * Author: ZhouYong
 */

public class ScreentShotUtil {


    public static Bitmap loadBitmapFromView(View v, int width, int height) {
        Bitmap b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.draw(c);
        saveBitmap(b);
        return b;
    }

    public static void saveBitmap(Bitmap bitmap) {

        File imagePath = new File("/sdcard/screenshotdemo1.jpg");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(imagePath, false);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
            Toast.makeText(BaseApplication.getAppContext(), imagePath.getAbsolutePath() + "", Toast.LENGTH_SHORT).show();


            Log.e("ImageSave", "Saveimage");
        } catch (FileNotFoundException e) {
            Log.e("GREC", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("GREC", e.getMessage(), e);
        }
    }
}
