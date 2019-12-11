package com.example.duan1.model;

public class LichTrinh {
    public String tenLT;
    public String noidungLT;
    public String tgdienraLT;

    public LichTrinh() {
    }

    public LichTrinh(String tenLT, String noidungLT, String tgdienraLT) {
        this.tenLT = tenLT;
        this.noidungLT = noidungLT;
        this.tgdienraLT = tgdienraLT;
    }

    public String getTenLT() {
        return tenLT;
    }

    public void setTenLT(String tenLT) {
        this.tenLT = tenLT;
    }

    public String getNoidungLT() {
        return noidungLT;
    }

    public void setNoidungLT(String noidungLT) {
        this.noidungLT = noidungLT;
    }

    public String getTgdienraLT() {
        return tgdienraLT;
    }

    public void setTgdienraLT(String tgdienraLT) {
        this.tgdienraLT = tgdienraLT;
    }
}
