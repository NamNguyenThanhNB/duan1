package com.example.duan1.presenter;

import com.example.duan1.inteface.AddMTDLActivity_Interface;

public class AddMTDLActivity_Precenter {
    private AddMTDLActivity_Interface mtdlActivity_interface;

    public AddMTDLActivity_Precenter(AddMTDLActivity_Interface mtdlActivity_interface) {
        this.mtdlActivity_interface = mtdlActivity_interface;
    }


    public void setJob_imgMtdlRefresh() {
        mtdlActivity_interface.setJob_imgMtdlRefresh();
    }

    public void setJob_imgMtdlDelete() {
        mtdlActivity_interface.setJob_imgMtdlDelete();
    }

    public void setJob_imgMtdlAdd() {
        mtdlActivity_interface.setJob_imgMtdlAdd();
    }
}
