package com.jackie.broadcast.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/12/17.
 */
public class MyOrderBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "接收到了静态注册的有序广播！", Toast.LENGTH_SHORT).show();
        abortBroadcast();
    }
}
