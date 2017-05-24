package com.example.administrator.springviewdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * date:2017/5/23 0023
 * authom:贾雪茹
 * function:
 */

public class MyPagerAdapter extends FragmentPagerAdapter{
    List<Fragment>flist;
    List<TitleBean.ResultBean.DateBean>titlelist;

    public MyPagerAdapter(FragmentManager fm, List<Fragment> flist, List<TitleBean.ResultBean.DateBean> titlelist) {
        super(fm);
        this.flist = flist;
        this.titlelist = titlelist;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titlelist.get(position).getTitle();
    }

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return flist.get(position);
    }

    @Override
    public int getCount() {
        return flist.size();
    }
}
