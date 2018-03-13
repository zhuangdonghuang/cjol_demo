package com.home.john.mybasket.util;

import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.android.Contents;
import com.google.zxing.client.android.Intents;
import com.home.john.mybasket.R;
import com.home.john.mybasket.modules.common.BaseActivity;

public class ZxingActivity extends BaseActivity {

    private TextView tvMsg;
    private final int request_code_scan = 3;

    @Override
    protected int getLayout() {
        return R.layout.activity_zxing;
    }

    @Override
    protected void initViews() {
        tvMsg = (TextView) findViewById(R.id.zxing_msg_tv);

    }

    @Override
    protected void initEvents() {
    }

    @Override
    protected void initData() {
    }

    //指定activity跳转到指定页面
    public void scan(View view) {
        Intent intent = new Intent(Intents.Scan.ACTION);
        intent.putExtra(Intents.Scan.MODE, Intents.Scan.QR_CODE_MODE);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        int size = width > height ? height : width;
        size = size >> 1;

        intent.putExtra(Intents.Scan.WIDTH, size);
        intent.putExtra(Intents.Scan.HEIGHT, size);
        startActivityForResult(intent, request_code_scan);

    }

    public void decode(View view) {
        Intent intent = new Intent(Intents.Encode.ACTION);
        intent.putExtra(Intents.Encode.TYPE, Contents.Type.TEXT);
        intent.putExtra(Intents.Encode.FORMAT, BarcodeFormat.QR_CODE);
        intent.putExtra(Intents.Encode.DATA,"饿呢嗯嗯嗯嗯呃嗯嗯嗯嗯嗯呃嗯嗯嗯呃恩");
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == request_code_scan) {
                String result = data.getStringExtra(Intents.Scan.RESULT);
                tvMsg.setText(result);
            }
        }
    }
}