package com.example.testlibrary.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;


/**
 * Created by csy on 2017/8/2.
 */

public class TestDbHelper extends OrmLiteSqliteOpenHelper
{
    private static final String databaseName = "test_db";
    private static final int databaseVersion = 2;
    private static TestDbHelper instance;
    private Dao<Pageinfo, Integer> mTestdbDao = null;

    public static TestDbHelper getInstance(Context context)
    {
        if (instance == null)
        {
            instance = new TestDbHelper(context);
        }
        return instance;
    }

    public TestDbHelper(Context context)
    {
        super(context, databaseName, null, databaseVersion);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource)
    {
        try
        {
            TableUtils.createTable(connectionSource, Pageinfo.class);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Dao<Pageinfo, Integer> getTestDb() throws Exception
    {
        if (mTestdbDao == null)
        {
            mTestdbDao = DaoManager.createDao(connectionSource, Pageinfo.class);
        }
        return mTestdbDao;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1)
    {
        try
        {
            TableUtils.dropTable(connectionSource, Pageinfo.class, true);
            TableUtils.createTable(connectionSource, Pageinfo.class);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void destory()
    {
        if (instance != null)
        {
            instance.mTestdbDao = null;
            instance.close();
            instance = null;
        }
    }

}
