package com.jingju.jnitest;

// Created by Macro on 2021/3/24.

import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThreadsTestActivity extends AppCompatActivity implements View.OnClickListener, Threads.ThreadsNativeCallBack {

    private EditText threadsEdit;
    private EditText iterationEdit;
    private Button startButton;
    private Threads mThreads;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threads_test);
        initView();
        mThreads = new Threads();
        mThreads.nativeInit();
        mThreads.setNativeCallBack(this);


    }

    private void initView() {
        threadsEdit = findViewById(R.id.threadsEdit);
        iterationEdit = findViewById(R.id.iterationsEdit);
        startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mThreads.nativeFree();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startButton:
                int threads = getNumber(threadsEdit, 0);
                int threadIterations = getNumber(iterationEdit, 0);
                if(threads>0&&threadIterations>0){
                    startThreads(threads,threadIterations);
                }
                break;
        }

    }

    private void startThreads(int threads,int iterations){
        mThreads.posixThreads(threads,iterations);
//        mThreads.javaThreads(threads,iterations);
    }


    @Override
    public void onNativieMessage(String message) {
        //tip:回调还是在子线程，要想更新Ui得发送到主线程，或者调用runOnUiThread。
        /**
         * 底层采用互斥量
         * 采用runOnUIThread，打印会出现错误，会先打印returen
         */
//        runOnUiThread(() -> {
            Log.d("onNativieMessage",message);
//            logView.append(message);
//            logView.append("\n");
//        });
    }

    private static int getNumber(EditText editText, int defaultValue) {
        int value;
        try {
            value = Integer.parseInt(editText.getText().toString());
        } catch (NumberFormatException e) {
            value = defaultValue;
        }
        return value;
    }


}
