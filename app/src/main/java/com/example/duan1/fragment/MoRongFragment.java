package com.example.duan1.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.duan1.R;
import com.example.duan1.activity.BaiTapActivity;
import com.example.duan1.activity.BoChuyenDoiActivity;
import com.example.duan1.activity.CaiDatActivity;
import com.example.duan1.activity.ThuVienActivity;
import com.example.duan1.activity.ThucPhamActivity;
import com.example.duan1.inteface.MoRong_Interface;
import com.example.duan1.presenter.MoRong_Precenter;

public class MoRongFragment extends Fragment implements MoRong_Interface {

    private MoRong_Precenter moRong_precenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mo_rong, container, false);
        moRong_precenter = new MoRong_Precenter(this);
        CardView cvLibrary = view.findViewById(R.id.cvLibrary);
        CardView cvConvert = view.findViewById(R.id.cvConvert);
        CardView cvSetting = view.findViewById(R.id.cvSetting);
        CardView cvFood_MR = view.findViewById(R.id.cvFood_MR);
        CardView cvExercise_MR = view.findViewById(R.id.cvExercise_MR);
        CardView cvReset = view.findViewById(R.id.cvReset);


        cvLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moRong_precenter.setJob_cvLibrary();
            }
        });

        cvConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moRong_precenter.setJob_cvConvert();
            }
        });

        cvSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moRong_precenter.setJob_cvSetting();
            }
        });

        cvFood_MR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moRong_precenter.setJob_cvFood_MR();
            }
        });


        cvExercise_MR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moRong_precenter.setJob_cvExercise_MR();
            }
        });


        cvReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moRong_precenter.setJob_cvReset();
            }
        });
        return view;
    }

    @Override
    public void setJob_cvLibrary() {
        Intent intent = new Intent(getActivity(), ThuVienActivity.class);
        getActivity().startActivity(intent);

    }

    @Override
    public void setJob_cvConvert() {
        Intent intent = new Intent(getActivity(), BoChuyenDoiActivity.class);
        getActivity().startActivity(intent);

    }

    @Override
    public void setJob_cvSetting() {
        Intent intent = new Intent(getActivity(), CaiDatActivity.class);
        getActivity().startActivity(intent);
    }

    @Override
    public void setJob_cvFood_MR() {

        Intent intent = new Intent(getActivity(), ThucPhamActivity.class);
        getActivity().startActivity(intent);
    }

    @Override
    public void setJob_cvExercise_MR() {

        Intent intent = new Intent(getActivity(), BaiTapActivity.class);
        getActivity().startActivity(intent);
    }

    @Override
    public void setJob_cvReset() {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setView(R.layout.dialog_reset_data);
        final AlertDialog dialog = alertDialog.show();
        Button btn_reset_Ok = dialog.findViewById(R.id.btn_reset_Ok);
        Button btn_reset_Cancel = dialog.findViewById(R.id.btn_reset_Cancel);
        btn_reset_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Xóa thành công :3", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        btn_reset_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Hủy xóa thành công :3", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }
}
