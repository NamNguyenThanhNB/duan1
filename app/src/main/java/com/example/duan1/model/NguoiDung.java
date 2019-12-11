package com.example.duan1.model;

import android.util.Log;

import com.example.duan1.R;

import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    public NguoiDung(String tenND, String ngaysinh, String gioitinh, String chieucao, String cannang, String anh, String ngaydangND) {
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

    public String tinhBMI() {

        Double w = Double.parseDouble(getCannang());
        Double h = Double.parseDouble(getChieucao());
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
        return String.valueOf(decimalFormat.format(bmi));
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

    public int selectSex() {
        if (getGioitinh().equalsIgnoreCase("Nam")) {
            return 0;
        } else return 1;
    }

    public String sStatus() {
        Double w = Double.parseDouble(getCannang());
        Double h = Double.parseDouble(getChieucao());
        double bmi = -1;
        try {
            bmi = w / (h * h);
            if (bmi < 1) {
                bmi = bmi * 10000;
            }
        } catch (Exception e) {
            Log.e("ND", "data not found");
        }
        double statusBMI = bmi;
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

    public String CNLT() {
        double solecc = 0;
        try {
            double cc = Integer.parseInt(getChieucao());

            if (cc < 100) {
                solecc = cc;
            } else if (cc < 200) {
                solecc = cc - 100;
            } else if (cc < 300) {
                solecc = cc - 200;
            } else if (cc < 400) {
                solecc = cc - 300;
            }
        } catch (Exception e) {
            Log.e("asd", "" + e);
        }
        Double x = solecc * 9 / 10;
        return String.valueOf(x) + " Kg";
    }

    public String CTD() {
        double solecc = 0;
        try {

            int cc = Integer.parseInt(getChieucao());
            if (cc < 100) {
                solecc = cc;
            } else if (cc < 200) {
                solecc = cc - 100;
            } else if (cc < 300) {
                solecc = cc - 200;
            } else if (cc < 400) {
                solecc = cc - 300;
            }
        } catch (Exception e) {
            Log.e("asd", "" + e);
        }
        return String.valueOf(solecc) + " Kg";
    }

    public String CTT() {
        double solecc = 0;
        try {

            int cc = Integer.parseInt(getChieucao());
            if (cc < 100) {
                solecc = cc;
            } else if (cc < 200) {
                solecc = cc - 100;
            } else if (cc < 300) {
                solecc = cc - 200;
            } else if (cc < 400) {
                solecc = cc - 300;
            }
        } catch (Exception e) {
            Log.e("asd", "" + e);
        }
        Double x = solecc * 8 / 10;
        return String.valueOf(x) + " Kg";
    }


    public String tinhTuoi() {

        Calendar currentDate;
        int cday, cmonth, cyear;
        int bday, bmonth, byear;
        //getting the current date
        currentDate = Calendar.getInstance();
        cday = currentDate.get(Calendar.DATE);
        cmonth = currentDate.get(Calendar.MONTH) + 1;
        cyear = currentDate.get(Calendar.YEAR);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        ParsePosition pos = new ParsePosition(0);
        Date birhDate = simpleDateFormat.parse(getNgaysinh(), pos);
        Log.e("ádd", currentDate + " --- " + birhDate);

        char[] arr = getNgaysinh().toCharArray();
        int t = arr.length;
        String a1 = String.valueOf(arr[t - 4]);
        String a2 = String.valueOf(arr[t - 3]);
        String a3 = String.valueOf(arr[t - 2]);
        String a4 = String.valueOf(arr[t - 1]);
        String a = a1 + a2 + a3 + a4;
        bday = birhDate.getDate();
        bmonth = birhDate.getMonth() + 1;
        byear = Integer.parseInt(a);
        Log.e("1", cday + " --- " + cmonth + " --- " + cyear);
        Log.e("2", bday + " --- " + bmonth + " --- " + a);
        int agey = cyear - byear;
        int agem = cmonth - bmonth;
        int aged = cday - bday;

        aged = aged < 0 ? (aged * -1) : aged;
        String resultMessage = "";
        if (agem < 0) {
            resultMessage = (agem * -1) + " month " + aged + " days " + agey + " years old";
        } else {
            resultMessage = String.valueOf(agey);
        }

        return resultMessage;
    }

    public int sSex() {
        if (getGioitinh().equalsIgnoreCase("nam")) {
            return R.drawable.male;
        } else return R.drawable.female;
    }
}
