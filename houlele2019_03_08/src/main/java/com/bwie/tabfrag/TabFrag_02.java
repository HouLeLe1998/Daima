package com.bwie.tabfrag;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bwie.beas.BeasFragment;
import com.bwie.houlele2019_03_08.R;

/**
 * 接口
 * 展示图片
 */
public class TabFrag_02 extends BeasFragment {

    private ImageView imageView;
//    接口
    private String image = "http://img.365jia.cn/uploads/special/tuku/201806/5b247f05646c345194.jpg";

    @Override
    protected int initLayout() {
        return R.layout.tabfrag_02;
    }

    @Override
    protected void initView() {
        imageView = find(R.id.ima);
    }

    @Override
    protected void initDate() {
//        获取图片
        Glide.with(getActivity()).load(image).into(imageView);
    }
}
