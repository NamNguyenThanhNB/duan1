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

import com.example.duan1.R;
import com.example.duan1.activity.ThemMT_DLActivity;
import com.example.duan1.databinding.FragmentMucTieuBinding;
import com.example.duan1.inteface.MucTieu_Interface;
import com.example.duan1.presenter.MucTieu_Precenter;

public class MucTieuFragment extends Fragment implements MucTieu_Interface {
    private Switch sGetUp;
    private Switch sBedTime;
    private Switch sMeal;
    private Switch sDrink;
    private Switch sExercise;
    private ImageView imgMtAdd;
    private MucTieu_Precenter mucTieuPrecenter;
    private FragmentMucTieuBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_muc_tieu, container, false);
        init();
        mucTieuPrecenter = new MucTieu_Precenter(this);
        binding.setMuctieuprecenter(mucTieuPrecenter);
        return binding.getRoot();
    }

    private void init() {

        sGetUp = (Switch) binding.getRoot().findViewById(R.id.sGetUp);
        sBedTime = (Switch) binding.getRoot().findViewById(R.id.sBedTime);
        sMeal = (Switch) binding.getRoot().findViewById(R.id.sMeal);
        sDrink = (Switch) binding.getRoot().findViewById(R.id.sDrink);
        sExercise = (Switch) binding.getRoot().findViewById(R.id.sExercise);
        imgMtAdd = (ImageView) binding.getRoot().findViewById(R.id.img_mt_add_);
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
        getActivity().startActivity(intent);
    }
}
