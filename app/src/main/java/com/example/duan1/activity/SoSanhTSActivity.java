package com.example.duan1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1.R;
import com.example.duan1.inteface.SSTSActivity_Interface;
import com.example.duan1.presenter.SSTSActivity_Precenter;

public class SoSanhTSActivity extends AppCompatActivity implements SSTSActivity_Interface {
    private TextView tvSsName;
    private EditText edtSsBirthday;
    private EditText edtSsSex;
    private TextView tvSsDate01;
    private EditText edtSsHeight1;
    private EditText edtSsWeight1;
    private TextView tvSsBmi1;
    private TextView tvSsDate02;
    private EditText edtSsHeight2;
    private EditText edtSsWeight2;
    private TextView tvSsBmi2;
    private Button btnSstsFinish;
    private TextView tvSsTdcn;
    private TextView tvSsTdcc;
    private SSTSActivity_Precenter ssts_activityPrecenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_so_sanh_ts);
        Toolbar toolbar = findViewById(R.id.toolbarSSTS);
        toolbar.setTitle("So Sánh Thông Số");
        setSupportActionBar(toolbar);
        init();
        //hien thi nut back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ssts_activityPrecenter = new SSTSActivity_Precenter(this);

        btnSstsFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ssts_activityPrecenter.setJob_btn_ssts_finish();
            }
        });
    }

    void init() {

        tvSsName = (TextView) findViewById(R.id.tv_ss_name);
        edtSsBirthday = (EditText) findViewById(R.id.edt_ss_birthday);
        edtSsSex = (EditText) findViewById(R.id.edt_ss_sex);
        tvSsDate01 = (TextView) findViewById(R.id.tv_ss_date01);
        edtSsHeight1 = (EditText) findViewById(R.id.edt_ss_height_1);
        edtSsWeight1 = (EditText) findViewById(R.id.edt_ss_weight_1);
        tvSsBmi1 = (TextView) findViewById(R.id.tv_ss_bmi_1);
        tvSsDate02 = (TextView) findViewById(R.id.tv_ss_date02);
        edtSsHeight2 = (EditText) findViewById(R.id.edt_ss_height_2);
        edtSsWeight2 = (EditText) findViewById(R.id.edt_ss_weight_2);
        tvSsBmi2 = (TextView) findViewById(R.id.tv_ss_bmi_2);
        btnSstsFinish = (Button) findViewById(R.id.btn_ssts_finish);
        tvSsTdcn = (TextView) findViewById(R.id.tv_ss_tdcn);
        tvSsTdcc = (TextView) findViewById(R.id.tv_ss_tdcc);
    }

    @Override
    public void setJob_btn_ssts_finish() {
        Toast.makeText(this, "setJob_btn_ssts_finish", Toast.LENGTH_SHORT).show();
    }
}
