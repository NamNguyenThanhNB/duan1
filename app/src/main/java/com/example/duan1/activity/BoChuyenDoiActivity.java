package com.example.duan1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.duan1.R;

public class BoChuyenDoiActivity extends AppCompatActivity {

    private Spinner spnStart_height, spnEnd_height, spnStart_weight, spnEnd_weight;
    //Tạo một mảng dữ liệu giả
    String arr[] = {
            "millimeter(mm)",
            "centimeter(cm)",
            "meter(m)",
            "kilometer(km)"};
    String arr1[] = {
            "miligam(mg)",
            "gam(g)",
            "kilôgam(kg)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bo_chuyen_doi);

         Toolbar toolbar = findViewById(R.id.toolbarBCD);
        toolbar.setTitle("Bộ Chuyển Đổi");
        setSupportActionBar(toolbar);

        //hien thi nut back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        //Lấy đối tượng Spinner ra
        spnStart_height = (Spinner) findViewById(R.id.spnStart_height);
        spnEnd_height = (Spinner) findViewById(R.id.spnEnd_height);
        spnStart_weight = (Spinner) findViewById(R.id.spnStart_weight);
        spnEnd_weight = (Spinner) findViewById(R.id.spnEnd_weight);
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
}
