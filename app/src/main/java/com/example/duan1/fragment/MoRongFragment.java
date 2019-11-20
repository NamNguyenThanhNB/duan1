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

public class MoRongFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mo_rong, container, false);

        CardView cvLibrary = view.findViewById(R.id.cvLibrary);
        cvLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ThuVienActivity.class);
                getActivity().startActivity(intent);
            }
        });

        CardView cvConvert = view.findViewById(R.id.cvConvert);
        cvConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BoChuyenDoiActivity.class);
                getActivity().startActivity(intent);
            }
        });

        CardView cvSetting = view.findViewById(R.id.cvSetting);
        cvSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CaiDatActivity.class);
                getActivity().startActivity(intent);
            }
        });

        CardView cvFood_MR = view.findViewById(R.id.cvFood_MR);
        cvFood_MR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ThucPhamActivity.class);
                getActivity().startActivity(intent);
            }
        });


        CardView cvExercise_MR = view.findViewById(R.id.cvExercise_MR);
        cvExercise_MR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BaiTapActivity.class);
                getActivity().startActivity(intent);
            }
        });


        CardView cvReset = view.findViewById(R.id.cvReset);
        cvReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });


        return view;
    }
}
