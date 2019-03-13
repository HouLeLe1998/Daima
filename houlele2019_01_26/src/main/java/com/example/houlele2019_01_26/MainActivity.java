package com.example.houlele2019_01_26;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.bumptech.glide.Glide;
import com.example.Bean.Bean;
import com.example.Frag.Frag_01;
import com.example.Frag.Frag_02;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private RadioGroup group;
    private List<Fragment> lsit;
    private String image = "https://ws1.sinaimg.cn/large/0065oQSqly1g04lsmmadlj31221vowz7.jpg";
    private ImageView imageView;

    /**
 *获取控件
 * 实现滑动点击效果
 */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        获取控件
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image5);
        Glide.with(MainActivity.this).load(image).into(imageView);
        pager = findViewById(R.id.pager);
        group = findViewById(R.id.radio);
        lsit = new ArrayList<Fragment>();
//        h获取frag
        Frag_01 frag_01 = new Frag_01();
        Frag_02 frag_02 = new Frag_02();
        lsit.add(frag_01);
        lsit.add(frag_02);
//        适配器
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return lsit.get(i);
            }

            @Override
            public int getCount() {
                return lsit.size();
            }
        });
//        点击
    group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.button1:
                    pager.setCurrentItem(0);
                break;
                case R.id.button2:
                    pager.setCurrentItem(1);
                    break;
            }
        }
    });

    }

}
