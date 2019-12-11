package com.example.duan1.model;

public class MucTieu {

    public String tenMT;
    public String noidungMT;
    public String ngayBDMT;
    public String ngayKTMT;

    public MucTieu() {
    }

    public MucTieu(String tenMT, String noidungMT, String ngayBDMT, String ngayKTMT) {
        this.tenMT = tenMT;
        this.noidungMT = noidungMT;
        this.ngayBDMT = ngayBDMT;
        this.ngayKTMT = ngayKTMT;
    }

    public String getTenMT() {
        return tenMT;
    }

    public void setTenMT(String tenMT) {
        this.tenMT = tenMT;
    }

    public String getNoidungMT() {
        return noidungMT;
    }

    public void setNoidungMT(String noidungMT) {
        this.noidungMT = noidungMT;
    }

    public String getNgayBDMT() {
        return ngayBDMT;
    }

    public void setNgayBDMT(String ngayBDMT) {
        this.ngayBDMT = ngayBDMT;
    }

    public String getNgayKTMT() {
        return ngayKTMT;
    }

    public void setNgayKTMT(String ngayKTMT) {
        this.ngayKTMT = ngayKTMT;
    }
}
