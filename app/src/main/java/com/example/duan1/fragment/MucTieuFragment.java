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

    private MucTieu_Precenter mucTieuPrecenter;
    private FragmentMucTieuBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_muc_tieu, container, false);

        mucTieuPrecenter = new MucTieu_Precenter(this);
        binding.setMuctieuprecenter(mucTieuPrecenter);
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
    public void setJob_imgLHAdd() {
        Intent intent = new Intent(getActivity(), ThemMT_DLActivity.class);
        intent.putExtra("MT-DL", 1);
        getActivity().startActivity(intent);
        Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();

    }
}
