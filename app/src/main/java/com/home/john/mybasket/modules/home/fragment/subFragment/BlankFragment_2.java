package com.home.john.mybasket.modules.home.fragment.subFragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import com.home.john.mybasket.R;
import com.home.john.mybasket.modules.common.BaseFragment;
import com.home.john.mybasket.modules.common.HomeActivity;
import com.home.john.mybasket.modules.home.activity.JobActivity;
import com.home.john.mybasket.modules.home.adapter.RecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class BlankFragment_2 extends BaseFragment {
    private static RecyclerView recyclerview;


    @Override
    protected int getLayout() {
        return R.layout.fragment_blank_fragment_2;

    }

    @Override
    protected void initViews() {
        recyclerview=(RecyclerView) root.findViewById(R.id.line_recycler);
    }

    @Override
    protected void initEvents() {
    }

    @Override
    protected void initData() {
        List<String> datas = new ArrayList<>();
        for (int i=0;i<100;i++){
            datas.add("产品经理"+i);
        }

        LinearLayoutManager manager = new LinearLayoutManager(this.getActivity());
        recyclerview.setLayoutManager(manager);

        //设置适配器
        RecycleViewAdapter adapter = new RecycleViewAdapter(this.getActivity(),datas);
        adapter.setClickListener(new RecycleViewAdapter.ItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(),JobActivity.class);
                startActivity(intent);
            }
        });
        recyclerview.setAdapter(adapter);
    }
}
