package com.example.MyAdapter;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.Bean.Bean;
import com.example.day_15.R;

import java.util.List;

public class MAdapter extends BaseAdapter {
    Context context;
    List<Bean.ResultBean.DataBean> list;

    public MAdapter(Context context, List<Bean.ResultBean.DataBean> list) {
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
        MHolder mHolder;
        if(convertView == null){
           convertView = View.inflate(context,R.layout.text1,null);
             mHolder = new MHolder();
             mHolder.textView = convertView.findViewById(R.id.name);
             mHolder.imageView  = convertView.findViewById(R.id.image);
             convertView.setTag(mHolder);
        }else{
           mHolder =(MHolder)convertView.getTag();
        }
        mHolder.textView.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getThumbnail_pic_s02()).into(mHolder.imageView);
        return convertView;
    }
    class  MHolder{
        TextView textView;
        ImageView imageView;
    }
}
