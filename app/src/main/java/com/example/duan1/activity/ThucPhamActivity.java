package com.example.duan1.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1.R;
import com.example.duan1.databinding.ActivityThucPhamBinding;
import com.example.duan1.inteface.MHChinh_Inteface;
import com.example.duan1.inteface.ThucPham_Interface;
import com.example.duan1.presenter.ThucPham_Precenter;

public class ThucPhamActivity extends AppCompatActivity implements MHChinh_Inteface {
    private TextView tvTpShowComment;
    private ImageView addFood;
    private RecyclerView rvTpMuch;
    private RecyclerView rvTpLimit;
    private RecyclerView rvTpNo;

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

        tvTpShowComment = (TextView) findViewById(R.id.tv_tp_ShowComment);
        addFood = (ImageView) findViewById(R.id.addFood);
        rvTpMuch = (RecyclerView) findViewById(R.id.rv_tp_much);
        rvTpLimit = (RecyclerView) findViewById(R.id.rv_tp_limit);
        rvTpNo = (RecyclerView) findViewById(R.id.rv_tp_no);

        ThucPham_Precenter thucPham_precenter = new ThucPham_Precenter(this);
        activityThucPhamBinding.setThucphamprecenter(thucPham_precenter);
    }

    @Override
    public void setJob_cvMhcWeight() {

    }

    @Override
    public void setJob_cvMhcBMI() {

    }

    @Override
    public void setJob_cvMhcNextFood() {

    }

    @Override
    public void setJob_cvMhcNextExercise() {

    }

    @Override
    public void setJob_addFood() {
        Toast.makeText(ThucPhamActivity.this, "show dialog for add foods", Toast.LENGTH_SHORT).show();

        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setView(R.layout.dialog_add_food);
        final AlertDialog dialog = alertDialog.show();

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
