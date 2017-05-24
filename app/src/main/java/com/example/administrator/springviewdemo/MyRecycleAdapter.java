package com.example.administrator.springviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2017/5/23 0023
 * authom:贾雪茹
 * function:
 */

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.MyHolder>{
    private List<MyDataBean.DataBean> datalist;
    private Context mContext;

    public MyRecycleAdapter(List<MyDataBean.DataBean> datalist, Context context) {
        this.datalist = datalist;
        mContext = context;
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //填充布局
       View view= LayoutInflater.from(mContext).inflate(R.layout.items,parent,false);
        //将布局绑定ViewHolder；
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
     //给控件赋值；
        holder.text1.setText(datalist.get(position).getTitle());
        holder.text2.setText(datalist.get(position).getLabel());
        ImageLoader.getInstance().displayImage(datalist.get(position).getUrl(),holder.imageview);
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
      private TextView text1,text2;
      private ImageView imageview;

    public MyHolder(View itemView) {
        super(itemView);
      text1 = (TextView) itemView.findViewById(R.id.mytitle);
        text2 = (TextView) itemView.findViewById(R.id.content);
        imageview = (ImageView) itemView.findViewById(R.id.imageview);
    }
}

}
