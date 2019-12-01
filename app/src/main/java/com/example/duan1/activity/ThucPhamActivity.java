package com.example.duan1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1.R;
import com.example.duan1.databinding.ActivityThucPhamBinding;
import com.example.duan1.inteface.ThucPham_Interface;
import com.example.duan1.presenter.ThucPham_Precenter;

public class ThucPhamActivity extends AppCompatActivity implements ThucPham_Interface {
    private TextView tvTpShowComment;
    private ImageView addFood;
    private RecyclerView rvTpMuch;
    private RecyclerView rvTpLimit;
    private RecyclerView rvTpNo;
    private ThucPham_Precenter thucPham_precenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThucPhamBinding activityThucPhamBinding = DataBindingUtil.setContentView(this, R.layout.activity_thuc_pham);
        Toolbar toolbar = findViewById(R.id.toolbarTP);
        toolbar.setTitle("Thực Phẩm");
        setSupportActionBar(toolbar);

        //hien thi nut back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        thucPham_precenter = new ThucPham_Precenter(this);

        tvTpShowComment = (TextView) findViewById(R.id.tv_tp_ShowComment);
        addFood = (ImageView) findViewById(R.id.addFood);
        rvTpMuch = (RecyclerView) findViewById(R.id.rv_tp_much);
        rvTpLimit = (RecyclerView) findViewById(R.id.rv_tp_limit);
        rvTpNo = (RecyclerView) findViewById(R.id.rv_tp_no);

        activityThucPhamBinding.setThucphamprecenter(thucPham_precenter);
    }

    @Override
    public void setJob_addFood() {
        Toast.makeText(ThucPhamActivity.this, "show dialog for add foods", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setJob_tvTpShowComment() {

    }

    @Override
    public void setJob_rvTpMuch() {

    }

    @Override
    public void setJob_rvTpLimit() {

    }

    @Override
    public void setJob_rvTpNo() {

    }
}
