package com.bawei.beas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bawei.weektest.R;

/**
 * @侯乐乐
 *获取控件
 * 获取布局
 * 获取数据
 */
public abstract class BeasActivity extends AppCompatActivity implements View.OnClickListener {
//    抽积
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        布局
        setContentView(initLayout());
//        控件
        initView();
//        数据
        initDate();
    }

    protected abstract void initDate();

    protected abstract void initView();

    protected abstract int initLayout();

    public <T extends View> T find(int inser) {
        return (T) findViewById(inser);
    }
}
