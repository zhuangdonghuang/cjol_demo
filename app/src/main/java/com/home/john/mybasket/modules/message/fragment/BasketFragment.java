package com.home.john.mybasket.modules.message.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.home.john.mybasket.R;
import com.home.john.mybasket.modules.message.activity.CustomerServiceActivity;
import com.home.john.mybasket.modules.common.BaseFragment;

/**
 * Created by John on 2016/6/2.
 */
public class BasketFragment extends BaseFragment {
    private TextView tv;
    @Override
    protected int getLayout() {
        return R.layout.fragment_basket;
    }

    @Override
    protected void initViews() {
        tv = (TextView) root.findViewById(R.id.tv_message);
    }

    @Override
    protected void initEvents() {
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CustomerServiceActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void initData() {
    }


}
