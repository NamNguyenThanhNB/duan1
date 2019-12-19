package com.example.duan1.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;
import com.example.duan1.activity.MainActivity;
import com.example.duan1.activity.ThemMT_DLActivity;
import com.example.duan1.dao.MucTieuDao;
import com.example.duan1.model.MucTieu;
import com.example.duan1.model.ThucPham;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MucTieuAdapter extends RecyclerView.Adapter<MucTieuHolder> {
    private Context context;
    private List<MucTieu> mucTieuList;
    private MucTieuDao mucTieuDao;
    private int x = 0;
    private boolean check = false;


    public MucTieuAdapter(Context context, List<MucTieu> mucTieuList) {
        this.context = context;
        this.mucTieuList = mucTieuList;
        mucTieuDao = new MucTieuDao(context);
    }

    public MucTieuAdapter(Context context, List<MucTieu> mucTieuList, int x, boolean check) {
        this.x = x;
        this.check = check;
        this.context = context;
        this.mucTieuList = mucTieuList;
        mucTieuDao = new MucTieuDao(context);
    }

    @NonNull
    @Override
    public MucTieuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_mt, parent, false);
        MucTieuHolder mucTieuHolder = new MucTieuHolder(view);
        return mucTieuHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MucTieuHolder holder, final int position) {

        holder.tv_tb.setTextColor(Color.RED);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        // Lấy ra năm - tháng - ngày hiện tại
        int tyear = calendar.get(calendar.YEAR);
        final int tmonth = calendar.get(calendar.MONTH) + 1;
        int tday = calendar.get(calendar.DAY_OF_MONTH);
        String todayS = tday + "/" + tmonth + "/" + tyear;
        Date mtS = null, day = null, mtE = null;
        try {
            mtE = simpleDateFormat.parse(mucTieuList.get(position).getNgayKTMT());
            mtS = simpleDateFormat.parse(mucTieuList.get(position).getNgayBDMT());
            day = simpleDateFormat.parse(todayS);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (mtS.before(day) && mtE.after(day)) {

            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();

            c1.setTime(mtS);
            c2.setTime(mtE);

            // Công thức tính số ngày giữa 2 mốc thời gian:
            long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
            holder.tv_tb.setText("Còn: " + noDay + " ngày");

        }
        if (mucTieuList.get(position).getNgayBDMT().equalsIgnoreCase(todayS)) {
            holder.tv_tb.setText("Hôm nay");
        }

        if (mtS.after(day) && position == 0) {
            holder.tv_tb.setText("Sắp diễn ra");
        }

        holder.tvRvmtTitle.setText(mucTieuList.get(position).getTenMT());
        holder.tvRvmtSTime.setText(mucTieuList.get(position).getNgayBDMT());
        holder.tvRvmtETime.setText(mucTieuList.get(position).getNgayKTMT());
        holder.tvRvmtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setView(R.layout.dialog_show_mtdl);
                final AlertDialog dialog = alertDialog.show();
                final TextView tvShowMTDL;
                final EditText edtMtdlShowTitle;
                final EditText edtMtdlShowStartMT;
                final EditText edtMtdlShowEndMT;
                final LinearLayout lnMtdlShowDL;
                final EditText edtMtdlShowStartDL;
                final EditText edtMtdlContentShow;
                final LinearLayout lnMtdlShowDel;
                final LinearLayout lnMtdlShowUpdate;


                tvShowMTDL = (TextView) dialog.findViewById(R.id.tv_showMTDL_);
                edtMtdlShowTitle = (EditText) dialog.findViewById(R.id.edt_mtdlShow_title);
                edtMtdlShowStartMT = (EditText) dialog.findViewById(R.id.edt_mtdlShow_startMT);
                edtMtdlShowEndMT = (EditText) dialog.findViewById(R.id.edt_mtdlShow_endMT);
                lnMtdlShowDL = (LinearLayout) dialog.findViewById(R.id.ln_mtdlShow_DL);
                edtMtdlContentShow = (EditText) dialog.findViewById(R.id.edt_mtdl_contentShow);
                lnMtdlShowDel = (LinearLayout) dialog.findViewById(R.id.ln_mtdlShow_del);
                lnMtdlShowUpdate = (LinearLayout) dialog.findViewById(R.id.ln_mtdlShow_update);


                tvShowMTDL.setText("TÊN MỤC TIÊU");
                lnMtdlShowDL.setVisibility(View.GONE);
                edtMtdlShowTitle.setEnabled(false);
                edtMtdlShowTitle.setText(mucTieuList.get(position).getTenMT());
                edtMtdlShowStartMT.setText(mucTieuList.get(position).getNgayBDMT());
                edtMtdlShowEndMT.setText(mucTieuList.get(position).getNgayKTMT());
                edtMtdlContentShow.setText(mucTieuList.get(position).getNoidungMT());
                edtMtdlShowStartMT.setOnLongClickListener(new View.OnLongClickListener() {
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
                                String sMT = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                edtMtdlShowStartMT.setText(sMT);
                                dialog_dp.dismiss();
                            }
                        });

                        return false;
                    }
                });
                if (!check) {

                    edtMtdlShowEndMT.setOnLongClickListener(new View.OnLongClickListener() {
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
                                    String eMT = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                    edtMtdlShowEndMT.setText(eMT);
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
                            final String mtStart = edtMtdlShowStartMT.getText().toString().trim();
                            String mtEnd = edtMtdlShowEndMT.getText().toString().trim();
                            String content = edtMtdlContentShow.getText().toString().trim();


                            MucTieu mucTieu = new MucTieu(title, content, mtStart, mtEnd);
                            boolean result = mucTieuDao.updateMT(mucTieu);
                            if (result) {

                                mucTieuList.get(position).setTenMT(title);
                                mucTieuList.get(position).setNoidungMT(content);
                                mucTieuList.get(position).setNgayBDMT(mtStart);
                                mucTieuList.get(position).setNgayKTMT(mtEnd);
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
                            boolean result = mucTieuDao.deleteMT(mucTieuList.get(position).getTenMT());
                            if (result) {
                                mucTieuList.remove(position);
                                notifyDataSetChanged();
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
                    edtMtdlShowStartMT.setEnabled(false);
                    edtMtdlShowEndMT.setEnabled(false);
                }

            }
        });
        if (!check) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    boolean result = mucTieuDao.deleteMT(mucTieuList.get(position).getTenMT());
                    if (result) {
                        mucTieuList.remove(position);
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
            return (x);
        } else {
            return mucTieuList.size();
        }
    }
}
