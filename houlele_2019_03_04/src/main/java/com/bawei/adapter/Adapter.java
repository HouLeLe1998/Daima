package com.bawei.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.bean.GridBean;
import com.bawei.weektest.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @侯乐乐
 * 上下文
 * 判断是否为空、
 *
 */
public class Adapter extends BaseAdapter {
//    上下文
    Context context;
    List<GridBean.ResultsBean> list;

    public Adapter(Context context, List<GridBean.ResultsBean> list) {
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
        MyHolder myHolder;
//        判断是否为空
        if (convertView == null){
//            布局
            convertView = View.inflate(context,R.layout.layout_text,null);
             myHolder = new MyHolder();
//             控件
            myHolder.textView = convertView.findViewById(R.id.text2);
            myHolder.textView2 = convertView.findViewById(R.id.text3);
            myHolder.imageView = convertView.findViewById(R.id.imageview);
            convertView.setTag(myHolder);

        }else{
             myHolder = (MyHolder)convertView.getTag();
        }
        myHolder.textView.setText(list.get(position).get_id());
        myHolder.textView2.setText(list.get(position).getDesc());
        Glide.with(context).load(list.get(position).getUrl()).into(myHolder.imageView);
        return convertView;
    }

    class MyHolder {
        TextView textView;
        TextView textView2;
        ImageView imageView;
    }
}
