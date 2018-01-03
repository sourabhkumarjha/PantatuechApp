package com.example.us74.pantatuechapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by US74 on 1/2/2018.
 */

public class mpagerAdapter extends PagerAdapter {


    private int [] anim;
    private int[] layouts;
    private LayoutInflater layoutInflater;
    private Context context;

    public mpagerAdapter(int[] layouts,Context context)
    {
        this.anim = anim;
        this.layouts = layouts;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = layoutInflater.inflate(layouts[position],container,false);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view =(View)object;
        container.removeView(view);
    }
}

