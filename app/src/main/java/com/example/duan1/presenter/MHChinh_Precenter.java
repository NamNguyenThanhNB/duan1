package com.example.duan1.presenter;

import com.example.duan1.inteface.MHChinh_Inteface;

public class MHChinh_Precenter {
    private MHChinh_Inteface mhChinhInteface;

    public MHChinh_Precenter(MHChinh_Inteface mhChinhInteface) {
        this.mhChinhInteface = mhChinhInteface;
    }

    public void setJob_cvMhcBMI() {
        mhChinhInteface.setJob_cvMhcBMI();
    }

    public void setJob_cvMhcNextExercise() {
        mhChinhInteface.setJob_cvMhcNextExercise();
    }

    public void setJob_cvMhcNextFood() {
        mhChinhInteface.setJob_cvMhcNextFood();
    }

    public void setJob_cvMhcWeight() {
        mhChinhInteface.setJob_cvMhcWeight();
    }

    public void setupChart() {
        mhChinhInteface.setupChart();
    }

}
