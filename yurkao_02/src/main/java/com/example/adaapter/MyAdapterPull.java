package com.example.adaapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wbean.Bean;
import com.example.wbean.Beang;
import com.example.yurkao_02.R;

import java.util.List;

public class MyAdapterPull  extends BaseAdapter {
    List<Beang.DataBean> list;
    Context context;

    public MyAdapterPull(List<Beang.DataBean> list, Context context) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        Myholde myholde;
        if(convertView == null){
            convertView = View.inflate(context, R.layout.text_pull,null);
             myholde = new Myholde();
             myholde.imageView = convertView.findViewById(R.id.imager_pill);
             myholde.textView  =convertView.findViewById(R.id.name_pull);
             convertView.setTag(myholde);
        }else{
            myholde = (Myholde) convertView.getTag();
        }
        myholde.textView .setText(list.get(position).getAuthor_name());
        Glide.with(context).load(list.get(position).getThumbnail_pic_s02()).into(myholde.imageView);
        return convertView;
    }
    class  Myholde {
        TextView textView;
        ImageView imageView;
    }
}
