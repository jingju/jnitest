package com.jingju.jnitest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG=MainActivity.class.getSimpleName();

    public Test mTest;
    private TextView mTvTest;
    private TextView mTvThreadsTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvTest = findViewById(R.id.test);
        mTvThreadsTest = findViewById(R.id.threadsTest);
        mTest=new Test();
        mTvTest.setOnClickListener(this);
        mTvThreadsTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.test:
                mTvTest.setText(mTest.testString());
                break;
             case R.id.threadsTest:
                 Intent intent = new Intent(this,ThreadsTestActivity.class);
                 startActivity(intent);
                 break;
        }
    }
}