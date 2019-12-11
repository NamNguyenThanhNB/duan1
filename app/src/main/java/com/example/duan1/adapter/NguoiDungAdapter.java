package com.example.duan1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.adapters.AdapterViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;
import com.example.duan1.model.NguoiDung;

import java.util.List;

public class NguoiDungAdapter extends RecyclerView.Adapter<NguoiDungHolder> {

    private Context context;
    private List<NguoiDung> nguoiDungList;

    public NguoiDungAdapter(Context context, List<NguoiDung> nguoiDungList) {
        this.context = context;
        this.nguoiDungList = nguoiDungList;
    }

    @NonNull
    @Override
    public NguoiDungHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_nd, parent, false);
        NguoiDungHolder nguoiDungHolder = new NguoiDungHolder(view);
        return nguoiDungHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NguoiDungHolder holder, int position) {
        holder.imgIcon.setImageResource(R.drawable.chisocothe);
        NguoiDung nguoiDung = nguoiDungList.get(position);
        String bmi = nguoiDung.tinhBMI();
        holder.tvRvndDate.setText("Ngày cập nhật: " + nguoiDungList.get(position).getNgaydangND());
        holder.tvRvndBmi.setText("BMI: " + bmi);
        holder.tvRvndWeight.setText("C.nặng: " + nguoiDungList.get(position).getCannang() + " Kg");
        holder.tvRvndHeight.setText("C.cao: " + nguoiDungList.get(position).getChieucao() + " Cm");
    }

    @Override
    public int getItemCount() {
        return nguoiDungList.size();
    }
}
