package com.example.MyAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.MyBean.Bean;
import com.example.tab_01.R;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<Bean.DataBean> list;
    private Context context;

    public MyAdapter(List<Bean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
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
    public int getItemViewType(int position) {
        return position%2;

    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        switch (getItemViewType(position)){
            case 0:
                MyHolder myHolder;
                if(convertView == null){
                    convertView  = View.inflate(context,R.layout.text_01,null);
                     myHolder = new MyHolder();
                     myHolder.textView = convertView.findViewById(R.id.text);
                     myHolder.imageView = convertView.findViewById(R.id.image);
                     convertView.setTag(myHolder);
                }else{
                    myHolder =(MyHolder)convertView.getTag();
                }
                myHolder.textView.setText(list.get(position).getNews_title());
                Glide.with(convertView).load(list.get(position).getPic_url()).into(myHolder.imageView);

                break;
            case 1:
                MyHolder2 myHolder2;
                if(convertView == null){
                    convertView = View.inflate(context,R.layout.text_02,null);
                     myHolder2 = new MyHolder2();
                    myHolder2.textView2 = convertView.findViewById(R.id.text1);
                    myHolder2.imageView2 = convertView.findViewById(R.id.image1);
                    convertView.setTag(myHolder2);
                }else{
                    myHolder2 =(MyHolder2) convertView.getTag();
                }
                myHolder2.textView2.setText(list.get(position).getNews_summary());
                Glide.with(convertView).load(list.get(position).getPic_url()).into(myHolder2.imageView2);
                break;
        }
        return convertView;
    }
    class  MyHolder{
        TextView textView;
        ImageView imageView;
    }
    class  MyHolder2{
        TextView textView2;
        ImageView imageView2;
    }
}
