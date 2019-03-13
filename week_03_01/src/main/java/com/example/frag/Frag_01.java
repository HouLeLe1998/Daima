package com.example.frag;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.base.BaseFranment;
import com.example.week_03_01.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class Frag_01 extends BaseFranment {

    private Banner banner;
    private List<String> image = new ArrayList<String>();

    @Override
    protected int initLayout() {

        return R.layout.frag_0;
    }

    @Override
    protected void initView() {

        banner = find(R.id.banner);
    }

    @Override
    protected void initDate() {
        image.add("http://ww1.sinaimg.cn/large/0065oQSqly1fsvb1xduvaj30u013175p.jpg");
        image.add("http://ww1.sinaimg.cn/large/0065oQSqly1fsp4iok6o4j30j60optbl.jpg");
        image.add("http://ww1.sinaimg.cn/large/0065oQSqly1fsoe3k2gkkj30g50niwla.jpg");
        image.add("http://ww1.sinaimg.cn/large/0065oQSqly1fsmis4zbe7j30sg16fq9o.jpg");
        Banner autoPlay = banner.isAutoPlay(true);
        autoPlay.setImages(image).setDelayTime(2000).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        }).start();
    }
}
