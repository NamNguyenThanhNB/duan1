package com.example.duan1.presenter;

import com.example.duan1.inteface.NDActivity_Interface;

public class NDActivity_Precenter {

    private NDActivity_Interface nd_Activity_interface;

    public NDActivity_Precenter(NDActivity_Interface nd_Activity_interface) {
        this.nd_Activity_interface = nd_Activity_interface;
    }

    public void setJob_btn_cnnd_refresh() {
        nd_Activity_interface.setJob_btn_cnnd_refresh();
    }

    public void setJob_btn_cnnd_CA() {
        nd_Activity_interface.setJob_btn_cnnd_CA();

    }

    public void setJob_btn_cnnd_finish() {
        nd_Activity_interface.setJob_btn_cnnd_finish();

    }
}
