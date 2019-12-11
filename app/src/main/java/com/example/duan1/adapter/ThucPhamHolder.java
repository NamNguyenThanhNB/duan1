package com.example.duan1.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;


class ThucPhamHolder extends RecyclerView.ViewHolder {
    public LinearLayout lnRv;
    public TextView tvRvtpTenTP;
    public TextView tvRvtpLoaiTP;

    public ThucPhamHolder(@NonNull View itemView) {
        super(itemView);

        lnRv = (LinearLayout) itemView.findViewById(R.id.ln_rv);
        tvRvtpTenTP = (TextView) itemView.findViewById(R.id.tv_rvtp_tenTP);
        tvRvtpLoaiTP = (TextView) itemView.findViewById(R.id.tv_rvtp_loaiTP);


    }

}
