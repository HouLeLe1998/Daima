package com.example.frag;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.adapter.MyAdapter;
import com.example.base.Base;
import com.example.bean.Bean;
import com.example.netulit.NetUlit;
import com.example.week.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class Frag_01 extends Base {

    private Banner banner;
    private PullToRefreshListView pull;
    private int  p = 1;
    private GridView gridView;
    private List<String> image = new ArrayList<String>();
    private String url = "http://api.expoon.com/AppNews/getNewsList/type/1/p/";
    private List<Bean.DataBean> list = new ArrayList<Bean.DataBean>();

    @Override
    protected int initLayout() {
        return R.layout.frag_01;
    }

    @Override
    protected void initView() {
        banner = find(R.id.banner);
        pull = find(R.id.pull);
        gridView = find(R.id.gridview);

    }

    @Override
    protected void initDate() {
//        获取图片
        image.add("http://ww1.sinaimg.cn/large/0065oQSqly1fsysqszneoj30hi0pvqb7.jpg");
        image.add("http://ww1.sinaimg.cn/large/0065oQSqly1fswhaqvnobj30sg14hka0.jpg");
        image.add("http://ww1.sinaimg.cn/large/0065oQSqly1fsvb1xduvaj30u013175p.jpg");
        image.add("http://ww1.sinaimg.cn/large/0065oQSqly1fsq9iq8ttrj30k80q9wi4.jpg");
        MyAdapter myAdapter = new MyAdapter(getActivity(),list);
        pull.setAdapter(myAdapter);
//        判断网络
        if (NetUlit.isgetcontent(getActivity())) {
            banner.isAutoPlay(true).setImages(image).setDelayTime(2000).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context).load(path).into(imageView);
                }
            }).start();
            islong();
            pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
                @Override
                public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

                }

                @Override
                public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

                }
            });
        }
    }

    private void islong() {


    }

}

