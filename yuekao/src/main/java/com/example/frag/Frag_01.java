package com.example.frag;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.base.BaseFragment;
import com.example.tabfrag.TabFrag_01;
import com.example.tabfrag.TabFrag_02;
import com.example.tabfrag.TabFrag_03;
import com.example.tabfrag.TabFrag_04;
import com.example.tabfrag.TabFrag_05;
import com.example.tabfrag.TabFrag_06;
import com.example.tabfrag.TabFrag_07;
import com.example.yuekao.R;

import java.util.ArrayList;
import java.util.List;

/**
 * tablayout
 * 实现上面的滑动
 *
 */
public class Frag_01 extends BaseFragment {

    private TabLayout tabLayout;
    private ViewPager pager;
    private String tab[] = {"沪深", "板块", "指数", "港股", "新三板", "商品", "更多"};
    private List<Fragment> list = new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.frag_01;

    }

    @Override
    protected void initView() {
        tabLayout = find(R.id.tab);
        pager = find(R.id.pager);
    }
//调用布局
    @Override
    protected void initDate() {
        TabFrag_01 tabFrag_01 = new TabFrag_01();
        TabFrag_02 tabFrag_02 = new TabFrag_02();
        TabFrag_03 tabFrag_03 = new TabFrag_03();
        TabFrag_04 tabFrag_04 = new TabFrag_04();
        TabFrag_05 tabFrag_05 = new TabFrag_05();
        TabFrag_06 tabFrag_06 = new TabFrag_06();
        TabFrag_07 tabFrag_07 = new TabFrag_07();
//       添加布局
        list.add(tabFrag_01);
        list.add(tabFrag_02);
        list.add(tabFrag_03);
        list.add(tabFrag_04);
        list.add(tabFrag_05);
        list.add(tabFrag_06);
        list.add(tabFrag_07);
//        添加适配器
       pager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
//           在此位置添加一个方法
//           getpageTite+快捷键
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
               return 7;
           }
       });
//       实现tablayoout
       tabLayout.setupWithViewPager(pager);
    }
}
