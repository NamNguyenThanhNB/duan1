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


public class BAHFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_, container, false);

        TabLayout tabLayout = view.findViewById(R.id.tabs);
        ViewPager pager = view.findViewById(R.id.pager);
        BAHPager BAHPager = new BAHPager(getActivity().getSupportFragmentManager());
        pager.setAdapter(BAHPager);
        tabLayout.setupWithViewPager(pager);

        tabLayout.getTabAt(0).setCustomView(R.layout.pager_item_csct);
        tabLayout.getTabAt(1).setCustomView(R.layout.pager_item_muctieu);
        tabLayout.getTabAt(2).select();
        tabLayout.getTabAt(2).setCustomView(R.layout.pager_item_home);
        tabLayout.getTabAt(3).setCustomView(R.layout.pager_item_tinhtoan);
        tabLayout.getTabAt(4).setCustomView(R.layout.pager_item_morong);


        return view;
    }


}
