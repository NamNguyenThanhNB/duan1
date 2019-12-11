package com.example.duan1.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;
import com.example.duan1.activity.ThemMT_DLActivity;
import com.example.duan1.adapter.LichTrinhAdapter;
import com.example.duan1.adapter.MucTieuAdapter;
import com.example.duan1.dao.LichTrinhDao;
import com.example.duan1.dao.MucTieuDao;
import com.example.duan1.databinding.FragmentMucTieuBinding;
import com.example.duan1.inteface.MucTieu_Interface;
import com.example.duan1.model.LichTrinh;
import com.example.duan1.model.MucTieu;
import com.example.duan1.presenter.MucTieu_Precenter;

import java.util.ArrayList;
import java.util.List;

public class MucTieuFragment extends Fragment implements MucTieu_Interface {

    private MucTieu_Precenter mucTieuPrecenter;
    private FragmentMucTieuBinding binding;
    private MucTieuDao mucTieuDao;
    private LichTrinhDao lichTrinhDao;
    private RecyclerView rvMtdlMt;
    private RecyclerView rvMtdlDl;
    private MucTieuAdapter mucTieuAdapter;
    private LichTrinhAdapter lichTrinhAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_muc_tieu, container, false);

        rvMtdlMt = (RecyclerView) binding.getRoot().findViewById(R.id.rv_mtdl_mt);
        rvMtdlDl = (RecyclerView) binding.getRoot().findViewById(R.id.rv_mtdl_dl);

        mucTieuPrecenter = new MucTieu_Precenter(this);
        binding.setMuctieuprecenter(mucTieuPrecenter);

        mucTieuDao = new MucTieuDao(getActivity());
        lichTrinhDao = new LichTrinhDao(getActivity());
        List<MucTieu> mucTieuList = mucTieuDao.selectMT();
        List<LichTrinh> lichTrinhList = lichTrinhDao.selectLT();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity());
        mucTieuAdapter = new MucTieuAdapter(getActivity(), mucTieuList);
        lichTrinhAdapter = new LichTrinhAdapter(getActivity(), lichTrinhList);


        rvMtdlMt.setLayoutManager(linearLayoutManager);
        rvMtdlMt.setAdapter(mucTieuAdapter);
        mucTieuAdapter.notifyDataSetChanged();

        rvMtdlDl.setLayoutManager(linearLayoutManager1);
        rvMtdlDl.setAdapter(lichTrinhAdapter);
        lichTrinhAdapter.notifyDataSetChanged();

        return binding.getRoot();
    }

    @Override
    public void setJob_sGetUp(boolean x) {
        if (x) {
            Toast.makeText(getActivity(), "setJob_sGetUp is on", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "setJob_sGetUp is off", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setJob_sBedTime(boolean x) {
        if (x) {
            Toast.makeText(getActivity(), "setJob_sBedTime is on", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "setJob_sBedTime is off", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setJob_sMeal(boolean x) {
        if (x) {
            Toast.makeText(getActivity(), "setJob_sMeal is on", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "setJob_sMeal is off", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setJob_sDrink(boolean x) {
        if (x) {
            Toast.makeText(getActivity(), "setJob_sDrink is on", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "setJob_sDrink is off", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setJob_sExercise(boolean x) {
        if (x) {
            Toast.makeText(getActivity(), "setJob_sExercise is on", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "setJob_sExercise is off", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setJob_imgMtAdd() {
        Intent intent = new Intent(getActivity(), ThemMT_DLActivity.class);
        intent.putExtra("MT-DL", 0);
        getActivity().startActivity(intent);

        Toast.makeText(getActivity(), "0", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setJobImgLHAdd() {
        Intent intent = new Intent(getActivity(), ThemMT_DLActivity.class);
        intent.putExtra("MT-DL", 1);
        getActivity().startActivity(intent);
        Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();

    }
}
