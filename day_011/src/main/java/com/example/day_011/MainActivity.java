package com.example.day_011;

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
import android.widget.Toast;

import com.example.Frag.Frag_01;
import com.example.Frag.Frag_02;
import com.example.Frag.Frag_03;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
      private String[] tab = {"首页","我的","新闻"};
      private List<Fragment> list = new ArrayList<Fragment>();
    private TabLayout tab1;
    private ViewPager pager;
    private DrawerLayout drawerLayout;
    private Button open;
    private Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.pager);
        tab1 = findViewById(R.id.tab_11);
        open = findViewById(R.id.but2);
        close = findViewById(R.id.but1);
        drawerLayout = findViewById(R.id.layout);
//固定侧拉
     drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNDEFINED);
//
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"打开",Toast.LENGTH_SHORT).show();
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"关闭",Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(Gravity.LEFT);
            }
        });
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

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tab[position];
            }
        });
        tab1.setupWithViewPager(pager);
    }

}
