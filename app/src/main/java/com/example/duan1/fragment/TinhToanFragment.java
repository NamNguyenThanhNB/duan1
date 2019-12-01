package com.example.duan1.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.duan1.R;
import com.example.duan1.activity.CachTinhBMIActivity;
import com.example.duan1.activity.ThemMT_DLActivity;
import com.example.duan1.databinding.FragmentTinhToanBinding;
import com.example.duan1.inteface.TinhToan_Interface;
import com.example.duan1.model.NguoiDung;
import com.example.duan1.presenter.TinhToan_Precenter;

import java.text.DecimalFormat;

public class TinhToanFragment extends Fragment implements TinhToan_Interface {

    private EditText edtTtName;
    private EditText edtTtAge;
    private EditText edtTtSex;
    private EditText edtTtHeight;
    private EditText edtTtWeight;
    private Button btnTtTinhToan;
    private CardView cvTtRefresh;
    private CardView cvTtNextDMT;
    private CardView cvTtNextBMI;
    private TextView tvTtShowBMI;
    private TextView tvTtShowStatus;
    private TextView tvTtShowComment;

    private TinhToan_Precenter tinhToan_precenter;
    private FragmentTinhToanBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tinh_toan, container, false);
        init();
        tinhToan_precenter = new TinhToan_Precenter(this);
        binding.setTinhtoanprecenter(tinhToan_precenter);

        return binding.getRoot();
    }

    private void init() {

        edtTtName = (EditText) binding.getRoot().findViewById(R.id.edt_tt_Name);
        edtTtAge = (EditText) binding.getRoot().findViewById(R.id.edt_tt_Age);
        edtTtSex = (EditText) binding.getRoot().findViewById(R.id.edt_tt_Sex);
        edtTtHeight = (EditText) binding.getRoot().findViewById(R.id.edt_tt_Height);
        edtTtWeight = (EditText) binding.getRoot().findViewById(R.id.edt_tt_Weight);

        btnTtTinhToan = (Button) binding.getRoot().findViewById(R.id.btn_tt_TinhToan);

        cvTtRefresh = (CardView) binding.getRoot().findViewById(R.id.cv_tt_Refresh);
        cvTtNextDMT = (CardView) binding.getRoot().findViewById(R.id.cv_tt_NextDMT);
        cvTtNextBMI = (CardView) binding.getRoot().findViewById(R.id.cv_tt_NextBMI);

        tvTtShowBMI = (TextView) binding.getRoot().findViewById(R.id.tv_tt_ShowBMI);
        tvTtShowStatus = (TextView) binding.getRoot().findViewById(R.id.tv_tt_ShowStatus);
        tvTtShowComment = (TextView) binding.getRoot().findViewById(R.id.tv_tt_ShowComment);
    }

    @Override
    public void setJob_btn_tt_TinhToan() {
        NguoiDung nguoiDung = new NguoiDung();
        nguoiDung.setName(edtTtName.getText().toString().trim());
        nguoiDung.setSex(edtTtSex.getText().toString().trim());
        nguoiDung.setAge(edtTtAge.getText().toString().trim());
        nguoiDung.setHeight(edtTtHeight.getText().toString().trim());
        nguoiDung.setWeight(edtTtWeight.getText().toString().trim());

        double tinh = tinhToan_precenter.tinhtoan(nguoiDung);
        if (tinh > 0) {

            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            tvTtShowBMI.setText("Chỉ số BMI: " + decimalFormat.format(tinh));
            tinhToan_precenter.setStatusBMI(tinh);
        }
    }

    @Override
    public void setJob_cv_tt_Refresh() {
        edtTtAge.setText("");
        edtTtHeight.setText("");
        edtTtName.setText("");
        edtTtSex.setText("");
        edtTtWeight.setText("");

        tvTtShowBMI.setText("Chỉ số BMI: ");
        tvTtShowComment.setText("");
        tvTtShowStatus.setText("Trạng thái cơ thể: ");
    }

    @Override
    public void setJob_cv_tt_NextDMT() {
        Intent intent = new Intent(getActivity(), ThemMT_DLActivity.class);
        startActivity(intent);

    }

    @Override
    public void setJob_cv_tt_NextBMI() {
        Intent intent = new Intent(getActivity(), CachTinhBMIActivity.class);
        startActivity(intent);

    }

    @Override
    public void setError_EmptyName() {
        edtTtName.setError("Tên không được để trống");
        edtTtName.requestFocus();
    }

    @Override
    public void setError_EmptyAge() {
        edtTtAge.setError("Tuổi không được để trống");
        edtTtAge.requestFocus();
    }

    @Override
    public void setError_AgeNotIsNumber() {
        edtTtAge.setError("Tuổi không đúng định dạng");
        edtTtAge.requestFocus();
    }

    @Override
    public void setError_HeightNotIsNumber() {
        edtTtHeight.setError("Chiều cao không đúng định dạng");
        edtTtHeight.requestFocus();
    }

    @Override
    public void setError_WeightNotIsNumber() {
        edtTtWeight.setError("Cân nặng không đúng định dạng");
        edtTtWeight.requestFocus();
    }

    @Override
    public void setError_falseAge() {
        edtTtAge.setError("Tuổi không được là số âm");
        edtTtAge.requestFocus();
    }

    @Override
    public void setError_falseWeight() {
        edtTtWeight.setError("Cân nặng không được là số âm");
        edtTtWeight.requestFocus();

    }

    @Override
    public void setError_falseHeight() {
        edtTtHeight.setError("Chiều cao không được là số âm");
        edtTtHeight.requestFocus();

    }

    @Override
    public void setError_EmptySex() {
        edtTtSex.setError("Giới tính không được để trống");
        edtTtSex.requestFocus();
    }

    @Override
    public void setError_EmptyWeight() {
        edtTtWeight.setError("Cân nặng không được để trống");
        edtTtWeight.requestFocus();
    }

    @Override
    public void setError_EmptyHeight() {
        edtTtHeight.setError("Chiều cao không được để trống");
        edtTtHeight.requestFocus();
    }

    @Override
    public void setStatusBMI(double statusBMI) {
        if (statusBMI < 18.5) {
            tvTtShowStatus.setText("Gầy");
        } else if (statusBMI < 24.9) {
            tvTtShowStatus.setText("Trạng thái cơ thể: " + "Bình thường");
        } else if (statusBMI <= 25) {
            tvTtShowStatus.setText("Trạng thái cơ thể: " + "Thừa cân");
        } else if (statusBMI < 29.9) {
            tvTtShowStatus.setText("Trạng thái cơ thể: " + "Tiền béo phì");
        } else if (statusBMI < 34.9) {
            tvTtShowStatus.setText("Trạng thái cơ thể: " + "Béo phì độ I");
        } else if (statusBMI < 39.9) {
            tvTtShowStatus.setText("Trạng thái cơ thể: " + "Béo phì độ II");
        } else {
            tvTtShowStatus.setText("Trạng thái cơ thể: " + "Béo phì độ III");
        }
    }
}
