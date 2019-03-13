package com.bwie.frag;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.bwie.beas.BeasFragment;
import com.bwie.houlele2019_03_08.PinDaoActivity;
import com.bwie.houlele2019_03_08.R;
import com.bwie.tabfrag.TabFrag_01;
import com.bwie.tabfrag.TabFrag_02;
import com.bwie.tabfrag.TabFrag_03;
import com.bwie.tabfrag.TabFrag_04;
import com.bwie.tabfrag.TabFrag_05;
import com.bwie.tabfrag.TabFrag_06;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合
 * tablayt滑动
 * 添加类
 * 添加布局
 * 适配器
 * 侯乐乐
 */
public class Frag_01 extends BeasFragment {

    private ViewPager pager1;
    private TabLayout tabLayout;
    //    集合数组
    private String tob[] = {"关注", "热点", "北京", "推荐", "视频", "新时代"};
    List<Fragment> fragments = new ArrayList<>();
    private TextView tlite;

    @Override
    protected int initLayout() {
        return R.layout.frag_01;
    }

    @Override
    protected void initView() {
        pager1 = find(R.id.pager1);
        tabLayout = find(R.id.tab);
        tlite = find(R.id.tlite);
    }
//添加布局
//  添加类
    @Override
    protected void initDate() {
//        跳转
        tlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),PinDaoActivity.class);
                startActivity(intent);
            }
        });
//        获取tabfrag
        TabFrag_01 tabFrag_01 = new TabFrag_01();
        TabFrag_02 tabFrag_02 = new TabFrag_02();
        TabFrag_03 tabFrag_03 = new TabFrag_03();
        TabFrag_04 tabFrag_04 = new TabFrag_04();
        TabFrag_05 tabFrag_05 = new TabFrag_05();
        TabFrag_06 tabFrag_06 = new TabFrag_06();
//        添加
        fragments.add(tabFrag_01);
        fragments.add(tabFrag_02);
        fragments.add(tabFrag_03);
        fragments.add(tabFrag_04);
        fragments.add(tabFrag_05);
        fragments.add(tabFrag_06);

//适配器
        pager1.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tob[position];
            }

            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
//        tab实现滑动
        tabLayout.setupWithViewPager(pager1);
    }

}
