package com.example.duan1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1.database.BodyAndHealthyDatabase;
import com.example.duan1.model.LichTrinh;
import com.example.duan1.model.ThucPham;

import java.util.ArrayList;
import java.util.List;

public class LichTrinhDao {

    public static final String TABLE_NAME = "LichTrinhDB";
    private SQLiteDatabase dbW, dbR;
    private BodyAndHealthyDatabase dbHelper;
    public static final String TAG = "LichTrinhDao";
    public static final String SQL_LichTrinhDB = "" +
            "CREATE TABLE " + TABLE_NAME + " ( tenLT NVARCHAR primary key, noidungLT NVARCHAR, tgdienraLT NVARCHAR);";

    public LichTrinhDao(Context context) {
        dbHelper = new BodyAndHealthyDatabase(context);
        dbW = dbHelper.getWritableDatabase();
        dbR = dbHelper.getReadableDatabase();
    }

    public boolean insertLT(LichTrinh lichTrinh) {
        ContentValues values = new ContentValues();
        values.put("tenLT", lichTrinh.getTenLT());
        values.put("noidungLT", lichTrinh.getNoidungLT());
        values.put("tgdienraLT", lichTrinh.getTgdienraLT());

        long result = dbW.insert(TABLE_NAME, null, values);

        try {
            if (result < 0) {
                return false;
            }
        } catch (Exception e) {
            Log.e(TAG, "INSERT LT: " + e.toString());
            return false;
        }
        return true;
    }

    public boolean updateLT(LichTrinh lichTrinh) {
        ContentValues values = new ContentValues();
        values.put("tenLT", lichTrinh.getTenLT());
        values.put("noidungLT", lichTrinh.getNoidungLT());
        values.put("tgdienraLT", lichTrinh.getTgdienraLT());

        long result = dbW.update(TABLE_NAME, values, "tenLT" + " =?", new String[]{lichTrinh.getTenLT()});

        try {
            if (result < 0) {
                return false;
            }
        } catch (Exception e) {
            Log.e(TAG, "UPDATE LT: " + e.toString());
            return false;
        }
        return true;
    }

    public boolean deleteLT(String id) {

        long result = dbW.delete(TABLE_NAME, "tenLT" + " =?", new String[]{String.valueOf(id)});

        try {
            if (result < 0) {
                return false;
            }
        } catch (Exception e) {
            Log.e(TAG, "DELETE LT: " + e.toString());
            return false;
        }
        return true;
    }

    public List<LichTrinh> selectLT() {
        List<LichTrinh> lichTrinhList = new ArrayList<>();
        // b2 : viet cau lenh select

        String select = "SELECT * FROM " + TABLE_NAME;

        // b3 : su dung cau lenh rawQuery
        Cursor cursor = dbR.rawQuery(select, null);
        if (cursor.moveToFirst()) {
            do {
                LichTrinh lichTrinh = new LichTrinh();
                lichTrinh.setTenLT(cursor.getString(0));
                lichTrinh.setNoidungLT(cursor.getString(1));
                lichTrinh.setTgdienraLT(cursor.getString(2));

                lichTrinhList.add(lichTrinh);
            } while (cursor.moveToNext());

            // dong ket noi con tro
            cursor.close();
        }
        return lichTrinhList;
    }

}
