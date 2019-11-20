package com.example.duan1.pager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.duan1.R;
import com.google.android.material.tabs.TabLayout;


public class MTDLFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mtdl_, container, false);

        TabLayout tabLayout = view.findViewById(R.id.tabs_MTDL);
        ViewPager pager = view.findViewById(R.id.pager_MTDL);
        MTDLPager mtDlPager = new MTDLPager(getActivity().getSupportFragmentManager());
        pager.setAdapter(mtDlPager);
        tabLayout.setupWithViewPager(pager);
        return view;
    }
}
