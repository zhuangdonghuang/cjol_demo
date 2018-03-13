package com.home.john.mybasket.modules.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.baidu.mapapi.SDKInitializer;
import com.home.john.mybasket.R;
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Animation scale= AnimationUtils.loadAnimation(this, R.anim.anim_scale);//获取“缩放”动画资源
        ImageView iv=(ImageView)findViewById(R.id.imageView1);	//获取要应用动画效果的ImageView
        iv.startAnimation(scale);	//播放“缩放”动画



        //设置缩放动画监听器
        scale.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                //跳转后结束
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
}
