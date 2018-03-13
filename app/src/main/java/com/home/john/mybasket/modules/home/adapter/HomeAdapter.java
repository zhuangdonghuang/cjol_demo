package com.home.john.mybasket.modules.home.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by John on 2016/6/14.
 */
public class HomeAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    public HomeAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    public HomeAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return list==null ? null:list.get(position);
    }

    @Override
    public int getCount() {
        return list==null ? 0 :list.size();
    }
}