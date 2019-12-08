package com.example.duan1.model;

import android.text.format.DateFormat;
import android.util.Log;
import android.widget.ImageView;

import com.example.duan1.R;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NguoiDung {
    public int maND;
    public String tenND;
    public String ngaysinh;
    public String gioitinh;
    public String chieucao;
    public String cannang;
    public String anh;
    public String ngaydangND;

    public String getTuoiND() {
        return tuoiND;
    }

    public void setTuoiND(String tuoiND) {
        this.tuoiND = tuoiND;
    }

    public String tuoiND;

    public NguoiDung() {
    }

    public NguoiDung(int maND, String tenND, String ngaysinh, String gioitinh, String chieucao, String cannang, String anh, String ngaydangND) {
        this.maND = maND;
        this.tenND = tenND;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.chieucao = chieucao;
        this.cannang = cannang;
        this.anh = anh;
        this.ngaydangND = ngaydangND;
    }

    public int getMaND() {
        return maND;
    }

    public void setMaND(int maND) {
        this.maND = maND;
    }

    public String getTenND() {
        return tenND;
    }

    public void setTenND(String tenND) {
        this.tenND = tenND;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getChieucao() {
        return chieucao;
    }

    public void setChieucao(String chieucao) {
        this.chieucao = chieucao;
    }

    public String getCannang() {
        return cannang;
    }

    public void setCannang(String cannang) {
        this.cannang = cannang;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getNgaydangND() {
        return ngaydangND;
    }

    public void setNgaydangND(String ngaydangND) {
        this.ngaydangND = ngaydangND;
    }

    public double tinhBMI(double w, double h) {
        double bmi = -1;
        try {
            bmi = w / (h * h);
            if (bmi < 1) {
                bmi = bmi * 10000;
            }
        } catch (Exception e) {
            Log.e("ND", "data not found");
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return Double.parseDouble(decimalFormat.format(bmi));
    }

    public String setStatus(double statusBMI) {
        String statuss = null;
        try {

            if (statusBMI < 18.5) {
                statuss = "Gầy";
            } else if (statusBMI < 24.9) {
                statuss = ("Bình thường");
            } else if (statusBMI <= 25) {
                statuss = ("Thừa cân");
            } else if (statusBMI < 29.9) {
                statuss = ("Tiền béo phì");
            } else if (statusBMI < 34.9) {
                statuss = ("Béo phì độ I");
            } else if (statusBMI < 39.9) {
                statuss = ("Béo phì độ II");
            } else {
                statuss = ("Béo phì độ III");
            }
        } catch (Exception e) {
            Log.e("NguoiDung", " Status is not found");
        }
        return statuss;
    }

    public String ngayHienTai() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
        dateFormatter.setLenient(false);
        Date today = new Date();
        String date = dateFormatter.format(today);
        return date;
    }


}
