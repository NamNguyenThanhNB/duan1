package com.example.duan1.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.duan1.R;
import com.example.duan1.activity.HoatDongGDActivity;
import com.example.duan1.activity.ND_Activity;
import com.example.duan1.activity.SoSanhTSActivity;
import com.example.duan1.activity.TheoDoiCNActivity;
import com.example.duan1.dao.NguoidungDao;
import com.example.duan1.databinding.FragmentChiSoCoTheBinding;
import com.example.duan1.inteface.CSCTActivity_Interface;
import com.example.duan1.model.NguoiDung;
import com.example.duan1.presenter.CSCTActivity_Precenter;

import java.util.List;

public class ChiSoCoTheFragment extends Fragment implements CSCTActivity_Interface {
    private CSCTActivity_Precenter csct_activityPrecenter;
    FragmentChiSoCoTheBinding binding;
    private NguoidungDao nguoidungDao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chi_so_co_the, container, false);

        nguoidungDao = new NguoidungDao(getActivity());
        LinearLayout lnUpdate = binding.getRoot().findViewById(R.id.ln_csct_Update);
        csct_activityPrecenter = new CSCTActivity_Precenter(this);
        binding.setCsctprecenter(csct_activityPrecenter);
        List<NguoiDung> nguoiDungList = nguoidungDao.selectND();

        int size = nguoiDungList.size();
        NguoiDung nguoiDung = nguoiDungList.get(size - 1);
        binding.setNguoidungView(nguoiDung);


        return binding.getRoot();
    }

    @Override
    public void setJob_ln_csct_Update() {

        Intent intent = new Intent(getActivity(), ND_Activity.class);
        startActivity(intent);
    }
}
