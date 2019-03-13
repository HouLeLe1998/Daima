package com.example.Frag;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.MyAdapter.MyAdapter;
import com.example.MyBean.Bean;
import com.example.NetUlit.Netulie;
import com.example.tab_02.R;
import com.google.gson.Gson;
import com.qy.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;

public class Frag_01 extends Fragment {
    private String Url = "http://api.expoon.com/AppNews/getNewsList/type/1/p/";
    private List<Bean.DataBean> list = new ArrayList<Bean.DataBean>();
    private XListView xListView;
    private  int p=1;
    private MyAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_01, container, false);
        xListView = view.findViewById(R.id.xlistview);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        开启禁止上拉或者加载
        xListView.setPullLoadEnable(true);
        xListView.setPullRefreshEnable(true);
//        判断网络
        Netulie ulie = new Netulie();
        boolean getcontent = ulie.isGetcontent(getActivity());
        if (getcontent) {
            myAdapter = new MyAdapter(list, getActivity());
            xListView.setAdapter(myAdapter);

            goon(p);
            //        xlistview 监听
            xListView.setXListViewListener(new XListView.IXListViewListener() {
                @Override
                public void onRefresh() {
//                    清空数据
                    list.clear();
//                  刷新
                    goon(p);
                }

                @Override
                public void onLoadMore() {
                    p++;
                    goon(p);
            }
            });
        } else {
            Toast.makeText(getActivity(), "检查网路", Toast.LENGTH_SHORT).show();
        }

    }
//运行\

    private void goon(int pag) {
        String s = Url + pag;
        new Anck().execute(s);
    }



    public class Anck extends AsyncTask<String, Void, String> {
        @Override
        protected void onPostExecute(String s) {

            Gson gson = new Gson();
            Bean bean = gson.fromJson(s, Bean.class);
            List<Bean.DataBean> data = bean.getData();
            list.addAll(data);

            myAdapter.notifyDataSetInvalidated();
//            显示头标
            xListView.setRefreshTime("刚刚");
            xListView.stopLoadMore();
            xListView.stopRefresh();
            super.onPostExecute(s);
        }

        @Override
        protected String doInBackground(String... strings) {
            String conten = Netulie.getConten(strings[0]);
            return conten;
        }
    }

}
