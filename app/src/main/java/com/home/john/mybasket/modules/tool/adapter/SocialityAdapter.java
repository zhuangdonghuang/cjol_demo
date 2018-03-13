package com.home.john.mybasket.modules.tool.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by John on 2016/3/18.
 */
public class SocialityAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    public SocialityAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }
    public SocialityAdapter(FragmentManager fm) {
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
