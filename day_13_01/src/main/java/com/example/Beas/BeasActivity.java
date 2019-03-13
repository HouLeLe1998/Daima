package com.example.Beas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class BeasActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initView();
        initDate();
    }

    protected abstract void initDate();

    protected abstract void initView();

    protected abstract int initLayout();
    public  <T extends  View>T find(int inser){
        return (T)findViewById(inser);
    }
}
