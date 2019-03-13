package com.bwie.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwie.houlele2019_03_08.R;

import java.util.List;

public class PinMyAdapter extends BaseAdapter {
    private List<String>  list;
    Context context;

    public PinMyAdapter(List<String> list) {
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
        MyAdapter myAdapter;
        if(convertView == null){
            convertView = View.inflate(context, R.layout.text_4,null);
             myAdapter = new MyAdapter();

        }
        return convertView;
    }
    class  MyAdapter{
        TextView textView;
        TextView textView1;
    }
}
