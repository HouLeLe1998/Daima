package com.bwie.beas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bwie.houlele2019_03_08.R;

public abstract class BeasVctivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initlayout());
        initView();
        initDate();
        initListenter();
        
    }

    protected abstract void initListenter();

    protected abstract void initDate();

    protected abstract void initView();

    protected abstract int initlayout();
     public <T extends  View>T find(int inser){
         return (T)findViewById(inser);
     }

}
