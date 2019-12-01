package com.example.duan1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1.R;
import com.example.duan1.databinding.ActivityNdBinding;
import com.example.duan1.inteface.NDActivity_Interface;
import com.example.duan1.presenter.NDActivity_Precenter;

public class ND_Activity extends AppCompatActivity implements NDActivity_Interface {
    private TextView tvCnndDate;
    private EditText edtCnndName;
    private EditText edtCnndBirthday;
    private EditText edtCnndSex;
    private TextView tvTtHeight;
    private EditText edtCnndHeight;
    private TextView tvTtWeight;
    private EditText edtCnndWeight;
    private Button btnCnndRefresh;
    private Button btnCnndCA;
    private Button btnCnndFinish;
    private ImageView imgCnndFollow;
    private NDActivity_Precenter nd_Activity_precenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNdBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_nd);
        Toolbar toolbar = findViewById(R.id.toolbarTCN_ND);
        toolbar.setTitle("Người Dùng");
        setSupportActionBar(toolbar);
        init();
        //hien thi nut back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        nd_Activity_precenter = new NDActivity_Precenter(this);

        binding.setNdprecenter(nd_Activity_precenter);
    }

    void init() {

        tvCnndDate = (TextView) findViewById(R.id.tv_cnnd_date);
        edtCnndName = (EditText) findViewById(R.id.edt_cnnd_name);
        edtCnndBirthday = (EditText) findViewById(R.id.edt_cnnd_birthday);
        edtCnndSex = (EditText) findViewById(R.id.edt_cnnd_sex);
        tvTtHeight = (TextView) findViewById(R.id.tv_tt_Height);
        edtCnndHeight = (EditText) findViewById(R.id.edt_cnnd_Height);
        tvTtWeight = (TextView) findViewById(R.id.tv_tt_Weight);
        edtCnndWeight = (EditText) findViewById(R.id.edt_cnnd_Weight);
        btnCnndRefresh = (Button) findViewById(R.id.btn_cnnd_refresh);
        btnCnndCA = (Button) findViewById(R.id.btn_cnnd_CA);
        btnCnndFinish = (Button) findViewById(R.id.btn_cnnd_finish);
        imgCnndFollow = (ImageView) findViewById(R.id.img_cnnd_follow);


    }

    @Override
    public void setJob_btn_cnnd_refresh() {
        Toast.makeText(this, "setJob_btn_cnnd_refresh", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setJob_btn_cnnd_CA() {
        Toast.makeText(this, "setJob_btn_cnnd_CA", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setJob_btn_cnnd_finish() {
        Toast.makeText(this, "setJob_btn_cnnd_finish", Toast.LENGTH_SHORT).show();
    }
}
