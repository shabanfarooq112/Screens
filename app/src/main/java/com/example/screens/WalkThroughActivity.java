package com.example.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.screens.adapters.SliderAdapter;

public class WalkThroughActivity extends AppCompatActivity {
    ViewPager viewPager;
    LinearLayout linearLayout;
    SliderAdapter sliderAdapter;
    TextView[] mDots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk_through);

        initComponent();
    }

    private void initComponent() {
        viewPager = findViewById(R.id.view_pager);
        linearLayout = findViewById(R.id.dots_linear_layout);

        sliderAdapter = new SliderAdapter(this);

        viewPager.setAdapter(sliderAdapter);
        AddDotsIndicator(0);
        viewPager.addOnPageChangeListener(listener);
    }

    public void AddDotsIndicator(int position){
        mDots = new TextView[6];
        linearLayout.removeAllViews();

        for(int pos=0 ; pos<mDots.length ; pos++){
            mDots[pos] = new TextView(this);
            mDots[pos].setText(Html.fromHtml("&#8226"));
            mDots[pos].setTextSize(50);
            mDots[pos].setTextColor(getResources().getColor(R.color.white));
            linearLayout.addView(mDots[pos]);
        }
        if(mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.black));
        }
    }
    ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            AddDotsIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}