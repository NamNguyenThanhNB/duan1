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
import com.example.duan1.inteface.CSCTActivity_Interface;
import com.example.duan1.presenter.CSCTActivity_Precenter;

public class ChiSoCoTheFragment extends Fragment implements CSCTActivity_Interface {
    private CSCTActivity_Precenter csct_activityPrecenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chi_so_co_the, container, false);


        LinearLayout lnUpdate = view.findViewById(R.id.ln_csct_Update);
        csct_activityPrecenter = new CSCTActivity_Precenter(this);

        lnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                csct_activityPrecenter.setJob_ln_csct_Update();
            }
        });

        return view;
    }

    @Override
    public void setJob_ln_csct_Update() {

        Intent intent = new Intent(getActivity(), ND_Activity.class);
        startActivity(intent);
    }
}
