package com.example.duan1.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;


class MucTieuHolder extends RecyclerView.ViewHolder {
    public TextView tvRvmtTitle;
    public TextView tvRvmtSTime;
    public TextView tvRvmtETime;
    public TextView tv_tb;
    public TextView tv_s;
    public TextView tv_e;

    public MucTieuHolder(@NonNull View itemView) {
        super(itemView);
        tvRvmtTitle = (TextView) itemView.findViewById(R.id.tv_rvmt_title);
        tvRvmtSTime = (TextView) itemView.findViewById(R.id.tv_rvmt_sTime);
        tvRvmtETime = (TextView) itemView.findViewById(R.id.tv_rvmt_eTime);
        tv_tb = (TextView) itemView.findViewById(R.id.tv_tb);
        tv_s = (TextView) itemView.findViewById(R.id.tv_s);
        tv_e = (TextView) itemView.findViewById(R.id.tv_e);


    }

}
