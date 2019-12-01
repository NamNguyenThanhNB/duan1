package com.example.duan1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.duan1.R;
import com.example.duan1.databinding.ActivityBoChuyenDoiBinding;
import com.example.duan1.inteface.BoChuyenDoiActivity_Interface;
import com.example.duan1.presenter.BoChuyenDoiActivity_Precenter;

public class BoChuyenDoiActivity extends AppCompatActivity implements BoChuyenDoiActivity_Interface {

    private Spinner spnStart_height, spnEnd_height, spnStart_weight, spnEnd_weight;
    private EditText edtStartHeight;
    private EditText edtEndHeight;
    private Button btnChuyenHeight;
    private EditText edtStartWeight;
    private EditText edtEndWeight;
    private Button btnChuyenWeight;

    private BoChuyenDoiActivity_Precenter boChuyenDoiActivity_precenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBoChuyenDoiBinding activityBoChuyenDoiBinding = DataBindingUtil.setContentView(this, R.layout.activity_bo_chuyen_doi);


        Toolbar toolbar = findViewById(R.id.toolbarBCD);
        toolbar.setTitle("Bộ Chuyển Đổi");
        setSupportActionBar(toolbar);
        //hien thi nut back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        edtStartHeight = (EditText) findViewById(R.id.edt_Start_height);
        edtEndHeight = (EditText) findViewById(R.id.edt_End_height);
        btnChuyenHeight = (Button) findViewById(R.id.btn_Chuyen_height);
        edtStartWeight = (EditText) findViewById(R.id.edt_Start_weight);
        edtEndWeight = (EditText) findViewById(R.id.edt_End_weight);
        btnChuyenWeight = (Button) findViewById(R.id.btn_Chuyen_weight);

        //Lấy đối tượng Spinner ra
        spnStart_height = (Spinner) findViewById(R.id.spnStart_height);
        spnEnd_height = (Spinner) findViewById(R.id.spnEnd_height);
        spnStart_weight = (Spinner) findViewById(R.id.spnStart_weight);
        spnEnd_weight = (Spinner) findViewById(R.id.spnEnd_weight);
        boChuyenDoiActivity_precenter = new BoChuyenDoiActivity_Precenter(this);
        boChuyenDoiActivity_precenter.createSpinner();
        activityBoChuyenDoiBinding.setBcdprecenter(boChuyenDoiActivity_precenter);
    }

    @Override
    public void createSpinner() {
        String arr[] = {
                "millimeter(mm)",
                "centimeter(cm)",
                "meter(m)",
                "kilometer(km)"};
        String arr1[] = {
                "miligam(mg)",
                "gam(g)",
                "kilôgam(kg)"};
        //Gán Data source (arr) vào Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (
                        this,
                        android.R.layout.simple_spinner_item,
                        arr
                );
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                (
                        this,
                        android.R.layout.simple_spinner_item,
                        arr1
                );

        //phải gọi lệnh này để hiển thị danh sách cho Spinner
        adapter.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        adapter1.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);

        //Thiết lập adapter cho Spinner
        spnStart_height.setAdapter(adapter);
        spnEnd_height.setAdapter(adapter);
        spnStart_weight.setAdapter(adapter1);
        spnEnd_weight.setAdapter(adapter1);
    }

    @Override
    public void setJob_btnChuyenHeight() {
        Toast.makeText(this, "setJob_btnChuyenHeight", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setJob_btnChuyenWeight() {
        Toast.makeText(this, "setJob_btnChuyenWeight", Toast.LENGTH_SHORT).show();
    }
}
