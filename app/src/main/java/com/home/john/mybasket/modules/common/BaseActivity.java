package com.home.john.mybasket.modules.common;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.home.john.mybasket.R;

/**Activity的基类 */
public abstract class BaseActivity  extends FragmentActivity{
    protected LinearLayout contentView;
    private TextView tvTitile;
    private ImageView ivLeftImage,ivRightImage;
    private RelativeLayout title_rl;
    private  View.OnClickListener defaultListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        contentView = (LinearLayout) findViewById(R.id.base_content_ll);
        //加载一个Fragment布局？？？
        View childContent = getLayoutInflater().inflate(getLayout(),null,false);
        contentView.addView(childContent);
        title_rl = (RelativeLayout) findViewById(R.id.base_title);
        tvTitile = (TextView) findViewById(R.id.title_bar_title_tv);
        ivLeftImage = (ImageView) findViewById(R.id.title_bar_left_iv);
        ivRightImage= (ImageView) findViewById(R.id.title_bar_right_iv);


        ivLeftImage.setOnClickListener(defaultListener);
        initViews();
        initEvents();
        initData();

    }

    protected void setTitleText(String title){
        tvTitile.setText(title);
    }
    protected void setTitleText(int titleId){
        tvTitile.setText(titleId);
    }
    protected  void setTitleLeftImage(int drawable){
        ivLeftImage.setImageResource(drawable);
    }
    protected void setTitleRightImage(int drawable){
        ivRightImage.setImageResource(drawable);
    }

    /** 设置Title为隐藏*/
    protected  void hideTitle(){
        title_rl.setVisibility(View.GONE);
    }
    /** 设置Title为可见*/
    protected  void showTile(){
        title_rl.setVisibility(View.VISIBLE);
    }
    /** 设置Title颜色*/
    protected  void setTtColor(int color){
        title_rl.setBackgroundColor(color);
    }

    /**设置title左边icon点击事件*/
    protected void  setTitleLeftOnClickListener(View.OnClickListener listener){
        ivLeftImage.setOnClickListener(listener);
    }
    /**设置title右边icon点击事件*/
    protected void  setTitleRightOnClickListener(View.OnClickListener listener){
        ivRightImage.setOnClickListener(listener);
    }


    //获取布局？
    protected  abstract int getLayout();
    //初始化视图
    protected abstract void initViews();
    //初始化事件
    protected abstract  void initEvents();
    //初始化数据
    protected  abstract  void initData();
}