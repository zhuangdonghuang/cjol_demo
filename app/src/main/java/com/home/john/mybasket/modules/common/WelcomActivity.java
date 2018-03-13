package com.home.john.mybasket.modules.common;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.home.john.mybasket.R;
import com.home.john.mybasket.modules.common.adapter.ViewPageAdapter;

import java.util.ArrayList;
import java.util.List;

public class WelcomActivity extends Activity implements ViewPager.OnPageChangeListener{

    private ViewPager vp;
    private ViewPageAdapter viewPageAdapter;
    private List<View> views;
    private Button openBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        intView();
    }

    private void intView() {

        LayoutInflater inflater = LayoutInflater.from(this);
        views = new ArrayList<>();
        views.add(inflater.inflate(R.layout.wellcome_1,null));
        views.add(inflater.inflate(R.layout.wellcome_2,null));
        views.add(inflater.inflate(R.layout.wellcome_3,null));
        views.add(inflater.inflate(R.layout.wellcome_4,null));
        views.add(inflater.inflate(R.layout.wellcome_5,null));
        viewPageAdapter = new ViewPageAdapter(views,this);
        vp = (ViewPager) findViewById(R.id.viewfinder_view);
        vp.setAdapter(viewPageAdapter);
        openBtn = (Button) views.get(4).findViewById(R.id.open_btn);
        openBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        vp.setOnPageChangeListener(this);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}
