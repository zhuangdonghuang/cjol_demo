package com.home.john.mybasket.modules.my.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.home.john.mybasket.R;
import com.home.john.mybasket.modules.common.BaseFragment;
import com.home.john.mybasket.util.MapActivity;
import com.home.john.mybasket.util.WebViewActivity;
import com.home.john.mybasket.util.ZxingActivity;

/**
 * Created by John on 2016/6/2.
 */
public class MyFragment extends BaseFragment {
    private TextView Zx;
    private TextView Map;
    private TextView Web;
    @Override
    protected int getLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initViews() {
        Zx = (TextView) root.findViewById(R.id.my_zxing);
        Map = (TextView) root.findViewById(R.id.my_map);
        Web = (TextView) root.findViewById(R.id.my_webView);
    }

    @Override
    protected void initEvents() {

        Zx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ZxingActivity.class);
                startActivity(intent);
            }
        });

        Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapActivity.class);
                startActivity(intent);
            }
        });

        Web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
    }
}
