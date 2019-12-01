package com.example.duan1.model;

import android.text.format.DateFormat;
import android.util.Log;
import android.widget.ImageView;

import com.example.duan1.R;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NguoiDung {
    public int id;
    public String name;
    public String birth;
    public String age;
    public String sex;
    public String weight;
    public String height;
    public String date;
    public String status;
    public double BMI;


    public NguoiDung() {
    }

    public NguoiDung(int id, String name, String age, String sex, String weight, String height) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
    }

    public String getbmi() {
        return String.valueOf(BMI);
    }

    public String getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getBMI() {
        return BMI;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }


    public double setBMI_(NguoiDung nguoiDung) {
        double bmi = -1;
        try {

            double w = Double.parseDouble(nguoiDung.getWeight());
            double h = Double.parseDouble(nguoiDung.getHeight());
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

    public String setStatus_(NguoiDung nguoiDung) {
        String statuss = null;
        try {
            double statusBMI = nguoiDung.getBMI();

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

    public String setDate_() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
        dateFormatter.setLenient(false);
        Date today = new Date();
        String date = dateFormatter.format(today);
        return date;
    }


}
