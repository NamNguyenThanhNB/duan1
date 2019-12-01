package com.example.duan1.presenter;

import android.util.Log;

import com.example.duan1.inteface.ThucPham_Interface;

public class ThucPham_Precenter {
    private ThucPham_Interface thucPham_interface;

    public ThucPham_Precenter(ThucPham_Interface thucPham_interface) {

        this.thucPham_interface = thucPham_interface;
    }

    public void setJob_addFood() {
        thucPham_interface.setJob_addFood();

    }

    public void setJob_tvTpShowComment() {
        thucPham_interface.setJob_tvTpShowComment();
    }

    public void setJob_rvTpMuch() {
        thucPham_interface.setJob_rvTpMuch();
    }

    public void setJob_rvTpLimit() {
        thucPham_interface.setJob_rvTpLimit();
    }

    public void setJob_rvTpNo() {
        thucPham_interface.setJob_rvTpNo();
    }
}
