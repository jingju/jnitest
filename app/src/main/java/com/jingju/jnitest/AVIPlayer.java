package com.jingju.jnitest;

// Created by Macro on 2021/3/31.

import java.io.IOException;

public class AVIPlayer {

    static {
        System.loadLibrary("AVIPlayer");
    }

    /**
     * 打开指定的AVI文件并返回一个文件描述符
     * @param fileName
     * @return
     * @throws IOException
     */
    public native static long open(String fileName) throws IOException;

    /**
     * 获得视频的宽度
     * @param avi
     * @return
     */
    public native static int getWidth(long avi);

    /**
     * 获得视频的高度
     * @param avi
     * @return
     */
    public native static int getHeight(long avi);

    /**
     *  获得帧率
     * @param avi
     * @return
     */
    public native static double getFrameRate(long avi);

    /**
     * 关闭指定文件
     * @param avi file descriptor
     * @return
     */
    public native static double close(long avi);

}
