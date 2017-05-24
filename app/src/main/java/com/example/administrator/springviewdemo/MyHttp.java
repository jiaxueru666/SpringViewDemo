package com.example.administrator.springviewdemo;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * date:2017/5/22 0022
 * authom:贾雪茹
 * function:
 */

public class MyHttp {
    public static final void gethttp(String path,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(path);
        x.http().get(params,callback);
    }
}
