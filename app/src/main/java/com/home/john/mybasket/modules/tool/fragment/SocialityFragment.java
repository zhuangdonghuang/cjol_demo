package com.home.john.mybasket.modules.tool.fragment;


import android.support.v4.widget.SwipeRefreshLayout;

import com.home.john.mybasket.R;
import com.home.john.mybasket.modules.common.BaseFragment;
import com.home.john.mybasket.modules.tool.adapter.SocialityListAdapter;
import com.home.john.mybasket.modules.tool.bean.sociality_bean;
import com.home.john.mybasket.modules.tool.utils.SocialityHttpUtil;
import com.home.john.mybasket.util.AssistantTask;
import com.home.john.mybasket.util.Constants;
import com.home.john.mybasket.util.LoadMoreListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 2016/6/2.
 */
public class SocialityFragment extends BaseFragment {
    private LoadMoreListView listView;
    private SocialityListAdapter adapter;
    private SwipeRefreshLayout refreshLayout;
    private List<sociality_bean> list;
    private int page = 1;
    @Override
    protected int getLayout() {
        return R.layout.fragment_sociality;
    }

    @Override
    protected void initViews() {
        listView = (LoadMoreListView) root.findViewById(R.id.sociality_lv);
        refreshLayout = (SwipeRefreshLayout) root;
    }

    @Override
    protected void initEvents() {
        //下拉刷新
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 1;
                // 下拉刷新先清空数据
                list.clear();
                // 再请求网络
                requestList();
            }
        });

        //加载更多
        listView.setLoadMoreListener(new LoadMoreListView.ILoadMoreListener() {
            @Override
            public void onLoadMore() {
                page++;
                requestList();
            }
        });
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        adapter = new SocialityListAdapter(getActivity(),list);
        listView.setAdapter(adapter);
        requestList();
    }


    //请求列表
    private void requestList() {
        SocialityHttpUtil.requestExchangeListt(page, new AssistantTask.IRequestCallback() {
            @Override
            public void onSuccess(Object obj) {
                try {
                    JSONObject root = new JSONObject(obj.toString());
                    String state = root.getString(Constants.RESPONSE_RESULT_STATE);
                    if (Constants.RESPONSE_RESULT_STATE_SUCCESS.equals(state)) {
                        JSONArray info = root.getJSONArray(Constants.RESPONSE_RESULT_INFO);
                        List<sociality_bean> tempList = sociality_bean.arrayExchangeListFromData(info.toString());
                        list.addAll(tempList);
                        adapter.notifyDataSetChanged();
                        // 隐藏正在刷新的效果
                        refreshLayout.setRefreshing(false);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String msg) {
                refreshLayout.setRefreshing(false);
            }
        });
    }

}
