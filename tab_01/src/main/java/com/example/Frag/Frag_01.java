package com.example.Frag;

import android.graphics.YuvImage;
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
import com.example.NetUlir.NetUlit;
import com.example.tab_01.R;
import com.google.gson.Gson;
import com.qy.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;

public class Frag_01 extends Fragment {
    private List<Bean.DataBean> list = new ArrayList<Bean.DataBean>();
    private String URLDate = "http://api.expoon.com/AppNews/getNewsList/type/1/p/";
    private int page =1;
    private XListView xListView;
    private MyAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_01, container, false);
        xListView = view.findViewById(R.id.xlistview);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        开启禁止上拉或加载
        xListView.setPullLoadEnable(true);
        xListView.setPullRefreshEnable(true);

        myAdapter = new MyAdapter(list, getActivity());
        xListView.setAdapter(myAdapter);
//        加载数据库
        initdate(page);
//        添加监听
        xListView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
//                  清空数据
                list.clear();
//                数据展示
                initdate(page);
            }

            @Override
            public void onLoadMore() {
                    page++;
                    initdate(page);
            }
        });
    }
 private  void jsonxi(String s){
        Gson gson = new Gson();
     Bean bean = gson.fromJson(s, Bean.class);
     List<Bean.DataBean> data = bean.getData();
//     添加数据
     list.addAll(data);
     //刷新适配器
     myAdapter.notifyDataSetInvalidated();
 }
     class Anck extends AsyncTask<String,Integer,String>{
         @Override
         protected void onPostExecute(String s) {
             super.onPostExecute(s);
////             解析数据库
             jsonxi(s);
//             关闭
            stopLoad();
         }

         @Override
         protected String doInBackground(String... strings) {

             return NetUlit.getContent(strings[0]);
         }
     }
//     判断网络，请求网络
     private void  initdate(int p){
        String murl = URLDate+p;
        if(NetUlit.isgetcontent(getActivity())) {
            Anck anck = new Anck();
            anck.execute(murl);
        }
        else{
            Toast.makeText(getActivity(),"请检查网络",Toast.LENGTH_SHORT).show();
        }
       }

//时间
 public  void  stopLoad(){
        xListView.setRefreshTime("刚刚");
        xListView.stopLoadMore();
        xListView.stopRefresh();
 }
}
