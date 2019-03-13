package com.bwie.houlele2019_03_08;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.WindowCallbackWrapper;
import android.view.View;
import android.widget.RadioGroup;

import com.bwie.beas.BeasVctivity;
import com.bwie.frag.Frag_01;
import com.bwie.frag.Frag_02;
import com.bwie.frag.Frag_03;
import com.bwie.frag.Frag_04;
import com.bwie.frag.Frag_05;

import java.util.ArrayList;
import java.util.List;

/**
 * @侯乐乐
 * 实现viewpage滑动
 * 适配器
 * 实现点击滑动
 *
 */
public class MainActivity extends BeasVctivity {

    private ViewPager pager;
    private RadioGroup group;
    private List<Fragment> list = new ArrayList<>();

    @Override
    protected void initListenter() {

    }

    @Override
    protected void initDate() {
        Frag_01 frag_01 = new Frag_01();
        Frag_02 frag_02 = new Frag_02();
        Frag_03 frag_03 = new Frag_03();
        Frag_04 frag_04 = new Frag_04();
        Frag_05 frag_05 = new Frag_05();
        list.add(frag_01);
        list.add(frag_02);
        list.add(frag_03);
        list.add(frag_04);
        list.add(frag_05);
//        适配器
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
//        实现点击控件
//        实现滑动事件
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.but1:
//                        获取点击页数从零开始
                        pager.setCurrentItem(0);
                        break;
                    case R.id.but2:
                        pager.setCurrentItem(1);
                        break;
                    case R.id.but3:
                        pager.setCurrentItem(2);
                        break;
                    case R.id.but4:
                        pager.setCurrentItem(3);
                        break;
                    case R.id.but5:
                        pager.setCurrentItem(4);
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
    protected void initView() {
        pager = find(R.id.pager);
        group = find(R.id.radio);
    }

    @Override
    protected int initlayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {

    }
}
