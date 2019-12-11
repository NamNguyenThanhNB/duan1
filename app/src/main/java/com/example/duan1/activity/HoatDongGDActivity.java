package com.example.duan1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.duan1.R;

public class HoatDongGDActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoat_dong_gd);
        Toolbar toolbar = findViewById(R.id.toolbarHDGD);
        toolbar.setTitle("Hoạt Động Gần Đây");
        setSupportActionBar(toolbar);

    }
}
