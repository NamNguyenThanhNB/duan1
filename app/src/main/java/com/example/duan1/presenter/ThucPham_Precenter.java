package com.example.duan1.presenter;

import com.example.duan1.inteface.ThucPham_Interface;

public class ThucPham_Precenter {
    private ThucPham_Interface thucPham_interface;

    public ThucPham_Precenter(ThucPham_Interface thucPham_interface) {

        this.thucPham_interface = thucPham_interface;
    }

    public void setJob_addFood() {
        thucPham_interface.setJob_addFood();
    }
}
