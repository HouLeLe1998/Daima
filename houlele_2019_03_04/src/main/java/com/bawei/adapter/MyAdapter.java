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
import com.bumptech.glide.request.RequestOptions;

import java.lang.invoke.CallSite;
import java.util.List;
/**
 * @侯乐乐
 * 上下文
 * 判断是否为空、
 *
 */
public class MyAdapter extends BaseAdapter {
//    上下文
    Context context;
    List<GridBean.ResultsBean> list;

    public MyAdapter(Context context, List<GridBean.ResultsBean> list) {
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
        if (convertView == null) {
//            获取布局
            convertView = View.inflate(context, R.layout.text1, null);
//            调用方法
            myHolder = new MyHolder();
            myHolder.textView = convertView.findViewById(R.id.text1);
            myHolder.imageView = convertView.findViewById(R.id.action_image);
            convertView.setTag(myHolder);
        }else{
            myHolder = (MyHolder)convertView.getTag();
        }
        myHolder.textView.setText(list.get(position).getDesc());
        RequestOptions options = new RequestOptions();
        Glide.with(context).load(list.get(position).getUrl()).apply(options).into(myHolder.imageView);
        return convertView;
    }

    class MyHolder {
        TextView textView;
        ImageView imageView;
    }
}
