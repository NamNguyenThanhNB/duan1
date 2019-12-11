package com.example.duan1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duan1.dao.NguoidungDao;
import com.example.duan1.model.NguoiDung;
import com.example.duan1.presenter.MHChao_Presenter;
import com.example.duan1.R;
import com.example.duan1.inteface.MHChao_Interface;

import java.util.List;

public class ManHinhChaoActivity extends AppCompatActivity implements MHChao_Interface {
    private MHChao_Presenter MHChao_Presenter;
    private NguoidungDao nguoidungDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chao);

        MHChao_Presenter = new MHChao_Presenter(this);
        MHChao_Presenter.nextScreen();
    }

    @Override
    public void nextScreen() {
        final Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    Toast.makeText(ManHinhChaoActivity.this, "Error", Toast.LENGTH_SHORT).show();
                } finally {
                    nguoidungDao = new NguoidungDao(ManHinhChaoActivity.this);
                    List<NguoiDung> nguoiDungList = nguoidungDao.selectND();
                    if (nguoiDungList.size() == 0) {
                        Intent intent = new Intent(ManHinhChaoActivity.this, ND_Activity.class);
                        startActivity(intent);
                    } else {

                        Intent intent = new Intent(ManHinhChaoActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        };
        thread.start();
    }
}
