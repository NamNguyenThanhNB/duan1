package com.example.duan1.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.duan1.R;
import com.example.duan1.activity.HoatDongGDActivity;
import com.example.duan1.activity.ND_Activity_Activity;
import com.example.duan1.activity.SoSanhTSActivity;
import com.example.duan1.activity.TheoDoiCNActivity;
import com.example.duan1.inteface.CSCTActivity_Interface;
import com.example.duan1.presenter.CSCTActivity_Precenter;

public class ChiSoCoTheFragment extends Fragment implements CSCTActivity_Interface {
    private CSCTActivity_Precenter csct_activityPrecenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chi_so_co_the, container, false);
        LinearLayout lnUpdate = view.findViewById(R.id.ln_csct_Update);
        CardView cvSoSanh = view.findViewById(R.id.cv_csct_SoSanh);
        CardView cvHoatDong = view.findViewById(R.id.cv_csct_HoatDong);
        CardView cvWeight = view.findViewById(R.id.cv_csct_Weight);
        csct_activityPrecenter = new CSCTActivity_Precenter(this);

        lnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                csct_activityPrecenter.setJob_ln_csct_Update();
            }
        });
        cvWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                csct_activityPrecenter.setJob_cv_csct_Weight();
            }
        });
        cvSoSanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                csct_activityPrecenter.setJob_cv_csct_SoSanh();
            }
        });
        cvHoatDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                csct_activityPrecenter.setJobcv_csct_HoatDong();
            }
        });

        return view;
    }

    @Override
    public void setJob_ln_csct_Update() {

        Intent intent = new Intent(getActivity(), ND_Activity_Activity.class);
        startActivity(intent);
    }

    @Override
    public void setJob_cv_csct_Weight() {
        Intent intent = new Intent(getActivity(), TheoDoiCNActivity.class);
        startActivity(intent);

    }

    @Override
    public void setJob_cv_csct_SoSanh() {
        Intent intent = new Intent(getActivity(), SoSanhTSActivity.class);
        startActivity(intent);

    }

    @Override
    public void setJobcv_csct_HoatDong() {
        Intent intent = new Intent(getActivity(), HoatDongGDActivity.class);
        startActivity(intent);

    }
}
