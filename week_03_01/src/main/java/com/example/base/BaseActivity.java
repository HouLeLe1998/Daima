package com.example.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initView();
        initDate();
    }

    protected abstract void initDate();


    protected abstract int initLayout();

    protected abstract void initView();
    

    public <T extends View> T find(int inse) {

        return (T) findViewById(inse);
    }
}
