package com.example.duan1.fragment;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
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
import com.example.duan1.activity.MainActivity;
import com.example.duan1.activity.ManHinhChaoActivity;
import com.example.duan1.activity.ND_Activity;
import com.example.duan1.activity.SoSanhTSActivity;
import com.example.duan1.activity.TheoDoiCNActivity;
import com.example.duan1.activity.ThuVienActivity;
import com.example.duan1.activity.ThucPhamActivity;
import com.example.duan1.dao.LichTrinhDao;
import com.example.duan1.dao.MucTieuDao;
import com.example.duan1.dao.NguoidungDao;
import com.example.duan1.dao.ThucPhamDao;
import com.example.duan1.database.BodyAndHealthyDatabase;
import com.example.duan1.databinding.FragmentMoRongBinding;
import com.example.duan1.inteface.MoRong_Interface;
import com.example.duan1.model.NguoiDung;
import com.example.duan1.presenter.MoRong_Precenter;

import java.util.List;

public class MoRongFragment extends Fragment implements MoRong_Interface {

    private MoRong_Precenter moRong_precenter;
    int verson1 = 0;

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
        verson1++;
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setView(R.layout.dialog_reset_data);
        final AlertDialog dialog = alertDialog.show();
        TextView textView = dialog.findViewById(R.id.textView);
        Button btn_reset_Ok = dialog.findViewById(R.id.btn_reset_Ok);
        Button btn_reset_Cancel = dialog.findViewById(R.id.btn_reset_Cancel);

        textView.setText("Bạn có chắc muốn xóa toàn bộ dữ liệu trong ứng dụng ?");
        btn_reset_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BodyAndHealthyDatabase dbHelper = new BodyAndHealthyDatabase(getActivity());
                SQLiteDatabase db = dbHelper.getReadableDatabase();

                try {

                    db.execSQL("DELETE FROM " + MucTieuDao.TABLE_NAME);
                    db.execSQL("DELETE FROM " + LichTrinhDao.TABLE_NAME);
                    db.execSQL("DELETE FROM " + NguoidungDao.TABLE_NAME);
                    db.execSQL("DELETE FROM " + ThucPhamDao.TABLE_NAME);

                } catch (SQLiteException e) {
                    e.printStackTrace();

                }

                final AlertDialog.Builder alertDialog1 = new AlertDialog.Builder(getActivity());
                alertDialog1.setView(R.layout.dialog_reset_data);
                final AlertDialog dialog1 = alertDialog1.show();
                TextView textView1 = dialog1.findViewById(R.id.textView);
                Button btn_reset_Ok1 = dialog1.findViewById(R.id.btn_reset_Ok);
                Button btn_reset_Cancel1 = dialog1.findViewById(R.id.btn_reset_Cancel);
                textView1.setText("Bạn muốn thoát hay khởi động lại ?");
                btn_reset_Ok1.setText("Khởi động lại");
                btn_reset_Ok1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Khoi tao lai Activity main
                        Intent intent = new Intent(getActivity().getApplicationContext(), ManHinhChaoActivity.class);
                        startActivity(intent);
                    }
                });
                btn_reset_Cancel1.setVisibility(View.GONE);
                btn_reset_Cancel1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Tao su kien ket thuc app
                        Intent startMain = new Intent(Intent.ACTION_MAIN);
                        startMain.addCategory(Intent.CATEGORY_HOME);
                        startActivity(startMain);
                        getActivity().finish();
                    }
                });
            }
        });
        btn_reset_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verson1--;
                dialog.dismiss();
            }
        });

    }
}
