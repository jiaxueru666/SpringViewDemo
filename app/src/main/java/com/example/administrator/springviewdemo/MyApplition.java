package com.example.administrator.springviewdemo;

import android.app.Application;
import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;
/**
 * date:2017/5/22 0022
 * authom:贾雪茹
 * function:
 */

public class MyApplition extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false);
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));
    }
}
