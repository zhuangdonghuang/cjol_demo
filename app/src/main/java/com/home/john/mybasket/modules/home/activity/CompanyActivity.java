package com.home.john.mybasket.modules.home.activity;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.home.john.mybasket.R;
import com.home.john.mybasket.modules.home.adapter.FragAdapter;
import com.home.john.mybasket.modules.home.fragment.subFragment.BlankFragment_1;
import com.home.john.mybasket.modules.home.fragment.subFragment.CompanyFragmentTab_1;
import com.home.john.mybasket.modules.home.fragment.subFragment.CompanyFragmentTab_2;

import java.util.ArrayList;
import java.util.List;


public class CompanyActivity extends FragmentActivity {

    private FragAdapter vpAdapter;
    private ViewPager viewpager;
    private List<Fragment> list;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);

        viewpager = (ViewPager) findViewById(R.id.company_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.company_tl_tab);

        initEvents();
        initData();
    }

    private void initData() {
        list = new ArrayList<Fragment>();
        list.add(new BlankFragment_1());
        list.add(new CompanyFragmentTab_2());
        list.add(new CompanyFragmentTab_1());

        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab().setText("招聘职位"));
        tabLayout.addTab(tabLayout.newTab().setText("公司信息"));
        tabLayout.addTab(tabLayout.newTab().setText("公司照片"));

        vpAdapter = new FragAdapter(getSupportFragmentManager(),list);
        viewpager.setAdapter(vpAdapter);
        viewpager.setCurrentItem(0);
    }

    private void initEvents() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                TabLayout.Tab tab = tabLayout.getTabAt(position);
                tab.select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
