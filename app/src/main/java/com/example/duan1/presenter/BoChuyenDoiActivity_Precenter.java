package com.example.duan1.presenter;

import com.example.duan1.inteface.BoChuyenDoiActivity_Interface;

public class BoChuyenDoiActivity_Precenter {

    private BoChuyenDoiActivity_Interface boChuyenDoiActivity_interface;

    public BoChuyenDoiActivity_Precenter(BoChuyenDoiActivity_Interface boChuyenDoiActivity_interface) {
        this.boChuyenDoiActivity_interface = boChuyenDoiActivity_interface;
    }

    public void createSpinner() {
        boChuyenDoiActivity_interface.createSpinner();
    }
    public void setJob_btnChuyenHeight() {
        boChuyenDoiActivity_interface.setJob_btnChuyenHeight();
    }

    public void setJob_btnChuyenWeight() {
        boChuyenDoiActivity_interface.setJob_btnChuyenWeight();
    }

}
