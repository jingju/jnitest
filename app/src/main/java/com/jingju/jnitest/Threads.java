package com.jingju.jnitest;

// Created by Macro on 2021/3/24.

import android.widget.EditText;

public class Threads {

    static {
        System.loadLibrary("threads");
    }


    private ThreadsNativeCallBack mNativeCallBack;
    /**
     * java api 开启线程
     * @param threads
     * @param iterations
     */
    public void javaThreads(int threads,int iterations){

        for (int i = 0; i <threads; i++) {
            final int id=i;
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    nativeWorker(id,iterations);
                }
            });
            thread.start();
        }

    }
    /**
     * posix api 开启线程，即c语言
     * @param threads
     * @param iterations
     */
    public native void posixThreads(int threads,int iterations);


    public interface ThreadsNativeCallBack{
        void  onNativieMessage(final String message);
    }

    public void setNativeCallBack(ThreadsNativeCallBack nativeCallBack) {
        this.mNativeCallBack = nativeCallBack;
    }


    private void onNativieMessage(final String message) {
        if(null!=mNativeCallBack){
            mNativeCallBack.onNativieMessage(message);
        }
    }


    /**
     * 初始化natvie代码
     */
    public native void nativeInit();

    /**
     * 释放navtive资源
     */
    public native void nativeFree();


    /**
     * 原声woker
     * @param id worker id
     * @param iterations    iteration count
     */
    public native void nativeWorker(int id,int iterations);

}
