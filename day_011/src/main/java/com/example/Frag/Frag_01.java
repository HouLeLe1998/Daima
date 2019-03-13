package com.example.Frag;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.MyAdapter.MyAdapter;
import com.example.MyBean.Bean;
import com.example.NetUlit.NetUlit;
import com.example.Sql.Dao;
import com.example.day_011.R;
import com.google.gson.Gson;
import com.qy.xlistview.XListView;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Frag_01 extends Fragment {

    private XListView xListView;
    private List<Bean.DataBean> list = new ArrayList<Bean.DataBean>();
    private int p = 1;
    private String Url = "http://api.expoon.com/AppNews/getNewsList/type/1/p/";
    private MyAdapter myAdapter;
    private Dao dao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_01, container, false);
        xListView = view.findViewById(R.id.xlistview);
        dao = new Dao(getActivity());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        xListView.setPullLoadEnable(true);
        xListView.setPullRefreshEnable(true);
//        判断网络
        NetUlit ulit = new NetUlit();
        myAdapter = new MyAdapter(getActivity(), list);
        boolean isgetConten = ulit.isgetConten(getActivity());
        if (isgetConten) {

            xListView.setAdapter(myAdapter);


//
            xListView.setXListViewListener(new XListView.IXListViewListener() {
                @Override
                public void onRefresh() {
//                    刷新
                    list.clear();
//
                    goop(p);
                }

                @Override
                public void onLoadMore() {
                    p++;
                    goop(p);
                }
            });
        } else {
            Toast.makeText(getActivity(), "检查网络", Toast.LENGTH_SHORT).show();
            Cursor name = dao.query("name", null, null, null, null, null, null);
            if(name.moveToFirst()){
                do {
                    String news_title = name.getString(name.getColumnIndex("news_title"));
                    String pic_url = name.getString(name.getColumnIndex("pic_url"));
                    list.add(new Bean.DataBean(news_title,pic_url));

                }while (name.moveToNext());
                Log.e("123",list.get(0).toString());
//                刷新适配器
                myAdapter.notifyDataSetChanged();
                xListView.setAdapter(myAdapter);

            }

        }
    }

    public void goop(int pag) {
        String s = Url + pag;
        new Anck().execute(s);
    }

    public class Anck extends AsyncTask<String, Void, String> {
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Gson gson = new Gson();
            Bean bean = gson.fromJson(s, Bean.class);
            List<Bean.DataBean> data = bean.getData();
            for (int i = 0; i <data.size() ; i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("news_title",data.get(i).getNews_title());
                contentValues.put("pic_url",data.get(i).getPic_url());
               dao.insert("name", null, contentValues);

            }


            list.addAll(data);
//            刷新适配器
            myAdapter.notifyDataSetChanged();
            xListView.setRefreshTime("刚刚");
            xListView.stopRefresh();
            xListView.stopLoadMore();
        }

        @Override
        protected String doInBackground(String... strings) {
            String getcontenr = NetUlit.getcontenr(strings[0]);
            return getcontenr;
        }
    }

    ;
}
