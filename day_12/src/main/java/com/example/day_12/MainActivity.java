package com.example.day_12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BAseActivity {

    private Button but;

    @Override
    protected void inDate() {
        but.setText("点击按钮");
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        but = fvdi(R.id.but);
        but.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.but:
                Toast.makeText(MainActivity.this,"点击了按钮",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
