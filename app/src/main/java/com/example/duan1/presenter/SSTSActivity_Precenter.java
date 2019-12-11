package com.example.duan1.presenter;

import com.example.duan1.dao.NguoidungDao;
import com.example.duan1.inteface.SSTSActivity_Interface;

public class SSTSActivity_Precenter {
    private SSTSActivity_Interface ssts_Activity_interface;
    public SSTSActivity_Precenter(SSTSActivity_Interface ssts_Activity_interface) {
        this.ssts_Activity_interface = ssts_Activity_interface;
    }

    public void setJob_btn_ssts_finish() {
        ssts_Activity_interface.setJob_btn_ssts_finish();
    }
}
