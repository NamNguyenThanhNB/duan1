package com.example.duan1.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;


class LichTrinhHolder extends RecyclerView.ViewHolder {
    public TextView tvRvmtTitle;
    public TextView tvRvmtSTime;
    public TextView tvRvdlSTime;

    public LichTrinhHolder(@NonNull View itemView) {
        super(itemView);
        tvRvmtTitle = (TextView) itemView.findViewById(R.id.tv_rvmt_title);
        tvRvmtSTime = (TextView) itemView.findViewById(R.id.tv_rvmt_sTime);
        tvRvdlSTime = (TextView) itemView.findViewById(R.id.tv_rvmt_eTime);


    }

}
