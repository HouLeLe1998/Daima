package com.example.BesaFragMnet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.week3.R;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        inteView();
        initDate();

    }

    public abstract void inteView();

    public abstract void initDate();

    public abstract int initLayout();
    public <T extends  View> T fing(int inse){
        return (T)findViewById(inse);
    }
}
