package com.jingju.jnitest;

// Created by Macro on 2021/3/31.

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public abstract class AbstractPlayerActivity extends AppCompatActivity {

    /**AVI 文件名字的extra*/
    public static final String EXTRA_FILE_NAME="";//todo 稍后赋值

    /** AVI 视频文件的描述符*/
    protected long avi=0;

    protected AVIPlayer mPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPlayer= new AVIPlayer();
    }

    /**
     * On start.
     */
    @Override
    protected void onStart() {
        super.onStart();
        //代开AVI文件
        try {
            avi=mPlayer.open(getFileName());
        }catch (IOException e){
            new AlertDialog.Builder(this)
                    .setTitle(R.string.error_alert_title)
                    .setMessage(e.getMessage())
                    .show();
        }
    }

    /**
     * On stop
     */
    @Override
    protected void onStop() {
        super.onStop();

        //如果AVI视频是打开的
        if(0!=avi){
            //关闭文件描述符
            mPlayer.close(avi);
            avi=0;
        }
    }
    /**
     * 获取AVI视频文件的名字
     */
    protected String getFileName(){
        return getIntent().getExtras().getString(EXTRA_FILE_NAME);
    }

}
