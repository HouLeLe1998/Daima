package com.example.fragment;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.example.base.BaseFragment;
import com.example.tabfragment.TabFrag_01;
import com.example.tabfragment.TabFrag_02;
import com.example.tabfragment.TabFrag_03;
import com.example.tabfragment.TabFrag_04;
import com.example.tabfragment.TabFrag_05;
import com.example.yurkao_02.MainActivity;
import com.example.yurkao_02.R;
import com.example.yurkao_02.Zhangjiaxingzhitianjia;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.List;

public class Frag_01 extends BaseFragment {

    private ViewPager pager;
    private TabLayout tabLayout;
    private List<Fragment> list = new ArrayList<>();
    private ArrayList<String> lista = new ArrayList<>();
    private TextView textView;

    @Override
    protected int initLayout() {
        return R.layout.frag_01;
    }

    @Override
    protected void initView() {
        pager = find(R.id.pager);
        tabLayout = find(R.id.tab);
        textView = find(R.id.tiajia);
    }

    @Override
    protected void initDate() {
//        频道管理


//
        TabFrag_01 tabFrag_01 = new TabFrag_01();
        TabFrag_02 tabFrag_02 = new TabFrag_02();
        TabFrag_03 tabFrag_03 = new TabFrag_03();
        TabFrag_04 tabFrag_04 = new TabFrag_04();
        TabFrag_05 tabFrag_05 = new TabFrag_05();
        list.add(tabFrag_01);
        list.add(tabFrag_02);
        list.add(tabFrag_03);
        list.add(tabFrag_04);
        list.add(tabFrag_05);
//        添加频道管理
        lista.add("张家兴");
        lista.add("张佳兴");
        lista.add("张嘉兴");
        lista.add("张加刑");
        lista.add("张假惺");

//


        pager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return lista.get(position);

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

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Zhangjiaxingzhitianjia.class);
                intent.putStringArrayListExtra("lista",lista);
                startActivityForResult(intent,1);

            }
        });
    }
}
