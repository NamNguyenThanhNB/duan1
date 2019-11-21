package com.example.duan1.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.duan1.R;
import com.example.duan1.activity.CachTinhBMIActivity;
import com.example.duan1.activity.ThemMT_DLActivity;

public class TinhToanFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tinh_toan, container, false);

        final EditText edt_tt_Name = view.findViewById(R.id.edt_tt_Name);
        final EditText edt_tt_Age = view.findViewById(R.id.edt_tt_Age);
        final EditText edt_tt_Sex = view.findViewById(R.id.edt_tt_Sex);
        final EditText edt_tt_Height = view.findViewById(R.id.edt_tt_Height);
        final EditText edt_tt_Weight = view.findViewById(R.id.edt_tt_Weight);
        final TextView tv_tt_ShowBMI = view.findViewById(R.id.tv_tt_ShowBMI);
        final TextView tv_tt_ShowStatus = view.findViewById(R.id.tv_tt_ShowStatus);
        final TextView tv_tt_ShowComment = view.findViewById(R.id.tv_tt_ShowComment);
        Button btn_tt_TinhToan = view.findViewById(R.id.btn_tt_TinhToan);
        CardView cvRestart = view.findViewById(R.id.cvRefresh);
        CardView cvNext_DMT = view.findViewById(R.id.cvNext_DMT);
        CardView cvNext_BMI = view.findViewById(R.id.cvNext_BMI);


        cvRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_tt_Name.setText("");
                edt_tt_Age.setText("");
                edt_tt_Sex.setText("");
                edt_tt_Height.setText("");
                edt_tt_Weight.setText("");
            }
        });

        cvNext_DMT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ThemMT_DLActivity.class);
                startActivity(intent);
            }
        });
        cvNext_BMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CachTinhBMIActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
