package com.example.duan1.presenter;

import com.example.duan1.inteface.CaiDat_Interface;

public class CaiDat_Precenter {

    private CaiDat_Interface caiDat_interface;

    public CaiDat_Precenter(CaiDat_Interface caiDat_interface) {
        this.caiDat_interface = caiDat_interface;
    }


    public void setJob_s_cd_nn_can(boolean x) {
        caiDat_interface.setJob_s_cd_nn_can(x);
    }


    public void setJob_s_cd_nn_chuongbao(boolean x) {
        caiDat_interface.setJob_s_cd_nn_chuongbao(x);
    }
}
