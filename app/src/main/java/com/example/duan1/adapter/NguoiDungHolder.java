package com.example.duan1.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;

class NguoiDungHolder extends RecyclerView.ViewHolder {

    public ImageView imgIcon;
    public TextView tvRvndDate;
    public TextView tvRvndBmi;
    public TextView tvRvndWeight;
    public TextView tvRvndHeight;

    public NguoiDungHolder(@NonNull View itemView) {
        super(itemView);


        imgIcon = (ImageView) itemView.findViewById(R.id.imgIcon);
        tvRvndDate = (TextView) itemView.findViewById(R.id.tv_rvnd_date);
        tvRvndBmi = (TextView) itemView.findViewById(R.id.tv_rvnd_bmi);
        tvRvndWeight = (TextView) itemView.findViewById(R.id.tv_rvnd_weight);
        tvRvndHeight = (TextView) itemView.findViewById(R.id.tv_rvnd_height);
    }
}
