package com.example.Frag;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.Bean.Bean;
import com.example.Beas.BeasFramen;
import com.example.MyAdapter.GridAdapter;
import com.example.MyAdapter.MyAdapter;
import com.example.NetUlit.NetUli;
import com.example.dao.Dao;
import com.example.day_13_01.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class Frag_01 extends BeasFramen {
    private List<String> image = new ArrayList<String>();
    private String url = "http://api.expoon.com/AppNews/getNewsList/type/1/p/";
    private Banner banner;
   private List<Bean.DataBean> list = new ArrayList<Bean.DataBean>();
    private GridView gridView;
    private  int page = 1;
    private PullToRefreshListView pull;
    private GridAdapter gridAdapter;
    private MyAdapter myAdapter;
    private Dao dao;

    @Override
    protected int initLayout() {
        return R.layout.frag_01;

    }

    @Override
    protected void initView() {
        banner = find(R.id.banner);
        gridView = find(R.id.grid);
        pull = find(R.id.listview);
        dao = new Dao(getActivity());
        pull.setMode(PullToRefreshBase.Mode.BOTH);
        pull.setScrollingWhileRefreshingEnabled(true);
    }

    @Override
    protected void initDate() {

        image.add("http://ww1.sinaimg.cn/large/0065oQSqly1fsvb1xduvaj30u013175p.jpg");
        image.add("http://ww1.sinaimg.cn/large/0065oQSqly1fsq9iq8ttrj30k80q9wi4.jpg");
        image.add("http://ww1.sinaimg.cn/large/0065oQSqly1fsp4iok6o4j30j60optbl.jpg");
        image.add("http://ww1.sinaimg.cn/large/0065oQSqly1fsmis4zbe7j30sg16fq9o.jpg");
        myAdapter = new MyAdapter(getActivity(),list);
        gridAdapter = new GridAdapter(getActivity(), list);
        pull.setAdapter(myAdapter);
         gridView.setAdapter(gridAdapter);
        if (NetUli.isgetconten(getActivity())) {
            banner.isAutoPlay(true).setImages(image).setDelayTime(2000).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context).load(path).into(imageView);
                }
            }).start();
            isgoing(page);
            pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
                @Override
                public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                      isgoing(page);
                }

                @Override
                public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                          page++;
                          isgoing(page);
                }
            });
        } else {
            Toast.makeText(getActivity(), "请检查网络", Toast.LENGTH_SHORT).show();
            Cursor person = dao.query("person", null, null, null, null, null, null);
if(person.moveToFirst()){
    do {
        String news_title = person.getString(person.getColumnIndex("news_title"));
        String pic_url = person.getString(person.getColumnIndex("pic_url"));
        list.add(new Bean.DataBean(news_title,pic_url));
    }while (person.moveToNext());
}

        }
    }

    private void isgoing(int p) {
            String ss = url+p;
            NetUli.MyAsyncTaca(ss, new NetUli.MyCallBack() {
                @Override
                public void getDate(String s) {
                    ismaking(s);
                }
            });
    }

    private void ismaking(String sl) {
        Gson gson = new Gson();
        Bean bean = gson.fromJson(sl, Bean.class);
        List<Bean.DataBean> data = bean.getData();
        for (int i = 0; i <data.size() ; i++) {
            ContentValues values = new ContentValues();
            values.put("news_title",data.get(i).getNews_title());
            values.put("pic_url",data.get(i).getPic_url());
            dao.insert("person",null,values);

        }
      list.addAll(data);
      gridAdapter.notifyDataSetChanged();;
      myAdapter.notifyDataSetChanged();
      pull.onRefreshComplete();
    }
}
