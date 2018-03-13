package com.home.john.mybasket.modules.home.fragment.subFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.home.john.mybasket.R;
import com.home.john.mybasket.modules.common.BaseFragment;

import org.w3c.dom.Text;


public class CompanyFragmentTab_2 extends BaseFragment {
    private TextView tvDescHidden;
    private TextView tvDescShow;
    private TextView tvClick;
    @Override
    protected int getLayout() {
        return R.layout.fragment_company_fragment_tab_2;
    }

    @Override
    protected void initViews() {
        tvDescHidden = (TextView) root.findViewById(R.id.main_tv_hidden);
        tvDescShow = (TextView) root.findViewById(R.id.main_tv_show);
        tvClick = (TextView) root.findViewById(R.id.main_tv_click);
    }

    @Override
    protected void initEvents() {
        tvClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvDescHidden.getVisibility()==View.VISIBLE){
                    tvDescHidden.setVisibility(View.GONE);
                    tvDescShow.setVisibility(View.VISIBLE);
                    tvClick.setText("收起");
                }else{
                    tvDescHidden.setVisibility(View.VISIBLE);
                    tvDescShow.setVisibility(View.GONE);
                    tvClick.setText("展开");
                }
            }
        });

    }

    @Override
    protected void initData() {

    }
}
