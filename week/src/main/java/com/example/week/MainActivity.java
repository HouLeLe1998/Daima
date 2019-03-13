package com.example.week;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.base.BaseActivity;
import com.example.frag.Frag_01;
import com.example.frag.Frag_02;
import com.example.frag.Frag_03;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private List<Fragment> list = new ArrayList<>();
    private String tab [] ={"首页","中页","我的"};
    private ViewPager pager;
    private TabLayout tabLayout;

    @Override
    protected void initDate() {
        Frag_01 frag_01 = new Frag_01();
        Frag_02 frag_02 = new Frag_02();
        Frag_03 frag_03 = new Frag_03();
        list.add(frag_01);
        list.add(frag_02);
        list.add(frag_03);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tab[position];
            }

            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        tabLayout.setupWithViewPager(pager);
    }

    @Override
    protected void initView() {
        pager = find(R.id.pager);
        tabLayout = find(R.id.tab);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {

    }
}
