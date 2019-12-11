package com.example.duan1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.duan1.R;

public class CachTinhBMIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cach_tinh_bmi);
        Toolbar toolbar = findViewById(R.id.toolbarTBMI);
        toolbar.setTitle("Cách Tính Chỉ Số BMI");
        setSupportActionBar(toolbar);



    }
}
