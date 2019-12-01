package com.example.duan1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.duan1.R;
import com.example.duan1.databinding.ActivityThemMtDlBinding;
import com.example.duan1.inteface.AddMTDLActivity_Interface;
import com.example.duan1.presenter.AddMTDLActivity_Precenter;

public class ThemMT_DLActivity extends AppCompatActivity implements AddMTDLActivity_Interface {
    private EditText edtMtdlTitle;
    private EditText edtMtdlStart;
    private EditText edtMtdlEnd;
    private Switch sMtdlNotify;
    private ImageView imgMtdlRefresh;
    private ImageView imgMtdlDelete;
    private ImageView imgMtdlAdd;
    private EditText edtMtdlContent;
    private AddMTDLActivity_Precenter mtdlActivity_precenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThemMtDlBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_them_mt__dl);
        Toolbar toolbar = findViewById(R.id.toolbarMTDL);
        toolbar.setTitle("Mục Tiêu - Đặt Lịch");
        setSupportActionBar(toolbar);

        //hien thi nut back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        init();
        mtdlActivity_precenter = new AddMTDLActivity_Precenter(this);


        binding.setAddMTDLprecenter(mtdlActivity_precenter);
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
