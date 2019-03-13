package com.example.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bean.Bean;
import com.example.yuekao.R;

import org.w3c.dom.Text;

import java.util.List;

public class XMyAdapter extends BaseAdapter {
    Context context;
    List<Bean.ResultBean.DataBean> list;

    public XMyAdapter(Context context, List<Bean.ResultBean.DataBean> list) {
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
        Myholder myholder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.text_01, null);
            myholder = new Myholder();
            myholder.textView = convertView.findViewById(R.id.text1);
            convertView.setTag(myholder);
        } else {
            myholder = (Myholder) convertView.getTag();
        }
        myholder.textView.setText(list.get(position).getTitle());
        return convertView;
    }

    class Myholder {
        TextView textView;
    }
}
