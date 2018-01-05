package com.example.us74.pantatuechapp;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {


    ImageView imageView;


    private CircleIndicator circleIndicator;

    private ViewPager mpager;


    //this is for activity
    private int[] layouts = {R.layout.aboutusslider, R.layout.servies, R.layout.client, R.layout.technologies, R.layout.contact_us};
    private mpagerAdapter mpagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mpager = (ViewPager) findViewById(R.id.viewPager);
        mpagerAdapter = new mpagerAdapter(layouts, this);
        mpager.setAdapter(mpagerAdapter);


        //this is for time picker
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 3000, 8000);


        //this is for logo design
        ImageView imageView = (ImageView) findViewById(R.id.ImageView);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.logo);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        imageView.setImageDrawable(roundedBitmapDrawable);


        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.ic_demo);
        indicator.setViewPager(mpager);


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //this is for time picker
    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (mpager.getCurrentItem() == 0) {
                        mpager.setCurrentItem(1);
                    } else if (mpager.getCurrentItem() == 1) {
                        mpager.setCurrentItem(2);
                    } else if (mpager.getCurrentItem() == 2) {
                        mpager.setCurrentItem(3);
                    } else if (mpager.getCurrentItem() == 3) {
                        mpager.setCurrentItem(4);

                    } else {
                        mpager.setCurrentItem(0);


                    }
                }
            });
        }
    }
}




