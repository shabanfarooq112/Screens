package com.example.screens.adapters;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.screens.R;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ViewHolder> {


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.child_list_item, parent, false);
        ChildAdapter.ViewHolder viewHolder = new ChildAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if(position == 1 ){
            holder.borderFL.setBackgroundResource(R.drawable.card_view_background);
            holder.checkIV.setVisibility(View.VISIBLE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {

                if(holder.checkIV.getVisibility() == View.INVISIBLE){
                    holder.borderFL.setBackgroundResource(R.drawable.card_view_background);
                    holder.checkIV.setVisibility(View.VISIBLE);
                }else {
                    holder.borderFL.setBackgroundResource(Color.TRANSPARENT);
                    holder.checkIV.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        FrameLayout borderFL;
        ImageView checkIV;

        public ViewHolder(View itemView) {
            super(itemView);

            borderFL = itemView.findViewById(R.id.child_list_item_card_view_border);
            checkIV = itemView.findViewById(R.id.child_list_item_checked);
        }
    }
}
