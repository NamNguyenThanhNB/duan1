package com.example.duan1.presenter;

import com.example.duan1.inteface.CSCTActivity_Interface;

public class CSCTActivity_Precenter {
    private CSCTActivity_Interface csct_Activity_interface;

    public CSCTActivity_Precenter(CSCTActivity_Interface csct_Activity_interface) {
        this.csct_Activity_interface = csct_Activity_interface;
    }

    public void setJob_ln_csct_Update() {
        csct_Activity_interface.setJob_ln_csct_Update();
    }


    public void setJob_cv_csct_Weight() {
        csct_Activity_interface.setJob_cv_csct_Weight();

    }


    public void setJob_cv_csct_SoSanh() {
        csct_Activity_interface.setJob_cv_csct_SoSanh();

    }


    public void setJobcv_csct_HoatDong() {
        csct_Activity_interface.setJobcv_csct_HoatDong();

    }
}
