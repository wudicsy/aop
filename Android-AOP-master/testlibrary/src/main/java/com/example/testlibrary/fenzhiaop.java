package com.example.testlibrary;

import android.app.Fragment;
import android.content.Context;
import android.util.Log;


import com.example.testlibrary.db.Pageinfo;
import com.example.testlibrary.db.TestDbHelper;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.List;

/**
 * Created by csy on 2017/8/15.
 */
@Aspect
public class fenzhiaop {

    public Context context;

    public fenzhiaop(Context context) {
        this.context = context;
    }

    @Pointcut("execution(* android.app.Activity.onCreate(..))")
    public void activityOnCreate() {
        //empty method body
    }

    @Around("activityOnCreate()")
    public void activityOnCreateTriggered(ProceedingJoinPoint joinPoint) throws Throwable {
        String targetClassName = joinPoint.getTarget().getClass().getName();
        String signatureName = joinPoint.getSignature().getName();
        Log.d("", targetClassName + " " + signatureName + " before");
        joinPoint.proceed();
        Fragment fragment = null;
        Log.d("", targetClassName + " " + signatureName + " after");
    }

    /**
     * activity onResume point cut
     */
    @Pointcut("execution(* android.app.Activity.onResume())")
    public void activityOnResume() {
        //empty method body
    }

    @Before("activityOnResume()")
    public void activityOnResumeTriggered(JoinPoint joinPoint) {
        String targetClassName = joinPoint.getTarget().getClass().getName();
        String signatureName = joinPoint.getSignature().getName();
        Log.d("", targetClassName + " " + signatureName + " before");
    }

    @Pointcut("execution(* android.support.v4.app.Fragment.onResume())")
    public void fgOnResume() {
        //empty method body
    }

    @Before("fgOnResume()")
    public void fgOnResumeTriggered(JoinPoint joinPoint) {
        String targetClassName = joinPoint.getTarget().getClass().getName();
        String signatureName = joinPoint.getSignature().getName();
        Log.d("", targetClassName + " " + signatureName + " before");
    }

    @Pointcut("execution(* android.support.v4.app.Fragment.onHiddenChanged(..))")
    public void fgOnHiddenChanged() {
        //empty method body
        String a = "1";
    }

    @Before("fgOnHiddenChanged(boolean hidden)")
    public void fgOnHiddenChangedTriggered(JoinPoint joinPoint, boolean hidden) {
        String targetClassName = joinPoint.getTarget().getClass().getName();
        String signatureName = joinPoint.getSignature().getName();
        Log.d("", targetClassName + " " + signatureName + " before");
    }


    @Pointcut("execution(* android.support.v4.app.Fragment.setUserVisibleHint(..))")
    public void setUserVisibleHint() {
        //empty method body
        String a = "1";
    }

    @Before("setUserVisibleHint()")
    public void setUserVisibleHintTriggered(JoinPoint joinPoint) {
        String targetClassName = joinPoint.getTarget().getClass().getName();
        String signatureName = joinPoint.getSignature().getName();
        String a = joinPoint.toString();
        basefragment b = (basefragment) joinPoint.getThis();
        //当c为false时，代表这个fragment正显示在前台
        boolean c = b.getUserVisibleHint();
        if (!c) {
//            Pageinfo pageinfo = new Pageinfo();
//            pageinfo.setmStarttime(System.currentTimeMillis());
//            pageinfo.setmPagename(targetClassName);
//            try
//            {
//                TestDbHelper.getInstance(context).getTestDb().create(pageinfo);
//            } catch (Exception e)
//            {
//                e.printStackTrace();
//            }
        } else {
            try {
                List<Pageinfo> list = TestDbHelper.getInstance(context).getTestDb().queryBuilder().orderBy("starttime", false).where().eq("pagename", targetClassName).query();
                if (list.size() != 0) {
                    long mStarttime = System.currentTimeMillis();
                    if ((mStarttime - list.get(0).getmStarttime()) / 1000 / 60 < 5) {
                        long aaab = (mStarttime - list.get(0).getmStarttime()) / 1000 / 60;
                        String ba = "1";
                    } else {
                        //新建
                        long aaab = (System.currentTimeMillis() - list.get(0).getmStarttime()) / 1000 / 60;
                        String ba = "1";
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Pointcut("execution(* android.support.v4.app.Fragment.onStop())")
    public void fgOnStop() {
        //empty method body
    }

    @Before("fgOnStop()")
    public void fgOnStopTriggered(JoinPoint joinPoint) {
        String targetClassName = joinPoint.getTarget().getClass().getName();
        String signatureName = joinPoint.getSignature().getName();
        Log.d("", targetClassName + " " + signatureName + " before");
    }


    @Pointcut("execution(* android.support.v4.app.Fragment.onDestroy())")
    public void fgonDestroy() {
        //empty method body
    }

    @Before("fgonDestroy()")
    public void fgonDestroyTriggered(JoinPoint joinPoint) {
        String targetClassName = joinPoint.getTarget().getClass().getName();
        String signatureName = joinPoint.getSignature().getName();
        Log.d("", targetClassName + " " + signatureName + " before");
    }


    @Pointcut("execution(* android.support.v4.app.Fragment.onPause())")
    public void fgonPause() {
        //empty method body
    }

    @Before("fgonPause()")
    public void fgonPauseTriggered(JoinPoint joinPoint) {
        String targetClassName = joinPoint.getTarget().getClass().getName();
        String signatureName = joinPoint.getSignature().getName();
        Log.d("", targetClassName + " " + signatureName + " before");
    }


}
