package com.example.day_13;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class BesaACtivit extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initlayout());
        intView();
        intDate();

    }

    protected abstract void intView();

    protected abstract void intDate();

    protected abstract int initlayout();
    public  <T extends  View> T find(int inse){
        return (T)findViewById(inse);
    }
}
