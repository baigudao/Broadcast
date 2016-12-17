package com.jackie.broadcast.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jackie.broadcast.R;
import com.jackie.broadcast.receiver.MyStandardBroadcastReceiver;

/**
 * Created by Administrator on 2016/12/17.
 */
public class MainActivity extends Activity {

    private Button button_send_standard;
    private MyStandardBroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_send_standard = (Button)findViewById(R.id.btn_send_standard);

        button_send_standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("standard.xxx");
                sendBroadcast(intent);//发送标准广播
            }
        });

        //动态注册广播接收器
        receiver = new MyStandardBroadcastReceiver();
        registerReceiver(receiver,new IntentFilter("standard.xxx"));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
