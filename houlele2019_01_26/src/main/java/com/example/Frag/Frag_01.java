package com.example.Frag;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.Bean.Bean;
import com.example.Bean.Beanc;
import com.example.Myadapter.MyAdapter;
import com.example.NetUlit.NetUlit;
import com.example.houlele2019_01_26.R;
import com.google.gson.Gson;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Frag_01 extends Fragment {

    private ListView listView;
    private String URl = "http://api.expoon.com/AppNews/getNewsList/type/1/p/1";

    private List<Bean.DataBean> list = new ArrayList<Bean.DataBean>();
    private MyAdapter myAdapter;
    private ImageView imag_layout;

    /**
 * @侯乐乐
 * 获取控件
 * 接收网络
 * 接受数据
 * 接受图片
 * 解析
 * listview展示
 */

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_01, container, false);
        listView = view.findViewById(R.id.listview);

        return view;
    }
//判断网络
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NetUlit ulit = new NetUlit();
        boolean isgetcontent = ulit.isgetcontent(getActivity());
        if (isgetcontent) {
            myAdapter = new MyAdapter(getActivity(), list);
            listView.setAdapter(myAdapter);
            Anck anck = new Anck();
            anck.execute(URl);
//            网络出问题提示吐司
        } else {
            Toast.makeText(getActivity(), "检查网络", Toast.LENGTH_SHORT).show();
        }
    }
//创建json解析
    public class Anck extends AsyncTask<String, Void, String> {
        @Override
        protected void onPostExecute(String s) {

            Gson gson = new Gson();
            Bean bean = gson.fromJson(s, Bean.class);
            List<Bean.DataBean> data = bean.getData();
            list.addAll(data);
            myAdapter.notifyDataSetChanged();
            super.onPostExecute(s);
        }
//获取数据
        @Override
        protected String doInBackground(String... strings) {
            String getcontent = NetUlit.getcontent(strings[0]);
            return getcontent;
        }
    }
}
