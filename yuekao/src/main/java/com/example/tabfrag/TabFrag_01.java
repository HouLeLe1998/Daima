package com.example.tabfrag;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.PullMyAdapter;
import com.example.base.BaseFragment;
import com.example.bean.Bean;
import com.example.mysql.Dao;
import com.example.netuli.NetUlit;
import com.example.yuekao.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class TabFrag_01 extends BaseFragment {

    private PullToRefreshListView pull;
    private List<Bean.ResultBean.DataBean> list = new ArrayList<>();
    private String url = "http://v.juhe.cn/toutiao/index?type=top&key=dbedecbcd1899c9785b95cc2d17131c5";
    private int page = 1;
    private PullMyAdapter pullMyAdapter;
    private Dao dao;

    //布局
    @Override
    protected int initLayout() {
        return R.layout.tabfrag_01;
    }

    //控件
    @Override
    protected void initView() {

        pull = find(R.id.pull);
        dao = new Dao(getActivity());
        pull.setMode(PullToRefreshBase.Mode.BOTH);
        pull.setScrollingWhileRefreshingEnabled(true);
    }

    //数据
    @Override
    protected void initDate() {
        //             适配器
        pullMyAdapter = new PullMyAdapter(getActivity(), list);
        pull.setAdapter(pullMyAdapter);
//        判断网络
        if (NetUlit.isGetContent(getActivity())) {
//             判断成功
//           添加一个方法
            isgiong(page);
//            监听
            pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
                @Override
                public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                    list.clear();
                    isgiong(page);
                }

                @Override
                public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

                    page++;
                    isgiong(page);
                }
            });

        } else {
//             判断失败
            Toast.makeText(getActivity(), "检查网络", Toast.LENGTH_SHORT).show();
//          没网的状况下查询数据库
            Cursor person = dao.query("person", null, null, null, null, null, null);
            if (person.moveToFirst()) {
//                使用到do while
                do {
                    String title = person.getString(person.getColumnIndex("title"));
                    String author_name = person.getString(person.getColumnIndex("author_name"));
                    String thumbnail_pic_s = person.getString(person.getColumnIndex("thumbnail_pic_s"));
                    String thumbnail_pic_s02 = person.getString(person.getColumnIndex("thumbnail_pic_s02"));
                    list.add(new Bean.ResultBean.DataBean(title,author_name,thumbnail_pic_s,thumbnail_pic_s02));

                } while (person.moveToNext());
                pullMyAdapter.notifyDataSetChanged();
            }
        }
    }

    private void isgiong(int page) {
        String ss = url;
        NetUlit.MyAnck(ss, new NetUlit.MyCallBack() {
            @Override
            public void GetDate(String s) {
                Gson gson = new Gson();
                Bean bean = gson.fromJson(s, Bean.class);
                List<Bean.ResultBean.DataBean> data = bean.getResult().getData();
//                添加数据
                for (int i = 0; i < data.size(); i++) {
                    ContentValues values = new ContentValues();
                    values.put("author_name", data.get(i).getAuthor_name());
                    values.put("thumbnail_pic_s02", data.get(i).getThumbnail_pic_s02());
                    values.put("thumbnail_pic_s", data.get(i).getThumbnail_pic_s());
                    values.put("title", data.get(i).getTitle());
                    dao.insert("person", null, values);
                }
                list.addAll(data);
                pullMyAdapter.notifyDataSetChanged();
                pull.onRefreshComplete();
            }
        });
    }

}
