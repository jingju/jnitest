package com.jingju.jnitest;

// Created by Macro on 2021/3/25.

public class Echo {

    static {
        System.loadLibrary("echo");

    }

    public native void nativeStartUpServer(int port) throws Exception;

    /**
     * 根据服务器给定的IP地址和端口号启动TCP客户端，并且发送给定消息
     * @param ip
     * @param port
     * @param message
     * @throws Exception
     */
    private native void nativeStartTcpClient(String ip,int port,String message) throws Exception;









}
