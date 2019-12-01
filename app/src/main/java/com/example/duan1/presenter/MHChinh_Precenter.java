package com.example.duan1.presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.duan1.inteface.MHChinh_Inteface;
import com.example.duan1.model.NguoiDung;

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

    public void test() {
        Log.e("MHC_precenter", "ok");
    }

    public NguoiDung setInfo(NguoiDung nguoiDung) {
        NguoiDung nguoiDung1 = null;

//        if (nguoiDung.getSex().equalsIgnoreCase("nam") || nguoiDung.getSex().equalsIgnoreCase("male")) {
//            nguoiDung1.setSex("@drawable/male");
//        } else {
//            nguoiDung1.setSex("@drawable/female");
//        }
        nguoiDung1.setName("Hi, " + nguoiDung.name);
        nguoiDung1.setAge(nguoiDung.age);
        nguoiDung1.setHeight(nguoiDung.getHeight());
        nguoiDung1.setWeight(nguoiDung.getWeight());
        nguoiDung1.setBMI(nguoiDung.setBMI_(nguoiDung));
        nguoiDung1.setStatus(nguoiDung.setStatus_(nguoiDung));
        nguoiDung1.setDate(nguoiDung.setDate_());
        return nguoiDung1;

    }


}
