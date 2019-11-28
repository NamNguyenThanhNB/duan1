package com.example.duan1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.duan1.R;
import com.example.duan1.inteface.MTDLActivity_Interface;
import com.example.duan1.presenter.MTDLActivity_Precenter;

public class ThemMT_DLActivity extends AppCompatActivity implements MTDLActivity_Interface {
    private EditText edtMtdlTitle;
    private EditText edtMtdlStart;
    private EditText edtMtdlEnd;
    private Switch sMtdlNotify;
    private ImageView imgMtdlRefresh;
    private ImageView imgMtdlDelete;
    private ImageView imgMtdlAdd;
    private EditText edtMtdlContent;
    private MTDLActivity_Precenter mtdlActivity_precenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_mt__dl);
        Toolbar toolbar = findViewById(R.id.toolbarMTDL);
        toolbar.setTitle("Mục Tiêu - Đặt Lịch");
        setSupportActionBar(toolbar);

        //hien thi nut back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        init();
        mtdlActivity_precenter = new MTDLActivity_Precenter(this);
        sMtdlNotify.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mtdlActivity_precenter.setJob_sMtdlNotify(isChecked);
            }
        });

        imgMtdlRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtdlActivity_precenter.setJob_imgMtdlRefresh();
            }
        });

        imgMtdlDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtdlActivity_precenter.setJob_imgMtdlDelete();
            }
        });

        imgMtdlAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtdlActivity_precenter.setJob_imgMtdlAdd();
            }
        });
    }

    private void init() {
        edtMtdlTitle = (EditText) findViewById(R.id.edt_mtdl_title);
        edtMtdlStart = (EditText) findViewById(R.id.edt_mtdl_start);
        edtMtdlEnd = (EditText) findViewById(R.id.edt_mtdl_end);
        sMtdlNotify = (Switch) findViewById(R.id.s_mtdl_notify);
        imgMtdlRefresh = (ImageView) findViewById(R.id.img_mtdl_refresh);
        imgMtdlDelete = (ImageView) findViewById(R.id.img_mtdl_delete);
        imgMtdlAdd = (ImageView) findViewById(R.id.img_mtdl_add);
        edtMtdlContent = (EditText) findViewById(R.id.edt_mtdl_content);
    }

    @Override
    public void setJob_sMtdlNotify(boolean x) {
        if (x) {
            Toast.makeText(this, "setJob_sMtdlNotify is on", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "setJob_sMtdlNotify is off", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setJob_imgMtdlRefresh() {
        edtMtdlTitle.setText("");
        edtMtdlStart.setText("");
        edtMtdlEnd.setText("");
        edtMtdlContent.setText("");
    }

    @Override
    public void setJob_imgMtdlDelete() {
        Toast.makeText(this, "delete if had data", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setJob_imgMtdlAdd() {
        Toast.makeText(this, "add", Toast.LENGTH_SHORT).show();
    }
}
