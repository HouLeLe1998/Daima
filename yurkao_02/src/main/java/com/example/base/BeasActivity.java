package com.example.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.yurkao_02.R;

public abstract class BeasActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(intitLayout());

        initView();
        initDate();
        initListenter();
    }

    protected abstract void initListenter();

    protected abstract void initView();

    protected abstract void initDate();

    protected abstract int intitLayout();
    public <T extends View>T find(int inser){
        return (T)findViewById(inser);
    }

}
