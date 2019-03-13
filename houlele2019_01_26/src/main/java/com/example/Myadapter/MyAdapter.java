package com.example.Myadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.Bean.Bean;
import com.example.houlele2019_01_26.R;

import java.util.List;

/**
 * @侯乐乐
 * 适配器
 * 获取两个get
 * shwith判断w
 * 优化适配器
 */
public class MyAdapter extends BaseAdapter {
    Context context;
    List<Bean.DataBean> list;

    public MyAdapter(Context context, List<Bean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 3;
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
        MyHolder1 myHolder1;
        MyHolder2 myHolder2;
        MyHolder3 myHolder3;
//        优化
        switch (getItemViewType(position)) {
            case 0:
//                判断
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.text1, null);
                    myHolder1 = new MyHolder1();
                    myHolder1.textView1 = convertView.findViewById(R.id.text1);
                    myHolder1.imageView1 = convertView.findViewById(R.id.image1);
                    convertView.setTag(myHolder1);
                } else {
                    myHolder1 = (MyHolder1) convertView.getTag();
                }
                myHolder1.textView1.setText(list.get(position).getNews_title());
                Glide.with(convertView).load(list.get(position).getPic_url()).into(myHolder1.imageView1);
                break;
            case 1:
                if(convertView == null){
                    convertView = View.inflate(context, R.layout.text2, null);
                     myHolder2 = new MyHolder2();
                    myHolder2.textView2 = convertView.findViewById(R.id.text2);
                    myHolder2.imageView2 = convertView.findViewById(R.id.image2);
                    convertView.setTag(myHolder2);
                }else{
                    myHolder2 = (MyHolder2) convertView.getTag();
                }
//                获取图片和数据
                myHolder2.textView2.setText(list.get(position).getNews_title());
                Glide.with(convertView).load(list.get(position).getPic_url()).into(myHolder2.imageView2);
                break;
//                从零开始代表三
            case 2:
                if(convertView == null){

                    convertView = View.inflate(context, R.layout.text3, null);
                     myHolder3 = new MyHolder3();
                    myHolder3.textView3 = convertView.findViewById(R.id.text3);
                    myHolder3.imageView3 = convertView.findViewById(R.id.image3);
                    convertView.setTag(myHolder3);
                }else{
                    myHolder3 = (MyHolder3) convertView.getTag();
                }
                myHolder3.textView3.setText(list.get(position).getNews_title());
                Glide.with(convertView).load(list.get(position).getPic_url()).into(myHolder3.imageView3);
                break;
        }
        return convertView;
    }
//创建类
    class MyHolder1 {
        TextView textView1;
        ImageView imageView1;

    }

    class MyHolder2 {
        TextView textView2;
        ImageView imageView2;

    }

    class MyHolder3 {
        TextView textView3;
        ImageView imageView3;

    }

}
