package com.jingju.jnitest;

// Created by Macro on 2021/3/26.

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class EchoClientActivity extends AbstractEchoActivity{

    //IP地址
    private EditText ipEdit;

    //消息编辑
    private EditText messageEdit;


    public EchoClientActivity() {
        super(R.layout.activity_echo_client);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ipEdit=(EditText)findViewById(R.id.ip_edit);
        messageEdit = (EditText)findViewById(R.id.message_edit);
    }

    protected void onStartButtonClicked(){
        String ip = ipEdit.getText().toString();
        Integer port = getPort();
        String message = messageEdit.getText().toString();
        if((0!= ip.length()) && (port!=null) && (0!=message.length())){


        }


    }


    /**
     * 客户端任务
     */
    private class ClientTask extends AbstractEchoTask{

        //连接的IP地址
        private final String ip;

        //端口号
        private final int port;

        //发送的消息文本
        private final String message;

        public ClientTask(String ip, int port, String message) {
            this.ip = ip;
            this.port = port;
            this.message = message;
        }

        @Override
        protected void onBackground() {
            logMessage("Starting client");
            try {

            }catch (Throwable e){
                logMessage(e.getMessage());
            }
            logMessage("Client terminated.");
        }
    }

}
