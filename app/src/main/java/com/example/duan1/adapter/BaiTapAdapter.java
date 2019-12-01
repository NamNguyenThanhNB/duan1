package com.example.duan1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;
import com.example.duan1.model.BaiTap;
import com.example.duan1.model.NguoiDung;

import java.util.List;

public class BaiTapAdapter extends RecyclerView.Adapter<BaiTapHolder> {
    private Context context;
    private List<BaiTap> baiTapList;

    public BaiTapAdapter(Context context, List<BaiTap> baiTapList) {
        this.context = context;
        this.baiTapList = baiTapList;
    }

    @NonNull
    @Override
    public BaiTapHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_nd, parent, false);
        BaiTapHolder baiTapHolder = new BaiTapHolder(view);
        return baiTapHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaiTapHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return baiTapList.size();
    }
}
