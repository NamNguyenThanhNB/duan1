package com.example.duan1.presenter;

import com.example.duan1.inteface.MTDLActivity_Interface;

public class MTDLActivity_Precenter {
    private MTDLActivity_Interface mtdlActivity_interface;

    public MTDLActivity_Precenter(MTDLActivity_Interface mtdlActivity_interface) {
        this.mtdlActivity_interface = mtdlActivity_interface;
    }

    public void setJob_sMtdlNotify(boolean x) {
        mtdlActivity_interface.setJob_sMtdlNotify(x);
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
