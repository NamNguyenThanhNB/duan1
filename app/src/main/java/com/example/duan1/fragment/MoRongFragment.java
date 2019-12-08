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
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.duan1.R;
import com.example.duan1.activity.BaiTapActivity;
import com.example.duan1.activity.BoChuyenDoiActivity;
import com.example.duan1.activity.CaiDatActivity;
import com.example.duan1.activity.SoSanhTSActivity;
import com.example.duan1.activity.TheoDoiCNActivity;
import com.example.duan1.activity.ThuVienActivity;
import com.example.duan1.activity.ThucPhamActivity;
import com.example.duan1.databinding.FragmentMoRongBinding;
import com.example.duan1.inteface.MoRong_Interface;
import com.example.duan1.presenter.MoRong_Precenter;

public class MoRongFragment extends Fragment implements MoRong_Interface {

    private MoRong_Precenter moRong_precenter;

    //khi chinh xong layout thi se co ham nay
    FragmentMoRongBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mo_rong, container, false);
        moRong_precenter = new MoRong_Precenter(this);

        //khai bao precenter trong xml
        binding.setMorongprecenter(moRong_precenter);

        return binding.getRoot();
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
    public void setJob_cvW_MR() {

        Intent intent = new Intent(getActivity(), TheoDoiCNActivity.class);
        getActivity().startActivity(intent);
    }

    @Override
    public void setJob_cvSS_MR() {

        Intent intent = new Intent(getActivity(), SoSanhTSActivity.class);
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
