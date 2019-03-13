package com.example.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.week.R;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initView();
        initDate();
    }

    protected abstract void initDate();

    protected abstract void initView();

    protected abstract int initLayout();
    public <T extends View>T find(int inser){
        return  (T)findViewById(inser);
    }
}
