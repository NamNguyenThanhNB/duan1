package com.example.duan1.presenter;

import android.util.Log;

import com.example.duan1.inteface.MHChinh_Inteface;
import com.example.duan1.inteface.ThucPham_Interface;

public class ThucPham_Precenter {
    private MHChinh_Inteface mhChinhInteface;

    public ThucPham_Precenter(MHChinh_Inteface mhChinhInteface) {

        this.mhChinhInteface = mhChinhInteface;
    }

    public void setJob_addFood() {
        mhChinhInteface.setJob_addFood();

    }


    public void setJob_rvTpMuch() {
        mhChinhInteface.setJob_rvTpMuch();
    }

    public void setJob_rvTpLimit() {
        mhChinhInteface.setJob_rvTpLimit();
    }

    public void setJob_rvTpNo() {
        mhChinhInteface.setJob_rvTpNo();
    }
}
