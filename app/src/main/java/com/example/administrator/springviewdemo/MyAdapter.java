package com.example.administrator.springviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * date:2017/5/24 0024
 * authom:贾雪茹
 * function:
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{
    private Context context;
    private List<MyDataBean.DataBean>datalist;
    //定义三种条目类型标记；
    private int type=0;
    private int type1=1;
    private int type2=2;
    private MyHolderone mHolderone;

    public MyAdapter(Context context, List<MyDataBean.DataBean> datalist) {
        this.context = context;
        this.datalist = datalist;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType==0){
            View view=LayoutInflater.from(context).inflate(R.layout.items,parent,false);
            view.setOnClickListener(this);
            MyHolderone one=new MyHolderone(view);
            return one;
        }else if(viewType==1){
            View view=LayoutInflater.from(context).inflate(R.layout.item2,parent,false);
            MyHoldertwo two=new MyHoldertwo(view);
            view.setOnClickListener(this);
            return two;
        }else if(viewType==2){
            View view=LayoutInflater.from(context).inflate(R.layout.item3,parent,false);
            MyHolderthree three=new MyHolderthree(view);
            view.setOnClickListener(this);
            return three;
        }else{
            View view=LayoutInflater.from(context).inflate(R.layout.items,parent,false);
           MyHolderone one=new MyHolderone(view);
            view.setOnClickListener(this);
            return one;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        holder.itemView.setTag(position);
          if(holder instanceof MyHolderone){
             MyHolderone holderone= (MyHolderone) holder;
              holderone.text1.setText(datalist.get(position).getTitle());
              holderone.text2.setText(datalist.get(position).getSource());

              holderone.imageview.setImageResource(R.drawable.ic_launcher);
          }else if(holder instanceof  MyHoldertwo){
            MyHoldertwo holdertwo= (MyHoldertwo) holder;
              holdertwo.texttwo.setText(datalist.get(position).getTitle());
              holdertwo.imagetwo1.setImageResource(R.drawable.ic_launcher);
              holdertwo.imagetwo2.setImageResource(R.drawable.ic_launcher);
              holdertwo.imagetwo3.setImageResource(R.drawable.ic_launcher);
              holdertwo.imagetwo3.setImageResource(R.drawable.ic_launcher);

          }else if(holder instanceof MyHolderthree){
             MyHolderthree holderthree= (MyHolderthree) holder;
              holderthree.textthree.setText(datalist.get(position).getTitle());
              holderthree.imagethree.setImageResource(R.drawable.ic_launcher);
          }else{
              mHolderone = (MyHolderone) holder;
              mHolderone.text1.setText(datalist.get(position).getTitle());
              mHolderone.text2.setText(datalist.get(position).getSource());
              mHolderone.imageview.setImageResource(R.drawable.ic_launcher);
          }

    }

    @Override
    public int getItemViewType(int position) {
       int i= position%3;
       switch (i){
           case 0:
               return type;
           case 1:
               return type1;
           case 2:
               return type2;
       }
        return -1;
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    @Override
    public void onClick(View view) {
        listener.sonClickListener((Integer) view.getTag(),view);
    }


    class MyHolderone extends RecyclerView.ViewHolder {
    private TextView text1, text2;
    private ImageView imageview;

    public MyHolderone(View itemView) {
        super(itemView);
        text1 = (TextView) itemView.findViewById(R.id.mytitle);
        text2 = (TextView) itemView.findViewById(R.id.content);
        imageview = (ImageView) itemView.findViewById(R.id.imageview);
    }
}
    class MyHoldertwo extends RecyclerView.ViewHolder {
        private TextView texttwo;
        private ImageView imagetwo1,imagetwo2,imagetwo3;

        public MyHoldertwo(View itemView) {
            super(itemView);
            //找到控件；
           texttwo= (TextView) itemView.findViewById(R.id.texttitle);
           imagetwo1= (ImageView) itemView.findViewById(R.id.image1);
           imagetwo2= (ImageView) itemView.findViewById(R.id.image2);
           imagetwo3= (ImageView) itemView.findViewById(R.id.image3);

        }
    }

    class MyHolderthree extends RecyclerView.ViewHolder {
        private TextView textthree;
        private ImageView imagethree;

        public MyHolderthree(View itemView) {
            super(itemView);
            textthree= (TextView) itemView.findViewById(R.id.mytitle);
            imagethree= (ImageView) itemView.findViewById(R.id.imageview);
        }
    }

//删除数据；
    public void remove(int position){

       datalist.remove(position);

        notifyItemRemoved(position);
//        notifyDataSetChanged();

        notifyItemRangeChanged(position,datalist.size());

    }



    interface SOnClickListener {

        void sonClickListener(int position,View view);
    }

//回调方法；
    //定义回调方法参数为接口对象
    public SOnClickListener listener;
    public void setOnClickListener(SOnClickListener listener){
        this.listener = listener;
    }
}