package com.bawei.weektest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bawei.adapter.Adapter;
import com.bawei.adapter.MyAdapter;
import com.bawei.bean.GridBean;
import com.bawei.beas.BeasActivity;
import com.bawei.netulit.NetUlit;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BeasActivity {

    private Banner banner;
    private PullToRefreshListView pull;
    private String url = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/";
    private int page = 1;
    private List<String> image = new ArrayList<>();
    private List<GridBean.ResultsBean> list = new ArrayList<>();
    private GridView gridView;
    private MyAdapter myAdapter;
    private Adapter adapter;

    /**
     * @侯乐乐
     * 实现无限轮播
     * 判断网络
     * 接收适配器
     * json解析
     */
    @Override
    protected void initDate() {
//        接收图片
        image.add("http://172.17.8.100/images/small/banner/cj.png");
        image.add("http://172.17.8.100/images/small/banner/hzp.png");
        image.add("http://172.17.8.100/images/small/banner/lyq.png");
        image.add("http://172.17.8.100/images/small/banner/px.png");
        image.add("http://172.17.8.100/images/small/banner/wy.png");
        myAdapter = new MyAdapter(MainActivity.this, list);
        gridView.setAdapter(myAdapter);
        adapter = new Adapter(MainActivity.this,list);
        pull.setAdapter(adapter);
//        判断网络
        if (NetUlit.isGetContent(MainActivity.this)) {
            banner.isAutoPlay(true).setImages(image).setDelayTime(2000).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
//                    实现轮播

                    Glide.with(context).load(path).into(imageView);
                }
            }).start();
            isgoing(page);
            pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
                @Override
                public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                    page++;
                    isgoing(page);
                }
//j接收
                @Override
                public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                     isgoing(page);
                }
            });
        }else{
//            网络出错
            Toast.makeText(MainActivity.this,"检查网络",Toast.LENGTH_SHORT).show();
        }
    }
//方法
    private void isgoing(int p) {
        String ss = url + p;
        NetUlit.MyAsync(ss, new NetUlit.MyCallBack() {
            @Override
            public void getDate(String s) {
                Gson gson = new Gson();
                GridBean gridBean = gson.fromJson(s, GridBean.class);
                List<GridBean.ResultsBean> results = gridBean.getResults();
//                添加
//                刷新适配器
                list.addAll(results);
                myAdapter.notifyDataSetChanged();
                list.addAll(results);
                adapter.notifyDataSetChanged();
                pull.onRefreshComplete();
            }
        });
    }
//获取控件
    @Override
    protected void initView() {
        banner = find(R.id.banner);
        gridView = find(R.id.gridview);
        pull = find(R.id.pull);
        pull.setMode(PullToRefreshBase.Mode.BOTH);
        pull.setScrollingWhileRefreshingEnabled(true);

    }
//布局
    @Override
    protected int initLayout() {
        return R.layout.activity_main;

    }

    @Override
    public void onClick(View v) {

    }
}
