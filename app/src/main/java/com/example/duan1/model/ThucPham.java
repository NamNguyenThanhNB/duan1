package com.example.duan1.model;

public class ThucPham {
    public String tenTP;
    public String loaiTP;
    public String chedoTP;

    public ThucPham() {
    }
    public ThucPham(String tenTP, String loaiTP, String chedoTP) {
        this.tenTP = tenTP;
        this.loaiTP = loaiTP;
        this.chedoTP = chedoTP;
    }
    public String getTenTP() {
        return tenTP;
    }

    public void setTenTP(String tenTP) {
        this.tenTP = tenTP;
    }

    public String getLoaiTP() {
        return loaiTP;
    }

    public void setLoaiTP(String loaiTP) {
        this.loaiTP = loaiTP;
    }

    public String getChedoTP() {
        return chedoTP;
    }

    public void setChedoTP(String chedoTP) {
        this.chedoTP = chedoTP;
    }


}
