package com.example.duan1.presenter;

import android.util.Log;

import com.example.duan1.inteface.TinhToan_Interface;
import com.example.duan1.model.NguoiDung;

public class TinhToan_Precenter {

    private TinhToan_Interface tinhToan_interface;
    private double tinh;

    public TinhToan_Precenter(TinhToan_Interface tinhToan_interface) {
        this.tinhToan_interface = tinhToan_interface;
    }

    public double tinhtoan(NguoiDung nguoiDung) {


        if (nguoiDung.getName().isEmpty()) {
            tinhToan_interface.setError_EmptyName();
        } else if (nguoiDung.getAge().isEmpty()) {
            tinhToan_interface.setError_EmptyAge();
        } else if (Integer.parseInt(nguoiDung.getAge()) < 1) {
            try {
                tinhToan_interface.setError_falseAge();
            } catch (Exception e) {
                tinhToan_interface.setError_AgeNotIsNumber();
            }
        } else if (nguoiDung.getSex().isEmpty()) {
            tinhToan_interface.setError_EmptySex();
        } else if (nguoiDung.getHeight().isEmpty()) {
            tinhToan_interface.setError_EmptyHeight();
        } else if (Double.parseDouble(nguoiDung.getHeight()) < 1) {
            try {
                tinhToan_interface.setError_falseHeight();
            } catch (Exception e) {
                tinhToan_interface.setError_HeightNotIsNumber();
            }
        } else if (nguoiDung.getWeight().isEmpty()) {
            tinhToan_interface.setError_EmptyWeight();
        } else if (Double.parseDouble(nguoiDung.getWeight()) < 1) {
            try {
                tinhToan_interface.setError_falseWeight();
            } catch (Exception e) {
                tinhToan_interface.setError_WeightNotIsNumber();
            }
        } else {
            double weight = Double.parseDouble(nguoiDung.getWeight());
            double height = Double.parseDouble(nguoiDung.getHeight());
            tinh = weight / (height * height);

            if (tinh < 1) {
                tinh = tinh * 10000;
            }
        }
        return tinh;
    }

    public void setJob_btn_tt_TinhToan() {
        tinhToan_interface.setJob_btn_tt_TinhToan();
    }

    public void setJob_cv_tt_Refresh() {
        tinhToan_interface.setJob_cv_tt_Refresh();
    }


    public void setJob_cv_tt_NextDMT() {
        tinhToan_interface.setJob_cv_tt_NextDMT();
    }


    public void setJob_cv_tt_NextBMI() {
        tinhToan_interface.setJob_cv_tt_NextBMI();
    }

    public void setStatusBMI(double statusBMI) {
        tinhToan_interface.setStatusBMI(statusBMI);
    }
}
