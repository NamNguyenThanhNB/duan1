package com.example.duan1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.duan1.R;
import com.example.duan1.adapter.NguoiDungAdapter;
import com.example.duan1.fragment.MoRongFragment;
import com.example.duan1.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class ThuVienActivity extends AppCompatActivity {
    private List<NguoiDung> nguoiDungList;
    private NguoiDungAdapter nguoiDungAdapter;
    private RecyclerView rvList_ND;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thu_vien);
        Toolbar toolbar = findViewById(R.id.toolbarTV);

        toolbar.setTitle("Thư viện");

        rvList_ND = findViewById(R.id.rvList_ND);
        setSupportActionBar(toolbar);
        //hien thi nut back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//        ImageView imgBack_01 = findViewById(R.id.imgBack_01);
//        imgBack_01.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ThuVienActivity.this, MoRongFragment.class);
//                startActivity(intent);
//            }
//        });

        nguoiDungList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            NguoiDung nguoiDung = new NguoiDung();
            nguoiDung.setName("nam " + i);
            nguoiDung.setWeight("58");
            nguoiDung.setHeight("165");
            nguoiDung.setDate("20/11/2019");

            nguoiDungList.add(nguoiDung);
        }
        nguoiDungAdapter = new NguoiDungAdapter(this, nguoiDungList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvList_ND.setLayoutManager(linearLayoutManager);
        rvList_ND.setAdapter(nguoiDungAdapter);

    }
}
