package com.example.duan1.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.example.duan1.R;
import com.example.duan1.activity.BaiTapActivity;
import com.example.duan1.activity.ThucPhamActivity;
import com.example.duan1.databinding.FragmentManHinhChinhBinding;
import com.example.duan1.inteface.MHChinh_Inteface;
import com.example.duan1.model.NguoiDung;
import com.example.duan1.presenter.MHChinh_Precenter;
import com.example.duan1.presenter.ThucPham_Precenter;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class ManHinhChinhFragment extends Fragment implements MHChinh_Inteface {

    private MHChinh_Precenter mhChinhPrecenter;
    private FragmentManHinhChinhBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_man_hinh_chinh, container, false);

        mhChinhPrecenter = new MHChinh_Precenter(this);

        NguoiDung nguoiDung = new NguoiDung(1, "nam", "19", "nam", "58", "168", "null", "20/11/2019");
        binding.setMhcprecenter(mhChinhPrecenter);
        ThucPham_Precenter thucPham_precenter = new ThucPham_Precenter(this);
        binding.setThucphamprecenter(thucPham_precenter);
        binding.setNguoidungView((nguoiDung));
        return binding.getRoot();
    }

    @Override
    public void setJob_cvMhcWeight() {

        Toast.makeText(getActivity(), "setJob_cvMhcWeight", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void setJob_cvMhcBMI() {
        Toast.makeText(getActivity(), "setJob_cvMhcBMI", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setJob_cvMhcNextFood() {
                Intent intent = new Intent(getActivity(), ThucPhamActivity.class);
                startActivity(intent);


    }

    @Override
    public void setJob_cvMhcNextExercise() {
                Intent intent = new Intent(getActivity(), BaiTapActivity.class);
                startActivity(intent);

    }

    @Override
    public void setJob_addFood() {
        Toast.makeText(getActivity(), "show dialog for add foods", Toast.LENGTH_SHORT).show();

        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setView(R.layout.dialog_add_food);
        final AlertDialog dialog = alertDialog.show();
    }

    @Override
    public void setJob_tvTpShowComment() {

    }

    @Override
    public void setJob_rvTpMuch() {

    }

    @Override
    public void setJob_rvTpLimit() {

    }

    @Override
    public void setJob_rvTpNo() {

    }

}

