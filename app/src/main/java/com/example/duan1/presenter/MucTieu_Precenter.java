package com.example.duan1.presenter;

import com.example.duan1.inteface.MucTieu_Interface;

public class MucTieu_Precenter {
    private MucTieu_Interface mucTieu_interface;

    public MucTieu_Precenter(MucTieu_Interface mucTieu_interface) {
        this.mucTieu_interface = mucTieu_interface;
    }

    public void setJob_sGetUp(boolean x) {
        mucTieu_interface.setJob_sGetUp(x);
    }

    public void setJob_sBedTime(boolean x) {
        mucTieu_interface.setJob_sBedTime(x);
    }

    public void setJob_sMeal(boolean x) {
        mucTieu_interface.setJob_sMeal(x);

    }

    public void setJob_sDrink(boolean x) {
        mucTieu_interface.setJob_sDrink(x);

    }

    public void setJob_sExercise(boolean x) {

        mucTieu_interface.setJob_sExercise(x);
    }

    public void setJob_imgMtAdd() {
        mucTieu_interface.setJob_imgMtAdd();

    }

    public void setJob_imgLHAdd() {
        mucTieu_interface.setJobImgLHAdd();
    }
}
