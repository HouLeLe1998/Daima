package com.example.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.example.bean.Bean;

import com.example.week.R;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    Context context;
    List<Bean.DataBean> list;

    public MyAdapter(Context context, List<Bean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHoder myHoder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.text1, null);
            myHoder = new MyHoder();
            myHoder.textView = convertView.findViewById(R.id.text1);
            myHoder.imageView = convertView.findViewById(R.id.image1);
            convertView.setTag(myHoder);
        } else {
            myHoder = (MyHoder) convertView.getTag();
        }

        myHoder.textView.setText(list.get(position).getNews_title());
        Glide.with(context).load(list.get(position).getPic_url()).into(myHoder.imageView);
        return convertView;
    }

    class MyHoder {
        ImageView imageView;
        TextView textView;
    }
}
