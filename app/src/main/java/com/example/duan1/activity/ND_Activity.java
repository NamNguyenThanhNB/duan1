package com.example.duan1.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1.ChupAnhActivity;
import com.example.duan1.R;
import com.example.duan1.dao.NguoidungDao;
import com.example.duan1.databinding.ActivityNdBinding;
import com.example.duan1.inteface.NDActivity_Interface;
import com.example.duan1.model.NguoiDung;
import com.example.duan1.presenter.NDActivity_Precenter;

import java.util.Calendar;
import java.util.List;

public class ND_Activity extends AppCompatActivity implements NDActivity_Interface {

    private TextView tvCnndDate;
    private EditText edtCnndName;
    private EditText edtCnndBirthday;
    private Spinner spn_sex;
    private EditText edtCnndHeight;
    private EditText edtCnndWeight;
    private ImageView img_cnnd_birthday;
    private Button btnCnndRefresh;
    private Button btnCnndCA;
    private Button btnCnndFinish;
    private ImageView imgCnndFollow;
    private NDActivity_Precenter nd_Activity_precenter;
    private ActivityNdBinding binding;
    private int getE;

    private NguoidungDao nguoidungDao;
    private List<NguoiDung> nguoiDungList;
    private int vitri = -1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nd);
        init();
        nguoidungDao = new NguoidungDao(this);
        Toolbar toolbar = findViewById(R.id.toolbarTCN_ND);
        // ghi người dùng cũ
        nguoiDungList = nguoidungDao.selectND();


        vitri = nguoiDungList.size() - 1;
// Check for SD Card
//        if (!Environment.getExternalStorageState().equals(
//                Environment.MEDIA_MOUNTED)) {
//            Toast.makeText(this, "Không có SD Card, chụp ảnh không hợp lệ", Toast.LENGTH_LONG)
//                    .show();
//
//            btnCnndCA.setVisibility(View.GONE);
//            imgCnndFollow.setVisibility(View.GONE);
//        } else {
            if (vitri < 0) {
                toolbar.setTitle("TẠO NGƯỜI DÙNG");
                edtCnndBirthday.setHint("dd/MM/yyyy");

            } else {
                toolbar.setTitle("CẬP NHẬT");

                binding.setNguoidungAdd(nguoiDungList.get(vitri));
                tvCnndDate.setText(nguoiDungList.get(vitri).getNgaydangND());
                if (nguoiDungList.get(vitri).getGioitinh().equalsIgnoreCase("Nam")) {
                    spn_sex.setSelection(0);
                } else {
                    spn_sex.setSelection(1);
                }
            }


            String pathImg = getIntent().getStringExtra("uriImage");
            if (vitri < 0 || pathImg.equals("")) {
                Toast.makeText(this, "a"+pathImg, Toast.LENGTH_SHORT).show();
                Log.e("url",pathImg+"");
                Bitmap bmp = BitmapFactory.decodeFile(pathImg);
                imgCnndFollow.setImageBitmap(bmp);
            } else {
                Bitmap bmp = BitmapFactory.decodeFile(nguoidungDao.selectNDbyDate(tvCnndDate.getText().toString()).getAnh());
                imgCnndFollow.setImageBitmap(bmp);
            }
            setSupportActionBar(toolbar);

            nd_Activity_precenter = new NDActivity_Precenter(this);
            binding.setNdprecenter(nd_Activity_precenter);

            img_cnnd_birthday.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(ND_Activity.this);
                    alertDialog.setView(R.layout.dialog_select_date);
                    final AlertDialog dialog = alertDialog.show();
                    DatePicker dpCalendar = dialog.findViewById(R.id.dpCalendar);
                    Calendar calendar = Calendar.getInstance();

                    // Lấy ra năm - tháng - ngày hiện tại
                    int year = calendar.get(calendar.YEAR);
                    final int month = calendar.get(calendar.MONTH);
                    int day = calendar.get(calendar.DAY_OF_MONTH);

                    // Khởi tạo sự kiện lắng nghe khi DatePicker thay đổi
                    dpCalendar.init(year, month, day, new DatePicker.OnDateChangedListener() {
                        @Override
                        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            Toast.makeText(ND_Activity.this, dayOfMonth + "-" + (monthOfYear + 1) + "-" + year, Toast.LENGTH_SHORT).show();
                            String sDL = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                            edtCnndBirthday.setText(sDL);
                            dialog.dismiss();
                        }
                    });
                }
            });
        }


    private void init() {
        img_cnnd_birthday = findViewById(R.id.img_cnnd_birthday);
        tvCnndDate = (TextView) findViewById(R.id.tv_cnnd_date);
        edtCnndName = (EditText) findViewById(R.id.edt_cnnd_name);
        edtCnndBirthday = (EditText) findViewById(R.id.edt_cnnd_birthday);
        spn_sex = (Spinner) findViewById(R.id.spn_sex);
        edtCnndHeight = (EditText) findViewById(R.id.edt_cnnd_Height);
        edtCnndWeight = (EditText) findViewById(R.id.edt_cnnd_Weight);
        btnCnndRefresh = (Button) findViewById(R.id.btn_cnnd_refresh);
        btnCnndCA = (Button) findViewById(R.id.btn_cnnd_CA);
        btnCnndFinish = (Button) findViewById(R.id.btn_cnnd_finish);
        imgCnndFollow = (ImageView) findViewById(R.id.img_cnnd_follow);

    }


    @Override
    public void setJob_btn_cnnd_refresh() {
        edtCnndName.setText("");
        edtCnndBirthday.setText("");
        spn_sex.setSelection(0);
        edtCnndHeight.setText("");
        edtCnndWeight.setText("");
    }

    @Override
    public void setJob_btn_cnnd_CA() {
        Intent intent = new Intent(this, ChupAnhActivity.class);
        startActivity(intent);
    }

    @Override
    public void setJob_btn_cnnd_finish() {
        if (vitri < 0) {
            if (checkND()) {
                String name = edtCnndName.getText().toString().trim();
                String birth = edtCnndBirthday.getText().toString().trim();
                String sex = spn_sex.getSelectedItem().toString();
                String height = edtCnndHeight.getText().toString().trim();
                String weight = edtCnndWeight.getText().toString().trim();
                String ngaydang = tvCnndDate.getText().toString().trim();

                NguoiDung nguoiDung = new NguoiDung(name, birth, sex, height, weight, "null", ngaydang);
                boolean result = nguoidungDao.insertND(nguoiDung);
                if (result) {
                    Intent intent = new Intent(ND_Activity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "false ins", Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            String name = edtCnndName.getText().toString().trim();
            String birth = edtCnndBirthday.getText().toString().trim();
            String sex = spn_sex.getSelectedItem().toString();
            String height = edtCnndHeight.getText().toString().trim();
            String weight = edtCnndWeight.getText().toString().trim();
            String ngaydang = tvCnndDate.getText().toString().trim();
            int id = nguoidungDao.findIDbyDate(ngaydang);
            if (ngaydang.equalsIgnoreCase(nguoiDungList.get(nguoiDungList.size() - 1).getNgaydangND())) {
                NguoiDung nguoiDung = new NguoiDung(name, birth, sex, height, weight, "null", ngaydang);
                boolean result = nguoidungDao.updateND(nguoiDung);
                if (result) {
                    notifyAll();

                } else {
                    Toast.makeText(this, "false update", Toast.LENGTH_SHORT).show();
                }
            } else {
                NguoiDung nguoiDung = new NguoiDung(name, birth, sex, height, weight, "null", ngaydang);
                boolean result = nguoidungDao.insertND(nguoiDung);

                if (result) {
                    notifyAll();
                } else {
                    Toast.makeText(this, "false ins update", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public boolean checkND() {
        String name = edtCnndName.getText().toString().trim();
        String birth = edtCnndBirthday.getText().toString().trim();
        String sex = spn_sex.getSelectedItem().toString();
        String height = edtCnndHeight.getText().toString().trim();
        String weight = edtCnndWeight.getText().toString().trim();
        if (name.isEmpty()) {
            edtCnndName.setError("Hãy nhập tên");
            edtCnndName.requestFocus();
            return false;
        } else if (birth.isEmpty()) {
            edtCnndBirthday.setError("Hãy nhập ngày sinh");
            edtCnndBirthday.requestFocus();
            return false;
        } else if (height.isEmpty()) {
            edtCnndHeight.setError("Hãy nhập chiều cao");
            edtCnndHeight.requestFocus();
            return false;
        } else if (Double.parseDouble(height) < 1 || Double.parseDouble(height) > 400) {
            try {
                edtCnndHeight.setError("Hãy nhập chiều cao là một số >0 và <400");
                edtCnndHeight.requestFocus();
                return false;
            } catch (Exception e) {
                edtCnndHeight.setError("Hãy nhập chiều cao là một số");
                edtCnndHeight.requestFocus();
                return false;
            }
        } else if (weight.isEmpty()) {
            edtCnndWeight.setError("Hãy nhập cân nặng");
            edtCnndWeight.requestFocus();
            return false;
        } else if (Double.parseDouble(weight) < 1) {
            try {
                edtCnndWeight.setError("Hãy nhập cân nặng là một số dương");
                edtCnndWeight.requestFocus();
                return false;
            } catch (Exception e) {
                edtCnndWeight.setError("Hãy nhập cân nặng là một số");
                edtCnndWeight.requestFocus();
                return false;
            }
        }
        return true;
    }

}
