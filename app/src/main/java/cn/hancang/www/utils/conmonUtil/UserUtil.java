package cn.hancang.www.utils.conmonUtil;

import android.content.Context;

import cn.hancang.www.app.BaseApplication;
import cn.hancang.www.bean.SQTUser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;

public class UserUtil {
    private static SQTUser sqtUser ;

    /**
     * 获取处理用户信息的实体类
     *
     * @return
     */
    public static SQTUser getLoginInfo() {
        if (sqtUser == null) {
            sqtUser = (SQTUser) readObject(SQTUser.class.getName());
            if (sqtUser == null) {
                LogUtils.logd("从对象缓存中获取LoginInfo为null");
            } else {
                LogUtils.logd("从对象缓存中获取LoginInfo：" + sqtUser.toString());
            }
        }
        return sqtUser;
    }

    /**
     * 将保存用户信息的实体类保存到本地文件
     *
     * @return
     */
    public static void setLoginInfo(SQTUser sqtUser) {
        UserUtil.sqtUser = sqtUser;
        fileSave(sqtUser, SQTUser.class.getName());
    }

    /**
     * 先将LoginInfo类的数据更新，然后保存到本地文件
     * 更新登陆用户的对象缓存
     *
     * @param
     */
    public static void updataLoginInfo() {
        fileSave(sqtUser, SQTUser.class.getName());
    }

    /*
    * 保存登陆的对象到本地   有的话自动清除本地文件
    * */
    public static void fileSave(Object object, String fileName) {
        // 保存在本地
        try {
            // 通过openFileOutput方法得到一个输出流，方法参数为创建的文件名（不能有斜杠），操作模式
            FileOutputStream fos = BaseApplication.getAppContext().openFileOutput(
                    fileName, Context.MODE_WORLD_READABLE);
            // FileOutputStream fos = new FileOutputStream(new
            // File(Environment.getExternalStorageDirectory()+"/user.txt"));

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);// 写入
            fos.close(); // 关闭输出流
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object readObject(String fileName) {
        Object object = null;
        try {
            FileInputStream fis = BaseApplication.getAppContext()
                    .openFileInput(fileName); // 获得输入流
            // FileInputStream fis = new FileInputStream(new
            // File(Environment.getExternalStorageDirectory()+"/user.txt")); //
            // 获得输入流
            ObjectInputStream ois = new ObjectInputStream(fis);
            object = ois.readObject();

        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (OptionalDataException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static void ClearLoginInfo() {
//        BaseApplication.getAppContext().getf


    }

}
