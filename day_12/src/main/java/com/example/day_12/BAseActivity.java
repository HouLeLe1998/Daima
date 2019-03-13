package com.example.day_12;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract  class BAseActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initView();
        inDate();
    }

    protected abstract void inDate();

    protected abstract int initLayout();

    protected abstract void initView();
    public  <T extends View> T fvdi(int  resid){
        return  (T)findViewById(resid);
    }
}
