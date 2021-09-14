package com.jingju.jnitest;

// Created by Macro on 2021/3/31.

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AVIPlayerTestActivity extends AppCompatActivity implements View.OnClickListener {


    /** AVI 文件名字编辑*/
    private EditText fileNameEdit;

    /** Player 类型的单选组*/
    private RadioGroup playerRadioGroup;

    /** Play 按钮*/
    private Button playButton;

    /**
     * On create
     * @param savedInstanceState
     */


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avi_player_test);

        fileNameEdit =(EditText) findViewById(R.id.file_name_edit);
        playerRadioGroup = (RadioGroup) findViewById(R.id.player_radio_group);
        playButton = (Button) findViewById(R.id.play_button);
        playButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.play_button:
                onPlayButtonClick();
                break;
        }
    }

    private void onPlayButtonClick(){
//        Intent intent;

        //活得选择的单选按钮
        int radioId=playerRadioGroup.getCheckedRadioButtonId();
        //基于id 选择activity
        switch (radioId){

        }

    }
}
