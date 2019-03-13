package com.example.tab_02;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.example.Frag.Frag_01;
import com.example.Frag.Frag_02;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] tlite = {"首页", "我的"};
    private List<Fragment> list = new ArrayList<Fragment>();
    private TabLayout tabLayout;
    private ViewPager pager;
    private DrawerLayout drawerLayout;
    private Button but1;
    private Button but2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tab_layout);
        drawerLayout = findViewById(R.id.reler_layout);
        but1 = findViewById(R.id.but1);
        but2 = findViewById(R.id.but2);
        pager = findViewById(R.id.pager);
        Frag_01 frag_01 = new Frag_01();
        Frag_02 frag_02 = new Frag_02();
        list.add(frag_01);
        list.add(frag_02);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tlite[position];
            }
        });
        tabLayout.setupWithViewPager(pager);
//        关闭滑动
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNDEFINED);
//        打开侧拉
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
//        关闭
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(Gravity.LEFT);
            }
        });

    }
}
