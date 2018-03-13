package com.home.john.mybasket.modules.message.activity;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.home.john.mybasket.R;
import com.home.john.mybasket.modules.message.adapter.ChatMessageAdapter;
import com.home.john.mybasket.modules.home.bean.ChatMessage;
import com.home.john.mybasket.util.ServiceUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerServiceActivity extends Activity {

    private ImageView iv;
    private ListView mMsgs;
    private ChatMessageAdapter mAdapter;
    private List<ChatMessage> mDatas;
    private EditText mInputMsg;
    private Button mSendMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        initView();
        initDatas();
        initListener();
    }


    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            // 等待接收，子线程完成数据的返回
            ChatMessage fromMessge = (ChatMessage) msg.obj;
            mDatas.add(fromMessge);
            mAdapter.notifyDataSetChanged();
            mMsgs.setSelection(mDatas.size()-1);
        }
    };

    private void initListener() {
        //返回
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        //发送按钮
        mSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String toMsg = mInputMsg.getText().toString();
                if (TextUtils.isEmpty(toMsg)) {
                    Toast.makeText(CustomerServiceActivity.this, "发送消息不能为空！",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                ChatMessage toMessage = new ChatMessage();
                toMessage.setDate(new Date());
                toMessage.setMsg(toMsg);
                toMessage.setType(ChatMessage.Type.OUTCOMING);
                mDatas.add(toMessage);
                mAdapter.notifyDataSetChanged();
                mMsgs.setSelection(mDatas.size() - 1);

                mInputMsg.setText("");

                new Thread() {
                    public void run() {
                        ChatMessage fromMessage = ServiceUtils.sendMessage(toMsg);
                        Message m = Message.obtain();
                        m.obj = fromMessage;
                        mHandler.sendMessage(m);
                    }
                }.start();
            }
        });




    }

    private void initDatas() {
        mDatas = new ArrayList<ChatMessage>();
        mDatas.add(new ChatMessage("你好，小野为您服务", ChatMessage.Type.INCOMING, new Date()));
        mAdapter = new ChatMessageAdapter(this,mDatas);
        mMsgs.setAdapter(mAdapter);
    }

    private void initView() {
        iv = (ImageView) findViewById(R.id.id_bk);
        mMsgs = (ListView) findViewById(R.id.id_listview_msgs);
        mInputMsg = (EditText) findViewById(R.id.id_input_msg);
        mSendMsg = (Button) findViewById(R.id.id_send_msg);
    }
}
