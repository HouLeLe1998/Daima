package com.example.bace;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public  abstract  class BaceActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initView();
        initDate();

    }

    protected abstract void initView();

    protected abstract void initDate();

    protected abstract int initLayout();
    public <T extends View>T fisv(int fin){
        return (T)findViewById(fin);
    }
}
