package com.example.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bean.Bean;
import com.example.yuekao.R;

import java.util.List;

public class PullMyAdapter extends BaseAdapter {
    Context context;
    List<Bean.ResultBean.DataBean> list;

    public PullMyAdapter(Context context, List<Bean.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }
    //    实现多条目添加两个方法
//    ++++++++++++++++++++++++++++++++++++++=

    @Override
    public int getItemViewType(int position) {
        return position%2;

    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
//+++++++++++++++++++++++++++++++++++++
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
//        取模 添加到switch
        MyHolder myHolder;
        MyHolder1 myHolder1;
        switch (getItemViewType(position)){
//            第一个条目
            case 0:
                if(convertView == null){
                    convertView = View.inflate(context, R.layout.text2,null);
                     myHolder = new MyHolder();
                     myHolder.imageView1 = convertView.findViewById(R.id.image2);
                     myHolder.textView1 = convertView.findViewById(R.id.text2);
                     convertView.setTag(myHolder);
                }else{
                    myHolder = (MyHolder)convertView.getTag();
                }
                myHolder.textView1.setText(list.get(position).getTitle());
                Glide.with(context).load(list.get(position).getThumbnail_pic_s()).into(myHolder.imageView1);
                break;
//                第二条目
            case 1:
                if(convertView == null){
                    convertView  = View.inflate(context,R.layout.text3,null);
                     myHolder1 = new MyHolder1();
                    myHolder1.imageView2 = convertView.findViewById(R.id.image3);
                    myHolder1.textView2 = convertView.findViewById(R.id.text3);
                    convertView.setTag(myHolder1);
                }else{
                    myHolder1 = (MyHolder1)convertView.getTag();
                }
                myHolder1.textView2.setText(list.get(position).getAuthor_name());
                Glide.with(context).load(list.get(position).getThumbnail_pic_s02()).into(myHolder1.imageView2);
                break;
        }
        return convertView;
    }
    class  MyHolder{
        TextView textView1;
        ImageView imageView1;
    }
    class MyHolder1{
        TextView textView2;
        ImageView imageView2;
    }
}
