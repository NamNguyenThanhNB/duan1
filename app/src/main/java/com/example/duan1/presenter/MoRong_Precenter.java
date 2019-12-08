package com.example.duan1.presenter;

import com.example.duan1.inteface.MoRong_Interface;

public class MoRong_Precenter {

    private MoRong_Interface moRong_interface;

    public MoRong_Precenter(MoRong_Interface moRong_interface) {
        this.moRong_interface = moRong_interface;
    }

    public void setJob_cvLibrary() {
        moRong_interface.setJob_cvLibrary();
    }


    public void setJob_cvConvert() {
        moRong_interface.setJob_cvConvert();
    }


    public void setJob_cvSetting() {
        moRong_interface.setJob_cvSetting();
    }


    public void setJob_cvW_MR() {
        moRong_interface.setJob_cvW_MR();
    }


    public void setJob_cvSS_MR() {
        moRong_interface.setJob_cvSS_MR();
    }


    public void setJob_cvReset() {
        moRong_interface.setJob_cvReset();
    }

}
