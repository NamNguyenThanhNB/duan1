package com.example.duan1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1.database.BodyAndHealthyDatabase;
import com.example.duan1.model.NguoiDung;
import com.example.duan1.model.ThucPham;

import java.util.ArrayList;
import java.util.List;

public class ThucPhamDao {

    public static final String TABLE_NAME = "ThucPhamDB";
    private SQLiteDatabase dbW, dbR;
    private BodyAndHealthyDatabase dbHelper;
    public static final String TAG = "ThucPhamDao";
    public static final String SQL_ThucPhamDB = "" +
            "CREATE TABLE " + TABLE_NAME + " ( tenTP NVARCHAR primary key, loaiTP NVARCHAR, chedoTP NVARCHAR);";

    public ThucPhamDao(Context context) {
        dbHelper = new BodyAndHealthyDatabase(context);
        dbW = dbHelper.getWritableDatabase();
        dbR = dbHelper.getReadableDatabase();
    }

    public boolean insertTP(ThucPham thucPham) {
        ContentValues values = new ContentValues();
        values.put("name", thucPham.getTenTP());
        values.put("type", thucPham.getLoaiTP());
        values.put("level", thucPham.getChedoTP());

        long result = dbW.insert(TABLE_NAME, null, values);

        try {
            if (result < 0) {
                return false;
            }
        } catch (Exception e) {
            Log.e(TAG, "INSERT TP: " + e.toString());
            return false;
        }
        return true;
    }

    public boolean updateTP(ThucPham thucPham) {
        ContentValues values = new ContentValues();
        values.put("name", thucPham.getTenTP());
        values.put("type", thucPham.getLoaiTP());
        values.put("level", thucPham.getChedoTP());

        long result = dbW.update(TABLE_NAME, values, "tenTP" + " =?", new String[]{String.valueOf(thucPham.getTenTP())});

        try {
            if (result < 0) {
                return false;
            }
        } catch (Exception e) {
            Log.e(TAG, "UPDATE TP: " + e.toString());
            return false;
        }
        return true;
    }

    public boolean deleteTP(int id) {

        long result = dbW.delete(TABLE_NAME, "id_TP" + " =?", new String[]{String.valueOf(id)});

        try {
            if (result < 0) {
                return false;
            }
        } catch (Exception e) {
            Log.e(TAG, "DELETE TP: " + e.toString());
            return false;
        }
        return true;
    }

    public List<ThucPham> selectTP() {
        List<ThucPham> thucPhamList = new ArrayList<>();
        // b2 : viet cau lenh select

        String select = "SELECT * FROM " + TABLE_NAME;

        // b3 : su dung cau lenh rawQuery
        Cursor cursor = dbR.rawQuery(select, null);
        if (cursor.moveToFirst()) {
            do {
                ThucPham thucPham = new ThucPham();
                thucPham.setTenTP(cursor.getString(0));
                thucPham.setLoaiTP(cursor.getString(1));
                thucPham.setChedoTP(cursor.getString(2));

                thucPhamList.add(thucPham);
            } while (cursor.moveToNext());

            // dong ket noi con tro
            cursor.close();
        }
        return thucPhamList;
    }

}
