package com.example.yuekao;

import android.content.ContentValues;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.adapter.XMyAdapter;
import com.example.base.BaseActivity;
import com.example.bean.Bean;
import com.example.frag.Frag_01;
import com.example.frag.Frag_02;
import com.example.frag.Frag_03;
import com.example.frag.Frag_04;
import com.example.frag.Frag_05;
import com.example.mysql.Dao;
import com.example.mysqla.Daol;
import com.example.netuli.NetUlit;
import com.google.gson.Gson;
import com.qy.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 滑动
 * 实现侧拉的xlistview
 */
public class MainActivity extends BaseActivity {

    private ViewPager pager;
    private RadioGroup group;
    private int page = 1;
    private List<Fragment> list = new ArrayList<>();
    List<Bean.ResultBean.DataBean> list1 = new ArrayList<>();
    private String ima = "http://ww1.sinaimg.cn/large/0065oQSqly1fsq9iq8ttrj30k80q9wi4.jpg";
    private String url = "http://v.juhe.cn/toutiao/index?type=top&key=dbedecbcd1899c9785b95cc2d17131c5";
    private ImageView imageView;
    private XListView listView;
    private XMyAdapter xMyAdapter;
    private Dao dao;
    private Daol daol;

    @Override
    protected void initDate() {

//        获取上拉加载
//        获取头像
        Glide.with(MainActivity.this).load(ima).into(imageView);
//xLISTVIEW
//给适配器一个方法
        MyAdapter();
//        调用一个数据
        isiong(page);

//   实现点击划动事件
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
//        滑动
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
                    case R.id.but5:
                        pager.setCurrentItem(4);
                        break;
                }
            }
        });
//        小圆点跟着走
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
        listView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
//                    刷新
                list1.clear();
                isiong(page);
            }

            @Override
            public void onLoadMore() {
                page++;
                isiong(page);

            }

        });

//        判断网络
        if (NetUlit.isGetContent(MainActivity.this)) {
            String ss = url;
            NetUlit.MyAnck(ss, new NetUlit.MyCallBack() {
                @Override
                public void GetDate(String s) {
                    isgson(s);
                }
            });
//            有网实现列表

        } else {
//            ，没网吐司
            Toast.makeText(MainActivity.this, "检查网络", Toast.LENGTH_SHORT).show();

        }


    }

    private void isiong(int page) {

    }

    public void isgson(String sl) {
        Gson gson = new Gson();
        Bean bean = gson.fromJson(sl, Bean.class);
        List<Bean.ResultBean.DataBean> data = bean.getResult().getData();
        for (int i = 0; i <data.size() ; i++) {
            ContentValues values = new ContentValues();
            values.put("title", data.get(i).getTitle());
            daol.insert("name", null, values);
        }
        list1.addAll(data);
        xMyAdapter.notifyDataSetChanged();
        listView.setRefreshTime("刚刚");
        listView.stopLoadMore();
        listView.stopRefresh();
        
    }

    //适配器
    private void MyAdapter() {
        xMyAdapter = new XMyAdapter(MainActivity.this, list1);
        listView.setAdapter(xMyAdapter);
    }


    @Override
    protected void initView() {
        pager = find(R.id.pager);
        group = find(R.id.group);
        imageView = find(R.id.image);
        listView = find(R.id.xlistview);
        daol = new Daol(MainActivity.this);
        listView.setPullLoadEnable(true);
        listView.setPullRefreshEnable(true);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {

    }
}
