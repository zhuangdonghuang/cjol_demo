package com.home.john.mybasket.modules.home.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
/**
 * Created by DONGHUANG on 2018/1/5.
 */

public class FragAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;
    private int currentItem;

    public FragAdapter(FragmentManager fm) {
        super(fm);
    }

    public FragAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int postion) {
        return list.get(postion);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    public void setCurrentItem(int currentItem) {
        this.currentItem = currentItem;
    }
}