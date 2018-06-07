package cn.hancang.www.greendaohelper;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import cn.hancang.www.gen.DaoMaster;
import cn.hancang.www.gen.UserDao;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Administrator on 2017/2/17 0017.
 */

public class MySQLiteOpenHelper extends DaoMaster.OpenHelper {


    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        Log.i("greenDAO",
                "Upgrading schema from version " + oldVersion + " to " + newVersion + " by migrating all tables data");
        MigrationHelper.getInstance().migrate(db, UserDao.class);
    }
}
