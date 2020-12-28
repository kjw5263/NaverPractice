package com.example.naverpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.naverpractice.fragment.pageOne;
import com.example.naverpractice.fragment.pageTwo;

public class MainActivity extends AppCompatActivity {
    private static final int MAX_PAGE=2;
    private ViewPager viewPager;

    private ImageView circle01;
    private ImageView circle02;

    private pageOne fragment01;
    private pageTwo fragment02;

    private int cur_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setFunction();


    }

    private void init() {
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new adapter(getSupportFragmentManager()));

        circle01 = findViewById(R.id.circle_one);
        circle02 = findViewById(R.id.circle_two);
        fragment01 = new pageOne();
        fragment02 = new pageTwo();

        cur_page=0;



    }


    private void setFunction() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                cur_page = position;
                if(position ==0){
                    circle01.setImageResource(R.mipmap.ic_circle_green);
                    circle02.setImageResource(R.mipmap.ic_circle_grey);
                }
                else {
                    circle01.setImageResource(R.mipmap.ic_circle_grey);
                    circle02.setImageResource(R.mipmap.ic_circle_green);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private class adapter extends FragmentPagerAdapter {
        public adapter(FragmentManager fm) { super(fm);}

        @Override
        public Fragment getItem(int position) {
            if((position <0) || (MAX_PAGE) <= position){
                return null;
            }

            if(position ==0){
                return fragment01;
            } else {
                return fragment02;
            }
        }

        @Override
        public int getCount() {
            return MAX_PAGE;
        }
    }
}