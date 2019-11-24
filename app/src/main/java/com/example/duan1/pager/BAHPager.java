package com.example.duan1.pager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.duan1.R;
import com.example.duan1.fragment.ChiSoCoTheFragment;
import com.example.duan1.fragment.ManHinhChinhFragment;
import com.example.duan1.fragment.MoRongFragment;
import com.example.duan1.fragment.MucTieuFragment;
import com.example.duan1.fragment.TinhToanFragment;


public class BAHPager extends FragmentStatePagerAdapter {
    public BAHPager(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.setPrimaryItem(container, position, object);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            ChiSoCoTheFragment chiSoCoTheFragment = new ChiSoCoTheFragment();
            return chiSoCoTheFragment;
        } else if (position == 1) {
            MucTieuFragment mucTieuFragment = new MucTieuFragment();
            return mucTieuFragment;
        } else if (position == 2) {
            ManHinhChinhFragment manHinhChinhFragment = new ManHinhChinhFragment();
            return manHinhChinhFragment;
        } else if (position == 3) {
            TinhToanFragment tinhToanFragment = new TinhToanFragment();
            return tinhToanFragment;
        } else {
            MoRongFragment moRongFragment = new MoRongFragment();
            return moRongFragment;
        }
    }


//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        if (position == 0) {
//            return "chỉ số";
//        } else if (position == 1) {
//            return "mục tiêu";
//        } else if (position == 2) {
//            return "";
//        } else if (position == 3) {
//            return "tính toán";
//        } else {
//            return "mở rộng";
//        }
//    }


    @Override
    public int getCount() {
        return 5;
    }
}
