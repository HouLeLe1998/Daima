package com.example.week_03_01;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.base.BaseActivity;
import com.example.frag.Frag_01;
import com.example.frag.Frag_02;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private List<Fragment> list = new ArrayList<Fragment>();
    private String ima = "http://ww1.sinaimg.cn/large/0065oQSqly1fsvb1xduvaj30u013175p.jpg";
    private String yyy[] = {"首页","我的"};
    private ViewPager pager;
    private TabLayout tabLayout;
    private ImageView imageView;

    @Override
    protected void initDate() {
        Frag_01 frag_01 = new Frag_01();
        Frag_02 frag_02 = new Frag_02();
        list.add(frag_01);
        list.add(frag_02);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return yyy[position];
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
//        RequestOptions options = RequestOptions.circleCropTransform();
        Glide.with(MainActivity.this).load(ima).into(imageView);
    }

    @Override
    protected int initLayout() {

        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        pager = find(R.id.pager);
        tabLayout = find(R.id.tab);
        imageView = find(R.id.image2);

    }




    @Override
    public void onClick(View v) {

    }
}
