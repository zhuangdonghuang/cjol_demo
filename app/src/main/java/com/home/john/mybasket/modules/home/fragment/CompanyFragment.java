package com.home.john.mybasket.modules.home.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.home.john.mybasket.R;
import com.home.john.mybasket.modules.common.BaseFragment;
import com.home.john.mybasket.modules.home.adapter.HomeAdapter;
import com.home.john.mybasket.modules.home.fragment.subFragment.BlankFragment_1;
import com.home.john.mybasket.modules.home.fragment.subFragment.BlankFragment_2;
import com.home.john.mybasket.modules.home.fragment.subFragment.BlankFragment_3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DONGHUANG on 2018/1/5.
 */

public class CompanyFragment extends BaseFragment {
    private TabLayout tabLayout;
    private HomeAdapter adapter;
    private ViewPager vp;




    @Override
    protected int getLayout() {
        return R.layout.fragment_company;
    }

    @Override
    protected void initViews() {
        vp = (ViewPager) root.findViewById(R.id.conmpany_tl_tab);
        tabLayout = (TabLayout) root.findViewById(R.id.conmpany_tl_tab);
    }

    @Override
    protected void initEvents() {
//        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                vp.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//            }
//        });
//
//
//        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//            }
//        });

    }

    @Override
    protected void initData() {
//        tabLayout.setTabMode(TabLayout.MODE_FIXED);
//        tabLayout.addTab(tabLayout.newTab().setText("招聘职位"));
//        tabLayout.addTab(tabLayout.newTab().setText("公司信息"));
//        tabLayout.addTab(tabLayout.newTab().setText("公司图片"));

        //添加三个Fragment
//        List<Fragment> list = new ArrayList<>();
//        list.add(new BlankFragment_1());
//        list.add(new BlankFragment_2());
//        list.add(new BlankFragment_3());
//
//        adapter = new HomeAdapter(getChildFragmentManager(), list);
//        //设置adapter
//        vp.setAdapter(adapter);
    }
}
