package com.example.allaop;

import android.app.Fragment;
import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by jesse on 14/03/2017.
 */
@Aspect
public class ActivityAOP1
{
    private static final String TAG = ActivityAOP1.class.getSimpleName();

    /**
     * activity onCreate point cut
     */
    @Pointcut("execution(* android.app.Activity.onCreate(..))")
    public void activityOnCreate()
    {
        //empty method body
    }

    @Around("activityOnCreate()")
    public void activityOnCreateTriggered(ProceedingJoinPoint joinPoint) throws Throwable
    {
        String targetClassName = joinPoint.getTarget().getClass().getName();
        String signatureName = joinPoint.getSignature().getName();
        Log.d(TAG, targetClassName + " " + signatureName + " before");
        joinPoint.proceed();
        Fragment fragment = null;
        Log.d(TAG, targetClassName + " " + signatureName + " after");
    }

    /*
    fragment生命周期回调
     */
    @Pointcut("execution(* android.app.Fragment.onResume(..))")
    public void fragmentOnResume()
    {
        //empty method body
    }

    @Around("fragmentOnResume")
    public void fragmentOnResumeTriggered(ProceedingJoinPoint joinPoint) throws Throwable
    {
        String targetClassName = joinPoint.getTarget().getClass().getName();
        String signatureName = joinPoint.getSignature().getName();
        Log.d(TAG, targetClassName + " " + signatureName + " before");
    }

    /**
     * activity onResume point cut
     */
    @Pointcut("execution(* android.app.Activity.onResume())")
    public void activityOnResume()
    {
        //empty method body
    }

    @Before("activityOnResume()")
    public void activityOnResumeTriggered(JoinPoint joinPoint)
    {
        String targetClassName = joinPoint.getTarget().getClass().getName();
        String signatureName = joinPoint.getSignature().getName();
        Log.d(TAG, targetClassName + " " + signatureName + " before");
    }
}
