package com.example.adaapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bean.Bean;
import com.example.yurkao_02.R;

import java.util.List;

public class MyXAdapter extends BaseAdapter {
    Context context;
    List<Bean> list;

    public MyXAdapter(Context context, List<Bean> list) {
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
            convertView = View.inflate(context, R.layout.text1, null);
            myHolder = new MyHolder();
            myHolder.imageView = convertView.findViewById(R.id.image1);
            myHolder.textView = convertView.findViewById(R.id.text1);
            convertView.setTag(myHolder);
        } else {
            myHolder = (MyHolder) convertView.getTag();
        }
        myHolder.textView.setText(list.get(position).getSummary());
        Glide.with(context).load(list.get(position).getImageUrl()).into(myHolder.imageView);
        return convertView;
    }

    class MyHolder {
        TextView textView;
        ImageView imageView;

    }
}
