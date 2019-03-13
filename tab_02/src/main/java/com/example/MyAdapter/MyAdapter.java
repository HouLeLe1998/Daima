package com.example.MyAdapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.MyBean.Bean;
import com.example.tab_02.R;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    List<Bean.DataBean> list;
    Context context;

    public MyAdapter(List<Bean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {

        return position % 2;
    }

    @Override
    public int getViewTypeCount() {

        return 2;
    }

    @Override
    public int getCount() {

        return list.size();
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)) {
            case 0:
                MyHolder myHolder;
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.text_01, null);
                    myHolder = new MyHolder();
                    myHolder.textView = convertView.findViewById(R.id.textView);
                    myHolder.imageView = convertView.findViewById(R.id.imageView);
                    convertView.setTag(myHolder);
                } else {
                    myHolder = (MyHolder) convertView.getTag();
                }
                myHolder.textView.setText(list.get(position).getNews_title());
                Glide.with(context).load(list.get(position).getPic_url()).into(myHolder.imageView);
                break;
            case  1:
                MyHolder1 myHolder1;
                if (convertView == null) {
                    myHolder1 = new MyHolder1();
                    convertView = View.inflate(context, R.layout.text_02, null);
                    myHolder1.textView1 = convertView.findViewById(R.id.textView2);
                    convertView.setTag(myHolder1);
                } else {
                    myHolder1 = (MyHolder1) convertView.getTag();
                }
              myHolder1.textView1.setText(list.get(position).getNews_id());
                break;
        }
        return convertView;
    }

    class MyHolder {
        TextView textView;
        ImageView imageView;
    }

    class MyHolder1 {
        TextView textView1;
    }
}
