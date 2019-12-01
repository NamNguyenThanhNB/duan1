package com.example.duan1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
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

        holder.tvRvndDate.setText(nguoiDungList.get(position).getDate());
        holder.tvRvndBmi.setText(nguoiDungList.get(position).getBMI()+"");
        holder.tvRvndWeight.setText(nguoiDungList.get(position).getWeight());
        holder.tvRvndHeight.setText(nguoiDungList.get(position).getHeight());
    }

    @Override
    public int getItemCount() {
        return nguoiDungList.size();
    }
}
