package com.example.duan1.pager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.duan1.fragment.ChiSoCoTheFragment;
import com.example.duan1.fragment.DatLich_Fragment;
import com.example.duan1.fragment.ManHinhChinhFragment;
import com.example.duan1.fragment.MoRongFragment;
import com.example.duan1.fragment.MucTieuFragment;
import com.example.duan1.fragment.MucTieu_Fragment;
import com.example.duan1.fragment.TinhToanFragment;


public class MTDLPager extends FragmentStatePagerAdapter {
    public MTDLPager(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            MucTieu_Fragment mucTieu_fragment = new MucTieu_Fragment();
            return mucTieu_fragment;
        } else {
            DatLich_Fragment datLich_fragment = new DatLich_Fragment();
            return datLich_fragment;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Mục Tiêu";
        } else {
            return "Đặt Lịch";
        }
    }


    @Override
    public int getCount() {
        return 2;
    }
}
