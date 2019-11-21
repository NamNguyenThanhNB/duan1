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
import com.example.duan1.activity.ND_Activity;
import com.example.duan1.activity.SoSanhTSActivity;
import com.example.duan1.activity.TheoDoiCNActivity;

public class ChiSoCoTheFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chi_so_co_the, container, false);
        LinearLayout lnUpdate = view.findViewById(R.id.lnUpdate);
        CardView cvSoSanh = view.findViewById(R.id.cvSoSanh);
        CardView cvHoatDong = view.findViewById(R.id.cvHoatDong);
        CardView cvWeight = view.findViewById(R.id.cvWeight);


        lnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ND_Activity.class);
                startActivity(intent);
            }
        });
        cvWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TheoDoiCNActivity.class);
                startActivity(intent);
            }
        });
        cvSoSanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SoSanhTSActivity.class);
                startActivity(intent);
            }
        });
        cvHoatDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HoatDongGDActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
