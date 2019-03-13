package com.bwie.tabfrag;

import android.content.ContentValues;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.bwie.adapter.MyAdapter;
import com.bwie.bean.Bean;
import com.bwie.beas.BeasFragment;
import com.bwie.dao.Dao;
import com.bwie.houlele2019_03_08.R;
import com.bwie.netuilt.NetUilt;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @houlelel
 * 接口
 * 抽积累
 * 展示数据
 * 获取适配器
 * 展示
 * 数据库
 */

public class TabFrag_01 extends BeasFragment {


    private PullToRefreshListView pull;
    private List<Bean.DataBeanX.DataBean> list = new ArrayList<>();
    private String url = "http://365jia.cn/news/api3/365jia/news/categories/hotnews?page=";
    private int page = 1;
    private MyAdapter myAdapter;
    private Dao dao;

    @Override

    protected int initLayout() {
        return R.layout.tabfrag_01;
    }

    @Override
    protected void initView() {
        pull = find(R.id.pull);
        pull.setMode(PullToRefreshBase.Mode.BOTH);
        pull.setScrollingWhileRefreshingEnabled(true);
        dao = new Dao(getActivity());
    }

    @Override
    protected void initDate() {
//          获取适配器
        myAdapter = new MyAdapter(list, getActivity());
        pull.setAdapter(myAdapter);
        if (NetUilt.IsGetContent(getActivity())) {
            isgion(page);
            pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
                @Override
                public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
//                    清空
                    list.clear();
                     isgion(page);

                }

                @Override
                public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                           page++;
                           isgion(page);
                }
            });
        }else {
//            检查网络
            Toast.makeText(getActivity(),"检查网络",Toast.LENGTH_SHORT).show();
        }
    }
//展示shaxin
    private void isgion(int p) {
        String str = url + p;
        NetUilt.MyAnck(str, new NetUilt.MyCallBack() {
            @Override
            public void getDate(String s) {
                Gson gson = new Gson();
                Bean bean = gson.fromJson(s, Bean.class);
                List<Bean.DataBeanX.DataBean> data = bean.getData().getData();
//                添加刷新
                for (int i = 0; i <data.size(); i++) {
                    ContentValues values = new ContentValues();
                    values.put("title",data.get(i).getTitle());
//                    values.put("pics",data.get(i).getPics().get(0));
                    dao.insert("person",null,values);
                }
                list.addAll(data);
                myAdapter.notifyDataSetChanged();
                pull.onRefreshComplete();
            }
        });
    }
}
