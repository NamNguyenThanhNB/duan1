package com.example.duan1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1.R;
import com.example.duan1.dao.NguoidungDao;
import com.example.duan1.databinding.ActivitySoSanhTsBinding;
import com.example.duan1.inteface.SSTSActivity_Interface;
import com.example.duan1.model.NguoiDung;
import com.example.duan1.presenter.SSTSActivity_Precenter;

import java.util.ArrayList;
import java.util.List;

public class SoSanhTSActivity extends AppCompatActivity implements SSTSActivity_Interface {
    private TextView tvSsName;
    private EditText edtSsBirthday;
    private EditText edtSsSex;
    private Spinner spn_ssts_01;
    private EditText edtSsHeight1;
    private EditText edtSsWeight1;
    private TextView tvSsBmi1;
    private Spinner spn_ssts_02;
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
        final ActivitySoSanhTsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_so_sanh_ts);
        Toolbar toolbar = findViewById(R.id.toolbarSSTS);
        toolbar.setTitle("So Sánh Thông Số");
        setSupportActionBar(toolbar);
        init();

        final NguoidungDao nguoidungDao = new NguoidungDao(this);
        List<NguoiDung> nguoiDungList = nguoidungDao.selectND();


        int size = nguoiDungList.size();
        String arr[] = new String[size];
        for (int i = 0; i < size; i++) {
            arr[i] = nguoiDungList.get(i).getNgaydangND();
        }

        //Gán Data source (arr) vào Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (
                        this,
                        android.R.layout.simple_spinner_item,
                        arr
                );
        //phải gọi lệnh này để hiển thị danh sách cho Spinner
        adapter.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);

        spn_ssts_01.setAdapter(adapter);
        spn_ssts_02.setAdapter(adapter);

        ssts_activityPrecenter = new SSTSActivity_Precenter(this);
        binding.setSstsprecenter(ssts_activityPrecenter);

        List<NguoiDung> ndl = nguoidungDao.selectND();
        NguoiDung nguoiDung = ndl.get(ndl.size() - 1);
        binding.setNguoidungView(nguoiDung);

        spn_ssts_01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                NguoiDung nguoiDung01 = nguoidungDao.selectNDbyDate(spn_ssts_01.getSelectedItem().toString());
                binding.setNguoidungView01(nguoiDung01);
                Toast.makeText(SoSanhTSActivity.this, nguoiDung01.getMaND() + " " + nguoiDung01.getTenND(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spn_ssts_02.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                NguoiDung nguoiDung02 = nguoidungDao.selectNDbyDate(spn_ssts_02.getSelectedItem().toString());
                Toast.makeText(SoSanhTSActivity.this, nguoiDung02.getMaND() + " " + nguoiDung02.getTenND(), Toast.LENGTH_SHORT).show();
                binding.setNguoidungView02(nguoiDung02);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    void init() {

        tvSsName = (TextView) findViewById(R.id.tv_ss_name);
        edtSsBirthday = (EditText) findViewById(R.id.edt_ss_birthday);
        edtSsSex = (EditText) findViewById(R.id.edt_ss_sex);
        spn_ssts_01 = (Spinner) findViewById(R.id.spn_ssts_01);
        edtSsHeight1 = (EditText) findViewById(R.id.edt_ss_height_1);
        edtSsWeight1 = (EditText) findViewById(R.id.edt_ss_weight_1);
        tvSsBmi1 = (TextView) findViewById(R.id.tv_ss_bmi_1);
        spn_ssts_02 = (Spinner) findViewById(R.id.spn_ssts_02);
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
