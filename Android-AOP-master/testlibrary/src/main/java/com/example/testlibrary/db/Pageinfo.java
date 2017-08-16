package com.example.testlibrary.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by csy on 2017/8/16.
 */
@DatabaseTable(tableName = "tb_user")
public class Pageinfo
{
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "starttime")
    private long mStarttime;
    @DatabaseField(columnName = "stoptime")
    private long mStoptime;
    @DatabaseField(columnName = "pagename")
    private String mPagename;

    public Pageinfo()
    {
    }

    public long getmStarttime()
    {
        return mStarttime;
    }

    public void setmStarttime(long mStarttime)
    {
        this.mStarttime = mStarttime;
    }

    public long getmStoptime()
    {
        return mStoptime;
    }

    public void setmStoptime(long mStoptime)
    {
        this.mStoptime = mStoptime;
    }

    public String getmPagename()
    {
        return mPagename;
    }

    public void setmPagename(String mPagename)
    {
        this.mPagename = mPagename;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }


}
