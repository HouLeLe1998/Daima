package com.example.day_12_02;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.Frag.Frag_01;
import com.example.Frag.Frag_02;
import com.example.Frag.Frag_03;
import com.example.bace.BaceActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaceActivity {
    private List<Fragment> list = new ArrayList<Fragment>();
    private ViewPager pager;
    private RadioGroup group;

    @Override
    protected void initView() {
        pager = fisv(R.id.pager);
        group = fisv(R.id.radio);
    }

    @Override
    protected void initDate() {
        Frag_01 frag_01 = new Frag_01();
        Frag_02 frag_02 = new Frag_02();
        Frag_03 frag_03 = new Frag_03();
        list.add(frag_01);
        list.add(frag_02);
        list.add(frag_03);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.but1:
                        pager.setCurrentItem(0);
                        break;
                    case R.id.but2:
                        pager.setCurrentItem(1);
                        break;
                    case R.id.but3:
                        pager.setCurrentItem(2);
                        break;
                }
            }
        });
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                   group.check(group.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;

    }

    @Override
    public void onClick(View v) {

    }
}
