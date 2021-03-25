package com.jingju.jnitest;

// Created by Macro on 2021/3/21.


public class Test {
    /**
     * 长长的写代码，依赖到项目里
     *
     * 编译一个动态库
     *
     * 编译一个静态库
     *
     */
    static {
        System.loadLibrary("test");
    }

    public native void testVoid();
    public native String testString();
}
