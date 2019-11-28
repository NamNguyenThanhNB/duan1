package com.example.duan1.presenter;

import com.example.duan1.inteface.CNCNActivity_Interface;

public class CNCNActivity_Precenter {
    private CNCNActivity_Interface cncn_Activity_interface;

    public CNCNActivity_Precenter(CNCNActivity_Interface cncn_Activity_interface) {
        this.cncn_Activity_interface = cncn_Activity_interface;
    }

    public void setJob_btn_cncn_finish() {
        cncn_Activity_interface.setJob_btn_cncn_finish();
    }
}
