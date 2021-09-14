package com.jingju.jnitest;

// Created by Macro on 2021/3/25.

import androidx.appcompat.app.AppCompatActivity;

public class EchoServerActivity extends AbstractEchoActivity {

    private Echo mEcho;

    public EchoServerActivity() {
        super(R.layout.activity_echo_server);
        mEcho=new Echo();
    }


    @Override
    protected void onStartButtonClicked() {
        Integer port = getPort();
        if(port !=null){


        }
    }


    private class ServerTask extends AbstractEchoTask{

        private final int port;

        public ServerTask(final int port) {
            this.port=port;
        }

        @Override
        protected void onBackground() {
            logMessage("Starting server");
            try {
                mEcho.nativeStartUpServer(port);
            }catch (Exception e){
                logMessage(e.getMessage());
            }

            logMessage("Server terminated");
        }
    }
}
