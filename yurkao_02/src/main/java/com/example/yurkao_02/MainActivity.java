package com.example.yurkao_02;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.adaapter.MyXAdapter;
import com.example.base.BeasActivity;
import com.example.bean.Bean;
import com.example.bean.Benaa;
import com.example.fragment.Frag_01;
import com.example.fragment.Frag_02;
import com.example.fragment.Frag_03;
import com.example.fragment.Frag_04;
import com.example.netulit.NetUilt;
import com.google.gson.Gson;
import com.qy.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BeasActivity {

    private ViewPager pager;
    private RadioGroup group;
    private List<Bean> lista = new ArrayList<>();
    private List<Fragment> list = new ArrayList<>();
    private String ima = "http://ww1.sinaimg.cn/large/0065oQSqly1fsfq1k9cb5j30sg0y7q61.jpg";
    private ImageView imageViews;
    private XListView listView;
    private String url = "http://172.17.8.100/movieApi/movie/v1/findHotMovieList?page=";
    private int page = 1;
    private String he = "&&count=";
    private int count = 10;
    private MyXAdapter myXAdapter;


    @Override
    protected void initListenter() {

    }

    @Override
    protected void initView() {
        pager = find(R.id.pager);
        group = find(R.id.radio);
        imageViews = find(R.id.image);
        listView = find(R.id.Xlistveiw);
        listView.setPullRefreshEnable(true);
        listView.setPullLoadEnable(true);


    }

    @Override
    protected void initDate() {
//        获取图片
//  调用方法
        //适配器
        myXAdapter = new MyXAdapter(MainActivity.this, lista);
        listView.setAdapter(myXAdapter);
//
        Glide.with(MainActivity.this).load(ima).into(imageViews);
//
        Frag_01 frag_01 = new Frag_01();
        Frag_02 frag_02 = new Frag_02();
        Frag_03 frag_03 = new Frag_03();
        Frag_04 frag_04 = new Frag_04();
        list.add(frag_01);
        list.add(frag_02);
        list.add(frag_03);
        list.add(frag_04);
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
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.but1:
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
        if (NetUilt.IsGetContent(MainActivity.this)) {
            isgong(url,page,he,count);
            listView.setXListViewListener(new XListView.IXListViewListener() {
                @Override
                public void onRefresh() {
                    isgong(url,page,he,count);
                }

                @Override
                public void onLoadMore() {
                    page++;
                    isgong(url,page,he,count);
                }
            });
        } else {
            Toast.makeText(MainActivity.this, "检查网络", Toast.LENGTH_SHORT).show();
        }


    }

    //方法
    private void isgong(String url,int page, String he,int count) {
        String str = url + page + he + count;
        NetUilt.MyAnck(str, new NetUilt.MyCallBack() {
            @Override
            public void getDate(String s) {
                Gson gson = new Gson();
                Benaa benaa = gson.fromJson(s, Benaa.class);
                List<Bean> result = benaa.getResult();
                lista.addAll(result);
                myXAdapter.notifyDataSetChanged();
                listView.setRefreshTime("刚刚");
                listView.stopLoadMore();
                listView.stopRefresh();

            }
        });


    }

    @Override
    protected int intitLayout() {

        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {

    }
}
