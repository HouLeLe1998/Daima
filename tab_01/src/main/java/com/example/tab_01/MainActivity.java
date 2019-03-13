package com.example.tab_01;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
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
import com.example.MyAdapter.MyAdapterFrag;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private String[] tlite = {"首页", "中心", "我的"};
    private List<Fragment> list = new ArrayList<Fragment>();
    private TabLayout tabLayout;
    private Button button1;
    private Button button2;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager pager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tab_layout);
        drawerLayout = findViewById(R.id.drwor_layout);
        button1 = findViewById(R.id.but_01);
        button2 = findViewById(R.id.but_02);
        Frag_01 frag_01 = new Frag_01();
        Frag_02 frag_02 = new Frag_02();
        Frag_03 frag_03 = new Frag_03();
        list.add(frag_01);
        list.add(frag_02);
        list.add(frag_03);
        MyAdapterFrag myAdapterFrag = new MyAdapterFrag(getSupportFragmentManager(), list, tlite);
        pager.setAdapter(myAdapterFrag);
        tabLayout.setupWithViewPager(pager);
//        侧拉
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNDEFINED);

       button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(MainActivity.this,"打开",Toast.LENGTH_SHORT).show();
               drawerLayout.openDrawer(Gravity.LEFT);
           }
       });
       button2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(MainActivity.this,"关闭",Toast.LENGTH_SHORT).show();
               drawerLayout.closeDrawer(Gravity.LEFT);
           }
       });
    }
}
