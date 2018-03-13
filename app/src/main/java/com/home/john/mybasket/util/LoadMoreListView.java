package com.home.john.mybasket.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;


/**
 * 自定义控件的三种方式:
 * 1,继承源生控件，重写某些一方法，或者添加一些方法
 * 2,把多阁组合控件何在一起，形成一个控件
 * 3,继承view重写ondraw方法，画出来
 * Created by John on 2016/3/16.
 */
public class LoadMoreListView extends ListView{
    private float lastY;
    private ILoadMoreListener loadMoreListener;
    TextView footer;

    public LoadMoreListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        footer = new TextView(getContext());
        footer.setText("正在加载中");
        addFooterView(footer);


        setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                //如果拉不动的时候再作判断
                if (scrollState == SCROLL_STATE_IDLE) {
                    //获取该ListView总共的item数量
                    int count = view.getCount();
                    //获取最后一个可见的item索引
                    int lastVisiblePosition = view.getLastVisiblePosition();
                    //如果是已经显示到最后一个item
                    if (lastVisiblePosition == count - 1) {

                        //如果第一次随便滑动一个位置停下来的最后一个item的y坐标
                        //等于上一次的y坐标
                        //那么我们认定这个listview到底了
                        //然后我们触法下一页的操作
                        int childCount = view.getChildCount();

                        View item = view.getChildAt(childCount - 1);
                        float currY = item.getY();
                        if (currY == lastY) {
                            // 到底了，触发加载下一页的操作

                            if (loadMoreListener != null) {
                                loadMoreListener.onLoadMore();
                            }
                        }
//                        记录上一次坐标
                        lastY = currY;
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        });
    }
    public void hideFooter(TextView footer){
        hideFooter(this.footer);
    }


    //设置加载更多监听器
    public void setLoadMoreListener(ILoadMoreListener listener){
        this.loadMoreListener = listener;
    }



    //加载更多监听
    public interface ILoadMoreListener{
        //加载更多回调
        void onLoadMore();
    }
}
