package com.jackie.broadcast.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/12/17.
 */
public class MyStandardBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "已经收到动态注册的标准广播了！", Toast.LENGTH_SHORT).show();
    }
}
