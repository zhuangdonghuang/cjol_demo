package com.home.john.mybasket.modules.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioGroup;

import com.home.john.mybasket.R;
import com.home.john.mybasket.modules.message.fragment.BasketFragment;
import com.home.john.mybasket.modules.home.fragment.HomeFragment;
import com.home.john.mybasket.modules.my.fragment.MyFragment;
import com.home.john.mybasket.modules.tool.fragment.SocialityFragment;



public class HomeActivity extends FragmentActivity {

    private final int request_code_scan = 3;
    private RadioGroup radioGroup;
    //上次点击的button的id，默认是选中第一个
    private int lastId = R.id.main_home_radiobutton;
    //用来记录上一次选中的索引
    private int lastIndex;
    private View contentLl;
    private Fragment[] fragments;
    private Fragment homeFragment;
    private Fragment socialityFragment;
    private Fragment shareFragment;
    private int pageindex;
    private Fragment myFragment;
    private Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        contentLl = findViewById(R.id.home_content_ll);
        radioGroup = (RadioGroup) findViewById(R.id.main_rg);

        //设置滑动冲突
//        slidingPaneLayout.setIntercept(new SlidingPanelayout.IIntercept() {
//            @Override
//            public int getPagerIndex() {
//                return pageindex;
//            }
//        });

        // radioGroup 底部导航栏点击事件
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                lastId = checkedId;
                int currIndex = 0;
                switch (checkedId) {
                    case R.id.main_home_radiobutton:
                        currIndex = 0;
                        break;

                    case R.id.main_sociality_radiobutton:
                        currIndex = 1;
                        break;

                    case R.id.main_share_radiobutton:
                        currIndex = 2;
                        break;

                    case R.id.main_mine_radiobutton:
                        currIndex = 3;
                        break;
                    default:
                        currIndex = 0;
                }
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                transaction.hide(fragments[lastIndex]);
                transaction.show(fragments[currIndex]);
                transaction.commit();
                lastIndex = currIndex;
            }
        });
        homeFragment = new HomeFragment();
        socialityFragment = new SocialityFragment();
        shareFragment = new BasketFragment();
        myFragment = new MyFragment();

        // Fragment集合
        fragments = new Fragment[]{
                homeFragment,
                socialityFragment,
                shareFragment,
                myFragment
        };
        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        for (int i =0;i<fragments.length;i++){
            Fragment fragment = fragments[i];
            transaction.add(R.id.home_content_fl, fragment);
            transaction.hide(fragment);
        }
        transaction.show(fragments[0]);
        transaction.commit();
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);

    }

//记录当前界面的page，以便返回时候依旧返回当前
//    public void setPageindex(int pageindex) {
//        this.pageindex = pageindex;
//    }
}
