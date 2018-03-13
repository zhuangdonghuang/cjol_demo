package com.home.john.mybasket.modules.home.fragment;



import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.home.john.mybasket.R;
import com.home.john.mybasket.modules.common.BaseFragment;
import com.home.john.mybasket.modules.common.HomeActivity;
import com.home.john.mybasket.modules.home.adapter.HomeAdapter;
import com.home.john.mybasket.modules.home.fragment.subFragment.BlankFragment_1;
import com.home.john.mybasket.modules.home.fragment.subFragment.BlankFragment_2;
import com.home.john.mybasket.modules.home.fragment.subFragment.BlankFragment_3;
import com.home.john.mybasket.modules.home.utils.BannerLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 2016/6/2.
 */
public class HomeFragment extends BaseFragment {
    private TabLayout tabLayout;
    private HomeAdapter adapter;
    private ViewPager viewPager;
    private Button bt_infor;
    //图片轮播控件
    private BannerLayout bannerLayout;
    @Override
    protected int getLayout() {
        return R.layout.fragment_sub_fragment_1;
    }

    @Override
    protected void initViews() {
        bannerLayout = (BannerLayout) root.findViewById(R.id.banner);
        viewPager = (ViewPager) root.findViewById(R.id.home_vp_tab);
        tabLayout = (TabLayout) root.findViewById(R.id.home_tl_tab);
        bt_infor = (Button) root.findViewById(R.id.but_top);
    }

    @Override
    protected void initEvents() {
            tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                }
            });


            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                @Override
                public void onPageSelected(int position) {
                    HomeActivity homeActivity = (HomeActivity) getActivity();
                    TabLayout.Tab tab = tabLayout.getTabAt(position);
                    tab.select();
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                }
            });
        //点击求职意向跳转入口
        bt_infor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void initData() {
        ArrayList<Integer> l = new ArrayList<>();

        //给广告栏设置默认的图片
        l.add(R.mipmap.ic_launcher);
        l.add(R.mipmap.ic_launcher);
        l.add(R.mipmap.ic_launcher);
        bannerLayout.setViewRes(l);
        //设置Tab名称
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab().setText("推荐"));
        tabLayout.addTab(tabLayout.newTab().setText("最新"));
        tabLayout.addTab(tabLayout.newTab().setText("最近"));
        //添加三个Fragment
        List<Fragment> list = new ArrayList<>();
        list.add(new BlankFragment_1());
        list.add(new BlankFragment_2());
        list.add(new BlankFragment_3());

        adapter = new HomeAdapter(getChildFragmentManager(), list);
        //设置adapter
        viewPager.setAdapter(adapter);
    }
}
