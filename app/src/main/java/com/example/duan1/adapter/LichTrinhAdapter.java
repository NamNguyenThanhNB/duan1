package com.example.duan1.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;
import com.example.duan1.activity.MainActivity;
import com.example.duan1.activity.ThemMT_DLActivity;
import com.example.duan1.dao.LichTrinhDao;
import com.example.duan1.dao.MucTieuDao;
import com.example.duan1.model.LichTrinh;
import com.example.duan1.model.MucTieu;

import java.util.Calendar;
import java.util.List;

public class LichTrinhAdapter extends RecyclerView.Adapter<LichTrinhHolder> {
    private Context context;
    private List<LichTrinh> lichTrinhList;
    private LichTrinhDao lichTrinhDao;
    private int x=0;
    private boolean check = false;

    public LichTrinhAdapter(Context context, List<LichTrinh> lichTrinhList) {
        this.context = context;
        this.lichTrinhList = lichTrinhList;
        lichTrinhDao = new LichTrinhDao(context);
    }

    public LichTrinhAdapter(Context context, List<LichTrinh> lichTrinhList, int x, boolean check) {
        this.context = context;
        this.lichTrinhList = lichTrinhList;
        this.x = x;
        this.check = check;
    }

    @NonNull
    @Override
    public LichTrinhHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_mt, parent, false);
        LichTrinhHolder lichTrinhHolder = new LichTrinhHolder(view);
        return lichTrinhHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final LichTrinhHolder holder, final int position) {

        Calendar calendar = Calendar.getInstance();

        // Lấy ra năm - tháng - ngày hiện tại
        int tyear = calendar.get(calendar.YEAR);
        final int tmonth = calendar.get(calendar.MONTH) + 1;
        int tday = calendar.get(calendar.DAY_OF_MONTH);
        String todayS = tday + "/" + tmonth + "/" + tyear;

            if (lichTrinhList.get(position).getTgdienraLT().equalsIgnoreCase(todayS)) {
                holder.tv_tb.setTextColor(Color.RED);
                holder.tv_tb.setText("Hôm nay");
            }


            holder.tv_s.setVisibility(View.GONE);
            holder.tv_e.setText("Thời gian diễn ra: ");
            holder.tvRvmtTitle.setText(lichTrinhList.get(position).getTenLT());
            holder.tvRvmtSTime.setVisibility(View.GONE);
            holder.tvRvdlSTime.setText(lichTrinhList.get(position).getTgdienraLT());
            holder.tvRvmtTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                    alertDialog.setView(R.layout.dialog_show_mtdl);
                    final AlertDialog dialog = alertDialog.show();
                    final TextView tvShowMTDL;
                    final EditText edtMtdlShowTitle;
                    final LinearLayout lnMtdlShowDL;
                    final LinearLayout lnMtdlShowMT;
                    final EditText edtMtdlShowStartDL;
                    final EditText edtMtdlContentShow;
                    final LinearLayout lnMtdlShowDel;
                    final LinearLayout lnMtdlShowUpdate;
                    final TextView tvTGDR_mtdl;

                    tvTGDR_mtdl = (TextView) dialog.findViewById(R.id.tvTGDR_mtdl);
                    tvShowMTDL = (TextView) dialog.findViewById(R.id.tv_showMTDL_);
                    edtMtdlShowTitle = (EditText) dialog.findViewById(R.id.edt_mtdlShow_title);
                    lnMtdlShowDL = (LinearLayout) dialog.findViewById(R.id.ln_mtdlShow_DL);
                    lnMtdlShowMT = (LinearLayout) dialog.findViewById(R.id.ln_mtdlShow_MT);
                    edtMtdlContentShow = (EditText) dialog.findViewById(R.id.edt_mtdl_contentShow);
                    edtMtdlShowStartDL = (EditText) dialog.findViewById(R.id.edt_mtdlShow_startDL);
                    lnMtdlShowDel = (LinearLayout) dialog.findViewById(R.id.ln_mtdlShow_del);
                    lnMtdlShowUpdate = (LinearLayout) dialog.findViewById(R.id.ln_mtdlShow_update);

                    tvShowMTDL.setText("TÊN LỊCH TRÌNH");
                    lnMtdlShowMT.setVisibility(View.GONE);
                    edtMtdlShowTitle.setEnabled(false);
                    edtMtdlShowTitle.setText(lichTrinhList.get(position).getTenLT());
                    edtMtdlShowStartDL.setText(lichTrinhList.get(position).getTgdienraLT());
                    edtMtdlContentShow.setText(lichTrinhList.get(position).getNoidungLT());

                    if (!check) {
                        edtMtdlShowStartDL.setOnLongClickListener(new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View v) {
                                final AlertDialog.Builder alertDialog_dp = new AlertDialog.Builder(context);
                                alertDialog_dp.setView(R.layout.dialog_select_date);
                                final AlertDialog dialog_dp = alertDialog_dp.show();
                                DatePicker dpCalendar = dialog_dp.findViewById(R.id.dpCalendar);
                                Calendar calendar = Calendar.getInstance();

                                // Lấy ra năm - tháng - ngày hiện tại
                                int year = calendar.get(calendar.YEAR);
                                final int month = calendar.get(calendar.MONTH);
                                int day = calendar.get(calendar.DAY_OF_MONTH);

                                // Khởi tạo sự kiện lắng nghe khi DatePicker thay đổi
                                dpCalendar.init(year, month, day, new DatePicker.OnDateChangedListener() {
                                    @Override
                                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                        Toast.makeText(context, dayOfMonth + "-" + (monthOfYear + 1) + "-" + year, Toast.LENGTH_SHORT).show();
                                        String sDL = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                        edtMtdlShowStartDL.setText(sDL);
                                        dialog_dp.dismiss();
                                    }
                                });
                                return false;
                            }
                        });

                        lnMtdlShowUpdate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String title = edtMtdlShowTitle.getText().toString().trim();
                                String dlStart = edtMtdlShowStartDL.getText().toString().trim();
                                String content = edtMtdlContentShow.getText().toString().trim();

                                LichTrinh lichTrinh = new LichTrinh(title, content, dlStart);
                                boolean result = lichTrinhDao.updateLT(lichTrinh);
                                if (result) {

                                    lichTrinhList.get(position).setTenLT(title);
                                    lichTrinhList.get(position).setNoidungLT(content);
                                    lichTrinhList.get(position).setTgdienraLT(dlStart);
                                    if (!holder.tv_tb.getText().toString().isEmpty()) {
                                        Intent intent = new Intent(context, MainActivity.class);
                                        context.startActivity(intent);
                                    } else {
                                        notifyDataSetChanged();
                                        dialog.dismiss();
                                    }
                                } else {
                                    Toast.makeText(context, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                                }
                            }

                        });
                        lnMtdlShowDel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                boolean result = lichTrinhDao.deleteLT(lichTrinhList.get(position).getTenLT());
                                if (result) {
                                    lichTrinhList.remove(position);
                                    if (!holder.tv_tb.getText().toString().isEmpty()) {
                                        Intent intent = new Intent(context, MainActivity.class);
                                        context.startActivity(intent);
                                    } else {
                                        notifyDataSetChanged();
                                        dialog.dismiss();
                                    }
                                } else {

                                    Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    } else {
                        LinearLayout linearLayout = dialog.findViewById(R.id.linearLayout);
                        linearLayout.setVisibility(View.GONE);
                        edtMtdlContentShow.setEnabled(false);
                        edtMtdlShowStartDL.setEnabled(false);
                    }
                }
            });
            if (!check) {

                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {

                        boolean result = lichTrinhDao.deleteLT(lichTrinhList.get(position).getTenLT());
                        if (result) {
                            lichTrinhList.remove(position);
                            if (!holder.tv_tb.getText().toString().isEmpty()) {
                                Intent intent = new Intent(context, MainActivity.class);
                                context.startActivity(intent);
                            } else {
                                notifyDataSetChanged();
                            }
                        } else {

                            Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
            }
        }

    @Override
    public int getItemCount() {
        if (check) {
            return x;
        } else {
            return lichTrinhList.size();
        }
    }
}
