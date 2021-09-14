package com.jingju.jnitest;

// Created by Macro on 2021/3/25.

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import org.w3c.dom.Text;

public abstract class AbstractEchoActivity extends AppCompatActivity implements View.OnClickListener {

    protected EditText portEdit;//端口号

    protected Button startButton;

    protected ScrollView logScroll;//日志滚动

    protected TextView logView;//日志示图

    private final int layoutId;

    public AbstractEchoActivity(final int layoutId){
        this.layoutId=layoutId;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);

        portEdit=(EditText) findViewById(R.id.port_edit);
        startButton=(Button)findViewById(R.id.start_button);
        logScroll=(ScrollView) findViewById(R.id.log_scroll);
        logView=(TextView) findViewById(R.id.log_view);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_button:
                onStartButtonClicked();
                break;
        }

    }

    protected abstract void onStartButtonClicked();

    protected Integer getPort(){
        Integer port;

        try {
            port=Integer.parseInt(portEdit.getText().toString());

        }catch (NumberFormatException e){
            port=null;
        }
        return port;
    }


    protected void  logMessage(final String message){
       runOnUiThread(()->{
           logMessageDirect(message);

       });
    }


    protected void logMessageDirect(final String message){
        logView.append(message);
        logView.append("\n");
        logScroll.fullScroll(View.FOCUS_DOWN);
    }


    protected abstract class AbstractEchoTask extends Thread{

        private final Handler handler;

        public AbstractEchoTask() {
            handler = new Handler();
        }

        /**
         * 线程执行前的回调
         */
        protected void onPreExecute(){
            startButton.setEnabled(false);
            logView.setText("");
        }

        public synchronized void start(){
            onPreExecute();
            super.start();
        }

        public void run(){
            onBackground();
            handler.post(()->{
                onPostExcute();

            });
        }

        /**
         * 新线程中的背景回调
         */
        protected abstract void onBackground();

        /**
         * 线程执行后的回到
         */
        protected void onPostExcute(){
            startButton.setEnabled(true);
        }

    }


}
