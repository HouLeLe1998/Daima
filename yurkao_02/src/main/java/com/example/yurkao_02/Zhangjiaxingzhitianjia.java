package com.example.yurkao_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adaapter.PAdapter;
import com.example.base.BeasActivity;

import java.util.ArrayList;
import java.util.List;

public class Zhangjiaxingzhitianjia extends BeasActivity {
    private ArrayList<String> listb = new ArrayList<>();
    private ArrayList<String> list;
    private ImageView imageView;
    private GridView gridView1;
    private GridView gridView2;
    private TextView tianjia;
    private ImageView fanhui;
    private PAdapter pAdapter;
    private PAdapter pAdapter1;

    @Override
    protected void initListenter() {
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tianjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putStringArrayListExtra("listb",listb);
                setResult(200,intent);
                finish();
            }
        });
        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                list.add(listb.get(position));
                list.remove(position);
                pAdapter.notifyDataSetChanged();
                pAdapter1.notifyDataSetChanged();
            }
        });
        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                list.add(listb.get(position));
                listb.remove(position);
                pAdapter.notifyDataSetChanged();
                pAdapter1.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        imageView = find(R.id.image5);
        gridView1 = find(R.id.gridview1);
        gridView2 = find(R.id.gridview2);
        tianjia = find(R.id.tianjia);
        fanhui = find(R.id.fanhui);
    }

    @Override
    protected void initDate() {
        ArrayList<String> lista = getIntent().getStringArrayListExtra("lista");
        listb.addAll(lista);
        listb.add("dscsd");
        listb.add("sdvs");
        listb.add("dscv");
        listb.add("sdavcs");
        listb.add("cavcaa");
        listb.add("vcava");
        pAdapter = new PAdapter(listb, Zhangjiaxingzhitianjia.this);
        pAdapter1 = new PAdapter(list, Zhangjiaxingzhitianjia.this);
        gridView1.setAdapter(pAdapter);
        gridView2.setAdapter(pAdapter1);



    }

    @Override
    protected int intitLayout() {
        return R.layout.activity_zhangjiaxingzhitianjia;
    }

    @Override
    public void onClick(View v) {

    }
}
