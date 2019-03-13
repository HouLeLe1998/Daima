package com.example.tabfragment;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adaapter.MyAdapterPull;
import com.example.base.BaseFragment;
import com.example.netulit.NetUilt;
import com.example.wbean.Bean;
import com.example.wbean.Beanaa;
import com.example.wbean.Beanb;
import com.example.wbean.Beanc;
import com.example.wbean.Beang;
import com.example.yurkao_02.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class TabFrag_01 extends BaseFragment {

    private PullToRefreshListView pull;
    private String url = "http://172.17.8.100/small/commodity/v1/commodityList";
    private int page = 1;
    private List<Beang.DataBean> list = new ArrayList<>();
    private MyAdapterPull myAdapterPull;

    @Override
    protected int initLayout() {
        return R.layout.tabfrag_01;
    }

    @Override
    protected void initView() {
        pull = find(R.id.pull);
        pull.setMode(PullToRefreshBase.Mode.BOTH);
        pull.setScrollingWhileRefreshingEnabled(true);
    }

    @Override
    protected void initDate() {
//        适配器
        myAdapterPull = new MyAdapterPull(list, getActivity());
        pull.setAdapter(myAdapterPull);
//        调用一个方法
        isgion(page);
        if (NetUilt.IsGetContent(getActivity())) {
            pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
                @Override
                public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                    list.clear();
                    isgion(page);
                }

                @Override
                public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                    isgion(page);
                    page++;
                }
            });
        } else {
            Toast.makeText(getActivity(), "网络错误", Toast.LENGTH_SHORT).show();
        }
    }

    private void isgion(final int page) {
        String str = url + page;
        NetUilt.MyAnck(str, new NetUilt.MyCallBack() {
            @Override
            public void getDate(String s) {
                Gson gson = new Gson();
                Beang beang = gson.fromJson(s, Beang.class);
                List<Beang.DataBean> data = beang.getData();
                list.addAll(data);
                myAdapterPull.notifyDataSetChanged();
                pull.onRefreshComplete();
            }
        });
    }
}
