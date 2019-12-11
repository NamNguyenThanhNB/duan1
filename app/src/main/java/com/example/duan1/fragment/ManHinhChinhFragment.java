package com.example.duan1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;
import com.example.duan1.adapter.ThucPhamAdapter;
import com.example.duan1.dao.NguoidungDao;
import com.example.duan1.dao.ThucPhamDao;
import com.example.duan1.databinding.FragmentManHinhChinhBinding;
import com.example.duan1.inteface.MHChinh_Inteface;
import com.example.duan1.model.NguoiDung;
import com.example.duan1.model.ThucPham;
import com.example.duan1.presenter.MHChinh_Precenter;
import com.example.duan1.presenter.ThucPham_Precenter;

import java.util.List;

public class ManHinhChinhFragment extends Fragment implements MHChinh_Inteface {

    private MHChinh_Precenter mhChinhPrecenter;
    private FragmentManHinhChinhBinding binding;
    private ThucPhamDao thucPhamDao;
    private ThucPhamAdapter thucPhamAdapter;
    private ThucPham_Precenter thucPham_precenter;
    private RecyclerView rvMhcMt;
    private RecyclerView rvMhcDl;
    private RecyclerView rvTpMuch;
    private RecyclerView rvTpLimit;
    private RecyclerView rvTpNo;

    private NguoidungDao nguoidungDao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_man_hinh_chinh, container, false);
        thucPhamDao = new ThucPhamDao(getActivity());
        nguoidungDao = new NguoidungDao(getActivity());
        mhChinhPrecenter = new MHChinh_Precenter(this);
        init();
        List<NguoiDung> nguoiDungList = nguoidungDao.selectND();

        int size = nguoiDungList.size();
        NguoiDung nguoiDung = nguoiDungList.get(size - 1);
        binding.setNguoidungView(nguoiDung);
        binding.setMhcprecenter(mhChinhPrecenter);


        thucPham_precenter = new ThucPham_Precenter(this);
        thucPham_precenter.setJob_rvTpMuch();
        thucPham_precenter.setJob_rvTpLimit();
        thucPham_precenter.setJob_rvTpNo();


        binding.setThucphamprecenter(thucPham_precenter);
        binding.setNguoidungView((nguoiDung));

        return binding.getRoot();
    }


    private void init() {

        rvMhcMt = (RecyclerView) binding.getRoot().findViewById(R.id.rv_mhc_mt);
        rvMhcDl = (RecyclerView) binding.getRoot().findViewById(R.id.rv_mhc_dl);
        rvTpMuch = (RecyclerView) binding.getRoot().findViewById(R.id.rv_tp_much);
        rvTpLimit = (RecyclerView) binding.getRoot().findViewById(R.id.rv_tp_limit);
        rvTpNo = (RecyclerView) binding.getRoot().findViewById(R.id.rv_tp_no);
    }


    @Override
    public void setJob_addFood() {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setView(R.layout.dialog_add_food);
        final AlertDialog dialog = alertDialog.show();
        Button btn_addFood;
        final EditText edtAddFoodName;
        final EditText edtAddFoodType;
        final Spinner spnAddFoodLevel;
        final Button btnAddFoodRefresh;
        final Button btnAddFoodExit;

        btnAddFoodRefresh = (Button) dialog.findViewById(R.id.btn_addFood_refresh);
        btnAddFoodExit = (Button) dialog.findViewById(R.id.btn_addFood_exit);
        btn_addFood = (Button) dialog.findViewById(R.id.btn_addFood);

        edtAddFoodName = (EditText) dialog.findViewById(R.id.edt_addFood_Name);
        edtAddFoodType = (EditText) dialog.findViewById(R.id.edt_addFood_Type);
        spnAddFoodLevel = (Spinner) dialog.findViewById(R.id.spn_addFood_Level);

        btn_addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameFood = edtAddFoodName.getText().toString().trim();
                String type = edtAddFoodType.getText().toString().trim();
                String level = spnAddFoodLevel.getSelectedItem().toString().trim();

                if (nameFood.isEmpty()) {
                    edtAddFoodName.setError("hãy nhập tên thực phẩm");
                    edtAddFoodName.requestFocus();
                } else if (type.isEmpty()) {
                    edtAddFoodType.setError("hãy nhập loại thực phẩm");
                    edtAddFoodType.requestFocus();
                } else {
                    ThucPham thucPham = new ThucPham(nameFood, type, level);
                    boolean result = thucPhamDao.insertTP(thucPham);

                    if (result == true) {
                        Toast.makeText(getActivity(), "true:" + result, Toast.LENGTH_SHORT).show();
                        List<ThucPham> thucPhamList_Much = thucPhamDao.selectThucPham("Được phép");
                        List<ThucPham> thucPhamList_limit = thucPhamDao.selectThucPham("Hạn chế");
                        List<ThucPham> thucPhamList_no = thucPhamDao.selectThucPham("Không được");

                        ThucPhamAdapter thucPhamAdapter_much = new ThucPhamAdapter(getActivity(), thucPhamList_Much);
                        ThucPhamAdapter thucPhamAdapter_limit = new ThucPhamAdapter(getActivity(), thucPhamList_limit);
                        ThucPhamAdapter thucPhamAdapter_no = new ThucPhamAdapter(getActivity(), thucPhamList_no);

                        rvTpMuch.setAdapter(thucPhamAdapter_much);
                        rvTpLimit.setAdapter(thucPhamAdapter_limit);
                        rvTpNo.setAdapter(thucPhamAdapter_no);


                        edtAddFoodName.setText("");
                        edtAddFoodType.setText("");
                        spnAddFoodLevel.setSelection(0);
                    } else {
                        Toast.makeText(getActivity(), "false:" + result, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnAddFoodExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnAddFoodRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtAddFoodName.setText("");
                edtAddFoodType.setText("");
                spnAddFoodLevel.setSelection(0);
            }
        });
    }


    @Override
    public void setJob_rvTpMuch() {
        List<ThucPham> thucPhamList_Much = thucPhamDao.selectThucPham("Được phép");

        thucPhamAdapter = new ThucPhamAdapter(getActivity(), thucPhamList_Much);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rvTpMuch.setLayoutManager(linearLayoutManager);
        rvTpMuch.setAdapter(thucPhamAdapter);
    }

    @Override
    public void setJob_rvTpLimit() {

        List<ThucPham> thucPhamList = thucPhamDao.selectThucPham("Hạn chế");

        thucPhamAdapter = new ThucPhamAdapter(getActivity(), thucPhamList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rvTpLimit.setLayoutManager(linearLayoutManager);
        rvTpLimit.setAdapter(thucPhamAdapter);

    }

    @Override
    public void setJob_rvTpNo() {

        List<ThucPham> thucPhamList = thucPhamDao.selectThucPham("Không được");

        thucPhamAdapter = new ThucPhamAdapter(getActivity(), thucPhamList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rvTpNo.setLayoutManager(linearLayoutManager);
        rvTpNo.setAdapter(thucPhamAdapter);

    }

}

