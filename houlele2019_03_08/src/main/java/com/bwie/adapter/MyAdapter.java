package com.bwie.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.bean.Bean;
import com.bwie.houlele2019_03_08.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 *适配器
 * 侯乐乐
 * 获取 上下文
 * 添加方法
 *
 */
public class MyAdapter extends BaseAdapter {
    List<Bean.DataBeanX.DataBean> list;
    Context context;

    public MyAdapter(List<Bean.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    //添加两个方法
    @Override
    public int getItemViewType(int position) {
        return position % 3;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    //
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
//多条目
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)) {
            case 0:
                MyHolder1 myHolder1;
//                判断为空
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.text_01, null);
                    myHolder1 = new MyHolder1();
                    myHolder1.textView1 = convertView.findViewById(R.id.text1);
                    myHolder1.imageView1 = convertView.findViewById(R.id.image1);
                    myHolder1.imageView11 = convertView.findViewById(R.id.image11);
                    myHolder1.imageView111 = convertView.findViewById(R.id.image111);
                    convertView.setTag(myHolder1);
                } else {
//                    接收hander
                    myHolder1 = (MyHolder1) convertView.getTag();
                }
                myHolder1.textView1.setText(list.get(position).getTitle());
                Glide.with(context).load(list.get(position).getPics()).into(myHolder1.imageView1);
                Glide.with(context).load(list.get(position).getPics()).into(myHolder1.imageView11);
                Glide.with(context).load(list.get(position).getPics()).into(myHolder1.imageView111);
                break;
//                第二个
            case 1:
                MyHolder2 myHolder2;
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.text_02, null);
                    myHolder2 = new MyHolder2();
                    myHolder2.imageView2 = convertView.findViewById(R.id.image2);
                    myHolder2.imageView22 = convertView.findViewById(R.id.image22);
                    myHolder2.imageView222 = convertView.findViewById(R.id.image222);
                    myHolder2.textView2 = convertView.findViewById(R.id.text6);
                    convertView.setTag(myHolder2);
                } else {
                    myHolder2 = (MyHolder2) convertView.getTag();
                }
                myHolder2.textView2.setText(list.get(position).getTitle());
                Glide.with(context).load(list.get(position).getPics()).into(myHolder2.imageView2);
                Glide.with(context).load(list.get(position).getPics()).into(myHolder2.imageView22);
                Glide.with(context).load(list.get(position).getPics()).into(myHolder2.imageView222);
                break;

            case 2:
                MyHolder3 myHolder3;
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.text_03, null);
                    myHolder3 = new MyHolder3();
                    myHolder3.imageView3 = convertView.findViewById(R.id.image3);
                    myHolder3.textView3 = convertView.findViewById(R.id.text3);
                    convertView.setTag(myHolder3);
                } else {
                    myHolder3 = (MyHolder3) convertView.getTag();
                }
                myHolder3.textView3.setText(list.get(position).getTitle());
                Glide.with(context).load(list.get(position).getPics()).into(myHolder3.imageView3);
                break;
        }
        return convertView;
    }
//常见类
    class MyHolder1 {
        TextView textView1;
        ImageView imageView1;
        ImageView imageView11;
        ImageView imageView111;
    }

    class MyHolder2 {
        TextView textView2;
        ImageView imageView2;
        ImageView imageView22;
        ImageView imageView222;
    }

    class MyHolder3 {
        TextView textView3;
        ImageView imageView3;
    }
}
