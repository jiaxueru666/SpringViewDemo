package com.example.administrator.springviewdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.utils.L;

import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.List;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends FragmentActivity {

    private TabLayout mTab;
    private ViewPager mViewpager;
    private List<TitleBean.ResultBean.DateBean> mDate;
    private List<Fragment> mListf;
    private List<String> mListpath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置TabLayout
       getTabLayout();

        mListpath = new ArrayList<String>();
        mListpath.add(MyPath.CAIJING);
        mListpath.add(MyPath.DUANZI);
        mListpath.add(MyPath.JIANKANG);
        mListpath.add(MyPath.JUNSHI);
        mListpath.add(MyPath.KEJI);
        mListpath.add(MyPath.MEINV);
        mListpath.add(MyPath.QICHE);
        mListpath.add(MyPath.QUTU);
        mListpath.add(MyPath.GUOJI);
        mListpath.add(MyPath.SHEHUI);
        mListpath.add(MyPath.SHIPIN);
        mListpath.add(MyPath.YULE);
        mListpath.add(MyPath.TIYU);
        mListpath.add(MyPath.REDIAN);
        mListpath.add(MyPath.BENDI);
        mListpath.add(MyPath.TUIJIAN);

        //网络获取标题数据 ；
        getTitleData();
    }

    public void getTabLayout() {
        mTab = (TabLayout) findViewById(R.id.tabs);
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mTab.setTabMode(TabLayout.MODE_SCROLLABLE);
       mTab.setupWithViewPager(mViewpager);
    }


    public void getTitleData() {
    MyHttp.gethttp(MyPath.TITLE, new Callback.CommonCallback<String>() {
        @Override
        public void onSuccess(String result) {
            //解析数据；
            Gson gson=new Gson();
            TitleBean titleBean = gson.fromJson(result, TitleBean.class);
            mDate = titleBean.getResult().getDate();
           //将Fragment添加到List集合中；
            mListf = new ArrayList<Fragment>();
            for(String p:mListpath){
                //循环添加多个Fragment；
//                for (int i = 0; i <mDate.size(); i++) {
                    mListf.add(new MyFragment(p));
//                }
            }
            //给ViewPager设置适配器；
            mViewpager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),mListf,mDate));
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
