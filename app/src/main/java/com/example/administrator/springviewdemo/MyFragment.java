package com.example.administrator.springviewdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;

import java.util.List;

import static android.R.attr.data;
import static android.content.ContentValues.TAG;

/**
 * date:2017/5/22 0022
 * authom:贾雪茹
 * function:
 */
/*
接口回调：RecycleView没有监听事件我们如果想对条目设置点击长按等事件就需要用到接口回调；
 */
public class MyFragment extends Fragment{
    private String path;
    private RecyclerView mRecycle;
    private MyAdapter mAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public MyFragment() {

    }


    public MyFragment(String path) {
        this.path = path;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mRecycle = (RecyclerView) getView().findViewById(R.id.recycle);
        /*
          参数：上下文，滑动方向，是否倒序排列；
         */
        //创建线性布局管理类；
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        //设置管理器；
        mRecycle.setLayoutManager(manager);
       //添加分隔线；
        mRecycle.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL));
        //网络请求数据；
        getData();
    }

    public void getData() {
        Log.i("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz", "getData: ");
     MyHttp.gethttp(path, new Callback.CommonCallback<String>() {



         @Override
         public void onSuccess(String result) {

             Gson gson=new Gson();
             MyDataBean myDataBean = gson.fromJson(result, MyDataBean.class);
             List<MyDataBean.DataBean> data = myDataBean.getData();
             Log.i("vvvvvvvv",data.get(0).getTitle());
             mAdapter = new MyAdapter(getActivity(),data);

             //设置适配器；
             mRecycle.setAdapter(mAdapter);
             mAdapter.setOnClickListener(new MyAdapter.SOnClickListener() {
                 @Override
                 public void sonClickListener(int position, View view) {
                     Toast.makeText(getActivity(),"123",Toast.LENGTH_SHORT).show();
                 }
             });

         }

         @Override
         public void onError(Throwable ex, boolean isOnCallback) {

         }

         @Override
         public void onCancelled(CancelledException cex) {

         }

         @Override
         public void onFinished() {

         }
     });
    }



}
