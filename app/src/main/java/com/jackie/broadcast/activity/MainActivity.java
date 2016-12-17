package com.jackie.broadcast.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;

import com.jackie.broadcast.R;
import com.jackie.broadcast.receiver.LocalReceiver;
import com.jackie.broadcast.receiver.MyStandardBroadcastReceiver;
import com.jackie.broadcast.receiver.NetworkChangeReceiver;

/**
 * Created by Administrator on 2016/12/17.
 */
public class MainActivity extends Activity {

    private Button button_send_standard;
    private Button button_send_order;
    private Button button_localBroadcast;
    private MyStandardBroadcastReceiver receiver;
    private NetworkChangeReceiver networkChangeReceiver;
    private LocalReceiver localReceiver;
    private LocalBroadcastManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_send_standard = (Button) findViewById(R.id.btn_send_standard);
        button_send_order = (Button) findViewById(R.id.btn_send_order);
        button_localBroadcast = (Button) findViewById(R.id.btn_send_localBroadcast);

        button_send_standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("standard.xxx");
                sendBroadcast(intent);//发送标准广播
            }
        });

        //动态注册广播接收器
        receiver = new MyStandardBroadcastReceiver();
        registerReceiver(receiver, new IntentFilter("standard.xxx"));


        button_send_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOrderedBroadcast(new Intent("order.xxx"), null);//发送有序广播
            }
        });


        //动态注册实现监听网络变化
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));


        //发送本地广播，并动态注册接收
        manager = LocalBroadcastManager.getInstance(MainActivity.this);
        button_localBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.sendBroadcast(new Intent("local.xxx"));
            }
        });

        //动态接收本地广播
        localReceiver = new LocalReceiver();
        manager.registerReceiver(localReceiver, new IntentFilter("local.xxx"));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        unregisterReceiver(networkChangeReceiver);
        manager.unregisterReceiver(localReceiver);
    }
}
