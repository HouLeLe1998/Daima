package com.example.adaapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.example.yurkao_02.R;
import com.qy.xlistview.XListView;

import java.util.List;

public class PAdapter  extends BaseAdapter {
    List<String> list;
    Context context;

    public PAdapter(List<String> list, Context context) {
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
        MyHolder myHolder;
        if(convertView == null){
            convertView = View.inflate(context,R.layout.text2,null);
             myHolder = new MyHolder();
             myHolder.textView = convertView.findViewById(R.id.text5);
             convertView.setTag(myHolder);
        }else{
            myHolder  = (MyHolder)convertView.getTag();
        }
        myHolder.textView.setText(list.get(position));
        return convertView;
    }
     class  MyHolder{
        TextView textView;

     }
}
