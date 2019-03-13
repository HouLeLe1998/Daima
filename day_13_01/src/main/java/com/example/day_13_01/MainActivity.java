package com.example.day_13_01;

import android.media.Image;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.Beas.BeasActivity;
import com.example.Frag.Frag_01;
import com.example.Frag.Frag_02;
import com.example.Frag.Frag_03;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BeasActivity {
    private String[]tab = {"首页","我的","年轻"};
    private String  ima = "http://ww1.sinaimg.cn/large/0065oQSqly1fszxi9lmmzj30f00jdadv.jpg";
  private List<Fragment> list = new ArrayList<Fragment>();
    private ViewPager pager;
    private TabLayout tabLayout;
    private ImageView imageView;

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
        Glide.with(MainActivity.this).load(ima).into(imageView);
    }

    @Override
    protected void initView() {
        pager = find(R.id.pager);
        tabLayout = find(R.id.tab);
        imageView = find(R.id.image);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {

    }
}
