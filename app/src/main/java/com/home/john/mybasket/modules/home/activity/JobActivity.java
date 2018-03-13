package com.home.john.mybasket.modules.home.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.home.john.mybasket.R;
import com.home.john.mybasket.modules.home.fragment.CompanyFragment;

public class JobActivity extends Activity {
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        iv = (ImageView) findViewById(R.id.imageViewgo);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(JobActivity.this,CompanyActivity.class);
                startActivity(intent);
            }
        });
    }
}
