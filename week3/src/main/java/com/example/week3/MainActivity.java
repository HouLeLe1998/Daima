package com.example.week3;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.BesaFragMnet.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
   private List<Fragment> list  = new ArrayList<Fragment>();
    private ViewPager pager;
    private TabLayout tabLayout;

    @Override
    public void inteView() {
        pager = fing(R.id.pager);
        tabLayout = fing(R.id.tab);
    }

    @Override
    public void initDate() {

    }

    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {

    }
}
