package com.example.duan1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1.database.BodyAndHealthyDatabase;
import com.example.duan1.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class NguoidungDao {

    public static final String TABLE_NAME = "NguoiDungDB";
    private SQLiteDatabase dbW, dbR;
    private BodyAndHealthyDatabase dbHelper;
    public static final String TAG = "NguoiDungDao";
    public static final String SQL_NguoiDungDB = "" +
            "CREATE TABLE " + TABLE_NAME + " (maND INTEGERAUTOINCREMENT , " +
            "tenND NVARCHAR, ngaysinh NVARCHAR, gioitinh NVARCHAR, " +
            "chieucao NVARCHAR, cannang NVARCHAR, anh NVARCHAR, ngaydangND NVARCHAR  primary key );";

    public NguoidungDao(Context context) {
        dbHelper = new BodyAndHealthyDatabase(context);
        dbW = dbHelper.getWritableDatabase();
        dbR = dbHelper.getReadableDatabase();
    }

    public boolean insertND(NguoiDung nguoiDung) {
        ContentValues values = new ContentValues();
        values.put("tenND", nguoiDung.getTenND());
        values.put("ngaysinh", nguoiDung.getNgaysinh());
        values.put("gioitinh", nguoiDung.getGioitinh());
        values.put("chieucao", nguoiDung.getChieucao());
        values.put("cannang", nguoiDung.getCannang());
        values.put("anh", nguoiDung.getAnh());
        values.put("ngaydangND", nguoiDung.getNgaydangND());

        long result = dbW.insert(TABLE_NAME, null, values);

        try {
            if (result < 0) {
                return false;
            }
        } catch (Exception e) {
            Log.e(TAG, "INSERT ND: " + e.toString());
            return false;
        }
        return true;
    }

    public boolean updateND(NguoiDung nguoiDung) {
        ContentValues values = new ContentValues();
        values.put("maND", nguoiDung.getMaND());
        values.put("tenND", nguoiDung.getTenND());
        values.put("ngaysinh", nguoiDung.getNgaysinh());
        values.put("gioitinh", nguoiDung.getGioitinh());
        values.put("chieucao", nguoiDung.getChieucao());
        values.put("cannang", nguoiDung.getCannang());
        values.put("anh", nguoiDung.getAnh());
        values.put("ngaydangND", nguoiDung.getNgaydangND());

        long result = dbW.update(TABLE_NAME, values, "ngaydangND" + " =?", new String[]{String.valueOf(nguoiDung.getNgaydangND())});

        try {
            if (result < 0) {
                return false;
            }
        } catch (Exception e) {
            Log.e(TAG, "UPDATE ND: " + e.toString());
            return false;
        }
        return true;
    }

    public boolean deleteND(int id) {

        long result = dbW.delete(TABLE_NAME, "ngaydangND" + " =?", new String[]{String.valueOf(id)});

        try {
            if (result < 0) {
                return false;
            }
        } catch (Exception e) {
            Log.e(TAG, "DELETE ND: " + e.toString());
            return false;
        }
        return true;
    }

    public List<NguoiDung> selectND() {
        List<NguoiDung> nguoiDungList = new ArrayList<>();
        // b2 : viet cau lenh select

        String select = "SELECT * FROM " + TABLE_NAME;

        // b3 : su dung cau lenh rawQuery
        Cursor cursor = dbR.rawQuery(select, null);
        if (cursor.moveToFirst()) {
            do {
                NguoiDung nguoiDung = new NguoiDung();
                nguoiDung.setMaND(cursor.getInt(0));
                nguoiDung.setTenND(cursor.getString(1));
                nguoiDung.setNgaysinh(cursor.getString(2));
                nguoiDung.setGioitinh(cursor.getString(3));
                nguoiDung.setChieucao(cursor.getString(4));
                nguoiDung.setCannang(cursor.getString(5));
                nguoiDung.setAnh(cursor.getString(6));
                nguoiDung.setNgaydangND(cursor.getString(7));

                nguoiDungList.add(nguoiDung);
            } while (cursor.moveToNext());

            // dong ket noi con tro
            cursor.close();
        }
        return nguoiDungList;
    }

    public int findIDbyDate(String ngaydang) {

        NguoiDung nguoiDung = new NguoiDung();
        // b2 : viet cau lenh select

        String select = "SELECT * FROM " + TABLE_NAME + " WHERE ngaydangND =?";

        // b3 : su dung cau lenh rawQuery
        Cursor cursor = dbR.rawQuery(select, new String[]{ngaydang});
        cursor.moveToFirst();
        nguoiDung.setMaND(cursor.getInt(0));
        nguoiDung.setTenND(cursor.getString(1));
        nguoiDung.setNgaysinh(cursor.getString(2));
        nguoiDung.setGioitinh(cursor.getString(3));
        nguoiDung.setChieucao(cursor.getString(4));
        nguoiDung.setCannang(cursor.getString(5));
        nguoiDung.setAnh(cursor.getString(6));
        nguoiDung.setNgaydangND(cursor.getString(7));
        // dong ket noi con tro
        cursor.close();

        return nguoiDung.getMaND();
    }


    public NguoiDung selectNDbyDate(String ngaydang) {

        NguoiDung nguoiDung = new NguoiDung();
        // b2 : viet cau lenh select

        String select = "SELECT * FROM " + TABLE_NAME + " WHERE ngaydangND =?";

        // b3 : su dung cau lenh rawQuery
        Cursor cursor = dbR.rawQuery(select, new String[]{ngaydang});
        cursor.moveToFirst();
        nguoiDung.setMaND(cursor.getInt(0));
        nguoiDung.setTenND(cursor.getString(1));
        nguoiDung.setNgaysinh(cursor.getString(2));
        nguoiDung.setGioitinh(cursor.getString(3));
        nguoiDung.setChieucao(cursor.getString(4));
        nguoiDung.setCannang(cursor.getString(5));
        nguoiDung.setAnh(cursor.getString(6));
        nguoiDung.setNgaydangND(cursor.getString(7));
        // dong ket noi con tro
        cursor.close();

        return nguoiDung;
    }
}
