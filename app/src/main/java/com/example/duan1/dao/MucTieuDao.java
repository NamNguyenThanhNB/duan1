package com.example.duan1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1.database.BodyAndHealthyDatabase;
import com.example.duan1.model.MucTieu;
import com.example.duan1.model.ThucPham;

import java.util.ArrayList;
import java.util.List;

public class MucTieuDao {

    public static final String TABLE_NAME = "MucTieuDB";
    private SQLiteDatabase dbW, dbR;
    private BodyAndHealthyDatabase dbHelper;
    public static final String TAG = "MucTieuDao";
    public static final String SQL_MucTieuDB = "" +
            "CREATE TABLE " + TABLE_NAME + " ( tenMT NVARCHAR primary key, noidungMT NVARCHAR, ngayBDMT NVARCHAR, ngayKTMT Date);";

    public MucTieuDao(Context context) {
        dbHelper = new BodyAndHealthyDatabase(context);
        dbW = dbHelper.getWritableDatabase();
        dbR = dbHelper.getReadableDatabase();
    }

    public boolean insertMT(MucTieu mucTieu) {
        ContentValues values = new ContentValues();
        values.put("tenMT", mucTieu.getTenMT());
        values.put("noidungMT", mucTieu.getNoidungMT());
        values.put("ngayBDMT", mucTieu.getNgayBDMT());
        values.put("ngayKTMT", mucTieu.getNgayKTMT());

        long result = dbW.insert(TABLE_NAME, null, values);

        try {
            if (result < 0) {
                return false;
            }
        } catch (Exception e) {
            Log.e(TAG, "INSERT MT: " + e.toString());
            return false;
        }
        return true;
    }

    public boolean updateMT(MucTieu mucTieu) {
        ContentValues values = new ContentValues();
        values.put("tenMT", mucTieu.getTenMT());
        values.put("noidungMT", mucTieu.getNoidungMT());
        values.put("ngayBDMT", mucTieu.getNgayBDMT());
        values.put("ngayKTMT", mucTieu.getNgayKTMT());
        long result = dbW.update(TABLE_NAME, values, "tenMT" + " =?", new String[]{mucTieu.getTenMT()});

        try {
            if (result < 0) {
                return false;
            }
        } catch (Exception e) {
            Log.e(TAG, "UPDATE MT: " + e.toString());
            return false;
        }
        return true;
    }

    public boolean deleteMT(String id) {

        long result = dbW.delete(TABLE_NAME, "tenMT" + " =?", new String[]{String.valueOf(id)});

        try {
            if (result < 0) {
                return false;
            }
        } catch (Exception e) {
            Log.e(TAG, "DELETE MT: " + e.toString());
            return false;
        }
        return true;
    }

    public List<MucTieu> selectMT() {
        List<MucTieu> mucTieuList = new ArrayList<>();
        // b2 : viet cau lenh select

        String select = "SELECT * FROM " + TABLE_NAME;

        // b3 : su dung cau lenh rawQuery
        Cursor cursor = dbR.rawQuery(select, null);
        if (cursor.moveToFirst()) {
            do {
                MucTieu mucTieu = new MucTieu();
                mucTieu.setTenMT(cursor.getString(0));
                mucTieu.setNoidungMT(cursor.getString(1));
                mucTieu.setNgayBDMT(cursor.getString(2));
                mucTieu.setNgayKTMT(cursor.getString(3));

                mucTieuList.add(mucTieu);
            } while (cursor.moveToNext());

            // dong ket noi con tro
            cursor.close();
        }
        return mucTieuList;
    }



    public List<MucTieu> selectMucTieu(String s) {
        List<MucTieu> mucTieuList = new ArrayList<>();
        // b2 : viet cau lenh select

        String select = "SELECT * FROM " + TABLE_NAME + " WHERE ngayBDMT = ?";

        // b3 : su dung cau lenh rawQuery
        Cursor cursor = dbR.rawQuery(select, new String[]{s});
        if (cursor.moveToFirst()) {
            do {
                MucTieu mucTieu = new MucTieu();
                mucTieu.setTenMT(cursor.getString(0));
                mucTieu.setNoidungMT(cursor.getString(1));
                mucTieu.setNgayBDMT(cursor.getString(2));
                mucTieu.setNgayKTMT(cursor.getString(3));

                mucTieuList.add(mucTieu);
            } while (cursor.moveToNext());

            // dong ket noi con tro
            cursor.close();
        }
        return mucTieuList;
    }

}
