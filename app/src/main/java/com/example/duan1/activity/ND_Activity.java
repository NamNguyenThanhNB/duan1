package com.example.duan1.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1.R;
import com.example.duan1.dao.NguoidungDao;
import com.example.duan1.databinding.ActivityNdBinding;
import com.example.duan1.inteface.NDActivity_Interface;
import com.example.duan1.model.NguoiDung;
import com.example.duan1.presenter.NDActivity_Precenter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        if (vitri < 0) {
            toolbar.setTitle("TẠO NGƯỜI DÙNG");
            edtCnndBirthday.setHint("dd/MM/yyyy");
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            tvCnndDate.setText(String.valueOf(simpleDateFormat.format(date)) + "");

        } else {
            toolbar.setTitle("CẬP NHẬT");
            binding.setNguoidungAdd(nguoiDungList.get(vitri));
            tvCnndDate.setText(nguoiDungList.get(vitri).getNgaydangND() + "");
            if (nguoiDungList.get(vitri).getGioitinh().equalsIgnoreCase("Nam")) {
                spn_sex.setSelection(0);
            } else {
                spn_sex.setSelection(1);
            }
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

                int year, month, day;
                if (vitri < 0) {
                    // Lấy ra năm - tháng - ngày hiện tại
                    year = calendar.get(calendar.YEAR);
                    month = calendar.get(calendar.MONTH);
                    day = calendar.get(calendar.DAY_OF_MONTH);

                } else {
                    Date brith = null;
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        brith = simpleDateFormat.parse(nguoiDungList.get(vitri).getNgaysinh());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    char[] arr = nguoiDungList.get(vitri).getNgaysinh().toCharArray();
                    int t = arr.length;
                    String a1 = String.valueOf(arr[t - 4]);
                    String a2 = String.valueOf(arr[t - 3]);
                    String a3 = String.valueOf(arr[t - 2]);
                    String a4 = String.valueOf(arr[t - 1]);
                    String a = a1 + a2 + a3 + a4;

                    year = Integer.parseInt(a);
                    month = brith.getMonth();
                    day = brith.getDate();

                }
                // Khởi tạo sự kiện lắng nghe khi DatePicker thay đổi
                dpCalendar.init(year, month, day, new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                        Toast.makeText(ND_Activity.this, dayOfMonth + "-" + (monthOfYear + 1) + "-" + year, Toast.LENGTH_SHORT).show();
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
        if (ContextCompat.checkSelfPermission(ND_Activity.this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    999);
        } else {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 999);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imgCnndFollow.setImageBitmap(imageBitmap);
        } else {
            Toast.makeText(this, "HAY CHUP ANH", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setJob_btn_cnnd_finish() {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String name = edtCnndName.getText().toString().trim();
        String birth = edtCnndBirthday.getText().toString().trim();
        String sex = spn_sex.getSelectedItem().toString();
        String height = edtCnndHeight.getText().toString().trim();
        String weight = edtCnndWeight.getText().toString().trim();
        String ngaydang = tvCnndDate.getText().toString().trim();


        if (vitri < 0) {
            if (checkND()) {

                NguoiDung nguoiDung = new NguoiDung(name, birth, sex, height, weight, "null", ngaydang);
                boolean result = nguoidungDao.insertND(nguoiDung);
                if (result) {
                    Intent intent = new Intent(ND_Activity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Tạo người dùng lỗi", Toast.LENGTH_SHORT).show();
                }
            } else {
            }
        } else {
            if (checkND()) {
                Date date = new Date();
                String dates = String.valueOf(simpleDateFormat.format(date));
                if (dates.equalsIgnoreCase(nguoiDungList.get(nguoiDungList.size() - 1).getNgaydangND())) {
                    NguoiDung nguoiDung = new NguoiDung(name, birth, sex, height, weight, "null", dates);
                    boolean result = nguoidungDao.updateND(nguoiDung);
                    if (result) {
                        Intent intent = new Intent(ND_Activity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, "Cập nhật người dùng lỗi", Toast.LENGTH_SHORT).show();
                        Log.e("Ecnnd: ", "update");
                    }
                } else {
                    NguoiDung nguoiDung = new NguoiDung(name, birth, sex, height, weight, "null", dates);
                    boolean result = nguoidungDao.insertND(nguoiDung);
                    if (result) {
                        Intent intent = new Intent(ND_Activity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, "Cập nhật người dùng lỗi", Toast.LENGTH_SHORT).show();
                        Log.e("Ecnnd: ", "ins");
                    }
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


        Calendar calendar = Calendar.getInstance();

        // Lấy ra năm - tháng - ngày hiện tại
        int year = calendar.get(calendar.YEAR);
        final int month = calendar.get(calendar.MONTH) + 1;
        int day = calendar.get(calendar.DAY_OF_MONTH);

        String today = day + "/" + month + "/" + year;

        double h = 0, w = 0;
        if (name.isEmpty()) {
            edtCnndName.setError("Hãy nhập tên");
            edtCnndName.requestFocus();
            return false;
        } else if (birth.isEmpty()) {
            edtCnndBirthday.setError("Hãy nhập ngày sinh");
            edtCnndBirthday.requestFocus();
            return false;
        } else if (!isDateValid(birth)) {
            edtCnndBirthday.setError("Ngày sinh sai định dạng(ngày/tháng/năm)");
            edtCnndBirthday.setText("");
            edtCnndBirthday.requestFocus();
            return false;
        } else if (stringToDate(birth).after(stringToDate(today))) {
            edtCnndBirthday.setError("Ngày sinh không lớn hơn ngày hôm nay");
            edtCnndBirthday.setText("");
            edtCnndBirthday.requestFocus();
            return false;
        } else if (height.isEmpty()) {
            edtCnndHeight.setError("Hãy nhập chiều cao");
            edtCnndHeight.requestFocus();
            return false;
        } else if (!isNumeric(height)) {
            edtCnndHeight.setError("Hãy nhập chiều cao là một số");
            edtCnndHeight.setText("");
            edtCnndHeight.requestFocus();
            return false;
        } else if (Double.parseDouble(height) < 1) {
            try {
                edtCnndHeight.setError("Chiều cao là một số lớn hơn 0");
                edtCnndHeight.setText("");
                edtCnndHeight.requestFocus();
                return false;
            } catch (Exception e) {
            }
        } else if (weight.isEmpty()) {
            edtCnndWeight.setError("Hãy nhập cân nặng");
            edtCnndWeight.requestFocus();
            return false;
        } else if (!isNumeric(weight)) {
            edtCnndWeight.setError("Hãy nhập cân nặng là một số");
            edtCnndWeight.setText("");
            edtCnndWeight.requestFocus();
            return false;
        } else if (Double.parseDouble(weight) < 1) {
            try {
                edtCnndWeight.setError("Cân nặng là một số lớn hơn 0");
                edtCnndWeight.setText("");
                edtCnndWeight.requestFocus();
                return false;
            } catch (Exception e) {
            }
        }
        return true;
    }

    public void Image() {
        BitmapDrawable drawable;
        Bitmap bitmap;

        drawable = (BitmapDrawable) imgCnndFollow.getDrawable();
        bitmap = drawable.getBitmap();

        FileOutputStream outputStream = null;
        File sdCard = Environment.getExternalStoragePublicDirectory("");

        File directory = new File(sdCard.getAbsolutePath() + "/BodyAndHealthyImg");
        directory.mkdir();


        String filename = String.format("%d.jpg", System.currentTimeMillis());
        File outFile = new File(directory, filename);

        Toast.makeText(this, "Image save successfully", Toast.LENGTH_SHORT).show();
        try {
            outputStream = new FileOutputStream(outFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.flush();
            outputStream.close();

            Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            intent.setData(Uri.fromFile(outFile));

            sendBroadcast(intent);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Date stringToDate(String aDate) {
        Date stringDate = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            stringDate = simpleDateFormat.parse(aDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return stringDate;
    }

    public static boolean isDateValid(String date) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
