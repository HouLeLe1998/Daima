package com.example.day_15;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.Bean.Bean;
import com.example.MyAdapter.MAdapter;
import com.example.Netlit.NetUlit;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Bean.ResultBean.DataBean> list =new ArrayList<Bean.ResultBean.DataBean>();
    private String url = "http://v.juhe.cn/toutiao/index?type=top&key=dbedecbcd1899c9785b95cc2d17131c5";
    private ListView listView;
    private MAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        InitMyAdapter();

    }

    private void InitMyAdapter() {
        NetUlit netUlit = new NetUlit();
        boolean isgetconten = netUlit.isgetconten(MainActivity.this);
        if(isgetconten){
        mAdapter = new MAdapter(MainActivity.this, list);
        listView.setAdapter(mAdapter);
        Anck anck = new Anck();
        anck.execute(url);

        }else {
            Toast.makeText(MainActivity.this,"检查网络",Toast.LENGTH_SHORT).show();
        }

    }

    public class  Anck extends AsyncTask<String,Void,String>{
         @Override
         protected void onPostExecute(String s) {
             Gson gson = new Gson();
             Bean bean = gson.fromJson(s, Bean.class);
             List<Bean.ResultBean.DataBean> data = bean.getResult().getData();
             list.addAll(data);
             mAdapter.notifyDataSetChanged();
             super.onPostExecute(s);
         }

         @Override
         protected String doInBackground(String... strings) {
             String getcontent = NetUlit.getcontent(strings[0]);
             return getcontent;
         }
     }
}
