package com.example.duan1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1.R;
import com.example.duan1.databinding.ActivityTheoDoiCnBinding;
import com.example.duan1.inteface.CNCNActivity_Interface;
import com.example.duan1.presenter.CNCNActivity_Precenter;
import com.github.mikephil.charting.charts.CombinedChart;

public class TheoDoiCNActivity extends AppCompatActivity implements CNCNActivity_Interface {
    private CombinedChart combinedChartCSCT;
    private TextView tvCncnDate;
    private EditText edtCncnWeight;
    private TextView tvCncnCnlt;
    private TextView tvCncnBmi;
    private TextView tvCncnMin;
    private TextView tvCncnMax;
    private Button btnCncnFinish;
    private CNCNActivity_Precenter cncn_Activity_precenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTheoDoiCnBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_theo_doi_cn);
        Toolbar toolbar = findViewById(R.id.toolbarTDCN);
        toolbar.setTitle("Theo Dõi Cân Nặng");
        setSupportActionBar(toolbar);
        init();
        //hien thi nut back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        cncn_Activity_precenter = new CNCNActivity_Precenter(this);

        binding.setTdcnprecenter(cncn_Activity_precenter);
    }

    void init() {
        combinedChartCSCT = (CombinedChart) findViewById(R.id.combinedChart_CSCT);
        tvCncnDate = (TextView) findViewById(R.id.tv_cncn_date);
        edtCncnWeight = (EditText) findViewById(R.id.edt_cncn_weight);
        tvCncnCnlt = (TextView) findViewById(R.id.tv_cncn_cnlt);
        tvCncnBmi = (TextView) findViewById(R.id.tv_cncn_bmi);
        tvCncnMin = (TextView) findViewById(R.id.tv_cncn_min);
        tvCncnMax = (TextView) findViewById(R.id.tv_cncn_max);
        btnCncnFinish = (Button) findViewById(R.id.btn_cncn_finish);
    }

    @Override
    public void setJob_btn_cncn_finish() {
        Toast.makeText(this, "setJob_btn_cncn_finish", Toast.LENGTH_SHORT).show();
    }
}
