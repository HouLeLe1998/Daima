package com.bwie.houlele2019_03_08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.bwie.beas.BeasVctivity;

import java.util.ArrayList;
import java.util.List;


public class PinDaoActivity extends BeasVctivity {


    private GridView gridView;
    private GridView gridView1;
    List<String> lista  = new ArrayList<>();
    List<String>  listb  =new ArrayList<>();
    @Override
    protected void initListenter() {

    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void initView() {
        gridView = find(R.id.grid1);
        gridView1 = find(R.id.grid2);

    }

    @Override
    protected int initlayout() {
        return R.layout.activity_pin_dao;
    }

    @Override
    public void onClick(View v) {

    }
}
