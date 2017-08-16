package com.example.testlibrary.db;

import com.j256.ormlite.dao.Dao;

import java.util.HashMap;
import java.util.List;

/**
 * Created by csy on 2017/8/2.
 */

public class TestDbDao
{
    private Dao<Pageinfo, Integer> dao = null;

    public TestDbDao(Dao<Pageinfo, Integer> dao)
    {
        this.dao = dao;
    }

    public void insert(Pageinfo data) throws Exception
    {
        List<Pageinfo> dRecords = getDRecord(data);
//        if (!ListUtil.isEmpty(dRecords))
//        {
//            Pageinfo dRecord = dRecords.get(0);
//            deleteDRecord(dRecord);
//        }
        dao.create(data);
    }

    public List<Pageinfo> getDRecord(Pageinfo data) throws Exception
    {
        HashMap<String, Object> map = new HashMap<>();
        map.put(TestIntentParam.TestDbParam.COLUMN_STARTTIME, data.getmStarttime());
        map.put(TestIntentParam.TestDbParam.COLUMN_STOPTIME, data.getmStoptime());
        map.put(TestIntentParam.TestDbParam.COLUMN_PAGENAME, data.getmPagename());
        return dao.queryForFieldValues(map);
    }

//    public void deleteDRecord(TestDb data) throws Exception
//    {
//        String sql = "delete from PX_StudyDRecord where"
//                + "' student_id = " + data.getStudentId() + "' and course_id = " + data.getCourseId();
//        dao.executeRaw(sql);
//    }


}
