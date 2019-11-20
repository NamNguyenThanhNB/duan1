package com.example.duan1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.duan1.R;
import com.example.duan1.fragment.MoRongFragment;

public class ThuVienActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thu_vien);
        Toolbar toolbar = findViewById(R.id.toolbarTV);

        toolbar.setTitle("Thư viện");
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
    }
}
