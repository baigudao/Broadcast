package com.jackie.broadcast.activity;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理所有的类
 * Created by Administrator on 2016/12/18.
 */
public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }
    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
