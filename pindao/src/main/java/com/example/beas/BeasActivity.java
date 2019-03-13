package com.example.beas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.pindao.R;

public abstract class BeasActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initView();
        initDate();
        initListenter();
    }

    protected abstract void initListenter();

    protected abstract void initDate();

    protected abstract void initView();

    protected abstract int initLayout();

         public <T extends View>T find(int inser){
             return (T)findViewById(inser);
         }
}
