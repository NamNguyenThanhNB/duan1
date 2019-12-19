package com.example.duan1.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;
import com.example.duan1.activity.MainActivity;
import com.example.duan1.dao.ThucPhamDao;
import com.example.duan1.model.ThucPham;

import java.util.List;

public class ThucPhamAdapter extends RecyclerView.Adapter<ThucPhamHolder> {
    private Context context;
    private List<ThucPham> thucPhamList;
    private ThucPhamDao thucPhamDao;
    private ThucPhamAdapter thucPhamAdapter;

    public ThucPhamAdapter(Context context, List<ThucPham> thucPhamList) {
        this.context = context;
        this.thucPhamList = thucPhamList;
        thucPhamDao = new ThucPhamDao(context);
    }

    @NonNull
    @Override
    public ThucPhamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_tp, parent, false);
        ThucPhamHolder thucPhamHolder = new ThucPhamHolder(view);
        return thucPhamHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ThucPhamHolder holder, final int position) {
        holder.tvRvtpTenTP.setText(thucPhamList.get(position).getTenTP());
        holder.tvRvtpLoaiTP.setText(thucPhamList.get(position).getLoaiTP());


        holder.tvRvtpTenTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setView(R.layout.dialog_show_food);
                final AlertDialog dialog = alertDialog.show();

                final Button btnShowFoodUpdate;
                final Button btnShowFoodDel;
                final EditText edtShowFoodName;
                final EditText edtShowFoodType;
                final Spinner spnShowFoodLevel;

                btnShowFoodUpdate = (Button) dialog.findViewById(R.id.btn_showFood_update);
                btnShowFoodDel = (Button) dialog.findViewById(R.id.btn_showFood_del);
                edtShowFoodName = (EditText) dialog.findViewById(R.id.edt_showFood_Name);
                edtShowFoodType = (EditText) dialog.findViewById(R.id.edt_showFood_Type);
                spnShowFoodLevel = (Spinner) dialog.findViewById(R.id.spn_showFood_Level);

                edtShowFoodName.setEnabled(false);
                edtShowFoodName.setText(thucPhamList.get(position).getTenTP());
                edtShowFoodType.setText(thucPhamList.get(position).getLoaiTP());
                final String level = thucPhamList.get(position).getChedoTP();
                if (level.equalsIgnoreCase("được phép")) {
                    spnShowFoodLevel.setSelection(0);
                } else if (level.equalsIgnoreCase("hạn chế")) {
                    spnShowFoodLevel.setSelection(1);
                } else if (level.equalsIgnoreCase("không được")) {
                    spnShowFoodLevel.setSelection(2);
                }

                btnShowFoodUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String tentp = edtShowFoodName.getText().toString().trim();
                        final String loaitp = edtShowFoodType.getText().toString().trim();
                        final String chedo = spnShowFoodLevel.getSelectedItem().toString();

                        if (tentp.isEmpty()) {
                            edtShowFoodName.setError("Nhập tên thưc phẩm cần sửa");
                            edtShowFoodName.requestFocus();
                        } else if (loaitp.isEmpty()) {
                            edtShowFoodType.setError("Nhập loại thực phẩm cần sửa");
                            edtShowFoodType.requestFocus();
                        } else {
                            ThucPham thucPham = new ThucPham(tentp, loaitp, chedo);
                            boolean result = thucPhamDao.updateTP(thucPham);
                            if (result) {
//                                thucPhamList.get(position).setTenTP(tentp);
                                thucPhamList.get(position).setLoaiTP(loaitp);
                                thucPhamList.get(position).setChedoTP(chedo);
                                notifyDataSetChanged();
                                Intent intent = new Intent(context, MainActivity.class);
                                context.startActivity(intent);
                            } else {
                                Toast.makeText(context, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });

                btnShowFoodDel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean result = thucPhamDao.deleteTP(thucPhamList.get(position).getTenTP());
                        if (result) {
                            thucPhamList.remove(position);
                            notifyDataSetChanged();
                            dialog.dismiss();
                        } else {
                            Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {


                boolean result = thucPhamDao.deleteTP(thucPhamList.get(position).getTenTP());
                if (result) {
                    thucPhamList.remove(position);
                    notifyDataSetChanged();
                } else {

                    Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return thucPhamList.size();
    }
}
