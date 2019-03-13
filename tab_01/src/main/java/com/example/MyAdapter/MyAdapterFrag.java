package com.example.MyAdapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MyAdapterFrag extends FragmentPagerAdapter {
    List<Fragment> list;
    String[] tlite;

    public MyAdapterFrag(FragmentManager fm, List<Fragment> list, String[] tlite) {
        super(fm);
        this.list = list;
        this.tlite = tlite;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tlite[position];
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
