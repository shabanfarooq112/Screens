package com.example.screens.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.screens.HomeActivity;
import com.example.screens.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return slide_heading.length;
    }

    public int[] slide_images = {
            R.drawable.ic_baseline_person_pin_24,
            R.drawable.ic_baseline_person_pin_24,
            R.drawable.ic_baseline_person_pin_24,
            R.drawable.ic_baseline_person_pin_24,
            R.drawable.ic_baseline_person_pin_24,
            R.drawable.ic_baseline_person_pin_24
    };

    public String[] slide_heading = {
            "How to GoTap to iphone",
            "How to GoTap to android",
            "TAP Direct",
            "Your TAP Profile",
            "Your QR Code",
            "Let's get GoTap"
    };




    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView imageView = view.findViewById(R.id.slide_layout_image);
        TextView heading = view.findViewById(R.id.textview1);
        ImageView backToHome = view.findViewById(R.id.back_to_home);

        heading.setText(slide_heading[position]);
        imageView.setImageResource(slide_images[position]);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , HomeActivity.class);
                context.startActivity(intent);
            }
        });



        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
