package com.example.MyAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.MyBean.Bean;
import com.example.day_011.R;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    Context context;
    List<Bean.DataBean> list;

    public MyAdapter(Context context, List<Bean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 3;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
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

        MyHolder myHolder;
        MyHolder1 myHolder1;
        MyHolder2 myHolder2;
        switch (getItemViewType(position)) {
            case 0:
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.text1, null);
                    myHolder = new MyHolder();
                    myHolder.textView = convertView.findViewById(R.id.text);
                    myHolder.imageView = convertView.findViewById(R.id.image);
                    convertView.setTag(myHolder);
                } else {
                    myHolder = (MyHolder) convertView.getTag();
                }
                myHolder.textView.setText(list.get(position).getNews_title());
                Glide.with(context).load(list.get(position).getPic_url()).into(myHolder.imageView);
                break;
            case 1:
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.text2, null);
                     myHolder1 = new MyHolder1();
                    myHolder1.imageView1 = convertView.findViewById(R.id.image1);
                    myHolder1.imageView2 = convertView.findViewById(R.id.image2);
                    convertView.setTag(myHolder1);
                }else{
                    myHolder1 = (MyHolder1) convertView.getTag();
                }
                Glide.with(context).load(list.get(position).getPic_url()).into(myHolder1.imageView1);
                Glide.with(context).load(list.get(position).getPic_url()).into(myHolder1.imageView2);
                break;
            case 2:
                if (convertView == null){
                    convertView = View.inflate(context, R.layout.text3, null);
                     myHolder2 = new MyHolder2();
                    myHolder2.textView1 = convertView.findViewById(R.id.text1);
                    myHolder2.textView2 = convertView.findViewById(R.id.text2);
                    convertView.setTag(myHolder2);
                }else{
                    myHolder2 = (MyHolder2) convertView.getTag();
                }
                myHolder2.textView2.setText(list.get(position).getNews_title());
                myHolder2.textView2.setText(list.get(position).getNews_title());
                break;
        }
        return convertView;
    }

    class MyHolder {
        TextView textView;
        ImageView imageView;
    }

    class MyHolder1 {
        ImageView imageView1;
        ImageView imageView2;
    }

    class MyHolder2 {
        TextView textView1;
        TextView textView2;
    }

}
